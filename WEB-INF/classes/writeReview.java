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

public class writeReview extends HttpServlet {
	
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
		
		DBCollection myReviews = db.getCollection("myReviews");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
						
		try{
			//Get the values from the form
                        //Integer productID=Integer.parseInt(request.getParameter("ProductId"));
			String productName=request.getParameter("ProductName");
                        String productCategory=request.getParameter("ProductCategory");
                        String Manufacturer=request.getParameter("Manufacturer");
                        String Retailer=request.getParameter("Retailer");
			
			out.println("<!doctype html>");
		         out.println("<html>");
			out.println("<head>");
                        //out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	                out.println("<title>Write Review</title>");
	                out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
                        //out.println("</head>");
			out.println("<body>");
                        out.println("<div id ='container'>");
                        out.println("<header>");
			out.println("<h1> <a href='/'> Gamer Zone</a></h1>");
			out.println("</header>");
                        out.println("<nav>");
                        out.println("<ul>");
                        out.println("<li class=''><a href=''>Home</a></li>");
                        out.println("<li class=''><a href='XBox'>XBox</a></li>");
                        out.println("<li class=''><a href='PlayStation'>Playstation</a></li>");
                        out.println("<li class=''><a href='Wii'>Wii</a></li>");
                        out.println("<li class=''><a href='Accessories'>Accessories</a></li>");
                        out.println("<li class=''><a href='viewCart'>myCart</a></li>");
                        out.println("<li class=''><a href='logOut'>LogOut</a></li>");
                        out.println("</ul>");
                        out.println("</nav>");
                        out.println("<img class='header-image' src='images/home.jpg' width = '100%' height = '100%' alt='Index Page Image'/>");
			out.println("<div id='body'>");
			out.println("<section id='content'>");
                        out.println("<article>");
                        out.println("<p> Share your experience</p>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<h2>Write Review</h2>");
                        out.println("</article>");
                        out.println("<article>");					
			out.println(" <form method=\"get\" action=\"submitReview\">");
			out.println("<fieldset>");
			out.println("<legend>Fill out the needed Information:</legend>");
			out.println("<table>");out.println("<tr>");
			out.println("<td>Product Name: </td>");
			out.println("<td> <input type=\"text\" name=\"ProductName\">"); 
			//out.println("<input type=\"hidden\" name=\"ProductId\" ></td>");
			out.println("</tr>");
			out.println("<td>Product Model: </td>");
                        out.println("<input type=\"text\" name=\"ProductCategory\" ></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Manufacturer: </td>");
			out.println("<td> <input type=\"text\" name=\"Manufacturer\" > </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Retailer: </td>");
			out.println("<td> <input type=\"text\" name=\"Retailer\"> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Retailer Zip: </td>");
			out.println("<td> <input type=\"text\" name=\"RetailerZip\"> </td>");
			out.println("</tr>");
			out.println("<td>Retailer City: </td>");
			out.println("<td> <input type=\"text\" name=\"RetailerCity\"> </td>");
			out.println("</tr>");
			out.println("<td>Retailer State: </td>");
			out.println("<td> <input type=\"text\" name=\"RetailerState\"> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Product on sale: </td>");
			out.println("<td>");
                        out.println("<select name=\"productonsale\">");
			out.println("<option value=\"None\" selected>None</option>");
			out.println("<option value=\"Yes\">Yes</option>");
			out.println("<option value=\"No\">No</option>");
                        out.println("</td>");
			out.println("</tr>");
                        out.println("<tr>");
			out.println("<td>Manufacturer Rebate: </td>");
			out.println("<td>");
                        out.println("<select name=\"ManufacturerRebate\">");
			out.println("<option value=\"None\" selected>None</option>");
			out.println("<option value=\"Yes\">Yes</option>");
			out.println("<option value=\"No\">No</option>");
                        out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Product Price: </td>");
			out.println("<td> <input type=\"text\" name=\"Price\"> </td>");
			out.println("</tr>");
             
			out.println("<tr>");
			out.println("<td>UserName: </td>");
			out.println("<td> <input type=\"text\" name=\"userName\"> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Age: </td>");
			out.println("<td> <input type=\"text\" name=\"userAge\"> </td>");
			out.println("</tr>");
                        out.println("<tr>");
			out.println("<td>Gender: </td>");
			out.println("<td>");
                        out.println("<select name=\"gender\">");
			out.println("<option value=\"0\" selected>None</option>");
			out.println("<option value=\"Male\">Male</option>");
			out.println("<option value=\"Female\">Female</option>");
                        out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Occupation: </td>");
			out.println("<td> <input type=\"text\" name=\"userOccupation\"> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>ReviewDate: </td>");
			out.println("<td> <input type=\"text\" name=\"reviewDate\"> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Review: </td>");
			out.println("<td> <input type=\"textarea\" rows='4' name=\"review\"> </td>");
			out.println("</tr>");
			out.println("<td>Rating Rating: </td>");
			out.println("<td>");
                        out.println("<select name=\"rating\">");
			out.println("<option value=\"0\" selected>0</option>");
			out.println("<option value=\"1\">1</option>");
			out.println("<option value=\"2\">2</option>");
                        out.println("<option value=\"3\">3</option>");
                        out.println("<option value=\"4\">4</option>");
                        out.println("<option value=\"5\">5</option>");
                        out.println("</td>");
			out.println("</tr>");
						out.println("<tr>");


		
			out.println("<tr>");
				//out.println("<td>Buy </td>");
			out.println("<td> <input type=\"Submit\" name=\"Submit\" value= 'Submit Review'> </td>");
			out.println("</tr>");
                        out.println("</table>");	
                        out.println("</article>");
                        out.println("</section>");

                        out.println("<aside class='sidebar'>");
                        out.println("<ul>");
                        out.println("<li>");
                        out.println("<h4> Games </h4>");
			out.println("<ul>");
			out.println("<li><a href='XBox'>XBox</a></li>");
                        out.println("<li><a href='PlayStation'>PlayStation</a></li>");
                        out.println("<li><a href='Wii'>Wii</a></li>");
                        out.println("<li><a href='Accessories'>Accessories</a></li>");
			out.println("</ul>");
                        out.println("</li>");
                        out.println("<li>");
                        out.println("<h4>Manufactureres</h4>");
                        out.println("<ul>");
                        out.println("<li><a href='XBox'>Microsoft</a></li>");
                        out.println("<li><a href='PlayStation'>Sony</a></li>");
                        out.println("<li><a href='Wii'>Niventendo</a></li>");
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