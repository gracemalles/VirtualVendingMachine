package com.techelevator.Logger;

import java.io.*;

public class VendingMachineLogger implements Closeable {
    private File logFile;
    private PrintWriter writer;

    public VendingMachineLogger (String path) {
        this.logFile = new File(path);

        if (logFile.exists()) {
            try {
                this.writer = new PrintWriter(new FileWriter(this.logFile, true));
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                writer = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
    public void write(String logMessage) {
        writer.println(logMessage);
    }
    @Override
    public void close() throws IOException {
        writer.close();
    }
    public void flush() {
        writer.flush();
    }
}
