package org.sfc.currencyconverterii.views.list;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.sfc.currencyconverterii.R;
import org.sfc.currencyconverterii.model.Currency;
import org.sfc.currencyconverterii.model.CurrencySingleton;
import org.sfc.currencyconverterii.utils.ParserDOM;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyConverterListFragment extends Fragment {

    private List<Currency> mCurrencyList = new ArrayList<>();
    private CurrencyAdapter mCurrencyAdapter;

    public CurrencyConverterListFragment() {
        // Required empty public constructor
    }

    private RecyclerView mCurrencyRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchCurrencyTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_currency_converter_list, container, false);
        mCurrencyRecyclerView = (RecyclerView) view.findViewById(R.id.currency_recycler_view);
        mCurrencyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    private void updateUI(){
        CurrencySingleton currencySingleton = CurrencySingleton.getInstance();
        if(isAdded()){
            mCurrencyRecyclerView.setAdapter(new CurrencyAdapter(mCurrencyList));
            currencySingleton.setCurrencyList(mCurrencyList);
        } else mCurrencyAdapter.notifyDataSetChanged();

    }


    private class FetchCurrencyTask extends AsyncTask<Void, Void, List<Currency>> {

        @Override
        protected List<Currency> doInBackground(Void... params) {
            return new ParserDOM().parse();
        }

        @Override
        protected void onPostExecute(List<Currency> currencies) {
            mCurrencyList = currencies;
            updateUI();
        }
    }
}
