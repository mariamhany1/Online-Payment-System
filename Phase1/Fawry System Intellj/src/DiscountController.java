import java.util.ArrayList;
import java.util.Map;

public class DiscountController extends FawryController{
    DiscountController(Database database){
        this.database = database;
    }

    String addMobileServiceDiscount(SpecificDiscount specificDiscount){
        database.mobileServiceDiscount = specificDiscount;
        return "Added Successfully";
    }

    String addInternetServiceDiscount(SpecificDiscount specificDiscount){
        database.internetServiceDiscount = specificDiscount;
        return "Added Successfully";
    }
    String addDonationServiceDiscount(SpecificDiscount specificDiscount){
        database.donationServiceDiscount = specificDiscount;
        return "Added Successfully";
    }
    String addLandLineServiceDiscount(SpecificDiscount specificDiscount){
        database.landlineServiceDiscount = specificDiscount;
        return "Added Successfully";
    }
    String addOverallDiscount(OverallDiscount overallDiscount){
        database.overallDiscount = overallDiscount;
        return "Added Successfully";
    }

    double applyOverAllDiscount(Client client, double amount){
        if(client.getTransactions().size() > 0 || database.overallDiscount == null){
            return amount;
        }
        else{
            return database.overallDiscount.applyDiscount(amount);
        }
    }
    double applyDiscountMobileService(Service service, Client client, double amount){
        double extra = amount - applyOverAllDiscount(client, amount);
        MobileServiceController mobileServiceController = new MobileServiceController(database);
        if(mobileServiceController.checkDiscountMobileService(service) && database.mobileServiceDiscount != null){
            return Math.max(database.mobileServiceDiscount.applyDiscount(amount) - extra, 0);
        }
        else{
            return amount;
        }
    }
    double applyDiscountInternetService(Service service, Client client, double amount){
        double extra = amount - applyOverAllDiscount(client, amount);
        InternetServiceController internetServiceController = new InternetServiceController(database);
        if(internetServiceController.checkDiscountInternetService(service) && database.internetServiceDiscount != null){
            return Math.max(database.internetServiceDiscount.applyDiscount(amount) - extra, 0);
        }
        else{
            return amount;
        }
    }
    double applyDiscountLandlineService(Service service, Client client, double amount){
        double extra = amount - applyOverAllDiscount(client, amount);
        LandlineServiceController landlineServiceController = new LandlineServiceController(database);
        if(landlineServiceController.checkDiscountLandlineService(service) && database.landlineServiceDiscount != null){
            return Math.max(database.landlineServiceDiscount.applyDiscount(amount) - extra, 0);
        }
        else{
            return amount;
        }
    }
    double applyDiscountDonationService(Service service, Client client, double amount){
        double extra = amount - applyOverAllDiscount(client, amount);
        DonationServiceController donationServiceController = new DonationServiceController(database);
        if(donationServiceController.checkDiscountDonationService(service) && database.donationServiceDiscount != null){
            return Math.max(database.donationServiceDiscount.applyDiscount(amount) - extra, 0);
        }
        else{
            return amount;
        }
    }
    boolean checkDiscountAvailable(Service service){
        for(int i = 0; i < database.discounts.size(); i++){
            if(database.discounts.get(i).wrappee.getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
}
