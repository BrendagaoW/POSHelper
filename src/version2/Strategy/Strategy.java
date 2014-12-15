package version2.Strategy;

import version2.Records.Discount;
import version2.Records.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brenda on 12/13/14.
 */
public abstract class Strategy {

    public List<Item> modify(List<Item> items){
        List<Item> newLists = new ArrayList<Item>();
        for (Item item:items){
            Item temp = diffModify(item);
            newLists.add(temp);
        }
        return newLists;
    }

    public abstract Item diffModify(Item item);
}
