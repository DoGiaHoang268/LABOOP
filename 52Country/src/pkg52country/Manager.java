
package pkg52country;

import Entity.EastAsianCountry;
import java.util.ArrayList;
import static java.util.Collections.list;

/**
 *
 * @author Hoang Do Gia
 */
public class Manager {

    Validation va = new Validation();
    ArrayList<EastAsianCountry> list  = new ArrayList<>();
    // show menu
    int showMenuAndChoice() {
        System.out.println("                            MENU\n"
                + 
                "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "==========================================================================\n"
        );
        int choice = va.checkInt("Enter your choice: ", 1, 5);
        return choice;
    }
    // code is super-key of EAC
    public EastAsianCountry checkContryExist(String code) {
        for (EastAsianCountry eac : list) {
            if (eac.getCountryCode().equalsIgnoreCase(code)) { // if key is exist
                return eac; // exist that country
            }

        }
        return null;
    }
    
      // add country
    public void addContry() {
        String code = va.checkString("Enter code of country: "); 
        while (checkContryExist(code) != null) { 
            System.err.println("Contry existed!");
            code = va.checkString("Enter code of country: "); 
        }
        String name = va.checkString("Enter name of country: ");
        float area = va.checkFloat("Enter total Area: ", 0, Float.POSITIVE_INFINITY); 
        String terain = va.checkString("Enter terrain of country: "); 
        list.add(new EastAsianCountry(code, name, area, terain)); 
    }
  // display list
   public void displayList() { 
        if (list.isEmpty()) {
            System.err.println("List is still empty!"); 
            System.out.println("");
        } else {
            System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                    "Terrain"); 
            for (EastAsianCountry eac : list) { 
                eac.display(); 
            }
            System.out.println("");
        }

    }
// search country by name
    public void searchByName() {
        if (list.isEmpty()) {
            System.out.println("");
            System.err.println("List is still empty!"); 

        } else {
            String searchName = va.checkString("Enter the name you want to search for: "); 
            boolean isFound = false;
            for (EastAsianCountry eac : list) {
                if (searchName.equalsIgnoreCase(eac.getCountryName())) {
                    isFound = true; // founded
                    System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name" 
                            ,"Total Area","Terrain"); 
                    eac.display();
                    break; 
                } else {
                    isFound = false;
                }

            }
            if (isFound == false) {
                System.err.println("Not found this country!");
                System.out.println("");
            }
        }
    }
    
    // sort list acending by name
    public void SortAcendingbyName(){ 
        ArrayList<EastAsianCountry> sortList = new ArrayList<>(list); 
        if (sortList.isEmpty()) {
            System.out.println("");
            System.err.println("List is still empty!"); 

        } else {
            
            // method sort
            sortList.sort((c1,c2)->c1.getCountryName()
                    .compareToIgnoreCase(c2.getCountryName()));
            // display sort list
            System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                            "Terrain"); 
            for (EastAsianCountry eac: sortList) {
                eac.display();
            }
            System.out.println("");
        }
    }

}
