import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ali Çolak
 * 2.03.2021
 */
public class Lab02_20190808064 {
    
    public static void main(String[] args) {
        
        int [][] array= {
                {1,2,3,4},
                {4,5,6,5},
                {7,8,9,6},
                {1,2,3,4}
                
        };
        
        System.out.println(Arrays.toString(convert(array)));
        
    }
    
    public static int [] convert( int [][] array ) {
        
        int [][] array2 = new int [array[0].length][array.length] ;
        
        for ( int i = 0 ; i < array[0].length ; i++ ) {
            
            array2[i]=new int[array.length];
            
        }
        
        for ( int i = 0 ; i < array[0].length ; i++ ) {
            
            for ( int j = 0 ; j < array.length ; j++ ) {
                
                array2[i][j] = array[j][i];
                
            }
            
        }
        
        for ( int i = 0 ; i < array[0].length ; i++ ) {
            
            for ( int j = 0 ; j < array.length ; j++ ) {
                
                array2[i][j] = array[j][i];
                
            }
            
        }
        
        array = array2;
        
        if ( array[0].length == 0 ) 
            return new int[0];
        
        
        int u=array.length;
        
        int h=u;
        
        int arr1 []=new int [u*u];
        int arr2 []=new int [u*u];
        
        for ( int i = 0 ; i < u ; i++ ) {
            
            System.arraycopy( array[i] , 0 , arr1 , (u*i) , array[i].length );
            
        }
        
        int a = array.length/2;
        int x=0;
        int y;
        
        for ( int i = 0 ; i < a ; i++ ){
            
            int tempArray []=method(arr1,u);
            
            for ( int j = 0 ; j < q.length ; j++ ) {
                
                arr2[x] = tempArray[j] ;
                
                x++;
                
            }
            
            if (u>3){
                
                int tempArray2 [] = new int[(u-2)*(u-2)];
                
                y=0;
                
                for ( int j = 0 ; j < u-2 ; j++ ){
                    
                    for(int k=0;k<u-2;k++){
                        
                        tempArray2[y] = arr1[ ( (j + 1) *u ) + 1 + k ];
                        y++;
                        
                    }
                    
                }
                
                arr1 = tempArray2;
                u = u - 2;
            }
            
        }
        
        if ( u % 2 == 1) 
            arr2[ ( h * h ) - 1 ] = arr1[ ( u * u ) / 2 ];
        
        return arr2;
        
    }

    public static int [] method(int array [],int u){
        
        int tempArray[] = new int[ ( u * 4) - 4] ;
        int x=0;
        
        for ( int i = 0 ; i < u ; i++ ){
            
            tempArray[x] = array[i];
            x++;
            
        }
        
        for ( int i = 0 ; i < u - 2 ; i++ ){
            
            tempArray[x] = array[ ( u * ( i + 2 ) )-1];
            x++;
        }
        
        for ( int i = 0 ; i < u ; i++ ){
            
            tempArray[x] = array[(u*u)-i-1];
            x++;
            
        }
        
        for ( int i = u-2 ; i > 0 ; i-- ) {
            
            tempArray[x] = array[(u*(i))];
            x++;
        }
        
        return tempArray;
        
    }
    
    public static int[] snail ( int[][] array ) {
        
        int [][] array2=new int[array[0].length][array.length];
        for (int i = 0; i < array[0].length; i++) {
            array2[i]=new int[array.length];
        }
        for (int i = 0; i <array[0].length; i++) {
            for (int j = 0; j <array.length ; j++) {
                array2[i][j]=array[j][i];
            }
        }
        for (int i = 0; i <array[0].length; i++) {
            for (int j = 0; j <array.length ; j++) {
                array2[i][j]=array[j][i];
            }
        }
        array=array2;
        DirectionContext dirContext = new DirectionContext(Direction.RIGHT);
        PositionContext positionContext = new PositionContext(0, 0);
        List<PositionContext> visited = new ArrayList<>();
        List<Integer> snailValues = new ArrayList<>();

        while(!visited.contains(positionContext) && isValidPosition(array, positionContext)){
            System.out.println("Visited: "+ positionContext);
            visited.add(positionContext);
            snailValues.add(array[positionContext.getRow()][positionContext.getColumn()]);

            PositionContext positionContextAux = calculateNextPosition(dirContext, positionContext);

            if(visited.contains(positionContextAux) || !isValidPosition(array, positionContextAux)){
                dirContext = dirContext.getNextDirection();
                positionContext = calculateNextPosition(dirContext, positionContext);
            }else{
                positionContext = positionContextAux;
            }
        }

        return snailValues.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private static PositionContext calculateNextPosition ( DirectionContext dirContext, PositionContext positionContext ) {
        switch (dirContext.getCurrentDirection()){
            case RIGHT:
                return positionContext.moveRight();
            case DOWN:
                return positionContext.moveDown();
            case LEFT:
                return positionContext.moveLeft();
            case UP:
                return positionContext.moveUp();
            default:
                throw new IllegalStateException("Could not calculate next position");
        }
    }

    private static boolean isValidPosition ( int[][] array, PositionContext positionContext ) {

        return positionContext.getRow() >= 0
                && positionContext.getColumn() >= 0
                && array.length>positionContext.getRow()
                && array[positionContext.getRow()].length>positionContext.getColumn();

    }


    enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    static class PositionContext {

        private final int column;
        private final int row;

        PositionContext ( int column, int row ) {
            this.column = column;
            this.row = row;
        }

        public int getColumn () {
            return column;
        }

        public int getRow () {
            return row;
        }

        PositionContext moveRight(){
            return new PositionContext(column+1, row);
        }

        PositionContext moveLeft(){
            return new PositionContext(column-1, row);
        }

        PositionContext moveUp(){
            return new PositionContext(column, row-1);
        }
        PositionContext moveDown(){
            return new PositionContext(column, row+1);
        }

        @Override
        public boolean equals ( Object obj ) {
            if (obj instanceof PositionContext) {
                PositionContext positionContext = (PositionContext) obj;
                return getRow()==positionContext.getRow() && getColumn()==positionContext.getColumn();
            }
            return false;
        }

        @Override
        public String toString(){
            return "("+getRow()+","+getColumn()+")";
        }
    }

    static class DirectionContext {

        private final Direction current;

        DirectionContext (Direction current) {
            this.current = current;
        }

        Direction getCurrentDirection () {
            return current;
        }

        DirectionContext getNextDirection () {
            switch (current) {
                case RIGHT:
                    return new DirectionContext(Lab02_20190808064.Direction.DOWN);
                case DOWN:
                    return new DirectionContext(Lab02_20190808064.Direction.LEFT);
                case LEFT:
                    return new DirectionContext(Lab02_20190808064.Direction.UP);
                case UP:
                    return new DirectionContext(Lab02_20190808064.Direction.RIGHT);
                default:
                    throw new IllegalStateException("Could not find next direction for " + current);
            }
        }
    }
}

