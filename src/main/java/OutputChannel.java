import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

class OutputChannel {

    private String[] args;
    private String message;

    OutputChannel(String[] args) {
        this.args = args;
    }

    void setMessage(String message) {
        this.message = message;
    }

    void spitOut() {
        String absolutePath = findAbsolutePath(args);
        if (absolutePath != null) {
            try {
                File file = new File(absolutePath);
                PrintWriter printWriter = new PrintWriter(new FileWriter(file, true));
                printWriter.println(message);
                printWriter.close();
            } catch (IOException e) {
                throw new RuntimeException("error writing to file" + e);
            }
        } else {
            System.out.println(message);
        }
    }

    private static String findAbsolutePath(String[] args) {
        return Arrays.stream(args)
                .filter(arg -> arg.contains("--file") || arg.contains("--f"))
                .findFirst()
                .map(arg -> arg.substring(arg.indexOf("=") + 1))
                .orElse(null);
    }
}
