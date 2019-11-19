package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentsVariables {


    public EnvironmentsVariables(){
    }

     public void ReadJSONProperties()throws Exception{
        Properties props = new Properties();
         try{
             Object obj = new JSONParser().parse(new FileReader("src/test/resources/Environments.json"));
             JSONObject jo = (JSONObject) obj;
             JSONArray ja = (JSONArray) jo.get("properties");
           for(int i = 0; i<ja.size();i++){
               System.setProperty(ChangeFormatJson(ja.get(i).toString(),"name"),ChangeFormatJson(ja.get(i).toString(),"value"));
           }
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String ChangeFormatJson(String hijo, String value)throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(hijo);
        return jsonNode.get(value).asText();
    }
    public String ReadTextsOnWizard(String name,String object)throws Exception{
            Object obj2 = new JSONParser().parse(new FileReader("src/test/resources/texts/"+name+".json"));
            JSONObject jo = (JSONObject) obj2;
            return jo.get(object).toString();
    }
}
