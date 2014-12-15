package version2.Strategy;

import version2.Records.Item;

/**
 * Created by Brenda on 12/15/14.
 */
public class SubReduce extends Strategy {

    private float subtotal;
    private float reduce;

    public SubReduce(float subtotal, float reduce) {
        this.subtotal = subtotal;
        this.reduce = reduce;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getReduce() {
        return reduce;
    }

    public void setReduce(float reduce) {
        this.reduce = reduce;
    }

    @Override
    public Item diffModify(Item item) {
        Item temp = new Item(item);
        if (temp.getTotal() >= subtotal){
            temp.setTotal(temp.getTotal()- reduce);
        }
        return temp;

    }
}
