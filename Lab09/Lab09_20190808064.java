import java.util.Arrays;

/**
 * @author Ali Çolak
 * 2.03.2021
 */
public class Lab09_20190808064 {

    public static void main(String[] args) {
        Stack <String> stack = new Stack(5);
        stack.push("Ali");
        System.out.println(stack.size());
        System.out.println(stack.capacity());
        stack.push("Emre");
        System.out.println(stack.toString());
        stack.push("Sefa");
        stack.push("Sefa");
        stack.push("Emrah");
        System.out.println(stack.pop());
        System.out.println(stack.pop());



    }

}

interface IStructure <T>{

    boolean isEmpty () ;

    int size () ;

    int capacity () ;

    String toString ();

}

abstract class Structure <T> {

    private T [] elements ;

    public Structure(int capacity) {

        elements = (T[]) new Object[capacity] ;

    }

    public T[] getElements() {
        return elements;
    }

}

class Stack <T> extends Structure implements IStructure {

    private int capacity ;

    public Stack(int capacity) {
        super(capacity);
        capacity = 0;
    }

    @Override
    public boolean isEmpty() {
        if (capacity==0){
            return true;
        }else return false;
    }

    @Override
    public int size() {
        return  capacity;
    }

    @Override
    public int capacity() {
        return getElements().length;
    }

    @Override
    public String toString () {
        return Arrays.toString(getElements());
    }

    public void push (T element) {

        if (capacity==getElements().length){
            throw new RuntimeException();
        }else {
            getElements() [capacity] = element;
            capacity++;
        }
    }

    public T pop () {
        if (capacity==0){
            throw new RuntimeException();
        }else {
            capacity--;
            return (T) getElements() [capacity];
        }

    }
}

class Queque <T> extends Structure implements IStructure {

    private int capacity ;

    public Queque(int capacity) {
        super(capacity);
        capacity=0;
    }


    @Override
    public boolean isEmpty() {
        if (capacity==0){
            return true;
        }else return false;
    }

    @Override
    public int size() {
        return  capacity;
    }

    @Override
    public int capacity() {
        return getElements().length;
    }

    @Override
    public String toString () {
        return Arrays.toString(getElements());
    }

    public void  queue (T element) {
        if (capacity==getElements().length){
            throw new RuntimeException();
        }else  {
            getElements() [capacity] = element;
            capacity++;
        }
    }

    public T dequeue () {
        if (capacity==0) {
            throw new RuntimeException();
        }else {
            capacity--;
            return (T) getElements() [0];
        }

    }

}
