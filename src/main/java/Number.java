
class Number {

    private int number;
    private int firstFactor;
    private boolean isPrime;


    Number(int number) {
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    int getFirstFactor() {
        return firstFactor;
    }

    void setFirstFactor(int firstFactor) {
        this.firstFactor = firstFactor;
    }

    boolean isPrime() {
        return isPrime;
    }

    void setPrime(boolean prime) {
        isPrime = prime;
    }

}
