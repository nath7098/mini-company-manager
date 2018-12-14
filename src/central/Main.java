package central;

import central.app.view.App;
import central.model.company.Company;

public class Main {

    public static void main(String[] args){
        App app = new App(); //creates the visuals of application
        //some actions are already working as adding/deleting employees or departments

        Company company = Company.initCompany();
        //Company company = Company.initFromCSV();
        company.saveToCSV();
    }
}
