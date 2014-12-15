package version2.Parser;

import version2.Records.Item;
import version2.Records.SecondHalf;

/**
 * Created by Brenda on 11/28/14.
 */
public class SecondParser extends Parser{
    @Override
    protected Item convert(String line) {
        Item item = new Item(line);
        return item;
    }
}
