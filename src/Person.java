import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by andrewallace on 3/2/18.
 */
public class Person {

    private String n;
    private HashMap<String, Integer> map;
    private ArrayList<String> prefList;
    private String match;

    public Person(String name, ArrayList<String> prefs) {
        this.n = name;
        this.map = new HashMap<>();
        this.match = "free";
        this.prefList = prefs;
        for(int i = 0; i < prefs.size(); i++) {
            map.put(prefs.get(i), prefs.size() - i);
        }
    }

    public String getName() {
        return n;
    }

    public int getPreference(String person) {
        return map.get(person);
    }

    public String getTopPreference() {
        return prefList.remove(0);
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(Person p) {
        this.match = p.getName();
    }

    public void resetMatch() {
        this.match = "free";
    }



}
