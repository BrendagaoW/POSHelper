package version2.Parser;

import version2.Records.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brenda on 11/27/14.
 */
public abstract class Parser<V> {

    public List<Item> parse(String path) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<Item> valueList = new ArrayList<Item>();
        while(bufferedReader.read() != -1){
            valueList.add(convert(bufferedReader.readLine()));
        }
        bufferedReader.close();
        return valueList;
    }

    protected abstract Item convert(String line);
}
