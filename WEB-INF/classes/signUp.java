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

public class signUp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try{
                         Double userid=0.0;
			//Get the values from the form
			String name = request.getParameter("name");
			String emailid = request.getParameter("emailid");	
			String username = request.getParameter("username");
			String password = request.getParameter("password");
                        						
			// If database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("Assignment");
				
			// If the collection does not exists, MongoDB will create it for you
			DBCollection myInfo = db.getCollection("myInfo");
                        
			System.out.println("Collection myInfo selected successfully");
			DBCursor cursor = myInfo.find();
                        while(cursor.hasNext())
                        { BasicDBObject obj=(BasicDBObject)cursor.next();
                          Double temp=(Double) obj.get("userid");
                          if(userid<  temp)
                           {userid=(Double) temp;
                              }
}
                       BasicDBObject doc = new BasicDBObject("title", "myinfo").
                                append("userid",userid+1.0).
				append("name", name).
				append("emailid", emailid).
				append("username", username).
				append("password", password);
			
									
			myInfo.insert(doc);
				
			System.out.println("Document inserted successfully");
			
			//Send the response back to the JSP
			PrintWriter out = response.getWriter();
						
					         out.println("<html>");
			out.println("<head>");
                        //out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	                //out.println("<title>Gamer Zone</title>");
	                out.println("<link rel='stylesheet' href='styles.css' type='text/css' >");
                        //out.println("</head>");
			out.println("<body>");
                        out.println("<div id ='container'>");
                        out.println("<header>");
			out.println("<h1> <a href='/'> Gamer Zone</a></h1>");
			out.println("</header>");
                        out.println("<nav>");
                        out.println("<ul>");
                        out.println("<li class='start selected'><a href=''>Home</a></li>");
                        
                        out.println("<li class=''><a href=''>XBox</a></li>");
                        out.println("<li class=''><a href=''>Playstation</a></li>");
                        out.println("<li class=''><a href=''>Wii</a></li>");
                        out.println("<li class=''><a href=''>Accessories</a></li>");
                        out.println("</ul>");
                        out.println("</nav>");
                        out.println("<img class='header-image' src='images/home.jpg' width = '100%' height = '100%' alt='Index Page Image'/>");
			out.println("<div id='body'>");
			out.println("<section id='content'>");
                        out.println("<article>");
                        out.println("<p>SignUp Successful</p>");
                        out.println("<p><a href='customerLogIn.html'> Log In</a> to continue</p>");
                        out.println("</article>");
                        out.println("</section>");
                        out.println("<aside class='sidebar'>");
                        out.println("<ul>");
                        out.println("<li>");
                        out.println("<h4> Games </h4>");
			out.println("<ul>");
			out.println("<li><a href=''>XBox</a></li>");
                        out.println("<li><a href=''>PlayStation</a></li>");
                        out.println("<li><a href=''>Wii</a></li>");
                        out.println("<li><a href=''>Accessories</a></li>");
			out.println("</ul>");
                        out.println("</li>");
                        out.println("<li>");
                        out.println("<h4>Manufactureres</h4>");
                        out.println("<ul>");
                        out.println("<li><a href=''>Microsoft</a></li>");
                        out.println("<li><a href=''>Sony</a></li>");
                        out.println("<li><a href=''>Niventendo</a></li>");
                        out.println("</ul>");
                        out.println("</li>");
                        
                        out.println("<li>");
                        out.println("<h4>About Us</h4>");
                        out.println("<ul>");
                        out.println("<li class='text'>");
                        //out.println("<p style='margin: 0;'>ge.</p>");
                        out.println("</ul>");
                        out.println("</li>");
                        out.println("</ul>");
                        out.println("</aside>");
                        out.println("<div class='clear'></div>");
                        out.println("</div>");
                        out.println("<footer>");
                        out.println("<div class='footer-content'>");
                        out.println("<ul>");
                        out.println("<li><h4>Dummy Link</h4></li>");
                        out.println("</ul>");
                        out.println("<div class='clear'></div>");
                        out.println("</div>");
                        out.println("<div class='footer-bottom'>");
                        out.println("<p>All Rights reserved @ Gamer Zone </p>");
                        out.println("</div>");
		
                        out.println("</footer>");
                        out.println("</div>");
                        out.println("</body>");
		        out.println("</html>");
		
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy()	{
      
	}
	
}

