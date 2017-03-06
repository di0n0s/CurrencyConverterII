package org.sfc.currencyconverterii.views.list;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.sfc.currencyconverterii.R;
import org.sfc.currencyconverterii.model.Currency;
import org.sfc.currencyconverterii.views.list.converter.CurrencyConverterActivity;

/**
 * Created by sfcar on 05/03/2017.
 */

public class CurrencyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Currency mCurrency;
    private Context mContext;

    private TextView mCurrencyNameTextView;
    private TextView mCurrencyValueTextView;
    private TextView mCurrencyCodeTextView;

    public CurrencyHolder(Context context,View itemView) {
        super(itemView);
        mContext = context;
        itemView.setOnClickListener(this);

        mCurrencyNameTextView = (TextView) itemView.findViewById(R.id.list_item_currency_name_text_view);
        mCurrencyValueTextView = (TextView) itemView.findViewById(R.id.list_item_currency_value_text_view);
        mCurrencyCodeTextView = (TextView) itemView.findViewById(R.id.list_item_currency_code_text_view);
    }

    public void bindCurrency(Currency currency){
        mCurrency = currency;
        mCurrencyNameTextView.setText(currency.getName());
        mCurrencyCodeTextView.setText(currency.getCode());
        mCurrencyValueTextView.setText(String.valueOf(currency.getValue())+"€");
    }

    @Override
    public void onClick(View v) {
        Intent intent = CurrencyConverterActivity.newIntent(v.getContext(), mCurrency.getCode());
        mContext.startActivity(intent);
    }
}
