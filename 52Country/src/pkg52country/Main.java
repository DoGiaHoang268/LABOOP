
package pkg52country;

public class Main {
    public static void main(String[] args) {
       Validation va = new Validation();
       Manager ma = new Manager();
        while (true) {
            int choice = ma.showMenuAndChoice(); // show menu and choice
            switch (choice) {
                case 1:
                    ma.addContry();
                    break;
                case 2:
                    ma.displayList();
                    break;
                case 3:
                    ma.searchByName();
                    break;
                case 4:
                    ma.SortAcendingbyName();
                    break;
                case 5:
                    return;
            }
        }
       
    }
    
}
