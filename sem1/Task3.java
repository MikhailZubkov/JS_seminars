// Дан массив nums = [3,2,2,3] и число val = 3. 
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива. 
// Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, 
// а остальные - равны ему.


package JavaProject.Seminars.sem1;

import java.util.Arrays;

public class Task3 {
//     public static void main(String[] args) {
//         int [] nums = new int[] {3, 3, 2, 2, 3};
//         int val = 3;
        
//         for (int i = 0; i < nums.length - 1; i++) {
//             if (nums[i] == val) {
//                 int temp = nums[i];
//                 nums[i] = nums[i + 1];
//                 // nums[nums.length - 1] = temp;
//                 nums[i + 1] = temp;
//                 for (int j = 0; j < nums.length; j++) {
//                     System.out.print(nums[j]);
//                 }
//                 System.out.println();
//             }
//         }
//     }
// }


    public static void main(String[] args) {
        int[] arr = { 3, 2, 2, 3, 4, 1 };
        int[] arrRes = new int[arr.length];
        int val = 4;
        int end = arr.length - 1;
        int begin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                arrRes[end--] = arr[i];
                // end--;
            } else {
                arrRes[begin++] = arr[i];
                // begin++;
            }
        }
        System.out.println(Arrays.toString(arrRes));

    }
}