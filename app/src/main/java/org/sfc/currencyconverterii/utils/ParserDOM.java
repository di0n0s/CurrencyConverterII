package org.sfc.currencyconverterii.utils;

import android.util.Log;

import org.sfc.currencyconverterii.model.Currency;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by sfcar on 05/03/2017.
 */

public class ParserDOM {

    private static final String mURL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
    private static final String TAG = "ParseCurrency";

    public ParserDOM() {
    }

    public List<Currency> parse() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        List<Currency> currencyList = new ArrayList<>();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(mURL);
            Element root = document.getDocumentElement();
            NodeList rootChilds = root.getChildNodes();
            Node cubeParent = rootChilds.item(5);
            Node cubeTime = cubeParent.getChildNodes().item(1);
            NodeList cubeChilds = cubeTime.getChildNodes();
            for (int i = 0; i < cubeChilds.getLength(); i++) {
                if(i%2!=0){
                    Currency currency = new Currency();
                    Node item = cubeChilds.item(i);
                    NamedNodeMap currencyAttributes = item.getAttributes();
                    currency.setCode(currencyAttributes.item(0).getNodeValue());
                    switch (currencyAttributes.item(0).getNodeValue()){
                        case "USD":
                            currency.setName("Dolar américano");
                            break;
                        case "JPY":
                            currency.setName("Yen japonés");
                            break;
                        case "BGN":
                            currency.setName("Leva búlgara");
                            break;
                        case "CZK":
                            currency.setName("Corona checa");
                            break;
                        case "DKK":
                            currency.setName("Corona danesa");
                            break;
                        case "GBP":
                            currency.setName("Libra esterlina británica");
                            break;
                        case "HUF":
                            currency.setName("Florín húngaro");
                            break;
                        case "PLN":
                            currency.setName("Zloty polaco");
                            break;
                        case "RON":
                            currency.setName("Leu rumano");
                            break;
                        case "SEK":
                            currency.setName("Corona sueca");
                            break;
                        case "CHF":
                            currency.setName("Franco suizo");
                            break;
                        case "NOK":
                            currency.setName("Corona noruega");
                            break;
                        case "HRK":
                            currency.setName("Kuna croata");
                            break;
                        case "RUB":
                            currency.setName("Rublo ruso");
                            break;
                        case "TRY":
                            currency.setName("Nueva Lira turca");
                            break;
                        case "BRL":
                            currency.setName("Real brasileño");
                            break;
                        case "CAD":
                            currency.setName("Dólar canadiense");
                            break;
                        case "CNY":
                            currency.setName("Yuan renminbi chino");
                            break;
                        case "HKD":
                            currency.setName("Dólar de Hong-Kong");
                            break;
                        case "IDR":
                            currency.setName("Rúpia indonesia");
                            break;
                        case "ILS":
                            currency.setName("Nuevo Sheqel israelí");
                            break;
                        case "INR":
                            currency.setName("Rupia india");
                            break;
                        case "KRW":
                            currency.setName("Won surcoreano");
                            break;
                        case "MXN":
                            currency.setName("Peso mexicano");
                            break;
                        case "MYR":
                            currency.setName("Ringgit malasio");
                            break;
                        case "NZD":
                            currency.setName("Dólar neozelandés");
                            break;
                        case "PHP":
                            currency.setName("Peso filipino");
                            break;
                        case "SGD":
                            currency.setName("Dólar singapurense");
                            break;
                        case "THB":
                            currency.setName("Baht tailandés");
                            break;
                        case "ZAR":
                            currency.setName("Rand sudafricano");
                            break;
                        case "AUD":
                            currency.setName("Dólar australiano");
                            break;



                    }
                    currency.setValue(1/Double.parseDouble(currencyAttributes.item(1).getNodeValue()));
                    currencyList.add(currency);
                }

            }


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currencyList;
    }

}
