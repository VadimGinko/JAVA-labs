package by.ginko.one.bl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    FileWriter reader;
    public Log(String filename)
    {
        try {
            reader = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Writelog(String message) throws IOException {
        this.reader.write(message + '\n');
    }

    public void Writeline() throws IOException {
        this.reader.write("------------------------------------\n");
    }
    public void close() throws IOException {
        this.reader.close();
    }
}
