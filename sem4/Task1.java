//Реализовать консольное приложение, которое в цикле:
//Принимает от пользователя строку вида text~num
// Нужно разделить строку по ~, сохранить text в связный список на позицию num.
// Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.

package JavaProject.Seminars.sem4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        List<String> texts = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите строку: ");
            String line = scanner.nextLine();

            if (line.length() == 0) break;
            String[] parts = line.split("~");
            int num = Integer.parseInt(parts[1]);

            if (parts[0].equals("print") && num >= 0 && num < texts.size()) System.out.println(texts.remove(num));
            else if (!parts[0].equals("print") && num >= 0 && num <= texts.size()) texts.add(num, parts[0]);
            else {
                System.out.println("Недопустимый индекс");
                continue;
            }
            System.out.println(texts);
        }
        scanner.close();
    }
}
