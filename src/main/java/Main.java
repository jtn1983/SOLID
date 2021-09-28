import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product1 = new Product("101", "Soap", 1, 20);
        Product product2 = new Product("102", "Shampoo", 1, 100);
        Product product3 = new Product("103", "Foam", 1, 120);
        Product product4 = new Product("104", "Paste", 1, 220);

        HashMap<String, Product> products = new HashMap<>();
        products.put(product1.getPid(), product1);
        products.put(product2.getPid(), product2);
        products.put(product3.getPid(), product3);
        products.put(product4.getPid(), product4);

        printProductList(products);

        Order order = new Order();
        while (true) {
            System.out.println("Input product id or 0 for exit: ");
            String pid = scanner.nextLine();
            if (pid.equals("0")) {
                break;
            }
            if (products.containsKey(pid)) {
                order.addProduct(products.get(pid));
                System.out.println("Product added succefully");
                continue;
            }
            System.out.println("Product with pid " + pid + "does not exist");
        }

        order.printCart();

    }

    public static void printProductList(HashMap<String, Product> products){
        for(Map.Entry<String, Product> item : products.entrySet()) {
            System.out.println(item.getValue());
        }

    }
}
