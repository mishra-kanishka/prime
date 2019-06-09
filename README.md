# Prime
Command line program to check prime number.

Command line Java program which tells if a given number is a prime number or not.
If the number is not a prime, prints one of the factor which the number can be divided with.


    - Program reads the numbers from the command line continuously.
    - Program does not processes numbers outside Java's integer range.
    - Program also accept optional command line argument which defines an output
     file were the results are appended instead of System.out.
    - Output file dose not contain any error messages, only valid results.
    - Error handling, border cases, error messages and tests cases.

Running Steps:

    - Clone and compile using "mvn clean install".
    - Run with : java -jar prime-1.0-SNAPSHOT.jar to print to console.
    - Run with : java -jar prime-1.0-SNAPSHOT.jar --f=prime.txt to print result to file.
    - Exit the program by entering "quit".