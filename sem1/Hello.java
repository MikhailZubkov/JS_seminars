package JavaProject.Seminars.sem1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm:ss");
        System.out.println(formatter.format(now));
    }
}
