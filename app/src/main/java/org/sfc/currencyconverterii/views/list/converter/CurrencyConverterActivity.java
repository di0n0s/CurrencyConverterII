package org.sfc.currencyconverterii.views.list.converter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import org.sfc.currencyconverterii.BaseActivity;

public class CurrencyConverterActivity extends BaseActivity {

    private static final String EXTRA_CURRENCY_CODE = "currency_converter_code";

    @Override
    protected Fragment createFragment() {
        String currencyConverterCODE = (String) getIntent().getSerializableExtra(EXTRA_CURRENCY_CODE);
        return CurrencyConverterFragment.newInstance(currencyConverterCODE);
    }


    public static Intent newIntent (Context packageContext, String currencyConverterCode){
        Intent intent = new Intent(packageContext, CurrencyConverterActivity.class);
        intent.putExtra(EXTRA_CURRENCY_CODE, currencyConverterCode);
        return  intent;
    }
}
