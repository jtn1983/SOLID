import java.util.Collection;

public interface IOrder {  //Interface segregation principle
    boolean addProduct(Product p);
    boolean removeProduct(String pid) throws ProductNotFoundException;
    Collection<Product> getCartDetails();
    Product getProductFromCart(String pid) throws ProductNotFoundException;
    int productCount();
    double getCartPrice();
    void printCart();
}
