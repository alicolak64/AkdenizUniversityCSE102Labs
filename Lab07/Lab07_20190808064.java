
/**
 * @author Ali Çolak
 * 2.03.2021
 */
public class Lab07_20190808064 {

    public static void main(String[] args) {

        RemoteControl tv=new TelevisionControl("LG",3500);
        tv.open();
        System.out.println("tv is open:"+tv.isOpen());

        System.out.println("current channel:"+((TelevisionControl)tv).getCurrentChannel());
        ((TelevisionControl) tv).setCurrentChannel(5);
        System.out.println("current channel:"+((TelevisionControl)tv).getCurrentChannel());

        tv.close();
        System.out.println("tv is open:"+tv.isOpen());


        AirConditionerControl airConditioner = new AirConditionerControl(31,17,"Arcelik",7000);
        airConditioner.open();
        System.out.println("air conditioner is open : "+airConditioner.isOpen());

        System.out.println("current heat : "+airConditioner.getCurrentHeat());
        airConditioner.coolDown();
        airConditioner.coolDown();
        airConditioner.coolDown();

        System.out.println("current heat : "+airConditioner.getCurrentHeat());
        airConditioner.warmUp();
        System.out.println("current heat : "+airConditioner.getCurrentHeat());

    }

}
abstract class RemoteControl {

    public boolean isOpen;
    private String brand;
    private int frequency;

    public RemoteControl(String brand, int frequency) {
        this.brand = brand;
        this.frequency = frequency;
    }

    abstract public void open();

    abstract public void close();

    public boolean isOpen() {
        return isOpen;
    }

    public String getBrand() {
        return brand;
    }

    public int getFrequency() {
        return frequency;
    }
}

class TelevisionControl extends RemoteControl {

    private int currentChannel;

    public TelevisionControl(String brand, int frequency) {
        super(brand, frequency);
        this.currentChannel =1;
    }

    @Override
    public void open() {

        if (isOpen){
            throw new RemoteControlException("Television is already opened");
        }else isOpen=true;

    }

    @Override
    public void close() {

        if (!isOpen){
            throw new RemoteControlException("Television is already closed");
        }else isOpen=false;

    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }
}

class AirConditionerControl extends RemoteControl {

    private int maxHeat ;
    private int minHeat ;
    private int currentHeat ;

    public AirConditionerControl( int maxHeat, int minHeat ,String brand, int frequency) {
        super(brand, frequency);
        this.maxHeat = maxHeat;
        this.minHeat = minHeat;
        this.currentHeat=24;
        if (maxHeat<30) throw new RemoteControlException("Maximum heat can not be lower than 30");
        if (minHeat>18) throw new RemoteControlException("Minimum heat can not be greater than 18");
    }

    @Override
    public void open() {

        if (isOpen){
            throw new RemoteControlException("Air conditioner is already opened");
        }else isOpen=true;

    }

    @Override
    public void close() {

        if (!isOpen){
            throw new RemoteControlException("Air conditioner is already closed");
        }else isOpen=false;

    }

    public void coolDown(){

        if (isOpen){

            if (currentHeat==minHeat){
                throw new RemoteControlException("Error: minimum heat reached");
            }else currentHeat--;

        }else throw new RemoteControlException("Air conditioner is  closed");

    }

    public void warmUp(){

        if (isOpen){

            if (currentHeat==maxHeat){
                throw new RemoteControlException("Error: maximum heat reached");
            }else currentHeat++;

        }else throw new RemoteControlException("Air conditioner is  closed");

    }

    public int getMaxHeat() {
        return maxHeat;
    }

    public int getMinHeat() {
        return minHeat;
    }

    public int getCurrentHeat() {
        return currentHeat;
    }
}



class RemoteControlException extends RuntimeException {

    public RemoteControlException(String message) {
        super(message);
    }
}