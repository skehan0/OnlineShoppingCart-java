public class Customer
{
    private String firstName;
    private String surname;
    private String emailAddress;
    private final long customerId;

    public Customer(String firstName, String surname, String emailAddress){
        this.firstName = firstName;
        this.surname = surname;
        this.emailAddress = emailAddress;
        customerId = makeCustomerId();
    }
    
    public long getId(){
        return customerId;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getSurname(){
        return surname;
    }
    
     public String getEmailAddress() {
        return emailAddress;
    }
    
     private long makeCustomerId() {
        return (long)Math.random() * 99999999999999L; // L needed for large number
    }
}
