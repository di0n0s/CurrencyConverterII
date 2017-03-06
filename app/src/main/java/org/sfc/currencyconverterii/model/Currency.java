package org.sfc.currencyconverterii.model;

/**
 * Created by sfcar on 05/03/2017.
 */

public class Currency {

    private String mName;
    private double mValue;
    private String mCode;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getValue() {
        return mValue;
    }

    public void setValue(double value) {
        mValue = value;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }
}
