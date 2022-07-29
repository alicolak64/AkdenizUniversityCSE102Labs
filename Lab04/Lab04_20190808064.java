/**
 * @author Ali Çolak
 * 2.03.2021
 */

public class Lab04_20190808064 {
    public static void main(String[] args) {
        Author author=new Author("Halit Ziya","Uşaklıgil","halitziya@gmail.com");
        Author author2=new Author("İskender","Pala","iskenderpala@gmail.com");
        Book book=new Book("ISBN252545","Öd",author2,25.8);
        PaperBook book2=new PaperBook("ISBN252548","Aşkı Memnu",author,28.4,20,true);
        EBook book3=new EBook("ISBN252547","Öd",author2,"www.n11/öd.com",35.6);
        System.out.println(author.getMail());
        System.out.println(author.getName());
        System.out.println(author.getSurName());
        System.out.println(book.getPrice());
        System.out.println(book.getAuthor());
        System.out.println(book.getIsbn());
        System.out.println(book.getTitle());
        System.out.println(book2.getInStock());
        System.out.println(book2.getPrice());
        System.out.println(book2.getShippingWeight());
        System.out.println(book2.getAuthor());
        System.out.println(book2.getTitle());
        System.out.println(book2.getIsbn());
        book2.setInStock(false);
        System.out.println(book3.getTitle());
        System.out.println(book3.getIsbn());
        System.out.println(book3.getAuthor());
        System.out.println(book3.getPrice());
        System.out.println(book3.getDownloadUrl());
        System.out.println(book3.getSizeMb());


    }

}
class Author{
    private String name;
    private String surName;
    private String mail;

    public Author(String name, String surName, String mail) {
        this.name = name;
        this.surName = surName;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
class Book{

    private String isbn;
    private String title;
    private Author author;
    private double price;

    public Book(String isbn, String title, Author author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(String isbn, String title, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price=15.25;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
class EBook extends Book{

    private String downloadUrl;
    private double sizeMb;

    public EBook(String isbn, String title, Author author, double price, String downloadUrl, double sizeMb) {
        super(isbn, title, author, price);
        this.downloadUrl = downloadUrl;
        this.sizeMb = sizeMb;
    }

    public EBook(String isbn, String title, Author author, String downloadUrl, double sizeMb) {
        super(isbn, title, author);
        this.downloadUrl = downloadUrl;
        this.sizeMb = sizeMb;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getSizeMb() {
        return sizeMb;
    }
}
class PaperBook extends Book{
    private double shippingWeight;
    private boolean inStock;

    public PaperBook(String isbn, String title, Author author, double price, double shippingWeight, boolean inStock) {
        super(isbn, title, author, price);
        this.shippingWeight = shippingWeight;
        this.inStock = inStock;
    }

    public PaperBook(String isbn, String title, Author author, double shippingWeight, boolean inStock) {
        super(isbn, title, author);
        this.shippingWeight = shippingWeight;
        this.inStock = inStock;
    }

    public double getShippingWeight() {
        return shippingWeight;
    }

    public boolean getInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
