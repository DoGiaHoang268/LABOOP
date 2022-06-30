/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg63;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Hoang Do Gia
 */
public class ManagerPerson {
     public void addPerson(ArrayList<Person> list) {
        Validation va = new Validation();
        System.out.println("======Management person program=====");
        for (int i = 0; i < 3; i++) {
            String name = va.checkFormatName("Please input name: ", "[a-zA-Z]+");
            String address = va.getString("Please input address: ");
            double salary = va.getSalary("please input salary: ");
            list.add(new Person(name, address, salary));

        }

    }

    public void sortPerson(ArrayList<Person> list) {
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getSalary() > o2.getSalary()) {
                    return 1;
                } else if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                }
            else return 0;
            }
        });
}
      public void dispplayPerson(ArrayList<Person> list) {
          for (Person person : list) {
              person.display();
          }
}
}
