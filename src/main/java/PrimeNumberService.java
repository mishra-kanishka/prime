import java.util.OptionalInt;
import java.util.stream.IntStream;

class PrimeNumberService {

    private Number number;
    private String input;
    private String result;

    PrimeNumberService(String input) {
        this.input = input;
        handle();
    }

    String getResult() {
        return result;
    }

    private void handle() {
        try {
            number = new Number(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            result = "Please enter valid integer.";
            return;
        }
        if (number.getNumber() <= 1) {
            result = String.format("%d is not prime.", number.getNumber());
            return;
        }
        processNumber();
        collectResult();
    }

    private void processNumber() {
        if (firstFactorsOf(number.getNumber()).isPresent()) {
            number.setFirstFactor(firstFactorsOf(number.getNumber()).getAsInt());
            number.setPrime(false);
        } else {
            number.setPrime(true);
        }
    }

    private static OptionalInt firstFactorsOf(int number) {
        return IntStream.range(2, number).filter(i -> number%i == 0).findFirst();
    }


    private void collectResult() {
        if (number.isPrime()) {
            result = String.format("%d is prime", number.getNumber());
            return;
        }
        result = String.format("%d is not prime. It is divisible by %d", number.getNumber(), number.getFirstFactor());
    }
}
