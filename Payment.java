public class Payment
{
    private Address billingAddress;
    private String cardType;
    private String cardNum;
    private boolean valid = false;
    
    public Payment(Address billingAddress, String cardType, String cardNum, String expDate){
        this.billingAddress = billingAddress;
        this.cardType = cardType;
        this.cardNum = cardNum;
        valid = validate();
    }
    
      private boolean validateCardType() {
        String cType = cardType.toLowerCase(); // coverts a given string to lowercase eg M==m 

        String[] validCardTypes = {"mastercard", "visa"}; // valid car types
        for (String validType : validCardTypes) {
            if (cType.equals(validType)) {
                return true;
            }
        }
        return  false;
    }
    
     private boolean validateCardNumber() {
        String cardNumber = cardNum.replaceAll(" ", ""); // replaces a sequence of characters
        if (cardNumber.length() != 16) { // card number must have 16 digits
            return false;
        }
        return true;
    }
    
     private boolean validate() {
        if (!validateCardType()) {
        // Invalid card type
            return false;
        }

        if (!validateCardNumber()) {
        //  Invalid card number
            return false;
        }
        return true; 
    }

    public boolean validated() {
        return valid;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }
}
