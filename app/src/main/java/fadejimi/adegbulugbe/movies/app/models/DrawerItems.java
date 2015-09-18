package fadejimi.adegbulugbe.movies.app.models;

/**
 * Created by Test on 9/16/2015.
 */
public class DrawerItems {
    String ItemName;
    int imgResId;

    public DrawerItems(String itemName, int imgResId)
    {
        super();
        this.ItemName = itemName;
        this.imgResId = imgResId;
    }

    public void setItemName(String itemName)
    {
        ItemName = itemName;
    }

    public String getItemName()
    {
        return ItemName;
    }

    public void setImgResId(int imgResId)
    {
        this.imgResId = imgResId;
    }

    public int getImgResId()
    {
        return imgResId;
    }
}
