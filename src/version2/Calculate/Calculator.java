package version2.Calculate;

import version2.Records.Item;
import version2.Strategy.CartList;
import version2.Strategy.Strategy;
import version2.Strategy.TotalReduce;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brenda on 12/15/14.
 */
public class Calculator {
    private List<Item> itemList;

    public Calculator(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Calculator(){
        this.itemList = new ArrayList<Item>();
    }

    public Calculator calculate(CartList cartList){
        itemList = cartList.getCartList();
        return this;
    }

    public Calculator calculate(Strategy strategy){
        Calculator temp = new Calculator(strategy.modify(itemList));
        return temp;
    }

    public float calculate(TotalReduce totalReduce){
        float total = 0;
        for (Item item : itemList){
            total += item.getTotal();
        }
        if (total >= totalReduce.getTotal()){
            total -= totalReduce.getReduce();
        }
        return total;
    }

    @Override
    public String toString() {
        return "ITEM" + "\t" +
                "PRICE" + "\t" +
                "NUMBER" + "\n" +
                itemList;
    }
}
