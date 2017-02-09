package com.fetch.fbapp3.resources; 
 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.PrintWriter; 
import java.util.Scanner; 

import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.MultipartConfig; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
import javax.servlet.http.Part; 

import com.fetch.fbapp3.model.User;

import java.sql.*; 
@WebServlet(name="UploadServlet", urlPatterns={"webapi1/upload"})     // specify urlPattern for servlet 
@MultipartConfig                                               // specifies servlet takes multipart/form-data 
public class UploadServlet extends HttpServlet { 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8"); 
        PrintWriter out = response.getWriter(); 
        System.out.println("i am right here");
        User u = new User();
        Cookie[] cookies = request.getCookies();
        int ID=0;
        for (int i = 0; i < cookies.length; i++) {
          String name = cookies[i].getName();
          	if(name.equals("ID"))
          		ID=Integer.parseInt(cookies[i].getValue());
        }	
        System.out.println("valur fetched from cookie"+ID);
        try { 
            // get access to file that is uploaded from client 
            Part p1 = request.getPart("file"); 
            InputStream is = p1.getInputStream(); 
             
              // read filename from stream 
              
               
              // get filename to use on the server 
              java.io.File f=new java.io.File(this.getServletContext().getRealPath("/images/")); 
                f.mkdir(); 
              String outputfile = this.getServletContext().getRealPath("/images/"+ID+".jpg"); 
            System.out.println("OUTPUT>>>>"+outputfile);   
            //String outputfile=""; 
               FileOutputStream os = new FileOutputStream (outputfile); 
             
            // write bytes taken from uploaded file to target file 
            int ch = is.read(); 
            while (ch != -1) { 
                 os.write(ch); 
                 ch = is.read(); 
            } 
            os.close(); 
             response.sendRedirect("http://localhost:8080/fbapp3/userHome.html");
           
             
             
            //out.println("<h3>File uploaded successfully!</h3>"); 
        } 
        catch(Exception ex) { 
           out.println("Exception -->" + ex.getMessage()); 
        } 
        finally {  
            out.close(); 
        } 
    } // end of doPost() 
    }
// end of UploadServlet 