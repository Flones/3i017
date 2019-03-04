package Service;

import java.util.Date;
import java.util.GregorianCalendar;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import BD.BDTools;

public class Message {
	//a finir
	
	public static JSONObject addComment(String cle, String texte) throws JSONException {
		if (cle==null||texte==null)
			return ServicesTools.ServiceRefused("Wrong argument", -1);
		JSONObject retour=new JSONObject();
		MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongo.getDatabase(my_db);
		MongoCollection<Document> col = db.getCollection("Messages");
		Document d = new Document();
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		Date date = calendar.getTime();
		String s = date.toString();
		d.append("date",s);
		d.append("text", texte);
		d.append("user", BDTools.getUserIDParcle(cle));
		d.append("type", "commment");
		System.out.println(d);
		col.insertOne(d);	
		return retour;
			
	}
	
	
	public static JSONObject addMessage(String cle, String texte) throws JSONException {
		if (cle==null||texte==null)
			return ServicesTools.ServiceRefused("Wrong argument", -1);
		JSONObject retour=new JSONObject();
		MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongo.getDatabase(my_db);
		MongoCollection<Document> col = db.getCollection("Messages");
		Document d = new Document();
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		Date date = calendar.getTime();
		String s = date.toString();
		d.append("date",s);
		d.append("text", texte);
		d.append("user", BDTools.getUserIDParcle(cle));
		d.append("type", "message");
		System.out.println(d);
		col.insertOne(d);	
		return retour;
			
	}
	public static JSONObject search(String key, String m) throws JSONException {
		if (key==null)
			return ServicesTools.ServiceRefused("Wrong argument", -1);
		JSONObject retour=new JSONObject();
		BD.BDTools.searchMessage(m);
		retour.put("message","trouv�");
		return retour;
	}
}
