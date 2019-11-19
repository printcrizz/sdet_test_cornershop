package pageObjects;

public class Address_po {

    public Address_po(){

    }

    public String Name(){
        return "/html/body/div[4]/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div[1]/div/input";
    }
    public String AddressType(){
        return "/html/body/div[4]/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div[2]/div/select";
    }
    public String StreetAddress(){
        return "/html/body/div[4]/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div[3]/div/input";
    }
    public String city(){
        return "/html/body/div[4]/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/select";
    }
    public String locality(){
        return "/html/body/div[4]/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div[5]/div[1]/div/select";
    }
    public String country(){
        return "/html/body/div[4]/div/div[1]/div/div/div/div/div[2]/div/div/div/div/div[5]/div[2]/div/select";
    }

}
