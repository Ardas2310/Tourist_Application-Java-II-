package categories;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RecommendedController{

    @FXML
    private Label bulletLabel;

    @FXML
    private Label recName1;

    @FXML
    private Label recRate1;

    @FXML
    private Label recType1;

    public void setData(Recommended recommended)
    {
        recName1.setText(recommended.getShopName1());
        recType1.setText(recommended.getShopType1());
        recRate1.setText(recommended.getShopRate1());
    }

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //<editor-fold defaultstate="collapsed" desc=" Recommend Shop 1 Objects ">
        recName1.setText(Recommended.shopName1);
        recType1.setText(Recommended.shopType1);
        recRate1.setText(Recommended.shopRate1);

        new ZoomIn(recName1).play();
        new ZoomIn(recType1).play();
        new ZoomIn(recRate1).play();
        //</editor-fold>
    }*/
}
