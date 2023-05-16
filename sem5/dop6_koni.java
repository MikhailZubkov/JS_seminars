//Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке была строго один раз.

package JavaProject.Seminars.sem5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class dop6_koni {

    public static void main(String[] args) {
        long timeStart = System.nanoTime();
        int n = 5;
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();

        int x = 0; // координата по вертикали
        int y = 0; // координата по горизонтали
        int move = 1; //номер шага
        int start = 1;
        int maxMove = 1;
        
        
        String[] coordinats = new String[3];
        arr[x][y] = move;

        Map <Integer, String> journalMove = new HashMap<>();
        journalMove.put(move, String.format("%d,%d", x, y));
//        System.out.println(journalMove);

        while (move < n*n) {
            if(move == 0) {
                System.out.printf("С данной стартовой точки решение не найдено. Максимальное количество ходов = ", maxMove);
                System.out.println();
                break;
            }
            int i = start;
            while(i <= 8) {  // 8 - варианты хода конём
                if(horse_move(x, y, arr, move, journalMove, i).containsKey(move+1)) {
                    horse_move(x, y, arr, move, journalMove, i);
//                    System.out.println();
//                    System.out.println(journalMove);
                    break;
                }
                i++;
            }
            if(journalMove.containsKey(move+1)){
                move++;
//                if(maxMove < move) maxMove = move;
                coordinats = journalMove.get(move).split(",");
                x = Integer.parseInt(coordinats[0]);
                y = Integer.parseInt(coordinats[1]);
                arr[x][y] = move;
                start = 1;
            }
            else {
                arr[x][y] = 0;
                journalMove.remove(move);
                coordinats = journalMove.get(--move).split(",");                
//                System.out.println(journalMove);
//                System.out.println(Arrays.toString(coordinats));
                x = Integer.parseInt(coordinats[0]);
                y = Integer.parseInt(coordinats[1]);
                start = Integer.parseInt(coordinats[2]) + 1;
//                System.out.printf("start=%d", start);
//                System.out.println();

                while (start == 9) {
                    arr[x][y] = 0;
                    journalMove.remove(move);
                    coordinats = journalMove.get(--move).split(",");  
                    x = Integer.parseInt(coordinats[0]);
                    y = Integer.parseInt(coordinats[1]);
                    start = Integer.parseInt(coordinats[2]) + 1;
                }
            }

        }
        
        for (int[] is : arr) {
            System.out.print("[");
            for (int i : is) {
                System.out.printf("%3d ", i);               
            }
            System.out.println("]");
        }
        long timeFinish = System.nanoTime();
        System.out.println(timeFinish - timeStart);
    }

    private static Map<Integer, String> horse_move(int x, int y, int[][] arr, int move, Map<Integer, String> journalMove, int variant) {
        int len = arr.length;
        switch(variant) {
            case 1:
                if (x + 2 < len && y + 1 < len && arr[x + 2][y + 1] == 0) { x = x + 2; y = y + 1; arr[x][y] = ++move;}
                break;
                
            case 2:
                if (x + 2 < len && y - 1 >= 0  && arr[x + 2][y - 1] == 0) {x = x + 2; y = y - 1; arr[x][y] = ++move;}
                break;
                
            case 3:
                if (x + 1 < len && y + 2 < len && arr[x + 1][y + 2] == 0) { x = x + 1; y = y + 2; arr[x][y] = ++move;}
                break;

            case 4:
                if (x + 1 < len && y - 2 >= 0  && arr[x + 1][y - 2] == 0) { x = x + 1; y = y - 2; arr[x][y] = ++move;}
                break;

            case 5:
                if (x - 2 >= 0  && y - 1 >= 0  && arr[x - 2][y - 1] == 0) { x = x - 2; y = y - 1; arr[x][y] = ++move;}
                break;

            case 6:
                if (x - 2 >= 0  && y + 1 < len && arr[x - 2][y + 1] == 0) { x = x - 2; y = y + 1; arr[x][y] = ++move;}
                break;

            case 7:
                if (x - 1 >= 0  && y - 2 >= 0  && arr[x - 1][y - 2] == 0) { x = x - 1; y = y - 2; arr[x][y] = ++move;}
                break;

            case 8:
                if (x - 1 >= 0  && y + 2 < len && arr[x - 1][y + 2] == 0) { x = x - 1; y = y + 2; arr[x][y] = ++move;}
                break;
            }
               
//        System.out.printf("x=%d, y=%d, move=%d, variant=%d", x, y, move, variant);
//        System.out.println();
        journalMove.put(move, String.format("%d,%d,%d", x, y, variant));

//        for (int[] is : arr) {
//            System.out.print("[");
//            for (int i : is) {
//                System.out.printf("%3d ", i);
//            }
//            System.out.println("]");
//        }

        return journalMove;    
    }
}
