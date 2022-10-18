public class Email
{
    private Order order;
    
    public Email(Order order)
    {
        this.order = order;
    }

    public void send(){
        String sendEmail = "\n";
        
        if(order.isPaymentSuccessful()){
            sendEmail +=
                    "Payment Successful \n" +
                    "Email: " + order.getCustomer().getEmailAddress() + "\n" +
                    "Customer: " + order.getCustomer().getFirstName() + " " +
                    order.getCustomer().getSurname() + "\n" +
                    "Order No.: #" + order.getId() + "\n" +
                    order + "\n" +
                    "Delivery Address:\n" + order.getShippingAddress() + "\n" +
                    "Billing Address:\n" + order.getPayment().getBillingAddress() + "\n";
        }
        else{
             sendEmail +=
                    "Payment Unsuccessful \n" +
                    "Email: " + order.getCustomer().getEmailAddress() + "\n" +
                    "Dear Customer, " + order.getCustomer().getFirstName() + " " +
                    order.getCustomer().getSurname() + "\n" +
                    "Your order could not be placed." + "\n" +
                    "Please verify your payment method!" + "\n" +
                    "Order unsuccessful, please try again.\n";
        }
        System.out.println(sendEmail);
    }
}
