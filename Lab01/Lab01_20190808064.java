import java.util.Arrays;
import java.util.Random;

/**
 * @author Ali Çolak
 * 2.03.2021
 */
public class Lab01_20190808064 {
    
    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(shuffle(new int[]{1,2,3,4,5,6,7})));
        
    }
    
    public static int[] shuffle ( int[] array ) {
        
        int[] newArray = new int[array.length];
        
        for ( int i = 0 ; i < array.length ; i++ ) 
            newArray[i] = array[i];
        
        Random random = new Random();
        
        int randomIndex = random.nextInt(newArray.length);
        
        for (int i = 0; i < newArray.length ; i++) {
            
            while ( ! ( ( randomIndex % 2 == 0 && i % 2 == 0) || (randomIndex % 2 == 1 && i % 2 == 1 ) ) ) {
                randomIndex = random.nextInt(newArray.length);
            }
            
            if ( randomIndex % 2 == 0 && i % 2 == 0 ) {
                
                int tempNumber = newArray[i];
                newArray[i] = newArray[randomNumber];
                newArray[randomIndex] = tempNumber;
                
            }
            
            else if (randomIndex % 2 == 1 && i % 2 == 1) {
                
                int tempNumber = newArray[i];
                newArray[i] = newArray[randomIndex];
                newArray[randomIndex] =tempNumber;
                
            }
            
        }
        
        return newArray;
        
    }
    
}
