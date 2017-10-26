package com.istarindia.tfylanguage.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by istarferoz on 27/10/17.
 */

public class OptionPojo implements Serializable {

    ArrayList<String> options;

    public OptionPojo() {
    }

    public OptionPojo(ArrayList<String> options) {
        this.options = options;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
}
