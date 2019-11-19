package pageObjects;

public class Login_po {

    public Login_po(){

    }

    public String SignUP(){
        return "/html/body/div[2]/div/div[1]/div/div/div/div/div[3]/button/span";
    }
    public String LogIn(){
        return "/html/body/div[2]/div/div[1]/div/div/div/div/div[2]/button/span";
    }
    public String email(){
        return "//*[@id=\"register\"]/input[2]";
    }
    public String name(){
        return "//*[@id=\"register\"]/input[3]";
    }
    public String lastName(){
        return "//*[@id=\"register\"]/input[4]";
    }
    public String password(){
        return "//*[@id=\"register\"]/input[5]";
    }
    public String signup_submit(){
        return "//*[@id=\"register\"]/input[6]";
    }
    public String email_sent(){
        return "/html/body/section/header/h1";
    }
    public String nextWizard1(){
        return "/html/body/div[4]/div/div[1]/div/div/div/div/div/div/div/div[1]/div/button/span";

    }
    public String nextWizard2() {
        return "/html/body/div[4]/div/div[1]/div/div/div/div/div/div/div/div[2]/div/button/span";
    }
    public String nextWizard3(){
        return "/html/body/div[4]/div/div[1]/div/div/div/div/div/div/div/div[3]/div/button/span";
    }
    public String getStarted(){
        return "/html/body/div[4]/div/div[1]/div/div/div/div/div/div/div/div[4]/div/button/span";
    }
    public String emailLogin(){
        return "//*[@id=\"email\"]";
    }
    public String passwordLogin(){
        return "//*[@id=\"password\"]";
    }
    public String loginButton(){
        return "/html/body/section/ol/section[1]/form/input[4]";
    }

}

