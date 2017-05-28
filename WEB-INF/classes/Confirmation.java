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
import java.util.Calendar;

public class Confirmation extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try{
			//Get the values from the form
                        int PurchaseID=0;
			String productName = request.getParameter("ProductName");
                        Double quantity = Double.parseDouble(request.getParameter("Quantity"));
                        Double Price = Double.parseDouble(request.getParameter("TotalPrice"));
                        String Name = request.getParameter("Name");
                        String Address = request.getParameter("Address");	
                        String MobileNo = request.getParameter("MobileNo");
			String EmailId = request.getParameter("EmailId");
			String cardType = request.getParameter("cardType");
                        String cardNumber = request.getParameter("cardNumber");
                        String userID= request.getSession().getAttribute("userId").toString();
                        Double productId = Double.parseDouble(request.getParameter("productId"));
                        Double cartID=Double.parseDouble(request.getParameter("cartId"));							
			DB db = mongo.getDB("Assignment");
                        DBCollection myCart = db.getCollection("myCart");
                         DBCursor curs = myCart.find();
                         myCart.remove(new BasicDBObject().append("cartID", cartID));
                        Calendar now = Calendar.getInstance();
                        now.add(Calendar.WEEK_OF_YEAR, 2);  
				
			// If the collection does not exists, MongoDB will create it for you
			DBCollection myPurchase = db.getCollection("myPurchase");
                         DBCursor cursor = myPurchase.find();
			
			PurchaseID=cursor.count();
                         	
			BasicDBObject doc = new BasicDBObject("title", "myPurchase").
                                append("PurchaseID", PurchaseID+1).
				append("productId", productId).
				append("userID", userID).
                                append("productName", productName).
				append("quantity", quantity).
                                append("Price", Price).
				append("Name", Name).
                                append("Address", Address).
				append("MobileNo", MobileNo).
                                append("EmailId", EmailId).
				append("Price", Price).
                                append("cardType", cardType).
				append("cardNumber", cardNumber).

				append("reviewDate",now.getTime()) ;
			
									
			myPurchase.insert(doc);
				
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
                        out.println("<p>Order Placed  Sucessfrully with Id "+PurchaseID+1+" and estimated delivery date is "+now.getTime()+" </p>");
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