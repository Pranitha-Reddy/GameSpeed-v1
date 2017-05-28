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

public class viewReview extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//Get the values from the form
                        //String searchParameter=request.getParameter("ProductName");
			
		        //String searchField = "productName";
			
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("Assignment");
			
			DBCollection myReviews = db.getCollection("myReviews");
			
			// Find and display 
			BasicDBObject searchQuery = new BasicDBObject();
			//searchQuery.put(searchField, searchParameter);

			DBCursor cursor = myReviews.find();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			//out.println(cursor);
						
					out.println("<!doctype html>");
		         out.println("<html>");
			out.println("<head>");
                        //out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	                out.println("<title>View Review</title>");
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
                        out.println("<p> More about the product</p>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<h2>Review</h2>");
                        out.println("</article>");
                        out.println("<article>");
                        if(cursor.count() == 0){
				out.println("There are no reviews for this product.");
			}else{
			
				
				
			String productName = "";
			String productModel = "";
			String Manufacturer = "";
			String Retailer = "";
			String RetailerZip = "";
			String RetailerCity = "";
			String RetailerState = "";
                        String productonsale = "";
                        String ManufacturerRebate = "";
                        int Price = 0;
                        String userName = "";
                        int userAge = 0;
                        String gender = "";	
                        String userOccupation = "";
			String reviewDate = "";
			String reviewText = "";
                        int rating = 0;
			int reviewID=0;
				
				while (cursor.hasNext()) {
					//out.println(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
			out.println("<table>");
								out.println("<tr>");
					out.println("<td> Product Name: </td>");
					productName = obj.getString("productName");
					out.println("<td>" +productName+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Product Model: </td>");
					productModel = obj.getString("productModel");
					out.println("<td>" +productModel+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Manufacturer: </td>");
					Manufacturer = obj.getString("Manufacturer");
					out.println("<td>" +Manufacturer+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Retailer: </td>");
					Retailer = obj.getString("Retailer");
					out.println("<td>" +Retailer+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Retailer Zip: </td>");
					RetailerZip = obj.getString("RetailerZip");
					out.println("<td>" +RetailerZip+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Retailer City: </td>");
					RetailerCity = obj.getString("RetailerCity");
					out.println("<td>" +RetailerCity+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Retailer State: </td>");
					RetailerState = obj.getString("RetailerState");
					out.println("<td>" +RetailerState+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Product on sale: </td>");
					productonsale = obj.getString("productonsale");
					out.println("<td>" +productonsale+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Manufacturer Rebate: </td>");
					ManufacturerRebate = obj.getString("ManufacturerRebate");
					out.println("<td>" +ManufacturerRebate+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Price: </td>");
					Price = Integer.parseInt(obj.getString("Price"));
					out.println("<td>" +Price+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> User Name: </td>");
					userName = obj.getString("userName");
					out.println("<td>" +userName+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Age: </td>");
					userAge = Integer.parseInt(obj.getString("userAge"));
					out.println("<td>" +userAge+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Gender: </td>");
					gender = obj.getString("gender");
					out.println("<td>" +gender+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Occupation: </td>");
					userOccupation = obj.getString("userOccupation");
					out.println("<td>" +userOccupation+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Review Date: </td>");
					reviewDate= obj.getString("reviewDate");
					out.println("<td>" +reviewDate+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td> Review: </td>");
					reviewText = obj.getString("reviewText");
					out.println("<td>" +reviewText+ "</td>");
					out.println("</tr>");

					out.println("<tr>");
					out.println("<td> Rating: </td>");
					rating = Integer.parseInt(obj.getString("rating"));
					out.println("<td>" +rating+ "</td>");
					out.println("</tr>");
				
                        out.println("</table>");}}
                                        	
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

	
	public void destroy(){
      // do nothing.
	}
}