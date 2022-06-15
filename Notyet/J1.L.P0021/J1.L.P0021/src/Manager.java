
import java.util.ArrayList;
import java.util.Collections;

public class Manager {

    static void displayMenu() {
        System.out.println("======WELCOME TO STUDENT MANAGEMENT========");
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.println("===========================================");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
    }

    static void createStudent(ArrayList<Student> listStudent) {
        System.out.println("----- Create Student -----");
        while (true) {
            if (listStudent.size() > 2) {
                System.out.print("Do you want to continue (Y/N)? ");
                if (!Validation.validateYN()) {
                    return;
                }
            }
            System.out.println("");
            System.out.print("Enter ID: ");
            String id = GetInput.getStringInput();
            String name;
            if (Validation.validateIDExist(id, listStudent)) {
                name = getNameByStudentID(id, listStudent);
                System.out.println("Enter name: " + name);
            } else {
                System.out.print("Enter Name: ");
                name = GetInput.getStringInput();
            }
            System.out.print("Enter Semester: ");
            String semester = GetInput.getStringInput();
            System.out.print("Enter Course Name (1: Java, 2: .Net, 3: C/C++): ");
            String courseName = GetInput.getCourseName();
            Student student = new Student(id, name, semester, courseName);
            if (Validation.validateInformationExist(id, semester, courseName, listStudent)) {
                System.err.println("Information Exist");
                System.out.println();
            } else {
                listStudent.add(new Student(id, name, semester, courseName));
                displayList(listStudent);
                System.out.println("");
            }
        }
    }

