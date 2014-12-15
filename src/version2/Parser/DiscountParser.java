package version2.Parser;

import version2.Records.Discount;
import version2.Records.Item;

/**
 * Created by Brenda on 11/28/14.
 */
public class DiscountParser extends Parser{

    @Override
    protected Item convert(String line) {
        String [] item = line.split(":");
        Item temp = new Item(item[0]);
        temp.setPrice(Float.parseFloat(item[1])/100);
        return temp;
    }

}
