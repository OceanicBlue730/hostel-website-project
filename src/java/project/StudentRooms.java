/*
* From Login.java
* Shows list of rooms checked into
* Link to check in page (that is rendered by CheckIn.java) if checked into no rooms
* Check Out - check out from room, redirects to CheckOut.java
*/
package project;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentRooms extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String email=request.getParameter("email");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome | Manage Rooms</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"studentstyle.css\">");
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
            out.println("<a href=\"CheckIn?email="+email+"\">");
            out.println("<span class=\"glyphicon glyphicon-check\"></span>");
            out.println("Check In");
            out.println("</a>");
            out.println("</li>");
            out.println("<li class=\"active\">");
            out.println("<a href=\"StudentRooms?email="+email+"\">");
            out.println("<span class=\"glyphicon glyphicon-th-large\"></span>");
            out.println("Manage Rooms");
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
        for(int i=0;i<SignUp.students.size();i++) {
            if(SignUp.students.get(i).email.equals(email)) {
                if(SignUp.students.get(i).roomuids.isEmpty()) {
                    out.println("<div id=\"content\">");
                    out.println("You have not checked in to any room.");
                    out.println("<a href=\"CheckIn?email="+email+"\">");
                    out.println("<p>Check in.</p>");            
                    out.println("</a>");
                    out.println("</div>");
                    break;
                }
                else {
                    out.println("<div class=\"container\">");
                    out.println("<table id=\"tab\" class=\"table\">");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>Room Unique ID</th>");
                    out.println("<th>Room Type</th>");
                    out.println("<th>Room Location</th>");
                    out.println("<th>Room Charges</th>");
                    out.println("<th>Payment Status</th>");
                    out.println("<th>Check Out</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");
                    for(int j=0;j<SignUp.students.get(i).roomuids.size();j++) {
                        for(int k=0;k<Insert.rooms.size();k++) {
                            if(SignUp.students.get(i).roomuids.get(j).equals(Insert.rooms.get(k).roomuid)) {
                                out.println("<tr>");
                                out.println("<td>"+SignUp.students.get(i).roomuids.get(j)+"</td>");
                                out.println("<td>"+Insert.rooms.get(k).roomtype+"</td>");
                                out.println("<td>"+Insert.rooms.get(k).roomloc+"</td>");
                                out.println("<td>"+Insert.rooms.get(k).roomchg+"</td>");
                                out.println("<td>"+Insert.rooms.get(k).paystatus+"</td>");
                                out.println("<td><a href=\"CheckOut?roomuid="+SignUp.students.get(i).roomuids.get(j)+"&email="+email+"\">CHECK OUT</a></td>");
                                out.println("</tr>");
                            }
                        }
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                    out.println("</div>");
                }
            }
        }
        out.println("</center>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}