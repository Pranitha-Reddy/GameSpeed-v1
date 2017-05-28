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

public class productDetails extends HttpServlet {
private static final long serialVersionUID = 1L;
protected HashMap products=new HashMap();
	public void init() throws ServletException{
      	
          }
        public void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
           Integer productNumber=1;
           productInfo pI=new productInfo();
           Iterator it= products.entrySet().iterator();
           while(it.hasNext())
           {
           productNumber++;
           }
           pI.setProductID(productNumber);
           pI.setProductCategory("XBox");
           pI.setProductName("XBox One");
           pI.setManufacturer("Microsoft");
           pI.setRetailer("Electronic Arts");
           pI.setProductSpecification("It comes with a 2 year warranty and has a memoryof 16GB can accomidate 4 players");
           pI.setCost(190);
           pI.setDiscount(89);
           pI.setRebate(0);
           products.put(productNumber,pI);
           productNumber++;
           
           pI=new productInfo();
                      pI.setProductID(productNumber);
           pI.setProductCategory("XBox");
           pI.setProductName("XBox 360");
           pI.setManufacturer("Microsoft");
           pI.setRetailer("Electronic Arts");
           pI.setProductSpecification("It comes with a 2 year warranty and has a memoryof 16GB can accomidate 4 players");
           pI.setCost(290);
           pI.setDiscount(89);
           pI.setRebate(0);
           products.put(productNumber,pI);
           productNumber++;
           pI=new productInfo();
                      pI.setProductID(productNumber);
           pI.setProductCategory("PlayStation");
           pI.setProductName("XBox 360");
           pI.setManufacturer("Microsoft");
           pI.setRetailer("Electronic Arts");
           pI.setProductSpecification("It comes with a 2 year warranty and has a memoryof 16GB can accomidate 4 players");
           pI.setCost(290);
           pI.setDiscount(89);
           pI.setRebate(0);
           products.put(productNumber,pI);
           productNumber++;
           pI=new productInfo();
                      pI.setProductID(productNumber);
           pI.setProductCategory("Wii");
           pI.setProductName("XBox 360");
           pI.setManufacturer("Microsoft");
           pI.setRetailer("Electronic Arts");
           pI.setProductSpecification("It comes with a 2 year warranty and has a memoryof 16GB can accomidate 4 players");
           pI.setCost(290);
           pI.setDiscount(89);
           pI.setRebate(0);
           products.put(productNumber,pI);
           productNumber++;




}



}