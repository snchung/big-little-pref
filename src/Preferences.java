import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by andrewallace on 3/2/18.
 */
public class Preferences {

    public void getPairings(ArrayList<Person> littles, ArrayList<Person> bigs) {
        HashMap<String, Person> map = new HashMap<>();
        Iterator iterL = littles.iterator();
        while(iterL.hasNext()) {
            Person p = (Person) iterL.next();
            map.put(p.getName(), p);
        }
        Iterator iterB = bigs.iterator();
        while(iterB.hasNext()) {
            Person p = (Person) iterB.next();
            map.put(p.getName(), p);
        }
        while(unmatchedLittle(littles)) {
            Person little = getUnmatchedLittle(littles);
            String nextBig = little.getTopPreference();
            Person big = map.get(nextBig);
            if(big.getMatch().equals("free")) {
                big.setMatch(little);
                little.setMatch(big);
            } else if(big.getPreference(big.getMatch()) < big.getPreference(little.getName())) {
                map.get(big.getMatch()).resetMatch();
                big.setMatch(little);
                little.setMatch(big);
            }

        }
    }

    public boolean unmatchedLittle(ArrayList<Person> littles) {
        Iterator<Person> iter = littles.iterator();
        while(iter.hasNext()) {
            if(iter.next().getMatch().equals("free")) {
                return true;
            }
        }
        return false;
    }

    public Person getUnmatchedLittle(ArrayList<Person> littles) {
        Iterator<Person> iter = littles.iterator();
        while(iter.hasNext()) {
            Person p = iter.next();
            if(p.getMatch().equals("free")) {
                return p;
            }
        }
        return null;
    }

}
