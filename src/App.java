import java.io.IOException;
import java.util.Scanner; 

public class App {
    public static void main(String[] args) throws Exception {
        Scanner kB = new Scanner(System.in);
        formatTest(kB);
        RUD(kB);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void RUD(Scanner kB) {
        System.out.print("Are you done? : ");
        if (kB.nextInt() == 1) 
            clearScreen();
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
}
