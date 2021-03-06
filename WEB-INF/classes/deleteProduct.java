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

public class deleteProduct extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	String productName = "";
	String imageLocation = " ";
	int productPrice = 0;
        String Manufacturer=" ";
        String productCategory=" ";
	public void init(){
		//Connect to Mongo DB
		MongoClient mongo = new MongoClient("localhost", 27017);
						
		// if database doesn't exists, MongoDB will create it for you
		DB db = mongo.getDB("Assignment");
		
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
						
		try{
			
			out.println("<!doctype html>");
		         out.println("<html>");
			out.println("<head>");
                        //out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	                out.println("<title>XBox</title>");
	                out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
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
                        out.println("<li class=''><a href=''>LogOut</a></li>");
                        out.println("</ul>");
                        out.println("</nav>");
                        out.println("<img class='header-image' src='images/home.jpg' width = '100%' height = '100%' alt='Index Page Image'/>");
			out.println("<div id='body'>");
			out.println("<section id='content'>");
                        out.println("<article>");
                        out.println("<p> </p>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<h2>Delete Product</h2>");
                        out.println("</article>");
                        out.println("<article>");					
			out.println(" <form method=\"get\" action=\"deleteTheProduct\">");
			out.println("<fieldset>");
			out.println("<p>Fill out the needed Information:</p>");
			out.println("<table>");
                        out.println("<tr>");
                        out.println("<td>Product Id: </td>");
			out.println("<td> <input type=\"text\" name=\"ProductId\"></td>"); 
			out.println("</tr>");
			out.println("<td>Product Name: </td>");
			out.println("<td> <input type=\"text\" name=\"ProductName\"></td>"); 
			out.println("</tr>");
                        out.println("<tr>");
			out.println("<td>Product Model: </td>");
                        out.println("<td><input type=\"text\" name=\"ProductCategory\"></td>");
			out.println("</tr>");
                        out.println("<tr>");
				//out.println("<td>Buy </td>");
			out.println("<td> <input type=\"Submit\" name=\"Submit\" value= 'Delete product'> </td>");
			out.println("</tr>");
                        out.println("</table>");	
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
                        out.println("<p style='margin: 0;'>This is a sample website created to demonstrate a standard enterprise web page.</p>");
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
}