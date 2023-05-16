import java.util.*;

class ListQuirks {
    public static void main(String[] args) {
        List list = new ArrayList<> ();
        list.add (0);  // Integer -> Object
        list.add ("Hello");
        list.add (null);

        System.out.println();

        int i;

        for (Object o : list)
            if (o != null)
                System.out.printf("%s %s\n", o.toString (), o.getClass().getName());

        List<Integer> numbers;

        printList (list);
    }

    public static void printList (List list) {  // любой List
    }
}
