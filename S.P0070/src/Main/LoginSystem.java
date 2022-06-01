/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author dinhh
 */
public class LoginSystem {
    private Locale locate;
    private ResourceBundle rb;
    private EBank eBank = new EBank(rb);

    public String inputAccount() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(rb.getString("enterAcc"));
            String acc = scanner.nextLine();
            if (eBank.checkAccount(acc) == null) {
                return acc;
            } else {
                System.out.println(eBank.checkAccount(acc));
            }
        }
    }

    public String inputPassword() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(rb.getString("enterPassword"));
            String pass = scanner.nextLine();
            if (pass.isEmpty()) {
                System.err.println(rb.getString("errPasswordEmpty"));
            } else if (eBank.checkPassword(pass) == null) {
                return pass;
            } else {
                System.err.println(rb.getString("errInputPassword"));
            }
        }
    }
    
    public void changeLanguage(int choice){
        if(choice==1){
            locate = new Locale("vi");
            eBank.setLocale(locate);
            this.rb = ResourceBundle.getBundle("language/" + locate);
        }else if(choice == 2){
            locate = new Locale("en");
            eBank.setLocale(locate);
            this.rb = ResourceBundle.getBundle("language/" + locate);
        }
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        EBank eBank = new EBank(rb);
    //    boolean checkC = false;

        while (true) {
            String acc = inputAccount();
            String pass = inputPassword();
            while (true) {
                String captcha = eBank.generateCaptcha();
                System.out.println("Captcha: " + captcha);
                System.out.print(rb.getString("enterCaptcha"));
                String inputCaptha = scanner.nextLine();
                if (eBank.checkCaptcha(captcha, inputCaptha) == null) {
                  //  checkC = true;
                    break;
                }
                System.err.println(rb.getString("errCaptcha"));
            }
//            if (checkC) {
                System.out.print(rb.getString("loginSuccess"));
                System.out.println("");
                return;
//            }
        }
    }
}
