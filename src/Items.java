import java.io.IOException;

/**
 * Created by Brenda on 11/21/14.
 */
public abstract class Items {
    protected String path;

    public void setPath(String path){
        this.path = path;
    }
    public String getPath(){
        return this.path;
    }

    public abstract boolean containItem(String item);
    public abstract void deleteItem(String item)throws IOException;
    public abstract void writeList()throws IOException;
    public abstract Object getItems();
}
