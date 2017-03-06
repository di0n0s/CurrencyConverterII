package org.sfc.currencyconverterii.views.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.sfc.currencyconverterii.R;
import org.sfc.currencyconverterii.model.Currency;

import java.util.List;

/**
 * Created by sfcar on 05/03/2017.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyHolder> {

    private List<Currency> mCurrencyList;

    public CurrencyAdapter(List<Currency> currencyList) {
        mCurrencyList = currencyList;
    }

    @Override
    public CurrencyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_currency, parent, false);
        return new CurrencyHolder(parent.getContext(), view);
    }

    @Override
    public void onBindViewHolder(CurrencyHolder holder, int position) {
        Currency currency = mCurrencyList.get(position);
        holder.bindCurrency(currency);
    }

    @Override
    public int getItemCount() {
        return mCurrencyList.size();
    }
}
