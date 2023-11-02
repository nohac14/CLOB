// import java.io.BufferedReader;
import java.io.File;
// import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner; 
import java.util.ArrayList;

public class App {
     private static ArrayList<Order> ordersArr = new ArrayList<Order>();
    
    public static void main(String[] args) throws Exception {
        // File file = new File("F:\\Personal Projects\\Stock Trading Engine\\CLOB\\src\\orders.in");
        // BufferedReader br = new BufferedReader(new FileReader(file));
        Scanner kB = new Scanner(System.in);
        // fillOrders(kB, file);

        boolean yOn = true;
        while (yOn) {
            System.out.print("(1:formatTest)\n(2:MatchTest)\nWhat do you want to do? : ");
            if (kB.nextInt() == 1) {  
                clearScreen();
                formatTest(kB);
                yOn = RUD(kB);
            }
            if (kB.nextInt() == 2) {
                clearScreen();
                matchTest();
                System.out.println(matchTest());
                yOn = RUD(kB);
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static boolean RUD(Scanner kB) {
        System.out.print("Are you done? : ");
        if (kB.nextInt() == 1)  {
            return false;
        }
        else {
            clearScreen();
            return true;
        }
    }

    public static boolean matchTest() {
        Order order1 = new Order(
            new Ticker("TW"),
            new Trader("trader1"),
            true,
            99.50,
            100,
            Status.OPEN
        );
        order1.printOrder();
        Order order2 = new Order(
            new Ticker("TW"),
            new Trader("trader2"),
            false,
            99.50,
            100,
            Status.OPEN
        );
        order2.printAnotherOrder();

        return isMatch(order1, order2);     
    }

    public static void formatTest(Scanner kB) {
        System.out.print("Enter test case #: ");
        while (true) {    
            if (kB.nextInt() == 1) {
                Order order = new Order(
                    new Ticker("TW"),
                    new Trader("trader1"),
                    true,
                    99.50,
                    100,
                    Status.OPEN
                );
                order.printOrder();
                break;
            }
            else if (kB.nextInt() == 2) {
                Order order1 = new Order(
                    new Ticker("TW"),
                    new Trader("trader1"),
                    true,
                    99.50,
                    100,
                    Status.OPEN
                );
                order1.printOrder();
                Order order2 = new Order(
                    new Ticker("TW"),
                    new Trader("trader2"),
                    false,
                    99.60,
                    200,
                    Status.OPEN
                );
                order2.printAnotherOrder();
                break;
            }
            else if (kB.nextInt() == 3) {
                Order order1 = new Order(
                    new Ticker("TW"),
                    new Trader("trader1"),
                    true,
                    99.50,
                    100,
                    Status.COMPLETED
                );
                order1.printOrder();
                Order order2 = new Order(
                    new Ticker("TW"),
                    new Trader("trader2"),
                    false,
                    99.50,
                    100,
                    Status.COMPLETED
                );
                order2.printAnotherOrder();
                break;
            }
            else {
                continue;
            }
        }
    }

    public static boolean isMatch(Order order1, Order order2) {
        if (order1.getTrader().equals(order2.getTrader()) || (order1.getSide() == order2.getSide()) || 
                                order1.getStatus() != Status.OPEN || order2.getStatus() != Status.OPEN) { // do not want same trader or side
            return false;
        }
        else {
            if (order1.getSide() == false) { // order1 is selling
                if ((order1.getQuantity() - order1.getFilledQuantity()) >= (order2.getQuantity() - order2.getFilledQuantity())) // is there enough stock for sale
                    return priceMatch(order1, order2);
                else
                    return false;
            }
            else {
                if ((order2.getQuantity() - order2.getFilledQuantity()) >= (order1.getQuantity() - order1.getFilledQuantity())) 
                    return priceMatch(order2, order1);
                else
                    return false;
            }
        }
    }

    public static boolean priceMatch(Order orderS, Order orderB) {
        if ((orderS.getLimit() + 1) >= orderB.getLimit() || (orderB.getLimit() + 1) >= orderS.getLimit() || orderS.getLimit() == orderB.getLimit()) {
            return true;
        }
        else
            return false;
    }

    public static void fillOrders(Scanner k, File file) {
        while (k.hasNextLine()) {
            
        }
    }

}
