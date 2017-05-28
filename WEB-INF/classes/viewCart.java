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

public class viewCart extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//Get the values from the form
                        
                        String searchParameter=request.getSession().getAttribute("userId").toString();;
			
		        String searchField = "userID";
			
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("Assignment");
			
			DBCollection myCart = db.getCollection("myCart");
			
			// Find and display 
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put(searchField, searchParameter);

			DBCursor cursor = myCart.find(searchQuery);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			//out.println(cursor);
						
					out.println("<!doctype html>");
		         out.println("<html>");
			out.println("<head>");
                        //out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	                out.println("<title>My Cart</title>");
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
                        out.println("<li class='start selected'><a href='viewCart'>myCart</a></li>");
                        out.println("<li class=''><a href='logOut'>LogOut</a></li>");
                        out.println("</ul>");
                        out.println("</nav>");
                        out.println("<img class='header-image' src='images/home.jpg' width = '100%' height = '100%' alt='Index Page Image'/>");
			out.println("<div id='body'>");
			out.println("<section id='content'>");
                        out.println("<article>");
                        out.println("<p> Seleted Products</p>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<h2>My Cart</h2>");
                        out.println("</article>");
                        out.println("<article>");
                        if(cursor.count() == 0){
				out.println("There are no products in the cart.");
			}else{
			
				
			int cartID=0;
                        Double productId=0.0;	
			String productName = "";
			String productModel = "";
                        Double tPrice = 0.0;
                        Double quantity = 0.0;
                        Double TotalPrice=0.0;

				while (cursor.hasNext()) {
					//out.println(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
                        cartID=Integer.parseInt(obj.getString("cartID"));
                        productId=obj.getDouble("productId");
                        productName=obj.getString("productName");
                        productModel=obj.getString("productModel");
                        quantity=obj.getDouble("quantity");
                        tPrice=obj.getDouble("tPrice");
                        TotalPrice=tPrice*quantity;
			out.println(" <form method=\"get\" action='order'>");
			out.println("<fieldset>");
			//out.println("<legend>Product information:</legend>");
			out.println("<table>");

			out.println("<tr>");
			out.println("<td>Product Name: </td>");
			out.println("<td> <input type=\"text\" name=\"ProductName\" value= '"+ productName +"' readonly>"); 
			out.println("<input type=\"hidden\" name=\"cartId\" value= "+ cartID +" readonly></td>");
			out.println("</tr>");
			out.println("<td>Product Model: </td>");
                        
			out.println("<td> <input type=\"textarea\" name=\"ProductModel\" value= '"+ productModel +"' readonly> </td>");
                        out.println("<input type=\"hidden\" name=\"ProductId\" value= "+ productId +" readonly></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Quantity: </td>");
			out.println("<td> <input type=\"text\" name=\"Quantity\" value= '"+quantity+"' readonly> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Total Price: </td>");
			out.println("<td> <input type=\"text\" name=\"TotalPrice\" value= '"+ TotalPrice+"' readonly> </td>");
			out.println("</tr>");
			


						out.println("<tr>");


		
			out.println("<tr>");
				//out.println("<td>Buy </td>");
			out.println("<td> <input type=\"Submit\" name=\"Submit\" value= 'Confirm Order'> </td>");
			out.println("</tr>");
                        out.println("</table>");	
                        out.println("</form>");
                                        }}	
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