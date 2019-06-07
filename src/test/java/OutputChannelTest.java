import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class OutputChannelTest {

    private OutputChannel outputChannel;
    private PrimeNumber primeNumber;
    private Stream<String> stream;
    private static final String TEST_FILE_PATH = "./src/test/resources/test.txt";

    private void readFile() {
        try {
            stream = Files.lines(Paths.get(OutputChannelTest.TEST_FILE_PATH));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @After
    public void removeTestFile() {
        File testFile = new File(TEST_FILE_PATH);
        testFile.deleteOnExit();
    }

    @Test (expected = RuntimeException.class)
    public void testFileNotFoundException() {
        String[] myArgs = {"--file=/text.txt"};
        outputChannel = new OutputChannel(myArgs);
        primeNumber = new PrimeNumber("17");
        outputChannel.setMessage(primeNumber.getResult());
        outputChannel.spitOut();
    }

    @Test
    public void testOutputToFile() {
        String[] myArgs = {"--f=" + TEST_FILE_PATH};
        outputChannel = new OutputChannel(myArgs);
        primeNumber = new PrimeNumber("23");
        outputChannel.setMessage(primeNumber.getResult());
        outputChannel.spitOut();
        readFile();
        assertTrue(stream.anyMatch(line -> line.contains("23 is prime")));
    }

}