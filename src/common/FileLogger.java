package common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public final class FileLogger {
    private static FileLogger instance = null;
    private Writer out;

    private FileLogger() {
    }

    public static void initializeLogger(final String outputFile) throws IOException {
        if (instance == null) {
            instance = new FileLogger();
            instance.out = new BufferedWriter(new FileWriter(outputFile));

        }
    }

    public static FileLogger getLogger() {
        return instance;
    }

    public void write(final String message) {
        try {
            out.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
