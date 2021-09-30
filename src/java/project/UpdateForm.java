/*
* From link on AdminRooms.java
* Form for updating room details
* Redirects to Update.java for making the changes
*/
package project;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
        String uid=request.getParameter("uid");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Admin | Update Room</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"signupstyle.css\">");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<script type=\"text/javascript\">");
            out.println("function success(){alert(\"Logged out successfully!\");}");
            out.println("function update(){var type=document.getElementById(\"type\").value;");
            out.println("var loc=document.getElementById(\"loc\").value;");
            out.println("var chg=document.getElementById(\"chg\").value;");
            out.println("var paystat=document.getElementById(\"pay\").value;");
            out.println("alert(\"You entered the following details:-\\nRoom type: \"+type");
            out.println("+\"\\nRoom location: \"+loc+\"\\nRoom charge: \"+chg");
            out.println("+\"\\nPayment Status: \"+paystat);}");
            out.println("</script>");
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
            out.println("<a href=\"admininsert.html\">");
            out.println("<span class=\"glyphicon glyphicon-plus\"></span>");
            out.println("Insert Room");
            out.println("</a>");
            out.println("</li>");
            out.println("<li class=\"active\">");
            out.println("<a href=\"AdminRooms\">");
            out.println("<span class=\"glyphicon glyphicon-th-large\"></span>");
            out.println("Manage Rooms");
            out.println("</a>");
            out.println("</li>");
            out.println("<li class=\"active\">");
            out.println("<a href=\"AdminUsers\">");
            out.println("<span class=\"glyphicon glyphicon-user\"></span>");
            out.println("View Users");
            out.println("</a>");
            out.println("</li>");
            out.println("<li class=\"active\" onclick=\"return success()\">");
            out.println("<a href=\"login.html\">");
            out.println("<span class=\"glyphicon glyphicon-log-out\"></span>");
            out.println("Logout");
            out.println("</a>");
            out.println("</li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("</nav>");
            out.println("<div id=\"bg\" class=\"bg-image\">");
            out.println("<center>");
            out.println("<div id=\"content\">");
            out.println("Update details for Room No. "+uid+"<br><br>");
            out.println("<form action=\"Update\" onsubmit=\"return update()\" method=\"GET\">");
            out.println("<div class=\"form-group\">");
            out.println("<input type=\"hidden\" class=\"form-control input-sm\" id=\"uid\" name=\"roomuid\" value=\""+uid+"\">");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<input type=\"text\" class=\"form-control input-sm\" id=\"type\" name=\"roomtype\" placeholder=\"Enter room type\" required>");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<input type=\"text\" class=\"form-control input-sm\" id=\"loc\" name=\"roomloc\" placeholder=\"Enter room location\" required>");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<input type=\"number\" class=\"form-control input-sm\" id=\"chg\" name=\"roomchg\" placeholder=\"Enter monthly room charge in Rs.\" required>");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"pay\">Select payment status</label>");
            out.println("<select class=\"form-select form-select-sm form-control\" id=\"pay\" name=\"paystatus\" required>");  
            out.println("<option value=\"Not Paid\">1. Not Paid</option>");
            out.println("<option value=\"Paid\">2. Paid</option>");
            out.println("</select>");
            out.println("</div>");
            out.println("<input type=\"submit\" value=\"Update Room\" class=\"btn btn-primary btn-xs\"><br><br>");
            out.println("</form>");
            out.println("</div>");
            out.println("</center>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
    }       
}