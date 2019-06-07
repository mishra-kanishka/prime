import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class AppRunner {

    private static final Logger logger = Logger.getLogger(AppRunner.class.getSimpleName());

    public static void main(String[] args) {
        logger.info("Starting the application...");
        logger.log(Level.INFO,"Enter \" quit \" to stop...");

        OutputChannel channel = new OutputChannel(args);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String value = scanner.next();
            if (value.equalsIgnoreCase("quit")) break;
            PrimeNumber primeNumber = new PrimeNumber(value);
            channel.setMessage(primeNumber.getResult());
            channel.spitOut();
        }
        scanner.close();
        logger.info("Stopping...");
    }

}
