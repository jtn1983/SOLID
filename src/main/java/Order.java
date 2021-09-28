import java.util.*;

public class Order implements IOrder { // single responsible principle

    private Map<String, Product> map;

    public Order(){
        map = new HashMap();
    }

    @Override
    public boolean addProduct(Product p) {
        if (map.containsKey(p.getPid())){
            Product p1 = map.get(p.getPid());
            p1.setPrice(p1.getPrice() + p.getPrice());
            p1.setQty(p1.getQty() + p.getQty());
            return true;
        }
        map.put(p.getPid(),p);
        return false;
    }

    @Override
    public boolean removeProduct(String pid) throws ProductNotFoundException {
        if (map.containsKey(pid)) {
            map.remove(pid);
            return true;
        } else {
            throw new ProductNotFoundException("Product with ID " + pid + " not found");
        }
    }

    @Override
    public Collection<Product> getCartDetails() {
        return map.values();
    }   //DRY

    @Override
    public Product getProductFromCart(String pid) throws ProductNotFoundException {
        if (map.containsKey(pid)) {
            return map.get(pid);
        } else {
            throw new ProductNotFoundException("Product with PID " + pid + " just not discovered");
        }
    }

    @Override
    public int productCount() {
        return map.size();
    }

    @Override
    public double getCartPrice() {
        double value = 0.0d;
        Iterator<Product> iterator = getCartDetails().iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            value += p.getPrice() * p.getQty();
        }
        return value;
    }

    @Override
    public void printCart() {
        Iterator<Product> iterator = getCartDetails().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
