/**
 * @author Ali Çolak
 * 2.03.2021
 */

public class Lab05_20190808064 {

    public static void main(String[] args) {

        Cpu cpu1=new Cpu("i7","4700Mhz");
        System.out.println(cpu1.toString());

        Cpu cpu2=new Cpu("i5","3700Mhz");
        System.out.println(cpu2.toString());

        Memory memory1=new Memory("ddr3",4);
        System.out.println(memory1.toString());

        Memory memory2=new Memory("ddr4",12);
        System.out.println(memory2.toString());

        Laptop laptop=new Laptop(cpu1,memory1);
        System.out.println(laptop.toString());

        Desktop desktop=new Desktop(cpu2,memory2);
        System.out.println(desktop.toString());
    }

}

class Computer{

    private Cpu cpu;
    private Memory memory;

    public Computer(Cpu cpu, Memory memory) {
        this.cpu = cpu;
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Computer [cpu=" + cpu +
                ", memory=" + memory + "]";
    }

}

class Laptop extends Computer{

    public Laptop(Cpu cpu, Memory memory) {
        super(cpu, memory);
    }

    @Override
    public String toString() {
        return "Laptop ["+super.toString()+"]";
    }

}

class Desktop extends Computer{

    public Desktop(Cpu cpu, Memory memory) {
        super(cpu, memory);
    }

    @Override
    public String toString() {
        return "Desktop ["+super.toString()+"]";
    }

}

class Cpu {

    private String nane;
    private String frequency;

    public Cpu(String nane, String frequency) {
        this.nane = nane;
        this.frequency = frequency;
    }

    public String getNane() {
        return nane;
    }

    public void setNane(String nane) {
        this.nane = nane;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Cpu [" +
                "frequency="+frequency+", name="+nane+"]";
    }

}

class Memory {

    private String type;
    private int capacity;

    public Memory(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Memory [" +
                "capacity="+capacity+", type="+type+"]";
    }
}