import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OutputChannelTest {

    private OutputChannel outputChannel;
    private PrimeNumberService primeNumberService;
    private Stream<String> stream;
    private static final String TEST_FILE_PATH = "./src/test/resources/test.txt";
    private File testFile = new File(TEST_FILE_PATH);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() throws IOException {
        testFile.delete();
        testFile.createNewFile();
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

    @Test
    public void testOutputToConsole() {
        System.setOut(new PrintStream(outContent));
        String[] myArgs = {};
        outputChannel = new OutputChannel(myArgs);
        primeNumberService = new PrimeNumberService("10");
        outputChannel.setMessage(primeNumberService.getResult());
        outputChannel.writeToOutput();
        assertEquals("10 is not prime. It is divisible by 2", outContent.toString().trim());
        System.setOut(originalOut);
    }

    private void readFile() {
        try {
            stream = Files.lines(Paths.get(OutputChannelTest.TEST_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Issue with reading test file " + e.getMessage());
        }
    }

}
