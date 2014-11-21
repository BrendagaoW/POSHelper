import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Brenda on 11/21/14.
 */
public class SecondHalf extends Items{

    Set<String> secondItems;

    public SecondHalf(String path) throws IOException{
        setPath(path);
        secondItems = new HashSet<String>();
        BufferedReader reader = new BufferedReader(new FileReader(getPath()));
        String string;
        while((string = reader.readLine()) != null){
            secondItems.add(string);
        }
        reader.close();
    }


    @Override
    public boolean containItem(String item) {
        if (secondItems.contains(item))
            return true;
        else
            return false;
    }


    public void addItem(String item) throws IOException {
        secondItems.add(item);
        writeList();
    }

    @Override
    public void deleteItem(String item) throws IOException {
        if (containItem(item)){
            secondItems.remove(item);
            writeList();
        }
    }

    @Override
    public void writeList() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(getPath()));
        for (String item:secondItems){
            writer.write(item + "\n");
        }
        writer.close();
    }

    @Override
    public Set<String> getItems() {
        return secondItems;
    }
}
