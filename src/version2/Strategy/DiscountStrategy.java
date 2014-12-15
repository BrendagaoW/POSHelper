package version2.Strategy;

import version2.Parser.DiscountParser;
import version2.Parser.Parser;
import version2.Records.Item;

import java.io.IOException;
import java.util.List;

/**
 * Created by Brenda on 12/13/14.
 */
public class DiscountStrategy extends Strategy {

    private static List<Item> discountList;

    public DiscountStrategy(String path)throws IOException{
        Parser discountParser = new DiscountParser();
        this.discountList = discountParser.parse(path);
    }

    @Override
    public Item diffModify(Item item) {
        Item temp = new Item(item);
        for (Item dis:discountList){
            if (temp.equals(dis)){
                temp.setPrice(temp.getPrice()*dis.getPrice());
                return temp;
            }
        }
        return item;
    }


}
