/**
 * Created by Brenda on 11/21/14.
 */

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * get the item list
 */
public class ItemList extends Items{
//    private String path;
    protected Map<String, Integer> items;

    ItemList(String filePath) throws IOException {
        setPath(filePath);

        createItems();
    }

    public void createItems()throws IOException{
        items = new HashMap<String, Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(getPath()));
        String string;
        while((string = reader.readLine()) != null){
            String[] list = string.split(":");
            items.put(list[0],Integer.parseInt(list[1]));
        }
        reader.close();
    }

    public boolean containItem(String item){
        if (items.containsKey(item)){
            return true;
        }else{
            return false;
        }
    }

    //if there is item already, just modify its price with the new price; else add the new item and its price
    public void addItem(String item, int price) throws IOException{
        items.put(item,price);
        writeList();
    }


    public void deleteItem(String item) throws IOException{
        if (containItem(item)){
            items.remove(item);
            writeList();
        }
    }

    public void writeList() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(getPath()));
        for (String item:items.keySet()){
            writer.write(item + ":" + items.get(item) + "\n");
        }
        writer.close();
    }

    public Map<String, Integer> getItems(){
        return items;
    }

    public int getValue(String item){
        if (!containItem(item))
            return -1;
        return items.get(item);
    }
}
