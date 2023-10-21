import java.io.IOException;
import java.util.Scanner; 

public class App {
    public static void main(String[] args) throws Exception {
        Scanner kB = new Scanner(System.in);
        boolean yOn = true;
        while (yOn) {
            System.out.print("(1:formatTest)\nWhat do you want to do? : ");
            if (kB.nextInt() == 1) {  
                clearScreen();
                formatTest(kB);
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
        if (order1.getTrader().equals(order2.getTrader()) || (order1.getSide() == order2.getSide())) { // do not want same trader or side
            return false;
        }
        else {
            // checking status is open and same ticker
            if ((order1.getStatus() == Status.OPEN) && ((order1.getStatus() == Status.OPEN) && (order1.getTicker().equals(order2.getTicker())))) {
                if (order1.getSide()) {
                    if (order1.getFilledQuantity() == order1.getQuantity()) { // has the order been fullfilled?
                        order1.setStatus(Status.COMPLETED);
                        return false;
                    }
                }
                else {
                    if (order2.getFilledQuantity() == order2.getQuantity()) {
                        order2.setStatus(Status.COMPLETED);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
