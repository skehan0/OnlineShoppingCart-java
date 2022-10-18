public class Address
{
    private String street;
    private String city;
    private String county;
    private String zip;

    public Address(String street, String city, String county, String zip)
    {
       this.street = street;
       this.city = city;
       this.county = county;
       this.zip = zip;  
    }
    
     public void setStreet(String street) { // sets address
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override // defines the specific address to the customer
    public String toString() {
        return  
            "\tStreet: " + street + "\n" +
            "\tCity: " + city + "\n" +
            "\tCountry: " + county + "\n" +
            "\tZIP: " + zip;
    }
}
