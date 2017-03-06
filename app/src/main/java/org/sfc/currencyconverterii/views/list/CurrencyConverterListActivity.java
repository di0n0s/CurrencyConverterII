package org.sfc.currencyconverterii.views.list;

import android.support.v4.app.Fragment;

import org.sfc.currencyconverterii.BaseActivity;

public class CurrencyConverterListActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new CurrencyConverterListFragment();
    }
}
