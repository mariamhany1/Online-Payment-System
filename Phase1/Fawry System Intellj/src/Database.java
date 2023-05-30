
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    Account account;
    ArrayList<Account> accounts;
    ArrayList<Service> services;
    ArrayList<Service> mobileServices;
    ArrayList<Service> InternetServices;
    ArrayList<Service> landlineServices;
    ArrayList<Service> donationServices;
    ArrayList<RefundRequest> refunds;

    ArrayList<Discount> discounts;
    SpecificDiscount mobileServiceDiscount;
    SpecificDiscount internetServiceDiscount;
    SpecificDiscount landlineServiceDiscount;
    SpecificDiscount donationServiceDiscount;
    OverallDiscount overallDiscount;

    ArrayList<CreditCard> creditCards;
    Database() {
        accounts = new ArrayList<>();
        services = new ArrayList<>();
        discounts = new ArrayList<>();
        creditCards = new ArrayList<>();
        mobileServices = new ArrayList<>();
        landlineServices = new ArrayList<>();
        InternetServices = new ArrayList<>();
        donationServices = new ArrayList<>();
        refunds = new ArrayList<>();
        mobileServiceDiscount = null;
        internetServiceDiscount = null;
        landlineServiceDiscount = null;
        donationServiceDiscount = null;
        overallDiscount = null;
    }

    public static class Pair<F, S> {
        private F first;
        private S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return this.first;
        }

        public S getSecond() {
            return this.second;
        }

        public void setFirst(F first) {
            this.first = first;
        }

        public void setSecond(S second) {
            this.second = second;
        }
    }
}