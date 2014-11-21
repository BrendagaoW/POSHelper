import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Brenda on 11/21/14.
 */
public class Cart extends ItemList{

    Cart(String filePath) throws IOException {
        super(filePath);
    }

    @Override
    public void createItems()throws IOException{
        items = new TreeMap<String, Integer>();//be sorted
        BufferedReader reader = new BufferedReader(new FileReader(getPath()));
        String string;
        while((string = reader.readLine()) != null){
            String[] list = string.split("-");
            if (containItem(list[0])){
                if (list.length == 1){
                    items.put(list[0],items.get(list[0])+1);
                }
                else{
                    items.put(list[0],items.get(list[0])+Integer.parseInt(list[1]));
                }
            }
            else{
                if (list.length == 1){
                    items.put(list[0],1);
                }
                else{
                    items.put(list[0],Integer.parseInt(list[1]));
                }
            }
        }
        reader.close();
    }

    @Override
    public void addItem(String item, int number) throws IOException{
        int howMany = number;
        if (containItem(item)){
            howMany += items.get(item);
            if (howMany < 0){
                deleteItem(item);
                return;
            }
        }
        items.put(item,howMany);
        writeList();
    }

    public void addItem(String item) throws IOException{
        addItem(item,1);
    }

    @Override
    public void writeList() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(getPath()));
        for (String item:items.keySet()){
            writer.write(item + "-" + items.get(item) + "\n");
        }
        writer.close();
    }
}
