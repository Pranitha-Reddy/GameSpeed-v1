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

public class submitReview extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try{
			//Get the values from the form
			String productName = request.getParameter("ProductName");
			String productModel = request.getParameter("ProductCategory");
			String Manufacturer = request.getParameter("Manufacturer");
			String Retailer = request.getParameter("Retailer");
			String RetailerZip = request.getParameter("RetailerZip");
			String RetailerCity = request.getParameter("RetailerCity");
			String RetailerState = request.getParameter("RetailerState");
                        String productonsale = request.getParameter("productonsale");
                        String ManufacturerRebate = request.getParameter("ManufacturerRebate");
                        int Price = Integer.parseInt(request.getParameter("Price"));
                        String userName = request.getParameter("userName");
                        int userAge = Integer.parseInt(request.getParameter("userAge"));
                        String gender = request.getParameter("gender");	
                        String userOccupation = request.getParameter("userOccupation");
			String reviewDate = request.getParameter("reviewDate");
			String reviewText = request.getParameter("review");
                        int rating = Integer.parseInt(request.getParameter("rating"));
			int reviewID;							
			// If database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("Assignment");
				
			// If the collection does not exists, MongoDB will create it for you
			DBCollection myReviews = db.getCollection("myReviews");
                         DBCursor cursor = myReviews.find();
			System.out.println("Collection myReviews selected successfully");
			reviewID=cursor.count();
                         	
			BasicDBObject doc = new BasicDBObject("title", "myReviews").
                                append("reviewID", reviewID+1).
				append("productName", productName).
				append("productModel", productModel).
                                append("Manufacturer", Manufacturer).
				append("Retailer", Retailer).
                                append("RetailerZip", RetailerZip).
				append("RetailerCity", RetailerCity).
                                append("RetailerState", RetailerState).
				append("productonsale", productonsale).
                                append("ManufacturerRebate", ManufacturerRebate).
				append("Price", Price).
                                append("userName", userName).
				append("userAge", userAge).
                                append("gender", gender).
                                append("userOccupation", userOccupation).
				append("reviewDate", reviewDate).
				append("reviewText", reviewText).
				append("rating", rating);
									
			myReviews.insert(doc);
				
			System.out.println("Document inserted successfully");
			
response.setContentType("text/html");
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
                        out.println("<p> Review Inserted Sucessfully</p>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<a href='XBox'>Models in XBox</a>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<a href='PlayStation'>Models in playstation</a>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<a href='Wii'>Models in Wii</a>");
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
	
	public void destroy()	{
      // do nothing.
	}
	
}