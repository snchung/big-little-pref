import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by andrewallace on 3/2/18.
 */
public class Reader {

    public ArrayList<Person> readLittles(String filename) {
        try {
            ArrayList<Person> littles = new ArrayList<>();

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while(line != null) {
                String little = line.substring(0, line.indexOf(":"));
                String[] prefs = line.substring(line.indexOf(":") + 1).split(",");
                ArrayList<String> prefList = new ArrayList<>();
                for(int i = 0; i < prefs.length; i++) {
                    prefList.add(prefs[i].trim());
                }
                Person p = new Person(little, prefList);
                littles.add(p);
                line = br.readLine();
            }
            return littles;
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Person> readBigs(String filename) {
        try {
            ArrayList<Person>  bigs = new ArrayList<>();

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while(line != null) {
                String big = line.substring(0, line.indexOf(":"));
                String[] prefs = line.substring(line.indexOf(":") + 1).split(",");
                ArrayList<String> prefList = new ArrayList<>();
                for(int i = 0; i < prefs.length; i++) {
                    prefList.add(prefs[i].trim());
                }
                Person p = new Person(big, prefList);
                bigs.add(p);
                line = br.readLine();
            }
            return bigs;
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
