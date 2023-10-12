import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private Ticker ticker;
    private Trader trader;
    private boolean side;
    private double limit;
    private int quantity;
    private int filledQuantity;
    private LocalDateTime createdAt;
    
    public Order(Ticker ticker, Trader trader, boolean side, double limit, int quantity) {
        this.ticker = ticker;
        this.trader = trader;
        this.side = side;
        this.limit = limit;
        this.quantity = quantity;
        this.filledQuantity = 0;
        this.createdAt = LocalDateTime.now(); // current date and time
    }
    
    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public boolean isSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFilledQuantity() {
        return filledQuantity;
    }

    public void setFilledQuantity(int filledQuantity) {
        this.filledQuantity = filledQuantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void printCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = createdAt.format(formatter);
        System.out.println("Order created at: " + formattedDate);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = createdAt.format(formatter);
        return "Order created at: " + formattedDate;
    }

    public void printOrder() {
        String sideStr = side ? "buy" : "sell";
        System.out.println("| ticker | trader  | side | limit  | quantity |");
        System.out.printf("| %-6s | %-7s | %-4s | $%-6.2f | %-8d |\n", ticker, trader, sideStr, limit, quantity);
    }
}
