/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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

    public String inputCaptcha() {
        Scanner scanner = new Scanner(System.in);
        String inputCapcha;

        while (true) {
            String captcha = eBank.generateCaptcha();
            System.out.print("Captcha: " + captcha+"\t");
            System.out.print(rb.getString("enterCaptcha"));
            inputCapcha = scanner.nextLine();
            if (inputCapcha.isEmpty()) {
                System.err.println(rb.getString("emptyCaptcha"));
            } else if (captcha.contains(inputCapcha)) {
                return rb.getString("loginSuccess");
            } else {
                System.err.println(rb.getString("errCaptcha"));
            }
        }

    }

    public void changeLanguage(int choice) {
        if (choice == 1) {
            locate = new Locale("vi");
            eBank.setLocale(locate);
            this.rb = ResourceBundle.getBundle("language/" + locate);
        } else if (choice == 2) {
            locate = new Locale("en");
            eBank.setLocale(locate);
            this.rb = ResourceBundle.getBundle("language/" + locate);
        }
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        EBank eBank = new EBank(rb);

        while (true) {
            String acc = inputAccount();
            String pass = inputPassword();
            String c = inputCaptcha();
            System.out.println("");
            return;

        }
    }
}
