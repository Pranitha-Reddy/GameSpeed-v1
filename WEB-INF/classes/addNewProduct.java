import javax.servlet.RequestDispatcher;
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

public class addNewProduct extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	MongoClient mongo;
	
	public void init() throws ServletException{
      	
          mongo = new MongoClient("localhost", 27017); 
	}
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
                    DB db = mongo.getDB("Assignment");
	            DBCollection myProduct = db.getCollection("myProduct");
                    String productName=request.getParameter("ProductName");
                    String productCategory=request.getParameter("ProductCategory");
                    String productSpecification=request.getParameter("productSpecification");
                    //String hasWarranty=request.getParameter("productSpecification");
                    String Retailer=request.getParameter("Retailer");
                    String Manufacturer=request.getParameter("Manufacturer");
                    String hasWarranty=request.getParameter("hasWarranty");
                    Double quantity=Double.parseDouble(request.getParameter("quantity"));
                    Double warrantyCost=Double.parseDouble(request.getParameter("warrantyCost"));
                    Double price=Double.parseDouble(request.getParameter("Price"));
                    Double discount=Double.parseDouble(request.getParameter("discount"));
                    Double rebate=Double.parseDouble(request.getParameter("rebate"));
                    DBCursor cursor = myProduct.find();
                    Double productID=0.0;
                    Long count=myProduct.count();

                         
                        while(cursor.hasNext())
                        { BasicDBObject obj=(BasicDBObject)cursor.next();
                          Double temp=(Double) obj.get("productID");
                          if(productID<  temp)
                           {productID=(Double) temp;
                              }

                       BasicDBObject doc = new BasicDBObject("title", "myProduct").
                                append("productID",productID+1.0).
				append("productCategory", productCategory).
				append("productName", productName).
                                append("productSpecification", productSpecification).
				append("hasWarranty", hasWarranty).
                                append("productRetailer", Retailer).
                                append("quantity", quantity).
                                append("warrantycost", warrantyCost).
                                append("price", price).
                                append("discount", discount).
                                append("rebate",rebate);
                        myProduct.insert(doc);
                         }

									
					
			
                     
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
                        out.println("<li class='start selected'><a href=''>Home</a></li>");
                        
                        out.println("<li class=''><a href=''>XBox</a></li>");
                        out.println("<li class=''><a href=''>Playstation</a></li>");
                        out.println("<li class=''><a href=''>Wii</a></li>");
                        out.println("<li class=''><a href=''>Accessories</a></li>");
                        
                        out.println("<li class=''><a href='logOut'>LogOut</a></li>");
                        out.println("</ul>");
                        out.println("</nav>");
                        out.println("<img class='header-image' src='images/home.jpg' width = '100%' height = '100%' alt='Index Page Image'/>");
			out.println("<div id='body'>");
			out.println("<section id='content'>");
                        out.println("<article>");
                        out.println("<p> </p>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<h2>Product has been sucessfully added</h2>");
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


/*String doctype= "<!doctype html>";


out.println(doctype+
            "<html>\n"+

             "<head>\n"+
	"<meta http-equiv=\"Content-Type\" content="text/html; charset=utf-8" />\n"+
	"<title> Game Zone </title>\n"+
	"<link rel="stylesheet" href="styles.css" type="text/css" />\n"+ 
        "
</head>\n"+

         "<body>\n"+
         "<div id=\"container\">\n"+
         "<header>\n"+
    	"<h1><a href=\"/\">CSP 595<span>Tutorial 2</span></a></h1>\n"+
    "</header>\n"+
    "<nav>\n"+
    	"<ul>\n"+
        	"<li class=\"start selected\"><a href="index.html">Home</a></li>\n"
            <li class=""><a href="XBox.html">XBox</a></li>
            <li class=""><a href="PlayStation.html">Play Station</a></li>
            <li class="end"><a href="#">Accessories</a></li>
        </ul>
    </nav>

	<img class="header-image" src="images/img_index1.jpg" width = "100%" height = "100%" alt="Index Page Image" />

    <div id="body">		

	<section id="content">

	    <article>
			
			<h2>Welcome to CSP 595 Store</h2>
			
            <p>This is a sample tempate using CSS3 &amp; HTML5 to demonstrate the structure of an enterprise web page.</p>	
            
            <p>This is the section to give an introduction to your web page.</p>
			
		</article>
	
		<article class="expanded">

            <h2>Secondary Section</h2>
						
            <p>This is the secondary where in you can put more information. This is not really mandatory</p>

			<h3>Learn More on HTML and CSS</h3>

			<p>Click on the links on your left under the section 'Helpful links' to learn more on HTML and CSS</p>
			<p>You can also click on the buttons below for references on HTML and CSS</p>
			
			<br><br>

			<a href="http://www.w3schools.com/html/default.asp" class="button">HTML</a>
			<a href="http://www.w3schools.com/css/default.asp" class="button">CSS</a>
			<br><br>
			<br>
			
		</article>
    </section>
        
    <aside class="sidebar">
	
            <ul>	
               <li>
                    <h4>Products</h4>
                    <ul>
                        <li><a href="XBox.html">XBox</a></li>
                        <li><a href="PlayStation.html">Play Station</a></li>
                        <li><a href="#">Accessories</a></li>
                    
                    </ul>
                </li>
                
                <li>
                    <h4>About us</h4>
                    <ul>
                        <li class="text">
                        	<p style="margin: 0;">This is a sample website created to demonstrate a standard enterprise web page.</p>
                        </li>
                    </ul>
                </li>
                
                <li>
                	<h4>Search site</h4>
                    <ul>
                    	<li class="text">
                            <form method="get" class="searchform" action="#" >
                                <p>
                                    <input type="text" size="25" value="" name="s" class="s" />
                                    
                                </p>
                            </form>	
						</li>
					</ul>
                </li>
                
                <li>
                    <h4>Helpful Links</h4>
                    <ul>
                        <li><a href="http://www.w3schools.com/html/default.asp" title="premium templates">Learn HTML here</a></li>
                        <li><a href="http://www.w3schools.com/css/default.asp" title="web hosting">Learn CSS here</a></li>
                        
                    </ul>
                </li>
                
            </ul>
		
    </aside>
    
	<div class="clear"></div>
	</div>
    
	<footer>
	
        <div class="footer-content">
            <ul>
            	<li><h4>Dummy Link Section 1</h4></li>
                <li><a href="#">Dummy Link 1</a></li>
                <li><a href="#">Dummy Link 2</a></li>
                <li><a href="#">Dummy Link  3</a></li>
			</ul>
           
        <div class="clear"></div>
        </div>
		
        <div class="footer-bottom">
            <p>CSP 595 - Enterprise Web Application - Tutorial 2</p>
        </div>
		
    </footer>
</div>

</body>

</html>*/
}catch (MongoException e) {
				e.printStackTrace();
		}
}
}