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

    protected void writeToOutput() {
        String absolutePath = findAbsolutePath(args);
        if (absolutePath != null) {
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(new File(absolutePath), true))) {
                printWriter.println(message);
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
                .map(arg -> arg.substring(arg.indexOf("=") + 1).trim())
                .orElse(null);
    }
}
