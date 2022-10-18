import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart
{
    private static int prevId = 0;
    private final int id;
    private float total;
    private Customer customer;
    private ArrayList<Item> items;
    private boolean closed = false;

    public ShoppingCart(Customer customer)
    {
        Date curDate = new Date( );
        SimpleDateFormat ft = 
        new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz"); // date format

        System.out.println("Current Date: " + ft.format(curDate)); // prints curDate
        
        this.customer = customer;
        items = new ArrayList<>();
        // counts customers in order
        id = prevId + 1;
        prevId = id;
    }

    public void addItem(Item item){
        if(closed) {
            System.out.println("Shopping cart is closed");
            System.out.println("You cant add more items");
            return;
        }
        else{
        items.add(item);
        total += item.getPrice();
        }
    }
    
    public void removeItem(Item item){
        if(closed){
            System.out.println("Shopping cart closed");
            System.out.println("You can't remove items");
            return;
        }
        else{
        items.remove(item); 
        total -= item.getPrice();
        }
    }
    
    public float getTotal(){
        return total;
    }
    
    public void close(){
        System.out.println("You closed your shopping cart");
        closed = true;
    }
    
    public void clear(){
        items = new ArrayList<>();
        total = 0;
    }
    
    public ArrayList<Item> getItems(){
        return items;
    }
    
    @Override
    public String toString(){
        String out = "\n" +
                "Shopping Cart\n" +
                "Cart No: #" + id + "\n" +
                "Customer: " + customer.getFirstName() + " " + customer.getSurname() +
                " Items:\n";
        for (Item item : items) {
            out += "\t- " + item + "\n";
        }

        out += "Total: €" + String.format("%.02f", total) + "\n";
        return out;
    }
}
