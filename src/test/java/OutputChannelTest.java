import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class OutputChannelTest {

    private OutputChannel outputChannel;
    private PrimeNumberService primeNumberService;
    private Stream<String> stream;
    private static final String TEST_FILE_PATH = "./src/test/resources/test.txt";
    private File testFile = new File(TEST_FILE_PATH);

    @Before
    public void setup() throws IOException {
        testFile.createNewFile();
    }

    @After
    public void removeTestFile() {
        testFile.deleteOnExit();
    }

    @Test (expected = RuntimeException.class)
    public void testHandleFileNotFoundException() {
        String[] myArgs = {"--file=/text.txt"};
        outputChannel = new OutputChannel(myArgs);
        primeNumberService = new PrimeNumberService("17");
        outputChannel.setMessage(primeNumberService.getResult());
        outputChannel.writeToOutput();
    }

    @Test
    public void testOutputToFile() {
        String[] myArgs = {"--f=" + TEST_FILE_PATH};
        outputChannel = new OutputChannel(myArgs);
        primeNumberService = new PrimeNumberService("23");
        outputChannel.setMessage(primeNumberService.getResult());
        outputChannel.writeToOutput();
        readFile();
        assertTrue(stream.anyMatch(line -> line.contains("23 is prime")));
    }

    private void readFile() {
        try {
            stream = Files.lines(Paths.get(OutputChannelTest.TEST_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Issue with reading test file " + e.getMessage());
        }
    }

}
