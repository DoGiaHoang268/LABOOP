
import java.util.ArrayList;

class Validation {

    static boolean validateYN() {
        String result = GetInput.getYN("[YyNn]{1}", "Please input Y for Yes, N for No: ");
        if(result.equalsIgnoreCase("Y"))
            return true;
        return false;
    }

    static boolean validateIDExist(String id, ArrayList<Student> listStudent) {
        for(Student student : listStudent){ 
            if(student.getId().equalsIgnoreCase(id)){ 
                return true;
            }
        }
        return false;
    }

    static boolean validateInformationExist(String id, String semester, String courseName, ArrayList<Student> listStudent) {
        for(Student student : listStudent){ 
            if(student.getId().equalsIgnoreCase(id) && student.getSemester().equalsIgnoreCase(semester) 
                    && student.getCourseName().equalsIgnoreCase(courseName)){ 
                return true;
            }
        }
        return false;
    }
    
}
