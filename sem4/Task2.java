//Реализовать консольное приложение, которое:
//Принимает от пользователя и “запоминает” строки.
//Если введено print, выводит строки в обратном порядке (первая введённая окажется последней выведенной).
//Если введено revert, удаляет предыдущую введенную строку из памяти.


package JavaProject.Seminars.sem4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> strStack = new ArrayDeque<>();

        String str;

        while (true) {
            str = scanner.nextLine();

            switch (str) {
                case "exit" -> System.exit(0);
                case "print" -> {
                    for (Iterator<String> it = strStack.descendingIterator(); it.hasNext(); ) {
                        String s = it.next();
                        System.out.printf("%s ", s);
                    }
                    System.out.println();
                }
                case "revert" -> System.out.println(strStack.pop());
                default -> strStack.add(str);
            }
        }
    }
}