    static void findAndSort(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.err.println("List Empty");
            return;
        }
        System.out.print("Do you want to find(F) or Sort(S)? ");
        String choice = GetInput.getYN("[SsFf]{1}", "Please enter S for Sort, F for Find: ");
        if (choice.equalsIgnoreCase("s")) {
            Collections.sort(listStudent);
            displayList(listStudent);
        } else {
            System.out.print("Enter Name of Student you want to find: ");
            String nameFind = GetInput.getStringInput();
            ArrayList<Student> listFind = findByName(nameFind, listStudent);
            Collections.sort(listFind);
            displayList(listFind);
        }
    }

    static void updateOrDelete(ArrayList<Student> listStudent) {
        
        if (listStudent.isEmpty()) {
            System.err.println("List Empty");
            return;
        }
        System.out.print("Enter ID of Student: ");
        String id = GetInput.getIDExist(listStudent);
        System.out.print("Do you want to update(U) or delete(D)? ");
        String choice = GetInput.getYN("[UuDd]{1}", "Please enter U for Update, D for Delete: ");
        if (choice.equalsIgnoreCase("u")) {
            while (true) {
                ArrayList<Student> listFind = findByID(id, listStudent);
                if (listFind.isEmpty()) {
                    System.out.println("No Student with ID " + id);
                    return;
                }
                displayList(listFind);
                displayUpdateMenu();
                int ch = GetInput.getIntLimit(1, 5);
                Student stu;
                switch (ch) {
                    case 1:
                        displayList(listFind);
                        System.out.println("Choose Line");
                        int lineId = GetInput.getIntLimit(1, listFind.size());
                        stu = listFind.get(lineId - 1);
                        System.out.print("Enter new ID: ");
                        String newId = GetInput.getStringInput();
                        String oldName1 = getNameByStudentID(id, listStudent);
                        String newName1 = getNameByStudentID(newId, listStudent);
                        if(Validation.validateIDExist(newId, listStudent)){
                             updateIdExist(stu, listStudent, newId, newName1);
                             updateName(stu, listStudent, newName1);
                        }else{                             
                            updateIdNotExist(stu, listStudent, newId);
                        }
                        
                        displayList(listStudent);
                        break;
                    case 2:

                        displayList(listFind);
                        System.out.println("Choose Line");
                        int lineName = GetInput.getIntLimit(1, listFind.size());
                        stu = listFind.get(lineName - 1);
                        System.out.print("Enter new Name: ");
                        String newName = GetInput.getStringInput();
                        String idByName = getIdByName(newName, listStudent);
                        if(!idByName.isEmpty()){
                             updateIdExist(stu, listStudent, idByName, newName);
                             updateName(stu, listStudent, newName);
                        }else{                             
                            updateName(stu, listStudent, newName);
                        }
                        
                        displayList(listStudent);
                        break;
                    case 3:
                        displayList(listFind);
                        System.out.println("Choose Line");
                        int lineSemester = GetInput.getIntLimit(1, listFind.size());
                        stu = listFind.get(lineSemester - 1);
                        System.out.print("Enter new Semester: ");
                        String newSemester = GetInput.getStringInput();
                        updateSemester(stu, listStudent, newSemester);
                        displayList(listStudent);
                        break;
                    case 4:
                        displayList(listFind);
                        System.out.println("Choose Line");
                        int lineCourse = GetInput.getIntLimit(1, listFind.size());
                        stu = listFind.get(lineCourse - 1);
                        System.out.print("Enter new Course(1: Java, 2: .Net, 3: C/C++): ");
                        String newCourse = GetInput.getCourseName();
                        updateCourseName(stu, listStudent, newCourse);
                        displayList(listStudent);
                        break;
                    case 5:
                        return;
                }
            }
        } else {
            ArrayList<Student> listFind = findByID(id, listStudent);
        if(listFind.isEmpty()){ 
            System.err.println("List Empty");
            return;
        }
        displayList(listFind);
            for (int i = 0; i < listFind.size(); i++) {
                Student studentFind = listFind.get(i);
                listStudent.remove(listFind.get(i));
            }
            System.out.println("Delete Successfully");
            displayList(listStudent);
        }
    }

    static void report(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.err.println("List Empty");
            return;
        }
        ArrayList<Report> reportList = new ArrayList<>();
        System.out.print("Enter ID of Student: ");
        String id = GetInput.getIDExist(listStudent);
        ArrayList listFind = findByID(id, listStudent);
        int totalCourse1 = getTotalCourse("Java", listFind);
        int totalCourse2 = getTotalCourse(".Net", listFind);
        int totalCourse3 = getTotalCourse("C/C++", listFind);
        addReport(totalCourse1, reportList, id, "Java", listFind);
        addReport(totalCourse2, reportList, id, ".Net", listFind);
        addReport(totalCourse3, reportList, id, "C/C++", listFind);

        System.out.format("%-20s%-15s%s\n", "Student Name", "Course Name", "Total Course");
        for (Report report : reportList) {
            System.out.format("%-20s%-15s%s\n", report.getStudentName(), report.getCourseName(), report.getTotalCourse());
        }
    }

    private static void displayList(ArrayList<Student> listStudent) {
        if(listStudent.isEmpty()){ 
            System.err.println("List Empty");
            return;
        }
        System.out.println("");
        for (Student student : listStudent) {
            System.out.format("%-15s|%-5s|%s\n", student.getStudentName(), student.getCourseName(), student.getSemester());
        }
    }

    private static String getNameByStudentID(String id, ArrayList<Student> listStudent) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student.getStudentName();
            }
        }
        return null;
    }

    private static ArrayList<Student> findByName(String nameFind, ArrayList<Student> listStudent) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getStudentName().toLowerCase().contains(nameFind.toLowerCase())) {
                list.add(student);
            }
        }
        return list;
    }

    private static ArrayList<Student> findByID(String id, ArrayList<Student> listStudent) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getId().toLowerCase().equals(id.toLowerCase())) {
                list.add(student);
            }
        }
        return list;
    }
// display menu update
    private static void displayUpdateMenu() {
        System.out.println("You want to update: ");
        System.out.println("\t1. ID");
        System.out.println("\t2. Name");
        System.out.println("\t3. Semester");
        System.out.println("\t4. Course Name");
        System.out.println("\t5. Exit");
    }
