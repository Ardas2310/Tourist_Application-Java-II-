package categories;


import com.example.tourist_application.Home;
import com.example.tourist_application.HomeController;
import java.util.Random;


public class Recommended extends HomeController implements Category
{
    Random random = new Random();
    public  String shop1;
    public   String shopName1;
    public  String shopType1;
    public  String shopRate1;

    @Override
    public void GenerateShops(String[] shopName, Double[] shopRate, String[] shopOpening, String[] shopType) {
        //<editor-fold defaultstate="collapsed" desc=" Recommend Shop 1 ">
        shop1 = String.valueOf(random.nextInt(shopName.length));
        shopName1 = String.valueOf(shopName[Integer.parseInt(shop1)]);
        shopRate1 = String.valueOf(String.valueOf(shopRate[Integer.parseInt(shop1)]));
        shopType1 = String.valueOf(shopType[Integer.parseInt(shop1)]);
        //</editor-fold>
    }

    public String getShop1() {
        return shop1;
    }

    public  void setShop1(String shop1) {
        shop1 = shop1;
    }

    public  String getShopName1() {
        return shopName1;
    }

    public  void setShopName1(String shopName1) {
        shopName1 = shopName1;
    }

    public  String getShopType1() {
        return shopType1;
    }

    public  void setShopType1(String shopType1) {
        shopType1 = shopType1;
    }

    public  String getShopRate1() {
        return shopRate1;
    }

    public  void setShopRate1(String shopRate1) {
        shopRate1 = shopRate1;
    }

    /*HomeForm.recRating1.setText(String.valueOf(shopRate[Integer.parseInt(shop1)]));
    HomeForm.typeRec1.setText(String.valueOf(shopType[Integer.parseInt(shop1)]));
        if(String.valueOf(shopOpening[Integer.parseInt(shop1)]).equals("{\"open_now\":true}"))
    {
        HomeForm.openRecLabel1.setVisible(true);
        HomeForm.closeRecLabel1.setVisible(false);
    }
        else
    {
        HomeForm.openRecLabel1.setVisible(false);
        HomeForm.closeRecLabel1.setVisible(true);
    }*/

}
