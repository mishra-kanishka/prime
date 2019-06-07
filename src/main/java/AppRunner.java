import java.util.Scanner;
import java.util.logging.Logger;

class AppRunner {

    private static final Logger logger = Logger.getLogger(AppRunner.class.getSimpleName());

    public static void main(String[] args) {
        logger.info("Starting the application...");
        logger.info("Enter \" quit \" to stop...");
        logger.info("Use program argument(--f or --file) to" +
                " write result to file. i.e --file=myFile.txt");

        OutputChannel channel = new OutputChannel(args);

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String value = scanner.next();
                if (value.equalsIgnoreCase("quit")) {
                    break;
                }
                PrimeNumberService service = new PrimeNumberService(value);
                channel.setMessage(service.getResult());
                channel.writeToOutput();
            }
        }

        logger.info("Stopping...");
    }

}
