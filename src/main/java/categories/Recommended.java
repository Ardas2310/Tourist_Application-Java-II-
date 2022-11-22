package categories;

import com.example.tourist_application.HomeController;

import java.util.Random;


public class Recommended extends HomeController implements Category
{
    Random random = new Random();
    public  static String[] shop = new String[5];
    public static   String[] name = new String[5];
    public static  String[] type = new String[5];
    public static String[] rate = new String[5];
    public static  String[] status = new String[5];

    @Override
    public void GenerateShops(String[] shopName, Double[] shopRate, Boolean[] shopOpening, String[] shopType)
    {
        //<editor-fold default-state="collapsed" desc=" Recommended Shop 1 ">
        shop[0] = String.valueOf(random.nextInt(shopName.length));
        name[0] = String.valueOf(shopName[Integer.parseInt( shop[0])]);
        rate[0] = String.valueOf(String.valueOf(shopRate[Integer.parseInt( shop[0])]));
        type[0] = String.valueOf(shopType[Integer.parseInt( shop[0])]);
        if(String.valueOf(shopOpening[Integer.parseInt( shop[0])]).equals("true"))
        {
            status[0] = "Open";
        }
        else
        {
            status[0] = "Close";
        }

        //</editor-fold>
        //<editor-fold default-state="collapsed" desc=" Recommended Shop 2 ">
        shop[1] = String.valueOf(random.nextInt(shopName.length));
        name[1] = String.valueOf(shopName[Integer.parseInt( shop[1])]);
        rate[1] = String.valueOf(String.valueOf(shopRate[Integer.parseInt( shop[1])]));
        type[1] = String.valueOf(shopType[Integer.parseInt( shop[1])]);
        if(String.valueOf(shopOpening[Integer.parseInt( shop[1])]).equals("true"))
        {
            status[1] = "Open";
        }
        else
        {
            status[1] = "Close";
        }

        //</editor-fold>
        //<editor-fold default-state="collapsed" desc=" Recommended Shop 3 ">
        shop[2] = String.valueOf(random.nextInt(shopName.length));
        name[2] = String.valueOf(shopName[Integer.parseInt( shop[2])]);
        rate[2] = String.valueOf(String.valueOf(shopRate[Integer.parseInt( shop[2])]));
        type[2] = String.valueOf(shopType[Integer.parseInt( shop[2])]);
        if(String.valueOf(shopOpening[Integer.parseInt( shop[2])]).equals("true"))
        {
            status[2] = "Open";
        }
        else
        {
            status[2] = "Close";
        }

        //</editor-fold>
        //<editor-fold default-state="collapsed" desc=" Recommended Shop 4 ">
        shop[3] = String.valueOf(random.nextInt(shopName.length));
        name[3] = String.valueOf(shopName[Integer.parseInt( shop[3])]);
        rate[3] = String.valueOf(String.valueOf(shopRate[Integer.parseInt( shop[3])]));
        type[3] = String.valueOf(shopType[Integer.parseInt( shop[3])]);
        if(String.valueOf(shopOpening[Integer.parseInt( shop[3])]).equals("true"))
        {
            status[3] = "Open";
        }
        else
        {
            status[3] = "Close";
        }

        //</editor-fold>
        //<editor-fold default-state="collapsed" desc=" Recommended Shop 5 ">
        shop[4] = String.valueOf(random.nextInt(shopName.length));
        name[4] = String.valueOf(shopName[Integer.parseInt( shop[4])]);
        rate[4] = String.valueOf(String.valueOf(shopRate[Integer.parseInt( shop[4])]));
        type[4] = String.valueOf(shopType[Integer.parseInt( shop[4])]);
        if(String.valueOf(shopOpening[Integer.parseInt( shop[4])]).equals("true"))
        {
            status[4] = "Open";
        }
        else
        {
            status[4] = "Close";
        }

        //</editor-fold>
    }

}
