package version2.Test;

import version2.Calculate.Calculator;
import version2.Strategy.*;
import java.io.IOException;


/**
 * Created by Brenda on 11/29/14.
 */
public class Main {
    public static void main(String [] args)throws IOException{

        CartList cartList = new CartList("cart.txt");
        DiscountStrategy discountStrategy = new DiscountStrategy("discount_promotion.txt");
        SecondStrategy secondStrategy = new SecondStrategy("second_half_price_promotion.txt");
        ItemList itemList = new ItemList("itemlist.txt");
        SubReduce subReduce = new SubReduce(100,5);
        TotalReduce totalReduce = new TotalReduce(300,10);

        Calculator calculator = new Calculator();

        calculator = calculator.calculate(cartList).calculate(itemList);
        System.out.println(calculator);
        calculator = calculator.calculate(discountStrategy).calculate(secondStrategy).calculate(subReduce);
        System.out.println(calculator);
        System.out.println(calculator.calculate(totalReduce));

    }
}
