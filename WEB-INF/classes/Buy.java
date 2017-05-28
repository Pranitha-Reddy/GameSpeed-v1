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

public class Buy extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
        
	
	public void init(){
		//Connect to Mongo DB
		MongoClient mongo = new MongoClient("localhost", 27017);
						
		// if database doesn't exists, MongoDB will create it for you
		DB db = mongo.getDB("Assignment");
		
		;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
						
		try{
			
		       response.setContentType("text/html");
		
		       PrintWriter out = response.getWriter();
                                            //Integer productID=Integer.parseInt(request.getParameter("ProductId"));
                        
                        Double productID=Double.parseDouble(request.getParameter("ProductId"));
                        String productName=request.getParameter("ProductName");
                           
				//Double productID=0.0;
				String productCategory=request.getParameter("ProductName");
                                String hasWarranty=request.getParameter("Warranty");
				//Double warrantycost = Double.parseDouble(request.getParameter("WarrantyCost"));
                                Double price = Double.parseDouble(request.getParameter("Price"));
                                Double discount =Double.parseDouble(request.getParameter("Discounts"));
                                Double rebate = Double.parseDouble(request.getParameter("Rebates"));
                                Double TotalPrice=((price)-(discount+rebate));
		out.println("<!doctype html>");
		         out.println("<html>");
			out.println("<head>");
                        //out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	                out.println("<title>Buy</title>");
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
                        out.println("<p> There differents kinds os gaming consoles available</p>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<h2>Add to cart</h2>");
                        out.println("</article>");
                        out.println("<article>");					//out.println("<tr>");
			out.println(" <form method=\"get\" action='addToCart'>");
			out.println("<fieldset>");
			out.println("<legend>Product information:</legend>");
			out.println("<table>");
                        out.println("<tr>");
			out.println("<td>Product Name: </td>");
			out.println("<td> <input type=\"text\" name=\"ProductName\" value= '"+ productName +"' readonly>"); 
			out.println("<input type=\"hidden\" name=\"ProductId\" value= "+ productID +" readonly></td>");
			out.println("</tr>");
			out.println("<tr>");
                        out.println("<td>Product Model: </td>");
                        out.println("<td><input type=\"text\" name=\"ProductCategory\" value= "+ productCategory +" readonly></td>");
			out.println("</tr>");
			out.println("<tr>");
                        out.println("<td>Price per each quantity: </td>");
                        out.println("<td><input type=\"text\" name=\"Total Price\" value= "+ TotalPrice +" readonly></td>");
			out.println("</tr>");
			/*if(hasWarranty=="Yes")
			{			

                        out.println("<tr>");
			out.println("<td>Need Warranty: </td>");
			out.println("<td>");
                        out.println("<select name=\"needWarranty\">");
			out.println("<option value=\"None\" selected>None</option>");
			out.println("<option value=\"Yes\">Yes</option>");
			out.println("<option value=\"No\">No</option>"); 
			out.println("</td>");
                        out.println("</tr>");

			}*/
                       out.println("<tr>");
			out.println("<td>Quantity: </td>");
			out.println("<td>");
                        out.println("<select name=\"quantity\">");
			out.println("<option value=\"1\" selected>1</option>");
			out.println("<option value=\"2\">2</option>");
			out.println("<option value=\"3\">3</option>"); 
			out.println("</td>");
                        out.println("</tr>");
		
			out.println("<tr>");
				//out.println("<td>Buy </td>");
			out.println("<td> <input type=\"Submit\" name=\"Submit\" value= 'Add to cart'> </td>");
			out.println("</tr>");	
                        out.println(" <form method=\"get\" action='customerHome'>"); 
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