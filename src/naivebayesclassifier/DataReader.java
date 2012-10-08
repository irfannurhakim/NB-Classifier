/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package naivebayesclassifier;



import com.nb.model.DataModel;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class DataReader {

    public static ArrayList<DataModel> readData(String path) {
        ArrayList<DataModel> data = new ArrayList();

        try {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream(path);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                //if (strLine.indexOf("?") == -1) {
                    String[] potong = strLine.split(",");
                    DataModel dat = new DataModel();
                    if (potong[0].equals("republican")) {
                        dat.setKelas(true);
                    } else {
                        dat.setKelas(false);
                    }
                    String[] potong2 = new String[potong.length - 1];
                    for (int i = 1; i < potong.length; i++) {
                        potong2[i - 1] = potong[i];
                    }
                    dat.setAtribut(potong2);
                    data.add(dat);
                    //System.out.println(dat.toString());
               // }
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        return data;
    }
}
