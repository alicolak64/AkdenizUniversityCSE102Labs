import java.util.Arrays;

/**
 * @author Ali Çolak
 * 2.03.2021
 */
public class Lab06_20190808064 {

    public static void main(String[] args) {

        try {
            Product chips=new Product("lafs","Chips");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Product yoghurt=new Product("1234571459","Yoghurt");
        Product bread=new Product("1452647852","Bread");
        Product cola=new Product("1245631587","Cola");
        Product huptrik=new Product("1234552475","Huptrik");

        User user=new User("yigitalkan","yigitalkan@akdeniz.edu.tr");
        Chart chart=new Chart(user);

        chart.addToChart(yoghurt);
        System.out.println(chart);
        chart.addToChart(bread);
        System.out.println(chart);
        chart.addToChart(cola);
        System.out.println(chart);


        chart.addToChart(huptrik);

    }

}
class BarcodeFormatInvalidException extends RuntimeException{

    public BarcodeFormatInvalidException() {
        super("Barcode number must be consist of 10 digit");
    }

}

class ShoppingChartFullException extends RuntimeException {

    public ShoppingChartFullException() {
        super("Shopping chart can not exceed 3 products.");
    }
}

class Product {

    private String barcode;
    private String name;

    public Product(String barcode, String name) {
        this.name = name;
        if (barcode.length()==10){
            this.barcode=barcode;
        }else throw new BarcodeFormatInvalidException();
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product [barcode=" + barcode + ", name=" + name + "]";
    }
}

class User {

    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", username=" + username + "]";
    }
}

class Chart{

    private User user;
    private Product [] products;

    public Chart(User user) {
        this.user = user;
        this.products=new Product[3];
    }

    public void addToChart(Product product) {

        if(products[0]==null) products[0]=product;
        else if(products[1]==null) products[1]=product;
        else if(products[2]==null) products[2]=product;
        else throw new ShoppingChartFullException();

    }

    @Override
    public String toString() {
        return "Chart [products=" + Arrays.toString(products) + ", user=" + user + "]";
    }
}



