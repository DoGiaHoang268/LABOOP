package j1.l.p0021;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class J1LP0021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Manager m = new Manager(list);
        Validation val = new Validation();
       
        list.add(new Student("1 ", "Do Gia Hoang",5, "Java"));
        list.add(new Student("2 ", "Bui Xuan Hoang",3, "C/C++"));
        list.add(new Student("3 ", "Dao Hong Le",4, ".Net"));
        list.add(new Student("4 ", "Dao Tuan Phong",2, "Java"));
        list.add(new Student("5 ", "Nguyen Xuan Phuc",5, "Java"));
        list.add(new Student("6 ", "Nguyen Kim Ngan",1, ".Net"));
        list.add(new Student("7 ", "Nguyen Duc Phuc",2, "C/C++"));
        list.add(new Student("8 ", "Dao Hong Phuc",6, ".Net"));
        list.add(new Student("9 ", "Le Phu",2, "Java"));
        list.add(new Student("10", "Chu Viet Dung",3, "C/C++"));

        while (true) {
            m.menu();
            int option = val.checkInt("Enter your choice: ", 1, 5);
            switch (option) {
                case 1:m.createStudent();
                    break;
                case 2:m.FindnSort();
                    break;
                case 3:m.UpDatenDelete();
                    break;
                case 4:m.report();
                    break;
                case 5:return;
                   
            }
        }

    }

}
