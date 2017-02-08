/**
 * Created by Wesley on 2/2/17.
 */

public class User {
    String name;
    String option;
    String newAccountOrNo;
    Double accountBalance;

    void chooseName() throws Exception {
        System.out.println("What is your Name?");
        name = Bank.scanner.nextLine();

        /* When user just presses enter, program throws an exception. For anything else
        they type, it says Welcome, and then whatever they typed.
         */

        if (Bank.accounts.containsKey(name)) {

            chooseOption();

        } else if (name.isEmpty()) {
            throw new Exception("Must enter name!");

        } else {


            while ((newAccountOrNo != "Y") && (newAccountOrNo != "N")) {

                System.out.println("No account found under that name \n" +
                        "Would you like to create a new account under the name " + name + "? \n" + "[Y or N]");

                newAccountOrNo = Bank.scanner.nextLine();


                if (newAccountOrNo.equalsIgnoreCase("Y")) {
                    System.out.println("How much would you like to deposit?");

                    double amount = Bank.scannerdouble.nextDouble();

                    Bank.accounts.put(name, amount);

                    break;
                }


                if (newAccountOrNo.equalsIgnoreCase("N")) {
                    System.out.println("Have a nice day.");
                    System.out.println("Thank You for using Java Bank!");
                    chooseName();
                    break;

                }

            }


        }




          /*  default:
                System.out.println("Invalid choice!");
                throw new Exception("Invalid choice!"); */


    }

    void chooseOption() throws Exception {
        System.out.println("WHAT WOULD YOU LIKE TO DO?");
        System.out.println("=>Press 1 to Check Balance");
        System.out.println("=>Press 2 to Withdraw Funds");
        System.out.println("=>Press 3 to Cancel");
        System.out.println("=>Press 4 to Close Account");

        option = Bank.scanner.nextLine();

        switch (option) {
            case "1":

                accountBalance = Bank.accounts.get(name);
                System.out.printf("$%.2f\n" , accountBalance);
                chooseOption();

                break;

            case "2":
                System.out.println("How much money would you like to withdraw?");

                accountBalance = Bank.accounts.get(name);
                double amount = Bank.scannerdouble.nextDouble();


                if (amount > accountBalance) {

                    System.out.println("Insufficient Funds.");
                }

                //deducts withdrawal amount, updates user's account, and prints a success message.
                else {

                    Bank.accounts.replace(name, accountBalance - amount);


                    System.out.println("Please take your $" + amount + " from the cash dispenser below. \n" +
                            "Your new account balance is:\n" + "$" + Bank.accounts.get(name));

                }

                chooseOption();

                break;

            case "3":
                System.out.println("Have a nice day.");
                System.out.println("Thank You for using Java Bank!");
                chooseName();
                break;
            default:
                throw new Exception("Invalid choice!");

            case "4":
                System.out.println("Account closed.\n" +
                        "Please take your $" + accountBalance + " from the cash dispenser below");
                Bank.accounts.remove(name);
                System.out.println("Thank You for using Java Bank!");
                chooseName();



        }
    }

}