import java.util.Iterator;

public class OrderWithUid extends Order { // open-closed principle
    private String uid;

    public OrderWithUid(String uid) {
        super();
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public void printCart() { //Liskov substitution principle

        Iterator<Product> iterator = getCartDetails().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("All products reserved for " + uid);
    }
}
