package Service;

import org.json.JSONException;
import org.json.JSONObject;

public class Message {
	//addMessage >> doput
	public static JSONObject addMessage(String cle, String texte) throws JSONException {
		if (cle==null||texte==null)
			return ServicesTools.ServiceRefused("Wrong argument", -1);
		JSONObject retour=new JSONObject();
		try {
			String key=ServicesTools.InsertMessage(texte);
			
			retour.put("status","OK");
			retour.put("key", key);
		}	
		catch(JSONException e){
			return(ServicesTools.ServiceRefused("Json pb"+e.getMessage(),100));
		}
		return retour;
			
	}
	//removeMessage >>doremove
	public static JSONObject removeMessage(String cle) throws JSONException {
		if (cle==null)
			return ServicesTools.ServiceRefused("Wrong argument", -1);
		JSONObject retour=new JSONObject();
		try {
			String key=ServicesTools.deleteMessage(cle);
			
			retour.put("status","OK");
			retour.put("key", key);
		}	
		catch(JSONException e){
			return(ServicesTools.ServiceRefused("Json pb"+e.getMessage(),100));
		}
		return retour;
			
	}
	
	//searchMessage >>truc bizarre voir avec prof
}
