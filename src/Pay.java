import java.io.IOException;
import java.util.Set;

/**
 * Created by Brenda on 11/21/14.
 */
/*
form:
    购物明细（数量 单价 小计）
    item1            5   40    120
    item3            2   50    75
    item5            4   60    216

    总计金额（优惠前  优惠后  优惠差价）
    411         540    411     129
 */
public class Pay {
    private ItemList itemList;
    private DiscountPromotion DiscountItems;
    private SecondHalf HalfItems;
    private Cart CartItems;

    Pay()throws IOException{
        itemList = new ItemList("itemlist.txt");
        DiscountItems = new DiscountPromotion("discount_promotion.txt");
        HalfItems = new SecondHalf("second_half_price_promotion.txt");
        CartItems = new Cart("cart.txt");
//        itemList.createItems();
//        CartItems.createItems();
    }

    public String getItemName(String itemName){
        String num = itemName.substring(4);
        int n = Integer.parseInt(num);
        return itemName.substring(0,4).toLowerCase()+n;
    }

    public void print(){
        System.out.println("购物明细（数量 单价  小计）");
        int amount = 0;
        int last = 0;
        Set<String> set = CartItems.getItems().keySet();

        for (String item:CartItems.getItems().keySet()){
            float number = CartItems.getValue(item);
            int price = itemList.getValue(item);
            amount += number*price;
            System.out.print(" " + getItemName(item) + " \t" + (int) number + "\t" + price);
            if (DiscountItems.containItem(item)){
                price *= DiscountItems.getValue(item)/100.0;
            }
            if (HalfItems.containItem(item)){
                number -= (int)(number/2)*0.5;
            }
            last += (int)(price*number);
            System.out.println("\t" + (int)(price*number));
        }
        System.out.println("\n总计金额（优惠前 优惠后  优惠差距）");
        System.out.println("  " + last + " \t" + amount + " \t" + last + " \t" + (amount-last));
    }

    public static void main(String [] args)throws IOException{
        Pay pay = new Pay();
        pay.print();
    }
}
