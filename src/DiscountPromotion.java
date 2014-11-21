import java.io.*;

/**
 * Created by Brenda on 11/21/14.
 */
public class DiscountPromotion extends ItemList{

    DiscountPromotion(String filePath) throws IOException {
        super(filePath);
    }

    @Override
    public void addItem(String item, int price) throws IOException{
        if (price > 100 || price < 0){
            return;
        }
        super.addItem(item,price);
    }
}
