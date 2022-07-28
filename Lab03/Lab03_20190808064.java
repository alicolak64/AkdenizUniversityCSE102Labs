package LabExercises2;


import java.util.Date;

/**
 * @author Ali Çolak
 * 16.03.2021
 */
public class Lab03_20190808064 {
    
    public static void main(String[] args) {
        
        Date date = new Date();
        
        Person person =new Person("Ali","Çolak","05525490064");
        
        City city1=new City("64400","Uşak");
        City city2=new City("07720","Antalya");
        
        Ticket ticket1=new Ticket(city1,city2,date,16);
        Ticket ticket2=new Ticket(city1,city2,15);
        
        System.out.println(ticket1.getDate());
        System.out.println(ticket1.getSeat());
        System.out.println(ticket1.getFrom());
        System.out.println(ticket1.getTo());
        System.out.println(ticket2.getDate());
        System.out.println(person.getName());
        System.out.println(person.getPhoneNumber());
        System.out.println(person.getSurName());
        
    }
    
}

class Ticket{
    
    private City from;
    private City to;
    private Date date;
    private int seat;

    public Ticket(City from, City to, Date date, int seat) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.seat = seat;
    }

    public Ticket(City from, City to, int seat) {
        this.from = from;
        this.to = to;
        this.seat = seat;
        Date now=new Date();
        this.date=new Date(now.getTime()+(1000*60*60*24));
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
class City{
    private String postalCode;
    private String name;

    public City(String postalCode, String name) {
        this.postalCode = postalCode;
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getName() {
        return name;
    }
}
class Person{
    private String name;
    private String surName;
    private String phoneNumber;

    public Person(String name, String surName, String phoneNumber) {
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

