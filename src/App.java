import java.util.Scanner; 

public class App {
    public static void main(String[] args) throws Exception {
        Scanner kB = new Scanner(System.in);
        System.out.print("Enter test case #: ");
        int testC = kB.nextInt();
        if (testC == 1) {
            Order order = new Order(
                new Ticker("TW"),
                new Trader("trader1", "password"),
                true,
                99.50,
                100
            );
            order.printOrder();
        }
        else if (testC == 2) {

        }
        else if (testC == 3) {
            
        }
        else if (testC == 3) {
            
        }
    }
}
