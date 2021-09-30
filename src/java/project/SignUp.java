/*
* From sign up page - signup.html
* Form for entering new student user details
* Inserts new student in ArrayList students if email ID is unique
* Shows message otherwise
* Link to got to login page (login.html)
*/
package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {

    class Student {
        String name;
        String phone;
        String email;
        String password;
        ArrayList<String> roomuids=new ArrayList<String>();
    }
    
    static ArrayList<Student> students=new ArrayList<Student>();
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String n=request.getParameter("fullname");
        String p=request.getParameter("phoneno");
        String e=request.getParameter("emailid");
        String pw=request.getParameter("password");              
        
        boolean flag=false;
        for(int i=0;i<students.size();i++) {
            if(students.get(i).email.equals(e)) {
                flag=true;
                break;
            }
        }
        if(flag==true) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Signup Unsuccessful</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"signupstyle.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-inverse navbar-fixed-top\">");
            out.println("<div class=\"container-fluid\">");            
            out.println("<div class=\"navbar-header\">");
            out.println("<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar\">");
            out.println("<span class=\"glyphicon glyphicon-menu-hamburger\"></span>");
            out.println("</button>");
            out.println("<a href=\"index.html\" class=\"navbar-brand\">Four Towers Hostel</a>");
            out.println("</div>");
            out.println("<div class=\"collapse navbar-collapse\" id=\"navbar\">");
            out.println("<ul class=\"nav navbar-nav navbar-right\">");
            out.println("<li class=\"active\">");
            out.println("<a href=\"login.html\">");
            out.println("<span class=\"glyphicon glyphicon-log-in\"></span>");
            out.println("Login");
            out.println("</a>");
            out.println("</li>");
            out.println("<li class=\"active\">");
            out.println("<a href=\"signup.html\">");
            out.println("<span class=\"glyphicon glyphicon-user\"></span>");
            out.println("Sign Up");
            out.println("</a>");
            out.println("</li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("</nav>");
            out.println("<div id=\"bg\" class=\"bg-image\">");        
            out.println("<center>");
            out.println("<div id=\"content\">");
            out.println("You have already signed up. Please ");
            out.println("<a href=\"login.html\">");
            out.println("login.");            
            out.println("</a>");
            out.println("</div>");
            out.println("</center>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        else {
            Student ob=new Student();
            ob.name=n;
            ob.phone=p;
            ob.email=e;
            ob.password=pw; 
            students.add(ob);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Signup Successful</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"signupstyle.css\">");           
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-inverse navbar-fixed-top\">");
            out.println("<div class=\"container-fluid\">");            
            out.println("<div class=\"navbar-header\">");
            out.println("<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar\">");
            out.println("<span class=\"glyphicon glyphicon-menu-hamburger\"></span>");
            out.println("</button>");
            out.println("<a href=\"index.html\" class=\"navbar-brand\">Four Towers Hostel</a>");
            out.println("</div>");
            out.println("<div class=\"collapse navbar-collapse\" id=\"navbar\">");
            out.println("<ul class=\"nav navbar-nav navbar-right\">");
            out.println("<li class=\"active\">");
            out.println("<a href=\"login.html\">");
            out.println("<span class=\"glyphicon glyphicon-log-in\"></span>");
            out.println("Login");
            out.println("</a>");
            out.println("</li>");
            out.println("<li class=\"active\">");
            out.println("<a href=\"signup.html\">");
            out.println("<span class=\"glyphicon glyphicon-user\"></span>");
            out.println("Sign Up");
            out.println("</a>");
            out.println("</li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("</nav>");
            out.println("<div id=\"bg\" class=\"bg-image\">");        
            out.println("<center>");
            out.println("<div id=\"content\">");
            out.println("Signed up successfully! Please ");
            out.println("<a href=\"login.html\">");
            out.println("login.");            
            out.println("</a>");
            out.println("</div>");
            out.println("</center>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }    
    }
}