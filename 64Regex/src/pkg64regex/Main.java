package pkg64regex;

/**
 *
 * @author Hoang Do Gia
 */
public class Main {

    public static void main(String[] args) {
        Validation va = new Validation();
        String phone = va.checkInputPhone("Phone number: ","^[0-9]{10}$");//Enter the number 0 to 9 consisting of 10 digits
        String date = va.checkInputDate("Date: ");
        String email = va.checkInputEmail("Email: ","^[a-zA-Z][a-zA-Z0-9\\_]+@[a-zA-Z]+(.[a-zA-z]+){1,3}$");
    }
    /*mail corect
    hoangdg@fpt.com
    hoangdg26@fpt.com
    hoangdg_26@fpt.com
    hoangdg_26@pft.edu.vn
     */
 /*date corect 
    
    
    
     */

}
