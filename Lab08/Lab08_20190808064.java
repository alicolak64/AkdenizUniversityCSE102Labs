import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Assert;

/**
 * @author Ali Çolak
 * 2.03.2021
 */
public class Lab08_20190808064 {


    @Test
    public void productConstructorTest1 (){
        Product yoghurt=new Product("1234571459","Yoghurt");
        Assert.assertEquals("1234571459",yoghurt.getBarcode());

    }

    @Test
    public void productConstructorTest2 (){
        Product yoghurt=new Product("1234571459","Yoghurt");
        Assert.assertEquals("Yoghurt",yoghurt.getName());
    }

    @Test
    public void barcodeFormatInvalidExceptionTest1 (){
        try {
            Product yoghurt=new Product("12345714595","Yoghurt");
        }catch (Exception e) {
            Assert.assertEquals(e instanceof BarcodeFormatInvalidException,true);
        }

    }

    @Test
    public void barcodeFormatInvalidExceptionTest2 (){
        try {
            Product yoghurt=new Product("12345714595","Yoghurt");
        }catch (Exception e) {
            Assert.assertEquals(e.getMessage(),"Barcode number must be consist of 10 digit");
        }

    }

    @Test
    public void productToStringTest () {
        Product yoghurt=new Product("1234571459","Yoghurt");
        Assert.assertEquals(yoghurt.toString(),"Product [barcode=1234571459, name=Yoghurt]");
    }

    @Test
    public void userConstructorTest1 (){
        User user=new User("yigitalkan","yigitalkan@akdeniz.edu.tr");
        Assert.assertEquals("yigitalkan",user.getUsername());

    }

    @Test
    public void userConstructorTest2 (){
        User user=new User("yigitalkan","yigitalkan@akdeniz.edu.tr");
        Assert.assertEquals("yigitalkan@akdeniz.edu.tr",user.getEmail());
    }

    @Test
    public void userToStringTest () {
        User user=new User("yigitalkan","yigitalkan@akdeniz.edu.tr");
        Assert.assertEquals(user.toString(),"User [email=yigitalkan@akdeniz.edu.tr, username=yigitalkan]");
    }

    @Test
    public void addToChartTest1 (){
        Product yoghurt=new Product("1234571459","Yoghurt");
        User user=new User("yigitalkan","yigitalkan@akdeniz.edu.tr");
        Chart chart=new Chart(user);
        chart.addToChart(yoghurt);
        Assert.assertEquals(chart.toString(),"Chart [products=[Product [barcode=1234571459, name=Yoghurt], null, null], user=User [email=yigitalkan@akdeniz.edu.tr, username=yigitalkan]]");
    }


    @Test
    public void addToChartTest2 (){
        Product yoghurt=new Product("1234571459","Yoghurt");
        Product bread=new Product("1452647852","Bread");
        User user=new User("yigitalkan","yigitalkan@akdeniz.edu.tr");
        Chart chart=new Chart(user);
        chart.addToChart(yoghurt);
        chart.addToChart(bread);
        Assert.assertEquals(chart.toString(),"Chart [products=[Product [barcode=1234571459, name=Yoghurt], Product [barcode=1452647852, name=Bread], null], user=User [email=yigitalkan@akdeniz.edu.tr, username=yigitalkan]]");
    }

    @Test
    public void addToChartTest3 (){
        Product yoghurt=new Product("1234571459","Yoghurt");
        Product bread=new Product("1452647852","Bread");
        Product cola=new Product("1245631587","Cola");
        User user=new User("yigitalkan","yigitalkan@akdeniz.edu.tr");
        Chart chart=new Chart(user);
        chart.addToChart(yoghurt);
        chart.addToChart(bread);
        chart.addToChart(cola);
        Assert.assertEquals(chart.toString(),"Chart [products=[Product [barcode=1234571459, name=Yoghurt], Product [barcode=1452647852, name=Bread], Product [barcode=1245631587, name=Cola]], user=User [email=yigitalkan@akdeniz.edu.tr, username=yigitalkan]]");
    }

    @Test
    public void shoppingChartFullExceptionTest1 (){
        Product yoghurt=new Product("1234571459","Yoghurt");
        Product bread=new Product("1452647852","Bread");
        Product cola=new Product("1245631587","Cola");
        Product huptrik=new Product("1234552475","Huptrik");
        User user=new User("yigitalkan","yigitalkan@akdeniz.edu.tr");
        Chart chart=new Chart(user);
        chart.addToChart(yoghurt);
        chart.addToChart(bread);
        chart.addToChart(cola);
        try {
            chart.addToChart(huptrik);
        }catch (Exception e){
            Assert.assertEquals(e instanceof ShoppingChartFullException,true);
        }
    }

    @Test
    public void shoppingChartFullExceptionTest2 (){
        Product yoghurt=new Product("1234571459","Yoghurt");
        Product bread=new Product("1452647852","Bread");
        Product cola=new Product("1245631587","Cola");
        Product huptrik=new Product("1234552475","Huptrik");
        User user=new User("yigitalkan","yigitalkan@akdeniz.edu.tr");
        Chart chart=new Chart(user);
        chart.addToChart(yoghurt);
        chart.addToChart(bread);
        chart.addToChart(cola);
        try {
            chart.addToChart(huptrik);
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),"Shopping chart can not exceed 3 products.");
        }
    }
}
