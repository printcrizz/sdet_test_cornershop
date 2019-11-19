package utils;

import cucumber.api.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class GeneralUtils {

    public GeneralUtils(){

    }

    public static String AmountFormat(Integer amount){
        DecimalFormat formatter = new DecimalFormat("###,###,###.###");
        return formatter.format(amount).toString();
    }
    public static String AddMoneyHeist(String money){
        return "$" + money;
    }
    static Boolean ValidateTexts(DataTable aux, String body) {
        List<Map<String, String>> list = aux.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            body.contains(list.get(i).toString());
            System.out.println("objetos "+list.get(i).toString());
        }
        return true;
    }
    //static void ChangeTab(String value){
      //  Robot movement = new Robot();
    //}
    static String RemoveCharacters(String keys){
        String aux = keys;
        aux = aux.replace("[","");
        aux = aux.replace("]","");
        return aux;
    }
    public String CreateTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        return timestamp.toString();
    }
    public void clickOnRecaptcha()throws Exception{
        Robot movement = new Robot();
        movement.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        movement.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(500);
        movement.keyPress(KeyEvent.VK_SPACE);
    }
    public float Multiplier(float Action_number, float multiplier){
        return Action_number * multiplier;
    }

    public float StringToFloat(String var){
        String f = var.replace(",",".");
        float aux= Float.parseFloat(f);
        return aux;
    }
    public String RemoveDollarChar(String key){
        String aux = key;
        aux = aux.replace("$","");
        return aux.trim();
    }
    public void NewTabChanger()throws Exception{
        Robot movement = new Robot();
        movement.keyPress(KeyEvent.VK_META);
        Thread.sleep(500);
        movement.keyPress(KeyEvent.VK_T);
        Thread.sleep(500);
        movement.keyRelease(KeyEvent.VK_META);
        movement.keyRelease(KeyEvent.VK_T);
       // movement.keyPress(KeyEvent.VK_SPACE);
    }
    public void GoBackTab()throws Exception{
        Robot movement = new Robot();
        movement.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(500);
        movement.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(500);
        movement.keyPress(KeyEvent.VK_TAB);

        movement.keyRelease(KeyEvent.VK_CONTROL);
        movement.keyRelease(KeyEvent.VK_SHIFT);
        movement.keyRelease(KeyEvent.VK_TAB);
    }

}

