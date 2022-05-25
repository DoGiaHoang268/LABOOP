
package pkg55;

import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Scanner;

/**
 *
 * @author Hoang Do Gia
 */
public class Management {

    Scanner sc = new Scanner(System.in);
    ArrayList<Doctor> list = new ArrayList<>();
    Validation va = new Validation();

    void showmenu() {
        System.out.println("========== Doctor management ===========");
        System.out.println("\t1. Add Doctor");
        System.out.println("\t2. Update Doctor");
        System.out.println("\t3. Delete Doctor");
        System.out.println("\t4. Search Doctor");
        System.out.println("\t5. Exit");
        System.out.println("");

    }

    public void List() {
        list.add(new Doctor("A1", "Nguyen van A", "specialization 1", 1));
        list.add(new Doctor("B2", "Nguyen van B", "specialization 2", 2));
        list.add(new Doctor("C3", "Nguyen van C", "specialization 3", 3));
        list.add(new Doctor("D4", "Nguyen van D", "specialization 4", 4));
        list.add(new Doctor("E5", "Nguyen van E", "specialization 5", 5));
    }

    void addDoctor(){
        
        System.out.println("------- Add Doctor -----------");
        System.out.println("Enter code:");
        String code = sc.nextLine();
        
        if(va.checkExistedDoctor(list,code) || code.isEmpty()){
            System.out.println("Code is not null od duplicate in the DB");
            return;
        }else{
            System.out.println("Enter name: ");
            String name = sc.nextLine();
            
            System.out.println("Enter the specialization: ");
            String specialization = sc.nextLine();
            
            int availability = va.checkInt( "Enter availability: ",0, Integer.MAX_VALUE);
            list.add(new Doctor(code, name, specialization, availability));
            System.out.println("Added Succesfully!");
        }
    }

    void updateDoctor() {
        System.out.println("Enter code to update: ");
        String code = sc.nextLine();
        
        for(Doctor d: list){
            if(code.equals(d.getCode())){
                System.out.println("Enter name: ");
                d.setName(sc.nextLine());
                System.out.println("Enter the specialization: ");
                d.setSpecialization(sc.nextLine());
                System.out.println("Enter availability: ");
                d.setAvailability(Integer.valueOf(sc.nextLine()));
                
                System.out.println("Update sucessfully!");
                break;
            }
            else{
                System.out.println("Not found");
                return;
            }
        }
    }

    void deleteDocotor() {
        System.out.println("------- Delete Doctor ---------");
        System.out.println("Enter code: ");
        String code = sc.nextLine();     
        for(Doctor doctor: list){
            if(doctor.getCode().equals(code)){
                list.remove(doctor);
                System.out.println("Delete sucessfully!");
                break;
            }else{
                System.out.println("Not found code!");
                return;
            }
        }
    }

    void searchDocter() {
        System.out.println("-------- Search Doctor -----------");
        System.out.println("Enter name: ");
        String text = sc.nextLine();
        System.out.println("------ Result -----------");
        System.out.printf("%-7s%-15s%-20s%-14s\n","Code","Name","Specialization","Availability");
        if(text.isEmpty()){
            for(Doctor doctor: list){
                System.out.println(doctor); 
            }
        }else{
            for(Doctor doctor:list){
                if(doctor.getName().contains(text)
                        || doctor.getCode().equals(text)
                        || doctor.specialization.equals(text)){
                    System.out.println(doctor);
                }
            }
        }
    }

}
