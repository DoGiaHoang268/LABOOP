package Manager;

import Entity.Doctor;
import java.util.ArrayList;

/**
 * Date 29.04.2020
 * @author Se05492
 * purpose: class main
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<>();
//        ld.add(new Doctor("Doc 1","Hung","Orthopedics",3));
//        ld.add(new Doctor("Doc 2","HungBeo","Obstetrics",2));
//        ld.add(new Doctor("A3","Huy","orthodontic",1));
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.addDoctor(ld);
                    break;
                case 2:
                    Manager.updateDoctor(ld);
                    break;
                case 3:
                    Manager.deleteDoctor(ld);
                    break;
                case 4:
                    Manager.searchDoctor(ld);
                    break;
                case 5:
                    return;
            }

        }

    }
}
