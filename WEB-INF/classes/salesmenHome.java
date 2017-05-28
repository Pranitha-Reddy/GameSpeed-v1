
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
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

public class salesmenHome extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	MongoClient mongo;
	
	public void init() throws ServletException{
      	
          mongo = new MongoClient("localhost", 27017); 
	}
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
                    DB db = mongo.getDB("Assignment");
	            DBCollection myProduct = db.getCollection("myProduct");
                    DBCursor cursor = myProduct.find();
                    Double productID=0.0;
                    Long count=myProduct.count();
                    if(count==0.0)
                    {
                         
                        /*while(cursor.hasNext())
                        { BasicDBObject obj=(BasicDBObject)cursor.next();
                          Double temp=(Double) obj.get("productID");
                          if(productID<  temp)
                           {productID=(Double) temp;
                              }
}*/                       //if(productID!=0.0)
//{
                       BasicDBObject doc = new BasicDBObject("title", "myProduct").
                                append("productID",productID+1.0).
				append("productCategory", "XBox").
				append("productName", "XBox One").
                                append("productSpecification", "Has great UI").
				append("hasWarranty", "yes").
                                append("productRetailer", "Electronic Arts").
                                append("quantity", 10).
                                append("warrantycost", 30).
                                append("price", 150).
                                append("discount", 0).
                                append("rebate", 0);
                        myProduct.insert(doc);
                         productID=1.0;
                        /*while(cursor.hasNext())
                        { BasicDBObject obj=(BasicDBObject)cursor.next();
                          Double temp=(Double) obj.get("productID");
                          if(productID<  temp)
                           {productID=(Double) temp;
                              }}*/
									
			
                       BasicDBObject doc1 = new BasicDBObject("title", "myProduct").
                                append("productID",productID+1.0).
				append("productCategory", "XBox").
				append("productName", "XBox 360").
                                append("productSpecification", "Has great UI").
				append("hasWarranty", "No").
                                append("productRetailer", "Electronic Arts").
                                append("quantity", 20).
                                append("warrantycost", 0).
                                append("price", 350).
                                append("discount", 100).
                                append("rebate", 0);
			
									
			myProduct.insert(doc1);
/*while(cursor.hasNext())
                        { BasicDBObject obj=(BasicDBObject)cursor.next();
                          Double temp=(Double) obj.get("productID");
                          if(productID<  temp)
                           {productID=(Double) temp;
                              }
}*/				productID=2.0;					
			
                       BasicDBObject doc0 = new BasicDBObject("title", "myProduct").
                                append("productID",productID+1.0).
				append("productCategory", "PlayStation").
				append("productName", "PlayStation 3").
                                append("productSpecification", "Has great UI").
				append("hasWarranty", "yes").
                                append("productRetailer", "Activision").
                                append("quantity", 5).
                                append("warrantycost", 10).
                                append("price", 200).
                                append("discount", 0).
                                append("rebate", 0);
			
									
			myProduct.insert(doc0);
/*while(cursor.hasNext())
                        { BasicDBObject obj=(BasicDBObject)cursor.next();
                          Double temp=(Double) obj.get("productID");
                          if(productID<  temp)
                           {productID=(Double) temp;
                              }}*/
									
			productID=3.0;
                       BasicDBObject doc2 = new BasicDBObject("title", "myProduct").
                                append("productID",productID+1.0).
				append("productCategory", "PlayStation").
				append("productName", "PlayStation4").
                                append("productSpecification", "Has great UI").
				append("hasWarranty", "yes").
                                append("productRetailer", "Ectivision").
                                append("quantity", 5).
                                append("warrantycost", 10).
                                append("price", 400).
                                append("discount", 0).
                                append("rebate", 50);
			
									
			myProduct.insert(doc2);
/*while(cursor.hasNext())
                        { BasicDBObject obj=(BasicDBObject)cursor.next();
                          Double temp=(Double) obj.get("productID");
                          if(productID<  temp)
                           {productID=(Double) temp;
                              }}*/
				productID=4.0;					
			
                       BasicDBObject doc3 = new BasicDBObject("title", "myProduct").
                                append("productID",productID+1.0).
				append("productCategory", "XBox").
				append("productName", "XBox One").
                                append("productSpecification", "Has great UI").
				append("hasWarranty", "yes").
                                append("productRetailer", "Electronic Arts").
                                append("quantity", 5).
                                append("warrantycost", 30).
                                append("price", 150).
                                append("discount", 0).
                                append("rebate", 0);
			
									
			myProduct.insert(doc3);
/*while(cursor.hasNext())
                        { BasicDBObject obj=(BasicDBObject)cursor.next();
                          Double temp=(Double) obj.get("productID");
                          if(productID<  temp)
                           {productID=(Double) temp;
                              }}*/
					productID=5.0;				
			
                       BasicDBObject doc4 = new BasicDBObject("title", "myProduct").
                                append("productID",productID+1.0).
				append("productCategory", "wii").
				append("productName", "wii").
                                append("productSpecification", "Has great UI").
				append("hasWarranty", "No").
                                append("productRetailer", "Take-Two Interactive").
                                append("quantity", 5).
                                append("warrantycost", 0).
                                append("price", 250).
                                append("discount", 70).
                                append("rebate", 0);
			
									
			myProduct.insert(doc4);
/*while(cursor.hasNext())
                        { BasicDBObject obj=(BasicDBObject)cursor.next();
                          Double temp=(Double) obj.get("productID");
                          if(productID<  temp)
                           {productID=(Double) temp;
                              }}*/
									
			productID=6.0;
                       BasicDBObject doc5 = new BasicDBObject("title", "myProduct").
                                append("productID",productID+1.0).
				append("productCategory", "Wii").
				append("productName", "Wii U").
                                append("productSpecification", "Has great UI").
				append("hasWarranty", "No").
                                append("productRetailer", "Take-Two Interactive").
                                append("quantity", 5).
                                append("warrantycost", 0).
                                append("price", 300).
                                append("discount", 0).
                                append("rebate", 0);
			
									
			myProduct.insert(doc5);}
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
                        out.println("<p> Salesmen Operations</p>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<a href='XBox'>Create customer accounts</a>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<a href=''>Add a customer order</a>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<a href=''>Delete a customer order</a>");
                        out.println("</article>");
                        out.println("<article>");
                        out.println("<a href=''>Update a customer order</a>");
                        out.println("</article>");
                        out.println("</section>");
                        out.println("<aside class='sidebar'>");
                        out.println("<ul>");
                        out.println("<li>");
                        out.println("<h4> Games </h4>");
			out.println("<ul>");
			out.println("<li><a href=''>XBox</a></li>");
                        out.println("<li><a href=''>PlayStation</a></li>");
                        out.println("<li><a href=''>Wii</a></li>");
                        out.println("<li><a href=''>Accessories</a></li>");
			out.println("</ul>");
                        out.println("</li>");
                        out.println("<li>");
                        out.println("<h4>Manufactureres</h4>");
                        out.println("<ul>");
                        out.println("<li><a href=''>Microsoft</a></li>");
                        out.println("<li><a href=''>Sony</a></li>");
                        out.println("<li><a href=''>Niventendo</a></li>");
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