/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package naivebayesclassifier;

import com.nb.model.Atribut;
import com.nb.model.DataModel;
import com.nb.util.Function;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author irfannurhakim
 */
public class NaiveBayesClassifier {

    /**
     * @param args the command line arguments
     */
    public static Atribut dataAtribut[] = {new Atribut("Outlook", false, new String[]{"Sunny","Overcast","Rain"}),
        new Atribut("Temperature", false, new String[]{"Hot","Mild","Cool"}),
        new Atribut("Humidity", false, new String[]{"High","Normal"}),
        new Atribut("Wind", false, new String[]{"Strong","Weak"})};

    public static void main(String[] args) {
        // TODO code application logic here


        ArrayList<DataModel> data = new ArrayList();
        data.add(new DataModel(new String[]{"Sunny","Hot","High","Weak"}, false));
        data.add(new DataModel(new String[]{"Sunny","Hot","High","Strong"}, false));
        data.add(new DataModel(new String[]{"Overcast","Hot","High","Weak"}, true));
        data.add(new DataModel(new String[]{"Rain","Mild","High","Weak"}, true));
        data.add(new DataModel(new String[]{"Rain","Cool","Normal","Weak"}, true));
        data.add(new DataModel(new String[]{"Rain","Cool","Normal","Strong"}, false));
        data.add(new DataModel(new String[]{"Overcast","Cool","Normal","Strong"}, true));
        data.add(new DataModel(new String[]{"Sunny","Mild","High","Weak"}, false));
        data.add(new DataModel(new String[]{"Sunny","Cool","Normal","Weak"}, true));
        data.add(new DataModel(new String[]{"Rain","Mild","Normal","Weak"}, true));
        data.add(new DataModel(new String[]{"Sunny","Mild","Normal","Strong"}, true));
        data.add(new DataModel(new String[]{"Overcast","Mild","High","Strong"}, true));
        data.add(new DataModel(new String[]{"Overcast","Hot","Normal","Weak"}, true));
        data.add(new DataModel(new String[]{"Rain","Mild","High","Strong"}, false));
        
        HashMap<String, Double> vnc;
        HashMap<String, Double> model;
        
        vnc = Function.vnc(data);
        
        model = Function.model(dataAtribut, data, vnc);
        
        System.out.println(Function.singleDataClassification(dataAtribut, new DataModel(new String[]{"Sunny","Cool","High","Strong"}, false), model));

    }
}
