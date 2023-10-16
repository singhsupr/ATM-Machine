import java.util.*;

class ATM_PROCESS {
    Scanner sc = new Scanner(System.in);
    String Bank[] = new String[] { "HDFC BANK", "STATE BANK", "UCO BANK", "AXIS BANK" }; // bank of respective persion
    int Accounts[] = new int[] { 957678, 911757, 964326, 743994 }; // Account that are predefined
    int Pin[] = new int[] { 9576, 9117, 9643, 7439 }; // Pins that are predefined
    String name[] = new String[] { "Aman", "Ramjee", "Deepak", "Supriya" }; // names of that predefined account holder
    double Balance[] = new double[] { 2000.50, 3000.0, 2500.50, 4000.0 }; // Balance of respective persion

    int acc_no, p = 0, pin_no;

    void acc_details() {
        System.out.println("\t ENTER THE ACCOUNT NUMBER :");
        acc_no = sc.nextInt();

        for (int i = 0; i < Accounts.length; i++) {
            if (acc_no == Accounts[i]) {
                p = 1;
                pin_details(i); // function invoked for checking the pin details of the users
            }
        }
        if (p == 0) {
            System.out.println("\t Please Enter a Valid Account Number\n");

            System.out.println("Press 1 for Re-Enter the Account Number");
            System.out.println("Press 2 for Exit");

            System.out.println("Enter your choice ::");
            int ch = sc.nextInt();

            switch (ch) // switch case for different options avaliable
            {
                case 1:
                    acc_details();
                    break;

                case 2:
                    System.exit(0);

                default:
                    System.out.println("Wrong Choice");
                    break;
            }
        }
    }

    void pin_details(int x) // Check the pin details of the Entered Account
    {
        System.out.println("\t Enter The Pin Number");
        pin_no = sc.nextInt();

        if (pin_no == Pin[x]) {
            System.out.println("\n Hii " + name[x] + ",\nThis are the services which we provide : \n"); // Welcome
                                                                                                        // Message
            Menu(x);

        } else {
            System.out.println(" \t Oops, Your Entered Pin is Invalid\n");

            System.out.println("Press 1 for Re-Entered the Pin");
            System.out.println("Press 2 for Exit");

            System.out.println("Enter your choice::");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    pin_details(x);
                    break;

                case 2:
                    System.exit(0);

                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }

void Menu(int x)
{
    //-- The Menu List /  The Availale Services -----

    System.out.println("\t Press 1 for checking the Account Details--");
    System.out.println("\t Press 2 for Adding Mony--");
    System.out.println("\t Press 3 for Withdrawing Mony--");
    System.out.println("\t Press 4 for Exit--");

    System.out.println("Enter your Choice :");
    int ch=sc.nextInt();

    switch(ch)
    {
        case 1:
        check_balance(x);   // Case for Checking the Account Balance
        break;

        case 2:
        add_money(x);      // Case for Adding the Balance Into Account 
        break;

        case 3:
        withdraw_money(x);  // Case for Removing the Balance From Account
        break;

        case 4:
        System.exit(0);  // Exit All the process
          
        default:
        System.out.println(" You Entered a Wrong Choice :");
        Menu(x);
        break;
    }
}

    void check_balance(int x) {
        System.out.println("Bank Account Holder :" + name[x]);
        System.out.println("Bank name :" + Bank[x]);
        System.out.println("Account Number :" + Accounts[x]);
        System.out.println("Balance :" + Balance[x]);
        System.out.println("Follow the Menu for Further Process");
        Menu(x);
    }

    void add_money(int x) // Function Which Adds the Money of the Account Holder
    {
        System.out.println("Enter The amount You Want to Add");
        Double n = sc.nextDouble();
        Balance[x] = Balance[x] + n;
        System.out.println("Your Amount Is Successfully Added \n\n Follow the Menu List for More Option\n");
        Menu(x);
    }

    void withdraw_money(int x) // Function Which Withdraw the Money of the Account Holder
    {
        System.out.println("Enter The Amount You Want to Withdraw");
        Double n = sc.nextDouble();

        if (Balance[x] >= n) {
            Balance[x] = Balance[x] - n;
            System.out.println(
                    "Your Amount Is Successfully Withrawn \n Please Collect Your Cash \n\n Follow the Menu List for More Option\n");
            Menu(x);
        } else {
            System.out.println("Sorry, your Account Balance Is Low \n Please Enter The Valid Amount:");
            Menu(x);
        }
    



    }}

    public class ATM_MACHINE
    {
    public static void main(String[] args) {
        ATM_PROCESS obj=new ATM_PROCESS(); //creating the object of the class
        obj.acc_details();  //invoking the first function
    }
}