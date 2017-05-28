

import java.util.HashMap;
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
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

public class storeManagerLogIn extends HttpServlet {
   
    protected Map users = new HashMap();
 
    public void init() {
                users.put("test", "test");
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
         response.setContentType("text/html");
		
		       PrintWriter out = response.getWriter();
        if(userid != null && userid.length() != 0) {
            userid = userid.trim();
        }
        if(password != null && password.length() != 0) {
            password = password.trim();
        }
        if(userid != null &&
            password != null) {
                String realpassword = (String)users.get(userid);
                if(realpassword != null &&
                    realpassword.equals(password)) {
                 RequestDispatcher requestDispatcher=request.getRequestDispatcher("storeManagerHome");
                  requestDispatcher.forward(request, response);
                } else {
                              out.println("<font color='red'><b>Please enter correct username and password</b></font>");

                                     RequestDispatcher requestDispatcher=request.getRequestDispatcher("storeManagerLogIn.html");
                  requestDispatcher.forward(request, response);
                }
        }  else {
                out.println("<font color='red'><b>Please enter the username and password</b></font>");

                                     RequestDispatcher requestDispatcher=request.getRequestDispatcher("storeManagerLogIn.html");
                  requestDispatcher.forward(request, response);
        }
    } 
    
  

   
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    } 


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
}
