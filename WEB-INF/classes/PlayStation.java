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
import java.util.*;
import java.util.List;
import java.util.Set;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

public class PlayStation extends HttpServlet {
private static final long serialVersionUID = 1L;
MongoClient mongo;
//protected HashMap prod=new HashMap();
	public void init() throws ServletException{
      	mongo = new MongoClient("localhost", 27017);
          }
/*public void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {}*/
        public void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
                //response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
						
		try{
			

		      /* HashMap products = (HashMap)request.getSession().getAttribute("products");
			for(int i=1;i<=products.size();i++)
        			{     
			  productInfo prod=(productInfo)products.get(i);
		
			if (request.getParameter(String.valueOf(prod.getProductID()))!=null){
			
			String productCategory=prod.getProductCategory();
                        if (productCategory.equals("XBox"))
                        {                       
                        Integer productID=prod.getProductID();
                        String productName=prod.getProductName();
                        String productManufacturer=prod.getManufacturer();
                        String Retailer=prod.getRetailer();
			
                        String ProductSpecification=prod.getProductSpecification();
                         Double Cost=prod.getCost(); 		
			 Double Rebates=prod.getRebate();
			Double Discounts=prod.getDiscount();
                        //response.setContentType("text/html");
//PrintWriter out = response.getWriter();*/ 
                    DB db = mongo.getDB("Assignment");
	            DBCollection myProduct = db.getCollection("myProduct");
                    DBCursor cursor = myProduct.find();
                         out.println("<!doctype html>");
		         out.println("<html>");
			out.println("<head>");
                        //out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	                out.println("<title>PlayStation</title>");
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
                        out.println("<li class='start selected'><a href='PlayStation'>Playstation</a></li>");
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
                        out.println("<h2>Models in PlayStation</h2>");
                        out.println("</article>");
                        
                        
			if(cursor.count() == 0){
				out.println("<p>There are no Models for this product.</p>");
			}else{
			        Long count=myProduct.count();
				Double productID=0.0;
				String productCategory="PlayStation";
				String productName = "";
				String productSpecification = "";
				String hasWarranty = "";
				Double warrantycost = 0.0;
				String productRetailer = "";
                                Double quantity=0.0;
                                Double price = 0.0;
                                Double discount = 0.0;
                                Double rebate = 0.0;
				
				for(Long i=count;i>0.0;i--) {
					//out.println(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
                                        if(obj.getString("productCategory").equals(productCategory)){
                                        out.println("<article class='expanded'>");
                                        out.println("<table>");
                                        out.println("<tr>");
				        //out.println("<td> Product Name: </td>");
					productName = obj.getString("productName");
                                        productSpecification=obj.getString("productSpecification");
                                        hasWarranty = obj.getString("hasWarranty");
                                        productRetailer=obj.getString("Retailer");
                                        warrantycost = obj.getDouble("warrantycost");
                                        quantity=obj.getDouble("quantity");
                                        price = obj.getDouble("price");
                                        discount = obj.getDouble("discount");
                                        rebate = obj.getDouble("rebate");
                                        productID=obj.getDouble("productID");
                                        //productName = obj.getString("productName");
			out.println("<article>");					//out.println("<tr>");
			out.println(" <form method=\"get\" action='Buy'>");
			out.println("<fieldset>");
			out.println("<legend>Product information:</legend>");
			out.println("<table>");

			out.println("<tr>");
			out.println("<td>Product Name: </td>");
			out.println("<td> <input type=\"text\" name=\"ProductName\" value= '"+ productName +"' readonly>"); 
			out.println("<input type=\"hidden\" name=\"ProductId\" value= "+ productID +" readonly></td>");
			out.println("</tr>");
			out.println("<td>Product Desc: </td>");
                        
			out.println("<td> <input type=\"textarea\" name=\"ProductDesc\" value= '"+ productSpecification +"' readonly> </td>");
                        out.println("<input type=\"hidden\" name=\"ProductCategory\" value= "+ productCategory +" readonly></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Manufacturer: </td>");
			out.println("<td> <input type=\"text\" name=\"Manufacturer\" value= \"Sony\" readonly> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Retailer: </td>");
			out.println("<td> <input type=\"text\" name=\"Retailer\" value= '"+ productRetailer+"' readonly> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Warranty: </td>");
			out.println("<td> <input type=\"text\" name=\"Warranty\" value= '"+ hasWarranty +"' readonly> </td>");
			out.println("</tr>");
			if(hasWarranty=="Yes")
			{			


			out.println("<tr>");
			out.println("<td>WarrantyCost: </td>");
			out.println("<td> <input type=\"text\" name=\"WarrantyCost\" value= "+warrantycost+" readonly> </td>");
			out.println("</tr>");
			

			}
                        			out.println("<tr>");
			out.println("<td>Quantity: </td>");
			
			out.println("<td> <input type=\"text\" name=\"Quantity\" value="+quantity+"> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Product Price: </td>");
			out.println("<td> <input type=\"text\" name=\"Price\" value= "+ price +" readonly> </td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Discounts: </td>");
			out.println("<td> <input type=\"text\" name=\"Discounts\" value= "+discount+" readonly> </td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Rebates: </td>");
			out.println("<td> <input type=\"text\" name=\"Rebates\" value= "+rebate+" readonly> </td>");
			out.println("</tr>");


						


		
			out.println("<tr>");
			out.println("<form class = 'submit-button' method = 'get' action = ''>");
			out.println("<td> <input class = 'submit-button' type = 'submit' name = 'Buy' value = 'Buy'> </td>");
                        out.println("</form>");
			out.println("</tr>");
                        out.println("<tr>");
			out.println("<form class = 'submit-button' method = 'get' action = 'writeReview'>");
			out.println("<td> <input class = 'submit-button' type = 'submit' name = 'writeReview' value = 'write Review'> </td>");
                        out.println("</form>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<form class = 'submit-button' method = 'get' action = 'viewReview'>");
			out.println("<td> <input class = 'submit-button' type = 'submit' name = 'view Review' value = 'view Review'> </td>");
                        out.println("</form>");
			out.println("</tr>");
                        out.println("</form>");
			 out.println("</table>");
                        out.println("</article>");



                        
}}}
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
                        
                        }	
			
			catch (MongoException e) {
			e.printStackTrace();
		}
}


   

}
