import java.util.OptionalInt;
import java.util.stream.IntStream;

class PrimeNumber {

    private int number;
    private int firstFactor;
    private boolean isPrime;
    private String result;

    String getResult() {
        return result;
    }

    int getNumber() {
        return number;
    }

    PrimeNumber(String input) {
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            result = "Please enter valid integer.";
            return;
        }
        if (number <= 1) {
            result = String.format("%d is not prime.", number);
            return;
        }
        processNumber(number);
    }

    /* TODO : Remove later.
    private void processNumber(int number) {
        if (number == 2 || number == 3) isPrime = true;
        for (int i=2; i<=number/2; i++) {
            if (number%i == 0) {
                isPrime = false;
                firstFactor = i;
                collectResult();
                break;
            }
            isPrime = true;
        }
        collectResult();
    }*/

    private void processNumber(int number) {
        if (firstFactorsOf(number).isPresent()) {
            firstFactor = firstFactorsOf(number).getAsInt();
            isPrime = false;
        } else {
            isPrime = true;
        }
        collectResult();
    }

    private static OptionalInt firstFactorsOf(int number) {
        return IntStream.range(2, number).filter(i -> number%i == 0).findFirst();
    }


    private void collectResult() {
        if (isPrime) {
            result = String.format("%d is prime", number);
            return;
        }
        result = String.format("%d is not prime. It is divisible by %d", number, firstFactor);
    }

}
