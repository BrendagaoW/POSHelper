package version2.Parser;

import version2.Records.Item;
import version2.Records.Items;

/**
 * Created by Brenda on 11/28/14.
 */
public class ItemParser extends Parser {

    @Override
    protected Item convert(String line) {
        String [] item = line.split(":");
        Item temp = new Item(item[0]);
        temp.setPrice(Integer.parseInt(item[1]));
        return temp;
    }

}
