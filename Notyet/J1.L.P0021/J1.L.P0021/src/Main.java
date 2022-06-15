
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Student> listStudent = new ArrayList<>();
        // loop until user input 5
        while(true){ 
            //display Menu
            Manager.displayMenu();
            //input choice
            int choice = GetInput.getIntLimit(1, 5);
            switch (choice) {
                //Create new Student
                case 1:
                    Manager.createStudent(listStudent);
                    break;
                //find and sort
                case 2:
                    Manager.findAndSort(listStudent);
                    break;
                //update or delete
                case 3:
                    Manager.updateOrDelete(listStudent);
                    break;
                case 4:
                    Manager.report(listStudent);
                    break;
                //exit
                case 5:
                    System.exit(0);
            }
        }
    }
    
}
