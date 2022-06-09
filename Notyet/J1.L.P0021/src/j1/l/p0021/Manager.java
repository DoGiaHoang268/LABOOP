package j1.l.p0021;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

/**
 *
 * @author ACER
 */
public class Manager {

    ArrayList<Student> list;
    Validation val = new Validation();
    public Manager(ArrayList<Student> list) {
        this.list = list;
    }

    public void menu() {
        System.out.println("");
        System.out.println("                                MENU                                     ");
        System.out.println("========================================================================\n"
                + "1.Create\n"
                + "2.Find and Sort\n"
                + "3.Update/Delete\n"
                + "4.Report\n"
                + "5.Exit\n"
                + " ========================================================================"
        );

        System.out.println("");
    }

    //tạo sinh viên mới, có trường hợp nếu số luownhj sinh viên lớn hơn 10 thì phải hỏi là có muốn tạo nữa hay ko
    public void createStudent() {
        if (list.size() > 10) {
            String choice = val.checkFormatString("Do you want to continue (Y/N)?"
                    + " Choose Y to continue, N to return main screen: ", "^[ynYN]{1}$");
            if (choice.equalsIgnoreCase("N")) {
                return;
            }
        }
        String code = val.checkCode(list);
        String name = val.checkFormatString("Enter name: ", "^[a-zA-Z\\s]+$");
        int semester = val.checkInt("Enter semester: ", 0, Integer.MAX_VALUE);
        int couseId = val.checkInt("Enter couseID(1-Java,2-.Net,3-C/C++): ", 1, 3);
        Map<Integer, String> course = new HashMap<>();
        course.put(1, "Java");
        course.put(2, ".Net");
        course.put(3, "C/C++");
        String courseName = course.get(couseId);
        list.add(new Student(code, name, semester, courseName));

    }

    //tìm kiếm và sắp xếp sinh viên theo tên
    public void FindnSort() {

        ArrayList<Student> findlist = new ArrayList<>();
        String name = val.checkFormatString("Enter name: ", "^[a-zA-Z\\s]+$").toUpperCase();

        for (Student student : list) {
            if (student.getStudentName().toUpperCase().contains(name)) {
                findlist.add(student);
            }
        }

        findlist.sort((s1, s2) -> s1.getStudentName().compareToIgnoreCase(s2.getStudentName()));
        for (Student student : findlist) {
            student.display();
        }

        if (findlist.isEmpty()) {
            System.err.println("Not found student have that name!!");
        }
    }

    //Update vad delete sinh viên dưa trên ID,
    public void UpDatenDelete() {
        boolean found = false;
        System.out.print("Enter your code:");
        String code = val.checkInputString();
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(code)) {
                found = true;
                student.display();
                String choice = val.checkFormatString("Do you want to update (U) or delete (D) student: ", "^[udUD]{1}$");
                if (choice.equalsIgnoreCase("u")) {

                    String name = val.checkFormatString("Enter name: ", "^[a-zA-Z\\s]+$");
                    int semester = val.checkInt("Enter semester:", 0, Integer.MAX_VALUE);
                    int couseId = val.checkInt("Enter couseID(1-Java,2-.Net,3-C/C++): ", 1, 3);
                    Map<Integer, String> course = new HashMap<>();
                    course.put(1, "Java");
                    course.put(2, ".Net");
                    course.put(3, "C/C++");
                    String courseName = course.get(couseId);

                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(courseName);

                } else {
                    list.remove(student);
                    break;
                }
            }
        }
        if (found == false) {
            System.err.println("Student not found!!!");
        }

    }

    //In ra danh sach dưa theo yêu cầu
    public void report() {
        for (Student student : list) {
            student.display();
        }
    }

}
