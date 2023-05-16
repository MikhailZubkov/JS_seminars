package JavaProject.Seminars.sem2;

import java.io.FileReader;
import java.io.IOException;

public class OpenFile {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader ("file.txt");
            // открыть файл: неправильное имя файла
            // читать из файла:  — сбой
        }
        catch (IOException ex) {
            System.out.println("Была проблема!");
        }

        catch (Exception ex) {
            System.out.println("Была проблема!");
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
