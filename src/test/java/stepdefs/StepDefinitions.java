package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.GeneralUtils;
import utils.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class StepDefinitions {
    public SeleniumUtils sel = new SeleniumUtils();
    public static GeneralUtils gu = new GeneralUtils();


    @Before
    public void beforehook(Scenario scenario){

    }

    @Then("^Close Browser$")
    public void closeBrowserInstance(){
        sel.CloseBrowser();
    }
    @Given("^Open Browser and navigate to \"([^\"]*)\"$")
    public void OpenBrowserAndNavigate(String url)throws Throwable{
        //sel.SetProperties();
        sel.OpenBrowser(url);
        sel.maximizeBrowser();
    }

    @And("^La pagina deberia tener los siguientes textos$")
    public void ValidateInnerText(DataTable dt)throws Throwable{
        boolean res=false;
        List<Map<String, String>> aux = dt.asMaps(String.class, String.class);
        for(int i = 0; i<aux.size();i++){
            res = sel.containsValueInXPath(aux.get(i).get("xpath"),aux.get(i).get("text").toString().trim());
        }
        Thread.sleep(1000);
        assert res;
    }


    @Given("^Click on \"([^\"]*)\" button$")
    public void clickButton(String buttonName) throws Throwable{
        sel.clickButtonInXPath(sel.GetXpathByName(buttonName,"Login_po"));
        Thread.sleep(7000);
    }
    @And("^Complete the form and submit$")
    public void complete_the_form_and_submit(DataTable dt) throws Throwable {
        List<Map<String, String>> aux = dt.asMaps(String.class, String.class);
        for(int i = 0; i<aux.size();i++){
            sel.sendValuesXpath(sel.GetXpathByName(aux.get(i).get("key"),"Login_po"), aux.get(i).get("value").toString());
        }
        Thread.sleep(1000);
        sel.clickButtonInXPath(sel.GetXpathByName("signup_submit","Login_po"));

    }
    @Then("^Validate message \"([^\"]*)\"$")
    public void Email_sent_validation(String text)throws Throwable{
        sel.compareStringsInXpath(sel.GetXpathByName("email_sent","Login_po"),text);
    }
    @And("^Dismiss starter tutorial$")
    public void DismissTutorial()throws Throwable{

        sel.clickButtonInXPath(sel.GetXpathByName("nextWizard1", "Login_po"));
        Thread.sleep(1000);
        sel.clickButtonInXPath(sel.GetXpathByName("nextWizard2", "Login_po"));
        Thread.sleep(1000);
        sel.clickButtonInXPath(sel.GetXpathByName("nextWizard3", "Login_po"));
        Thread.sleep(1000);

        sel.clickButtonInXPath(sel.GetXpathByName("getStarted", "Login_po"));
        Thread.sleep(1000);
    }
    @And("^Add a new Address$")
    public void AddAddress(DataTable dt)throws Throwable{
        List<Map<String, String>> aux = dt.asMaps(String.class, String.class);
        for(int i = 0; i<aux.size();i++){
            sel.sendValuesXpath(sel.GetXpathByName(aux.get(i).get("key"),"Address_po"), aux.get(i).get("value").toString());
        }
        Thread.sleep(1000);
        //sel.clickButtonInXPath(sel.GetXpathByName("continue","Login_po"));

    }
    @And("^put \"([^\"]*)\" and \"([^\"]*)\" to login$")
    public void LogIn(String email, String pass)throws Throwable{
        sel.sendValuesXpath(sel.GetXpathByName("emailLogin","Login_po"), email);

        sel.sendValuesXpath(sel.GetXpathByName("passwordLogin","Login_po"), pass);

        sel.clickButtonInXPath(sel.GetXpathByName("loginButton","Login_po"));

    }

}
