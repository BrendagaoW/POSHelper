package version2.Strategy;

import version2.Parser.CartParser;
import version2.Parser.Parser;
import version2.Records.Cart;
import version2.Records.Item;

import java.io.IOException;
import java.util.List;

/**
 * Created by Brenda on 12/15/14.
 */
public class CartList{
    private List<Item> cartList;

    public CartList(String path) throws IOException{
        Parser cartParser = new CartParser();
        cartList = cartParser.parse(path);
    }

    public List<Item> getCartList() {
        return cartList;
    }
}
