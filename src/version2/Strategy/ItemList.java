package version2.Strategy;

import version2.Parser.ItemParser;
import version2.Parser.Parser;
import version2.Records.Discount;
import version2.Records.Item;
import version2.Records.Items;

import java.io.IOException;
import java.util.List;

/**
 * Created by Brenda on 12/15/14.
 */
public class ItemList extends Strategy {

    private static List<Item> itemsList;

    public ItemList(String path)throws IOException{
        Parser itemParser = new ItemParser();
        itemsList = itemParser.parse(path);
    }

    @Override
    public Item diffModify(Item item) {
        Item temp = new Item(item);
        for (Item item1:itemsList){
            if (temp.equals(item1)){
                temp.setPrice(item1.getPrice());
                return temp;
            }
        }
        return temp;
    }
}
