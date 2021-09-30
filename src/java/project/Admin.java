/*
* From admin side of login page - login.html
* Matches email and password
* Redirects to AdminRooms.java to show existing rooms if matched
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

public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String e=request.getParameter("email");
        String pw=request.getParameter("password");
        
        if((e.equals("fourtowers@gmail.com"))&&(pw.equals("4towers"))) {
            response.sendRedirect("AdminRooms");       
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
                    out.println("Incorrect email ID or password. Please try again.");
                    out.println("<a href=\"login.html\">");
                    out.println("<p>Login.</p>");            
                    out.println("</a>");
                    out.println("</div>");
                    out.println("</center>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }