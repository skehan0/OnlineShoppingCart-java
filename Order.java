import java.util.ArrayList;

public class Order
{
    private static int prevId = 0;
    private int id;
    private ArrayList<Item> items = new ArrayList<>();
    private Address shippingAddress;
    private Payment payment;
    private float total;
    private Customer customer;
    private boolean paymentSuccessful = false;

    public Order(ShoppingCart cart, Customer customer)
    {
        this.customer = customer;
        items.addAll(cart.getItems());
        
        total = cart.getTotal();
        cart.clear();
        
        id = prevId + 1;
        prevId = id;
    }
    
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setPayment(Payment payment) {
        if (!payment.validated()) {
        // Your payment is not valid
            return;
        }
        else{
        this.payment = payment;
        this.paymentSuccessful = true;
        }
    }

    @Override
    public String toString() {
        String out = "Order Items: \n";

        for (Item item : items) {
            out += "\t- " + item + "\n";
        }

        out += "Total: €" + String.format("%.02f", total);

        return out;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isPaymentSuccessful() {
        return paymentSuccessful;
    }

    public int getId() {
        return id;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public Payment getPayment() {
        return payment;
    }
}
