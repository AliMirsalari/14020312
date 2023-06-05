package org.example.ui;

import com.vdurmont.emoji.EmojiManager;
import org.example.model.User;
import org.example.util.ApplicationContext;
import org.example.util.Constant;

import java.util.Scanner;

import static org.example.ui.Printer.printFinishLine;

public class Menu {


    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            printFinishLine();
            Printer.printMenu(Constant.FIRST_MENU_ITEMS);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.FIRST_MENU_ITEMS[0]);
                    SignUp();
                    pressEnterToContinue();
                    break;
                case 2:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.FIRST_MENU_ITEMS[1]);
                    SignIn();
                    pressEnterToContinue();
                    break;
                case 3:
                    printFinishLine();
                    clearScreen();
                    Printer.printMsg(Constant.FIRST_MENU_ITEMS[2]);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 3);
        scanner.close();
    }

    private void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }


    private void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private void SignUp(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! " + EmojiManager.getForAlias("hand").getUnicode());
        System.out.println("To get sign you up, Answer the following questions.");
        pressEnterToContinue();

        System.out.print("Your National Code? ");
        String natCode = scanner.nextLine();

        System.out.print("Your First Name? ");
        String firstName = scanner.nextLine();

        System.out.print("Your Last Name? ");
        String lastName = scanner.nextLine();

        System.out.print("Your UserName? ");
        String username = scanner.nextLine();

        System.out.print("Your Password? ");
        String password = scanner.nextLine();

        System.out.print("Your Email? ");
        String email = scanner.nextLine();

        User user = new User(natCode , firstName , lastName , username , password , email);
        ApplicationContext.getUserService().save(user);

        System.out.println("congratulations! You are one of us." + EmojiManager.getForAlias("wink").getUnicode());
        System.out.println("Now, you can Sign in...");
    }

    private void SignIn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome back! " + EmojiManager.getForAlias("hand").getUnicode());
        System.out.print("To get sign in,");
        pressEnterToContinue();

        System.out.print("Enter your Username:");
        String username = scanner.nextLine();

        System.out.print("Enter your Password:");
        String password = scanner.nextLine();


       if(ApplicationContext.getUserService().isPasswordCurrect(username , password)){
           System.out.println("congratulations! You are in the system." + EmojiManager.getForAlias("wink").getUnicode());
       }
    }



}
