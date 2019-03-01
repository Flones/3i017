package Servlet.message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class AddMessage
 */
@WebServlet("/AddMessage")
public class AddMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
			response.setContentType( " text / plain " );
			String id=request.getParameter("id");
			String m=request.getParameter("message");
			try {
				JSONObject retour=Service.Message.addMessage(id,m);
				PrintWriter out = response.getWriter ();
				out.printf(retour.toString());
				//?m=abcd
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType( " text / plain " );
		String id=request.getParameter("id");
		try {
			JSONObject retour=Service.Message.removeMessage(id);
			PrintWriter out = response.getWriter ();
			out.printf(retour.toString());
			//?id=abcd
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
