/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg55;

/**
 *
 * @author Hoang Do Gia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Management managerment = new Management();
        Validation validation = new Validation();

        while (true) {
            managerment.showmenu();
            int choice = validation.checkInt("Enter your choice:", 1, 5);
            switch (choice) {
                case 1:
                    managerment.addDoctor();
                    break;
                case 2:
                    managerment.updateDoctor();
                    break;
                case 3:
                    managerment.deleteDocotor();
                    break;
                case 4:
                    managerment.searchDocter();
                    break;
                case 5:
                    return;

            }
        }

    }

}
