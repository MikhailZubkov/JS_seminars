package JavaProject.Seminars.sem2;

import java.util.Scanner;

public class InputTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int a = inputNumber (scanner);
        System.out.println(a);
    }

    private static int inputNumber (Scanner scanner) {
        while (true) {
            try {
                String line = scanner.nextLine ();
                String[] parts = line.split (" ");
                for (String part : parts)  // для каждой строки part из массива parts
                    System.out.println(part);
                return Integer.parseInt (line);  // throw new Exception ("Такая-то ошибка");
            }
            catch (Exception ex) {
                System.out.printf("Ошибка ввода: %s\n", ex.getMessage ());
            }
            finally {
                // сдать в систему ресурсы, если вы их брали
                // файлы
            }
        }
    }
}
