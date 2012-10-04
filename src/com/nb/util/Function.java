/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nb.util;

import com.nb.model.Atribut;
import com.nb.model.DataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author irfannurhakim
 */
public class Function {

    public static HashMap<String, Double> vnc(ArrayList<DataModel> data) {
        double pos = 0;
        double neg = 0;
        HashMap<String, Double> res = new HashMap<String, Double>();
        for (Iterator<DataModel> it = data.iterator(); it.hasNext();) {
            DataModel dataModel = it.next();
            if (dataModel.isKelasPos()) {
                pos++;
            } else {
                neg++;
            }
        }
        res.put("valPositif", (double) pos / data.size());
        res.put("countPositif", (double) pos);
        res.put("valNegatif", (double) neg / data.size());
        res.put("countNegatif", (double) neg);
        return res;
    }

    public static HashMap<String, Double> model(Atribut[] attr, ArrayList<DataModel> data, HashMap<String, Double> vnc) {
        //iterate per atribut if its pos or neg   
        HashMap<String, Double> aa = new HashMap<String, Double>();

        for (int i = 0; i < attr.length; i++) {
            for (int j = 0; j < attr[i].getPosibility().length; j++) {
                double pos = 0;
                double neg = 0;

                for (Iterator<DataModel> it = data.iterator(); it.hasNext();) {
                    DataModel dataModel = it.next();

                    if (dataModel.isKelasPos() && dataModel.getAtribut()[i].equalsIgnoreCase(attr[i].getPosibility()[j])) {
                        pos++;
                    } else if (!dataModel.isKelasPos() && dataModel.getAtribut()[i].equalsIgnoreCase(attr[i].getPosibility()[j])) {
                        neg++;
                    }
                }
                aa.put(attr[i].getName() + "-" + attr[i].getPosibility()[j] + "-Yes", pos / vnc.get("countPositif"));
                aa.put(attr[i].getName() + "-" + attr[i].getPosibility()[j] + "-No", neg / vnc.get("countNegatif"));
            }
        }
        
        aa.put("valPositif", vnc.get("valPositif"));
        aa.put("valNegatif", vnc.get("valNegatif"));
        return aa;
    }

    public static HashMap<Boolean, Double> singleDataClassification(Atribut[] attr, DataModel newData, HashMap<String, Double> model) {
        HashMap<Boolean, Double> xx = new HashMap<Boolean, Double>();
        double pos = 1;
        double neg = 1;
        for (int i = 0; i < attr.length; i++) {
            pos *= model.get(attr[i].getName() + "-" + newData.getAtribut()[i] + "-Yes");
            neg *= model.get(attr[i].getName() + "-" + newData.getAtribut()[i] + "-No");
        }
        
        if(pos >= neg){
            xx.put(Boolean.TRUE, pos);
        } else {
            xx.put(Boolean.FALSE, neg);
        }
        
        return xx;
    }
    
    public static HashMap<String, Boolean> multipleDataCassification(Atribut[] attr, ArrayList<DataModel> newListData, HashMap<String, Double> model){
        //TODO buat multiple data test 
        
        return null;
    }
}
