package version2.Parser;

import version2.Records.Cart;
import version2.Records.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brenda on 11/28/14.
 */
public class CartParser extends Parser{

    @Override
    public List<Item> parse(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<Item> valueList = new ArrayList<Item>();
        while(bufferedReader.read() != -1){
            Item temp = convert(bufferedReader.readLine());
            if (valueList.contains(temp)){
                for (Item item:valueList){
                    if (item.equals(temp)){
                        item.setNumber(temp.getNumber()+item.getNumber());
                        break;
                    }
                }
            }
            else {
                valueList.add(temp);
            }
        }
        bufferedReader.close();
        return valueList;
    }

    @Override
    protected Item convert(String line) {
        String [] item = line.split("-");
        Item temp = new Item(item[0]);
        if (item.length == 1){
            temp.setNumber(1);
        }else {
            temp.setNumber(Integer.parseInt(item[1]));
        }
        return temp;
    }
}
