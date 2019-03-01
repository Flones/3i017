package Service;

import org.json.JSONException;
import org.json.JSONObject;

public class Message {
	//a finir
	
	public static JSONObject addMessage(String cle, String texte) throws JSONException {
		if (cle==null||texte==null)
			return ServicesTools.ServiceRefused("Wrong argument", -1);
		JSONObject retour=new JSONObject();
		try {
			String key=BD.BDTools.InsertMessage(cle,texte);
			
			retour.put("message add","OK");
		}	
		catch(JSONException e){
			return(ServicesTools.ServiceRefused("Json pb"+e.getMessage(),100));
		}
		return retour;
			
	}
	//removeMessage >>doremove
	/*public static JSONObject removeMessage(String cle,String message) throws JSONException {
		if (cle==null)
			return ServicesTools.ServiceRefused("Wrong argument", -1);
		JSONObject retour=new JSONObject();
		try {
			String key=BD.BDTools.deleteMessage(cle,message);
			
			retour.put("message delete","OK");
		}	
		catch(JSONException e){
			return(ServicesTools.ServiceRefused("Json pb"+e.getMessage(),100));
		}
		return retour;
			
	}
	*/
	public static JSONObject search(String key, String messa) throws JSONException {
		if (key==null)
			return ServicesTools.ServiceRefused("Wrong argument", -1);
		JSONObject retour=new JSONObject();
		BD.BDTools.searchMessage(messa);
		retour.put("message","trouvé");
		return retour;
	}
	
	//searchMessage >>truc bizarre voir avec prof
}
