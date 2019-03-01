package Service;


import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

public class ServicesTools{
	
	public static JSONObject ServiceRefused(String message, int id) throws JSONException {
		JSONObject json= new JSONObject();
		json.put("id-erreur",id);
		json.put("message",message);
		json.put("status","KO");
		return json;
	}
	
	public static JSONObject serviceAccepted() throws JSONException {
		JSONObject json= new JSONObject();
		json.put("status","OK");
		return json;
	}
	//User
	public static boolean checkUserExist(String login) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		return BD.BDTools.checkUserExist(login);
	}
	public static boolean checkCleExist(String clé) throws SQLException {
		
		return BD.BDTools.checkCleExists(clé);
	}
	
	public static boolean checkUserPassword(String login,String pwd) {
		return true;
	}
	public static int getUserId(String login) {
		return 30;
	}
	public static String InsertConnection(int id_user,boolean a) {
		return "clefGéneré";
	}
	public static String Deconnexion(String clé) {
		return "deconnecté";
	}
	public static String checkFriendExist(int id) {
		// TODO Auto-generated method stub
		return "il existe";
	}
	public static String addFriend(int id) throws SQLException {
		
		return BD.BDTools.addFriend(id);
	}	
	public static String removeFriend(int id) throws SQLException {
		// TODO Auto-generated method stub
		return BD.BDTools.removeFriend(id);
	}
	
	//Message
	public static String InsertMessage(String message) {
		return message;
	}
	public static String deleteMessage(String cle) {
		return "effacé";
	}




	
}
