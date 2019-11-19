package utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.DataTable;

public class RestUtils {

    private Unirest rest = new Unirest();

    public HttpResponse<JsonNode> giveToken()throws Throwable{
    HttpResponse<JsonNode> response = Unirest.post("https://eservices.inversionessecurity.cl/api/website/auth/login")
            .header("Content-Type", "application/json; charset=UTF-8")
            .header("Invsec-Channel", "1")
            .header("Invsec-Version", "1")
            .header("Host", "eservices.inversionessecurity.cl")
            .body("{\"idCliente\":\"12485766-k\", \"clave\":\"1234asdf\" }")
            .asJson();
    return response;
}

    public HttpResponse<JsonNode> sendFirstRequest(String tokenName, DataTable rut) throws Throwable{
        HttpResponse<JsonNode> response = rest.post("https://api.sandbox.connect.fif.tech/sso/oauth2/v2/token")
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic 204972971540932329514:BIvHPipZOOSLOO2smaBhP_Y8SY2UOZZhwsb6eVeKJQvi")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "57496bba-8331-45ff-a6cf-83a6ae42ce11").asJson();
                //.body(ReadTemplateToJson(tokenName, rut)).asJson();
        return response;
    }

    public HttpResponse<JsonNode> sendRequest(String bearer, String template, DataTable data) throws Throwable{
        HttpResponse<JsonNode> response = rest.post("https://api.sandbox.connect.fif.tech/checkout/payments")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+bearer+"")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "89d2e0fa-a13f-477a-a45b-785e9f783a54").asJson();
               // .body(ReadTemplateToJson(template, data)).asJson();
        return response;
    }
    public void SendDeleteWizard() throws Throwable {

        try {
            HttpResponse<JsonNode> response = rest.delete("http://apicommondev2/api/EvaluadorScripts/CLIENTE/id/12485766-K/data")
                    .header("Content-Type", "application/json")
                    .header("Invsec-Channel", "1")
                    .header("Invsec-Version", "1")
                    .header("LogLevel", "4")
                    .body("{\n   \"$flowVersion\": 1,\n   \"$currentPos\": 0,\n   \"$step\": 0,\n   \"$lastPos\": 0,\n   \"$flow\": \"BIENVENIDA|DATOSBASICOSCLIENTE|DATOSPERSONALESCLIENTE|DIRECCIONPARTICULARCLIENTE|DATOSLABORALESCLIENTE|RELACIONCLIENTEINVERSIONES|DATOSPERSONALESCOMPLETADO|AUTORIZACIONES|INSTRUCCIONES|AUTORIZACIONESCOMPLETADO|CUENTASBANCARIASCLIENTE|FORMASDEPAGOCLIENTE|CUENTABANCARIACOMPLETADO|DECLARACIONESFATCA|DECLARACIONESPEP|PERFILINVERSIONISTA|DECLARACIONESCOMPLETADO|GUARDA|CONTRATOS|LISTACONTRATOSFIRMADOS|FIRMACOMPLETADO\",\n   \"$flowInitialized\": true,\n   \"$injectedSpouseWiz\": false,\n   \"$injectedSpouseAddrWiz\": false,\n   \"$injectedWorkAddrWiz\": false,\n   \"$injectedInvestorPoll\": false,\n   \"$injectedCrsWiz\": false,\n   \"$signedAgain\": true,\n   \"$allSigned\": false,\n   \"$enrollFlowComplete\": false,\n   \"$enrollStartedOn\": \"2019-02-19T16:10:03\",\n   \"$personType\": \"PN\"\n}")
                    .asJson();
            System.out.println("Voy aca :"+response.getBody());
        }catch (UnirestException e) {
            e.printStackTrace();
        }
        //return response;
    }


   // private static String ReadTemplateToJson(String templateName, DataTable dt) throws Throwable{
       // File fileContents = new File("src/test/resources/templates/"+templateName);
       // Binding binding = createBinding(dt);
       // GStringTemplateEngine templateEngine = new GStringTemplateEngine();
       // Template template = templateEngine.createTemplate(fileContents);
      //  Template response = template.make(binding.variable);
       // return response;
    //}
   // private static Binding createBinding(DataTable aux) {
     //   List<Map<String, String>> list = aux.asMaps(String.class, String.class);
       // Binding newBind = new groovy.lang.Binding();
        //for (int i = 0; i < list.size(); i++) {
        //   newBind.setVariable(list.get(i).get("Key"),list.get(i).get("Value").toString())
       // }
       // println("BINDINGS_FINAL: "+newBind.getVariables())
       // return newBind;
    //}
 }



