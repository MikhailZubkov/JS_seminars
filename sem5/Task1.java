//Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false,
// если нет. Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву
// во втором слове, при этом
//повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования.
// (Например, add - egg изоморфны)
//буква может не меняться, а остаться такой же. (Например, note - code)
//Пример 1:
//Input: s = "foo", t = "bar"
//Output: false
//Пример 2:
//Input: s = "paper", t = "title"
//Output: true

package JavaProject.Seminars.sem5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку s: ");
        String s = scanner.nextLine();
        System.out.println("Введите строку t: ");
        String t = scanner.nextLine();
        scanner.close();
        System.out.println(isIsomorphic(s, t));

    }

    private static boolean isIsomorphic (String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> code = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (code.containsKey(s.charAt(i))) {
                if (!code.get(s.charAt(i)).equals(t.charAt(i))) return false;
            }
            else {
                code.put(s.charAt(i), t.charAt(i));
            }
            if (code.containsValue(t.charAt(i))) {
                for (Map.Entry<Character, Character> pair : code.entrySet()) {
                    if (t.charAt(i) == pair.getValue())
                        if (pair.getKey() != s.charAt(i))
                            return false;
                }
            }
        }

        return true;

    }
}
