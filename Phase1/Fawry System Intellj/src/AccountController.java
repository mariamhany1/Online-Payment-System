public class AccountController extends FawryController{
    AccountController(Database database){
        this.database = database;
    }
    String addAccount(Admin admin){
        admin.setAccountID(database.accounts.size());
        database.accounts.add(admin);
        return "Account added successfully";
    }
    String addAccount(Client client) {
        client.setAccountID(database.accounts.size());
        database.accounts.add(client);
        return "Account added successfully";
    }
    String addCreditCard(Client client, CreditCard creditCard){
        client.setCreditCard(creditCard);
        CreditCardController creditCardController = new CreditCardController(database);
        int indexCreditCard = creditCardController.checkExistenceCreditCard(creditCard);
        if(indexCreditCard == -2){
            return "Please Enter a valid Credit Card";
        }
        else if(indexCreditCard == -1){
            database.creditCards.add(creditCard);
        }
        else{
            database.creditCards.set(indexCreditCard, creditCard);
        }
        return "Credit Card added successfully";
    }
    boolean checkAccountLogin(Account account1, String usernameOrEmail, String password){
        if((account1.getUsername().equals(usernameOrEmail) || account1.getEmail().equals(usernameOrEmail)) &&
            account1.getPassword().equals(password)
        ) {
            return true;
        }
        else{
            return false;
        }
    }
    boolean checkAccountSignUp(Account account1, Account account2){
        if(account1.getUsername().equals(account2.getUsername()) ||
                account1.getEmail().equals(account2.getEmail())) {
            return true;
        }
        else{
            return false;
        }
    }
    String addFunds(Client client, double amount){
        CreditCardMethod creditCardMethod = new CreditCardMethod(database);
        return creditCardMethod.addFunds(client, amount);
    }
}
