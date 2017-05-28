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


public class addToCart extends HttpServlet {
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
                      try{  int cartID=0;
                        Double temp=0.0;
                        Double Price=0.0;
                        Double Discount=0.0;
                        Double rebate=0.0;
                        Double warrantyCost=0.0;
                        Double totalPrice=0.0;
                        Double searchParameter=Double.parseDouble(request.getParameter("ProductId"));
                        String searchField = "productID";
			String productName=request.getParameter("ProductName");
                        String productCategory=request.getParameter("ProductCategory");
                        Double quantity=Double.parseDouble(request.getParameter("quantity"));
                        Double tPrice=Double.parseDouble(request.getParameter("Total Price"));
                        DB db = mongo.getDB("Assignment");
                       /* DBCollection myProducts = db.getCollection("myProducts");
                        BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put(searchField, searchParameter);

			DBCursor curs = myProducts.find(searchQuery);
			
		        //String searchField = "productID";

			
                        if(curs.count()==0)
                         {out.println("Input is not Proper");}
                         else
                         {
                          while(curs.hasNext())
                          {
                           BasicDBObject obj = (BasicDBObject) curs.next();
                           Price=obj.getDouble("price");
                           Discount=obj.getDouble("discount");
                           rebate=obj.getDouble("rebate");
                           warrantyCost=obj.getDouble("warrantycost");
                           //temp=(Discount+rebate);
                           //totalPrice=(Price+warrantyCost-temp);
                          }
                          }*/
                         
                        totalPrice=(tPrice*quantity);
			System.out.println("Collection myReviews selected successfully");
			DBCollection myCart = db.getCollection("myCart");
	                DBCursor cursor = myCart.find();
                        cartID=cursor.count();
                        String userID= request.getSession().getAttribute("userId").toString();	
			BasicDBObject doc1 = new BasicDBObject("title", "myCart").
                                append("cartID", cartID+1).
				append("productName", productName).
				append("productModel", productCategory).
                                append("userID", userID).
                                append("productId", searchParameter).
				append("quantity", quantity).
				append("tPrice", totalPrice);
									
			myCart.insert(doc1);
				
			System.out.println("Document inserted successfully");

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
                        out.println("<p> Product has been added to cart successfull</p>");
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