package JavaProject.DZ.DZ6;
import java.util.*;

/*Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
        Создать множество ноутбуков.
        Написать метод, который будет запрашивать у пользователя критерий (или критерии)
        фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
        “Введите цифру, соответствующую необходимому критерию:
        1 - ОЗУ
        2 - Объём ЖД
        3 - Операционная система
        4 - Цвет …
        Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры
        фильтрации можно также в Map.
        Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
*/
public class Task1_magazin_tehniki {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Samsung", 16, 512, "windows", "cherry");
        Laptop laptop2 = new Laptop("Lenovo", 8, 256, "windows", "black");
        Laptop laptop3 = new Laptop("Macbook", 32, 512, "macos", "silver");

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);

        System.out.println(laptops);

        Map<Integer, String> filter = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("Задайте критерии фильтрации: \n" +
                    "1 - ОЗУ\n" +
                    "2 - Объём ЖД\n" +
                    "3 - Операционная система\n" +
                    "4 - Цвет\n" +
                    "5 - Запустить поиск");

            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("Введите минимальный объем памяти: ");
                        filter.put(1, scanner.next());
                        break;
                    case 2:
                        System.out.println("Введите минимальный объем жесткого диска:");
                        filter.put(2, scanner.next());
                        break;
                    case 3:
                        System.out.println("Введите операционную систему: ");
                        filter.put(3, scanner.next().toLowerCase());
                        break;
                    case 4:
                        System.out.println("Введите цвет ноутбука:");
                        filter.put(4, scanner.next().toLowerCase());
                        break;
                    case 5:
                        flag = false;
                        break;
                }
            } else {
                flag = false;
                System.out.println("Вы ввели не число");
            }
            System.out.println(filter);

        }
        Set<Laptop> results = new HashSet<>();
        for (Laptop element : laptops) {
            if (filter.containsKey(1)) {
                if (Integer.parseInt(filter.get(1)) <= element.getRam()) {
                    results.add(element);
                } else
                    continue;
            }

            if (filter.containsKey(2)) {
                if (Integer.parseInt(filter.get(2)) <= element.getHdd()) {
                    results.add(element);
                } else {
                    results.remove(element);
                    continue;
                }
            }
            if (filter.containsKey(3)) {
                if (filter.get(3).equals(element.getOs())) {
                    results.add(element);
                } else {
                    results.remove(element);
                    continue;
                }
            }
            if (filter.containsKey(4)) {
                if (filter.get(4).equals(element.getColor())) {
                    results.add(element);
                } else {
                    results.remove(element);
                }
            }
        }
        for (Laptop laptop : results) {
            System.out.println(laptop);
        }
    }
}
