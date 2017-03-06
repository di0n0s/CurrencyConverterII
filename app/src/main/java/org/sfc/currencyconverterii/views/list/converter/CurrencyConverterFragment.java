package org.sfc.currencyconverterii.views.list.converter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.sfc.currencyconverterii.R;
import org.sfc.currencyconverterii.model.Currency;
import org.sfc.currencyconverterii.model.CurrencySingleton;
import org.sfc.currencyconverterii.views.list.CurrencyConverterListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyConverterFragment extends Fragment {

    private static final String KEY_VALUE_IN = "valueIN";
    private static final String ARG_CURRENCY_CONVERTER_CODE = "currency_converter_code";
    private Currency mCurrency;
    private double mValueIn;
    private double mValueOut;


    public CurrencyConverterFragment() {
        // Required empty public constructor
    }

    private TextInputEditText mInsertValueInputEditText;
    private TextView mCurrencyTextView;
    private TextView mCurrencyOutTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String currencyConverterCODE = (String) getArguments().getSerializable(ARG_CURRENCY_CONVERTER_CODE);
        mCurrency = CurrencySingleton.getInstance().getCurrency(currencyConverterCODE);
        //mValueIn = savedInstanceState.getDouble(KEY_VALUE_IN);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_currency_converter, container, false);
        mInsertValueInputEditText = (TextInputEditText) view.findViewById(R.id.insert_currency_textInputEditText);
        mCurrencyOutTextView = (TextView) view.findViewById(R.id.currency_out_text_view);
        mCurrencyTextView = (TextView) view.findViewById(R.id.currency_text_view);
        mCurrencyTextView.setText(mCurrency.getName());
        mInsertValueInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if (mInsertValueInputEditText.getText().toString() == null || mInsertValueInputEditText.getText().toString().isEmpty()) {
                        mValueIn = 0.0;
                    } else {
                        mValueIn = Double.parseDouble(s.toString());
                    }
                    getValueOut();

                } catch (NumberFormatException e){
                    System.out.println("Could not parse " + e);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(KEY_VALUE_IN, mValueIn);

    }

    private void getValueOut() {
        mValueOut = mValueIn * mCurrency.getValue();
        mCurrencyOutTextView.setText(String.valueOf(mValueOut)+"€");
    }

    public static CurrencyConverterFragment newInstance(String code){
        Bundle args = new Bundle();
        args.putString(ARG_CURRENCY_CONVERTER_CODE, code); //Creamos un conjunto de argumentos

        CurrencyConverterFragment fragment = new CurrencyConverterFragment() ; //Creamos una instancia del fragment
        fragment.setArguments(args); //Añadimos los argumentos
        return fragment; //Devolvemos el fragment

    }

}
