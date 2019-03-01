package Service;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

public class Relation {
	
	public static JSONObject addFriend(String cle,int id) throws JSONException, SQLException {
		if (cle==null||id==0)
			return ServicesTools.ServiceRefused("Wrong argument", -1);
		JSONObject retour=new JSONObject();
		try {
			if(ServicesTools.checkFriendExist(id)==null)
				return (ServicesTools.ServiceRefused("Unknown friend", 1));
			String key=ServicesTools.addFriend(id);
			
			retour.put("status","OK");
			retour.put("key", key);
		}	
		catch(JSONException e){
			return(ServicesTools.ServiceRefused("Json pb"+e.getMessage(),100));
		}
		return retour;
			
	}
	
	public static JSONObject removeFriend(String cle,int id) throws JSONException, SQLException {
		if (cle==null||id==0)
			return ServicesTools.ServiceRefused("Wrong argument", -1);
		JSONObject retour=new JSONObject();
		try {
			if(ServicesTools.checkFriendExist(id)==null)
				return (ServicesTools.ServiceRefused("Unknown friend", 1));
			String key=ServicesTools.removeFriend(id);
			
			retour.put("status","OK");
			retour.put("key", key);
		}	
		catch(JSONException e){
			return(ServicesTools.ServiceRefused("Json pb"+e.getMessage(),100));
		}
		return retour;
			
	}
	
}
