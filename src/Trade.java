import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Trade {
    private Ticker ticker;
    private double price;
    private int quantity;
    private Order buyOrder;
    private Order sellOrder;
    private LocalDateTime createdAt;

    public Trade(Ticker ticker, double price, int quantity, Order buyOrder, Order sellOrder, LocalDateTime createdAt) {
        this.ticker = ticker;
        this.price = price;
        this.quantity = quantity;
        this.buyOrder = buyOrder;
        this.sellOrder = sellOrder;
        this.createdAt = LocalDateTime.now(); // current date and time
    }
    
    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Order getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(Order buyOrder) {
        this.buyOrder = buyOrder;
    }

    public Order getSellOrder() {
        return sellOrder;
    }

    public void setSellOrder(Order sellOrder) {
        this.sellOrder = sellOrder;
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
}