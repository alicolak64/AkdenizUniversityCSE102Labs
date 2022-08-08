import java.util.ArrayList;
import java.util.Arrays;;

/**
 * @author Ali Çolak
 * 2.03.2021
 */
public class Lab12_20190808064 {

    public static void findRepeats(int[] array,int n) {
        Arrays.sort(array);
        ArrayList<Integer> numbers= new ArrayList<>();
        int counter;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            counter=0;
            for (int j = index; j < array.length; j++) {
                if (array[i] == array[j]) {
                    counter++;
                    index++;
                }
                else {
                    i = index-1;
                    break;
                }
            }
            if (counter>n) numbers.add(array[i-1]);
        }
        System.out.println(numbers);
    }

}
