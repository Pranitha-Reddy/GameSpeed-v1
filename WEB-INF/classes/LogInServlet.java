import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

public class LogInServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//Get the values from the form
			String user = request.getParameter("username") ;
                  PrintWriter out = response.getWriter();
			      //out.println(user);
                        String pass=request.getParameter("password");
			
		
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("Assignment");
			
			DBCollection myInfo = db.getCollection("myInfo");
			DBCursor cursor = myInfo.find();
                        HttpSession session=request.getSession();
                         if(user == null || pass==null)
                             {
                                out.println("<font color='red'><b>Please enter the username and password</b></font>");
                                //RequestDispatcher requestDispatcher =request.getRequestDispatcher("customerLogIn.html");
                                //requestDispatcher.forward(request, response);
                              }
			
                          
                         else 
                             {
                                 while(cursor.hasNext())
                                   { 
                                      BasicDBObject obj=(BasicDBObject) cursor.next();
                                      out.println(obj.getString("username"));
                                      if((obj.getString("username").equals(user)) && (obj.getString("password").equals(pass)))
                                         {//out.println(obj.getString("username"));
                                         String userId= obj.getString("userid");
                                          if(session.isNew())
                                           {
                                           session.setAttribute("userId",userId);
                                            }
                                         
                                    RequestDispatcher requestDispatcher=request.getRequestDispatcher("customerHome");
                                    requestDispatcher.forward(request, response);
                                          
                                          
                                  }
			}}
			//out.println(cursor);
			 String docType ="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +"Transitional//EN\">\n";
                         			
			
			
		} catch (MongoException e) {
				e.printStackTrace();
		}
	}

	
	public void destroy(){
      
	}
}