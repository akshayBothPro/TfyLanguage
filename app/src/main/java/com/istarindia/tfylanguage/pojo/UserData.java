package com.istarindia.tfylanguage.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by akshay on 10/27/17.
 */

public class UserData implements Serializable {
    public int id;
    ArrayList<GridItem> gridItems;


    public UserData(int id, ArrayList<GridItem> gridItems) {
        this.id = id;
        this.gridItems = gridItems;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<GridItem> getGridItems() {
        return gridItems;
    }

    public void setGridItems(ArrayList<GridItem> gridItems) {
        this.gridItems = gridItems;
    }
}