//update name
    private static void updateName(String oldName, String newName, ArrayList<Student> listStudent) {
        for (Student student : listStudent) {
            if (student.getStudentName().equalsIgnoreCase(oldName)) {
                student.setStudentName(newName);
            }
        }
    }
//update Semester
    private static void updateSemester(Student stu, ArrayList<Student> listStudent, String newSemester) {
        if (Validation.validateInformationExist(stu.getId(), stu.getSemester(), newSemester, listStudent)) {
            System.out.println("Duplicate Information");
        } else {
            int index = getIndexStudentList(stu, listStudent);
            listStudent.get(index).setSemester(newSemester);
        }
    }
//get index student list
    private static int getIndexStudentList(Student studentFind, ArrayList<Student> listStudent) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(studentFind.getId()) && student.getSemester().equalsIgnoreCase(studentFind.getSemester())
                    && student.getCourseName().equalsIgnoreCase(studentFind.getCourseName())) {
                return listStudent.indexOf(student);
            }
        }
        return 0;
    }
//get total course
    private static int getTotalCourse(String courseName, ArrayList<Student> listStudent) {
        int count = 0;
        for (Student student : listStudent) {
            if (student.getCourseName().equalsIgnoreCase(courseName)) {
                count++;
            }
        }
        return count;
    }
//add report
    private static void addReport(int totalCourse, ArrayList<Report> reportList, String id, String courseName, ArrayList<Student> listStudent) {
        if (totalCourse != 0) {
            reportList.add(new Report(getNameByStudentID(id, listStudent), courseName, totalCourse));
        }
    }
//update course name
    private static void updateCourseName(Student stu, ArrayList<Student> listStudent, String newCourse) {
        if (Validation.validateInformationExist(stu.getId(), stu.getSemester(), newCourse, listStudent)) {
            System.out.println("Duplicate Information");
        } else {
            int index = getIndexStudentList(stu, listStudent);
            listStudent.get(index).setCourseName(newCourse);
        }
    }

    private static void updateIdNotExist(String newId, ArrayList<Student> listStudent, String oldId) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(oldId)) {
                student.setId(newId);
            }
        }
    }

    private static void updateIdExist(String newId, ArrayList<Student> listStudent, String oldId, ArrayList<Student> listFind) {
        int count = 0;
        for (Student studentFind : listFind) {
            studentFind.setId(newId);
            if (Validation.validateInformationExist(newId, studentFind.getSemester(), studentFind.getCourseName(), listStudent)) {
                count++;
            }
        }
        if (count != 0) {
            System.out.println("Duplicate Information");
        } else {
            for (Student student : listStudent) {
                if (student.getId().equalsIgnoreCase(oldId)) {
                    student.setId(newId);
                }
            }
        }
    }

    private static void updateIdNotExist(Student stu, ArrayList<Student> listStudent, String newId) {
            int index = getIndexStudentList(stu, listStudent);
            listStudent.get(index).setId(newId);
        
    }

    private static void updateIdExist(Student stu, ArrayList<Student> listStudent, String newId, String newName) {
        if (Validation.validateInformationExist(newId, stu.getSemester(), stu.getCourseName(), listStudent)) {
            System.out.println("Duplicate Information");
        } else {
            int index = getIndexStudentList(stu, listStudent);
            listStudent.get(index).setId(newId);
            listStudent.get(index).setStudentName(newName);
        }
    }


    private static String getIdByName(String name, ArrayList<Student> listStudent) {
        for (Student student : listStudent) {
            if (student.getStudentName().equalsIgnoreCase(name)) {
                return student.getId();
            }
        }
        return "";
    }

    private static void updateName(Student stu, ArrayList<Student> listStudent, String newName) {

            int index = getIndexStudentList(stu, listStudent);
            listStudent.get(index).setStudentName(newName);
        }
}
