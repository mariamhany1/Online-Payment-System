public class CreditCard {
    String cardNumber;
    double amount;
    CreditCard(String cardNumber, double amount){
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }
    public String getCardNumber() {
        return cardNumber;
    }
}
