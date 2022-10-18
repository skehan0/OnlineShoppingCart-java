/**
 * Gavin Skehan
 * Assignment 2
 * 14/10/22
 */
public class TransactionTest
{   
    public static void main(String[] args){
        TransactionTest test = new TransactionTest();
        test.transaction1();
        test.transaction2();
    }
    
    public void transaction1(){
        // 1. create new customer
        Customer customer = new Customer("Niamh", "O'Leary", "niamhol@zmail.com");
        // create shopping cart for the customer
        ShoppingCart cart = new ShoppingCart(customer);
        
        // 2. Create and add items
        Item item1 = new Item("toothbrush");
        Item item2 = new Item("dog food");
        Item item3 = new Item("dougnuts");
        
        // 3. add items with known cost
        item1.setPrice(2.00f);
        item2.setPrice(3.50f);
        item3.setPrice(5.25f);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        
        // 4. Create a new order
        cart.close();
        Order order = new Order(cart, customer);
        
        // 5. Create and Address
        Address billingAddress = new Address("16 downstreet", "Portloaise",
                "Co.Laois", "R23 UX5V");
        Address shippingAddress = new Address("16 downstreet", "Portlaoise",
                "Co.Laois", "R23 UX5V");

        order.setShippingAddress(shippingAddress);
        
        // 6. Add a Payment type
        Payment payment = new Payment(billingAddress, "mastercard",
        "1234 5678 9876 5432", "01/01/2023");
        order.setPayment(payment);

        // 8. Email
        Email email = new Email(order);
        email.send();
    }
    
    public void transaction2(){
        Customer customer = new Customer("Cathal", "Farrel",
                "cfarrel@zmail.com");

        ShoppingCart cart = new ShoppingCart(customer);

        Item item1 = new Item("beer");
        Item item2 = new Item("popcorn");
        Item item3 = new Item("movie");

        item1.setPrice(18.00f);
        item2.setPrice(2.75f);
        item3.setPrice(5.25f);
        
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        
        System.out.println(cart);
        
        cart.removeItem(item3);

        cart.close();
        Order order = new Order(cart, customer);


        Address billingAddress = new Address("6 Crossroads", "Galway",
                "Co.Galway", "U56 YY23");
        Address shippingAddress = new Address("6 Crossroads", "Galway",
                "Co.Galway", "U56 YY23");

        order.setShippingAddress(shippingAddress);

        Payment payment = new Payment(billingAddress, "Revolut",
                "1111 2222 3333 4444", "10/11/2024");
        order.setPayment(payment);

        Email email = new Email(order);
        email.send();
    }
}
