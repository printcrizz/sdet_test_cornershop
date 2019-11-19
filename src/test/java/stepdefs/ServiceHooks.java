package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.SeleniumUtils;

public class ServiceHooks {

    SeleniumUtils sell = new SeleniumUtils();

    @Before
    public void initializeTest(Scenario scenario)throws Exception{
        sell.setUp();
    }

    //@After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @After
    public void CloseScenarios(){
        //sell.AfterTest();
        //System.out.println("cerré los navegadores");
    }
}
