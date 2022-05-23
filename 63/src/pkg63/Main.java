package pkg63;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        ManagerPerson m = new ManagerPerson();
        m.addPerson(list);
        m.sortPerson(list);
        m.dispplayPerson(list);
        
    }

}
