package org.sfc.currencyconverterii.model;

import java.util.List;

/**
 * Created by sfcar on 06/03/2017.
 */

public class CurrencySingleton {
    private static CurrencySingleton sCurrencySingleton;
    private List<Currency> mCurrencyList;

    public static CurrencySingleton getInstance() {//Context para la BBDD
        if(sCurrencySingleton==null){
            sCurrencySingleton = new CurrencySingleton(); //Si no hay una instancia la crea
        }
        return sCurrencySingleton;
    }

    public CurrencySingleton() {
    }

    public List<Currency> getCurrencyList(){ //Acceder al listado
        return mCurrencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        mCurrencyList = currencyList;
    }

    public Currency getCurrency(String code){ //Devuelve la moneda con el codigo indicado
        for(Currency currency : mCurrencyList){
            if(currency.getCode().equals(code)){
                return currency;
            }
        } return null;
    }

}

