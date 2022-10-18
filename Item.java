public class Item
{
    private String name;
    private float price;
    private static int prevId = 0;
    private int id;

    public Item(String name){
        this.name = name;
        id = makeId();
    }
    
    public Item (String name, float price) {
        this.name = name;
        this.price = price;
        id = makeId();
    }
    
    public int makeId(){
        int id = prevId + 1;
        prevId = id;
        
        return id;
    }
    
    public void setPrice(float price){
        this.price = price;
    }
    
    public float getPrice(){
        return price;
    }
    
    public String toString(){ // returns a string representation of the method
        String out = "Item ID: " + id + "\t" + name + "\t" + "Price: " + price;
        return out;
    }
}
