/*
* From student side of login page - login.html
* Matches email and password with records in ArrayList students
* Redirects to StudentRooms.java to show rooms checked into if matched
* Shows message if not matched
* Link to login page (login.html)
*/
package project;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
    
        String e=request.getParameter("email");
        String pw=request.getParameter("password");
        
        boolean flag=false;
        for(int i=0;i<SignUp.students.size();i++) {
            if(e.equals(SignUp.students.get(i).email)) {
                if(pw.equals(SignUp.students.get(i).password)) {
                    response.sendRedirect("StudentRooms?email="+e); 
                }
                else {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Login Unsuccessful</title>");
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
                    out.println("The password you entered is incorrect. Please try again.");
                    out.println("<a href=\"login.html\">");
                    out.println("<p>Login.</p>");            
                    out.println("</a>");
                    out.println("</div>");
                    out.println("</center>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }
                flag=true;
                break;
            }
        }        
        if(flag==false) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Unsuccessful</title>");
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
            out.println("You are not registered. Please ");
            out.println("<a href=\"signup.html\">");
            out.println("sign up");
            out.println("</a>");
            out.println(".");
            out.println("</div>");
            out.println("</center>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}