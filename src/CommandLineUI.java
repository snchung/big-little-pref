import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by andrewallace on 3/2/18.
 */
public class CommandLineUI {


    public static void main(String [] args) {
        Reader r = new Reader();
        ArrayList<Person> littles = r.readLittles("littles.txt");
        ArrayList<Person> bigs = r.readBigs("bigs.txt");
        Preferences p = new Preferences();
        p.getPairings(littles, bigs);

        Iterator<Person> iterl = littles.iterator();
        while(iterl.hasNext()) {
            Person pe = iterl.next();
            System.out.println(pe.getName() + " matched with " + pe.getMatch());
        }
System.out.println();
        Iterator<Person> iterr = bigs.iterator();
        while(iterr.hasNext()) {
            Person pe = iterr.next();
            System.out.println(pe.getName() + " matched with " + pe.getMatch());
        }


    }
}
