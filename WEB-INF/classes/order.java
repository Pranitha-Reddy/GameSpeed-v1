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


public class order extends HttpServlet {
private static final long serialVersionUID = 1L;
MongoClient mongo;
public void init(){
		//Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
						
		// if database doesn't exists, MongoDB will create it for you
		}

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                       response.setContentType("text/html");
		
		       PrintWriter out = response.getWriter();
                                            //Integer productID=Integer.parseInt(request.getParameter("ProductId"));
                      try{  
                        int orderID=0;
                         String userID= request.getSession().getAttribute("userId").toString();
                        Double searchParameter=Double.parseDouble(request.getParameter("ProductId"));
                         Double cartID=Double.parseDouble(request.getParameter("cartId"));
                        Double TotalPrice=Double.parseDouble(request.getParameter("TotalPrice"));
                        //String searchField = "productID";
			String productName=request.getParameter("ProductName");
                        //String productCategory=request.getParameter("ProductCategory");
                        Double quantity=Double.parseDouble(request.getParameter("Quantity"));
                        DB db = mongo.getDB("Assignment");
                        //DBCollection myProducts = db.getCollection("myProducts");
                        //BasicDBObject searchQuery = new BasicDBObject();
			//searchQuery.put(searchField, searchParameter);

                        			out.println("<html>");
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
                        
                        out.println("<li class=''><a href='XBox'>XBox</a></li>");
                        out.println("<li class=''><a href='playstation'>Playstation</a></li>");
                        out.println("<li class=''><a href='wii'>Wii</a></li>");
                        out.println("<li class=''><a href='Accessories'>Accessories</a></li>");
                        out.println("<li class=''><a href='viewCart'>myCart</a></li>");
                        out.println("<li class=''><a href='logOut'>LogOut</a></li>");
                        out.println("</ul>");
                        out.println("</nav>");
                        out.println("<img class='header-image' src='images/home.jpg' width = '100%' height = '100%' alt='Index Page Image'/>");
			out.println("<div id='body'>");
			out.println("<section id='content'>");
                        out.println("<article>");
                        out.println(" <form method=\"get\" action='Confirmation'>");
			out.println("<fieldset>");
			//out.println("<legend>Product information:</legend>");
			out.println("<table>");

			out.println("<tr>");
			out.println("<td>Product Name: </td>");
			out.println("<td> <input type=\"text\" name=\"ProductName\" value= '"+ productName +"' readonly>"); 
			out.println("<input type=\"hidden\" name=\"productId\" value= "+ searchParameter +" readonly></td>");
			out.println("<td>Quantity: </td>");
			out.println("<td> <input type=\"text\" name=\"Quantity\" value= '"+quantity+"' readonly> </td>");
                        out.println("<input type=\"hidden\" name=\"cartId\" value= "+ cartID +" readonly></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Total Price: </td>");
			out.println("<td> <input type=\"text\" name=\"TotalPrice\" value= '"+ TotalPrice+"' readonly> </td>");
			out.println("</tr>");
                        out.println("<tr>");
			out.println("<td>Name: </td>");
			out.println("<td> <input type=\"text\" name=\"Name\"> </td>");
			out.println("</tr>");
                        out.println("<tr>");
			out.println("<td>Address: </td>");
			out.println("<td> <input type=\"textarea\" name=\"Address\"> </td>");
			out.println("</tr>");
                        out.println("<tr>");
			out.println("<td>Mobile No: </td>");
			out.println("<td> <input type=\"text\" name=\"MobileNo\"> </td>");
			out.println("</tr>");
                        out.println("<tr>");
			out.println("<td>Email Id: </td>");
			out.println("<td> <input type=\"text\" name=\"EmailId\"> </td>");
			out.println("</tr>");
                        out.println("<tr>");
			out.println("<td>Card Type: </td>");
			out.println("<td>");
                        out.println("<select name=\"cardType\">");
			out.println("<option value=\"Visa\" selected>Visa</option>");
			out.println("<option value=\"Master\">Master</option>");
			out.println("<option value=\"Other\">Other</option>"); 
			out.println("</td>");
                        out.println("</tr>");
                        out.println("<tr>");
			out.println("<td>Card Number: </td>");
			out.println("<td> <input type=\"text\" name=\"cardNumber\"> </td>");
			out.println("</tr>");
			out.println("<tr>");
		       //out.println("<td>Buy </td>");
			out.println("<td> <input type=\"Submit\" name=\"Submit\" value= 'Purchase'> </td>");
			out.println("</tr>");
                        out.println("</table>");
                        out.println("</form>");
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
                        out.println("<h4>Manufacturers</h4>");
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