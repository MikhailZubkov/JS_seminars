//Написать программу, определяющую правильность расстановки скобок в выражении.
//        Пример 1: a+(d*3) - истина   (
//        Пример 2: [a+(1*3) - ложь
//        Пример 3: [6+(3*3)] - истина
//        Пример 4: {a}[+]{(d*3)} - истина
//        Пример 5: <{a}+{(d*3)}> - истина
//        Пример 6: {a+]}{(d*3)} - ложь

package JavaProject.Seminars.sem5;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку s: ");
        String s = scanner.nextLine();
        scanner.close();

        System.out.println(rightBrackets(s));
    }

    private static boolean rightBrackets(@NotNull String s) {
        Map<Character, Character> brackets = new HashMap<>();
        Stack<Character> open = new Stack<>();
        brackets.put('{', '}');
        brackets.put('(', ')');
        brackets.put('<', '>');
        brackets.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            if (brackets.containsKey(s.charAt(i))) open.push(s.charAt(i));
            else if (brackets.containsValue(s.charAt(i))) {
                if (open.empty() || s.charAt(i) != brackets.get(open.pop())) return false;
            }
        }
        return open.empty();
    }
}

