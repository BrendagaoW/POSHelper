package version2.Records;

/**
 * Created by Brenda on 11/28/14.
 */
public class Item <T extends Item>{
    private String itemID;
    private float price;
    private float number;
    private float total;

    public Item(String itemID) {
        this.itemID = itemID;
        this.price = 0;
        this.number = 0;
        this.total = 0;
    }

    public Item(){
        this.itemID = null;
        this.price = 0;
        this.number = 0;
        this.total = 0;
    }

    public Item(Item item){
        this.itemID = item.itemID;
        this.price = item.price;
        this.number = item.number;
        this.total = item.total;
    }

    public void setItemID(String id){
        this.itemID = id;
    }

    public void setNumber(float number) {
        this.number = number;
        total = number*price;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getNumber() {

        return number;
    }

    public float getTotal() {
        return total;
    }

    public String getItemID(){
        return itemID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float value){
        this.price = value;
        total = number*price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (itemID != null ? !itemID.equals(item.itemID) : item.itemID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return itemID != null ? itemID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "\n" + itemID + "\t" + getPrice() + "\t" + getNumber() + "\t" + getTotal();
    }
}
