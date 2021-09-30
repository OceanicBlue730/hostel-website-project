/*
* From navbar
* Shows list of users and the rooms they have checked into
*/
package project;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Admin | View Users</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"adminstyle.css\">");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<script type=\"text/javascript\">");
            out.println("function success(){alert(\"Logged out successfully!\");}");
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
            out.println("<li class=\"active\">");
            out.println("<a href=\"login.html\" onclick=\"return success()\">");
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
            if(SignUp.students.isEmpty()) {
                out.println("<div id=\"content\">");
                out.println("There are no students registered.");
                out.println("</div>");
            }
            else {
                out.println("<div class=\"container\">");
                out.println("<table id=\"tab\" class=\"table\">");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>Full Name</th>");
                out.println("<th>Phone No.</th>");
                out.println("<th>Email ID</th>");
                out.println("<th>Rooms Checked Into</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for(int i=0;i<SignUp.students.size();i++) {
                    out.println("<tr>");
                    out.println("<td>"+SignUp.students.get(i).name+"</td>");
                    out.println("<td>"+SignUp.students.get(i).phone+"</td>");
                    out.println("<td>"+SignUp.students.get(i).email+"</td>");
                    if(SignUp.students.get(i).roomuids.isEmpty()) {
                        out.println("<td>None</td>");
                    }
                    else {
                        out.println("<td>");
                        for(int j=0;j<SignUp.students.get(i).roomuids.size();j++) {
                            out.println(SignUp.students.get(i).roomuids.get(j)+"  ");
                        }
                        out.println("</td>");
                    }
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");
            }
        out.println("</center>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}