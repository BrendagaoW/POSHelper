package version2.Strategy;

import version2.Parser.Parser;
import version2.Parser.SecondParser;
import version2.Records.Discount;
import version2.Records.Item;
import version2.Records.SecondHalf;

import java.io.IOException;
import java.util.List;

/**
 * Created by Brenda on 12/15/14.
 */
public class SecondStrategy extends Strategy{
    private static List<Item> secondHalfList;
    @Override
    public Item diffModify(Item item) {
        Item temp = new Item(item);
        for (Item secondHalf:secondHalfList){
            if (temp.equals(secondHalf)){
                temp.setNumber(temp.getNumber()-(float)((int)(temp.getNumber()/2)*0.5));
                return temp;
            }
        }
        return item;
    }

    public SecondStrategy(String path)throws IOException{
        Parser secondParser = new SecondParser();
        secondHalfList = secondParser.parse(path);

    }
}
