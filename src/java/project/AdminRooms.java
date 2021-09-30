/*
* From Admin.java
* Shows list of rooms created
* Search rooms by ID, type, location, availability or payment status
* Update room - redirects to UpdateForm.java that has update form
* Delete room - redirects to Delete.java
*/
package project;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminRooms extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String search=request.getParameter("search");
        boolean flag=false;
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Admin | Manage Rooms</title>");
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
            out.println("<div class=\"searchbar\">");
            out.println("<form action=\"AdminRooms\" method=\"GET\">");
            out.println("<div class=\"form-group\">");
            out.println("<input type=\"submit\" value=\"View All\" class=\"btn btn-primary btn-xs\">");
            out.println("<input type=\"text\" placeholder=\"Search\" class=\"input-sm\" name=\"search\">");
            out.println("<input type=\"submit\" value=\"Search\" class=\"btn btn-warning btn-xs\">");
            out.println("</div");
            out.println("</form>");
            out.println("</div>");
            out.println("<div class=\"container\">");
        if(search==null||search=="") {
            flag=true;
            if(Insert.rooms.isEmpty()) {
                out.println("<div id=\"content\">");
                out.println("There are no rooms to show.<br>Please ");
                out.println("<a href=\"admininsert.html\">");
                out.println("insert a room");            
                out.println("</a>");
                out.println(".");
                out.println("</div>");
            }
            else {                
                out.println("<table id=\"tab\" class=\"table\">");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>Room Unique ID</th>");
                out.println("<th>Room Type</th>");
                out.println("<th>Room Location</th>");
                out.println("<th>Room Charges</th>");
                out.println("<th>Room Status</th>");
                out.println("<th>Payment Status</th>");
                out.println("<th>Update</th>");
                out.println("<th>Delete</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for(int i=0;i<Insert.rooms.size();i++) {                    
                    out.println("<tr>");
                    out.println("<td>"+Insert.rooms.get(i).roomuid+"</td>");
                    out.println("<td>"+Insert.rooms.get(i).roomtype+"</td>");
                    out.println("<td>"+Insert.rooms.get(i).roomloc+"</td>");
                    out.println("<td>"+Insert.rooms.get(i).roomchg+"</td>");
                    out.println("<td>"+Insert.rooms.get(i).roomstatus+"</td>");
                    out.println("<td>"+Insert.rooms.get(i).paystatus+"</td>");
                    out.println("<td><a href=\"UpdateForm?uid="+Insert.rooms.get(i).roomuid+"\">UPDATE</a></td>");
                    out.println("<td><a href=\"Delete?uid="+Insert.rooms.get(i).roomuid+"\">DELETE</a></td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>"); 
            }   
        }
        else {
            if(Insert.rooms.isEmpty()) {                
                out.println("<div id=\"content\">");
                out.println("There are no rooms to show.<br>Please ");
                out.println("<a href=\"admininsert.html\">");
                out.println("insert a room");            
                out.println("</a>");
                out.println(".");
                out.println("</div>");
                flag=true;
            }
            else {
                for(int i=0;i<Insert.rooms.size();i++) {                    
                    if((Insert.rooms.get(i).roomuid.equals(search))||(Insert.rooms.get(i).roomtype.equals(search))
                            ||(Insert.rooms.get(i).roomloc.equals(search))||(Insert.rooms.get(i).roomstatus.equals(search))
                            ||(Insert.rooms.get(i).paystatus.equals(search))) {
                        flag=true;
                    }
                }
                if(flag==true) {                    
                    out.println("<table id=\"tab\" class=\"table\">");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>Room Unique ID</th>");
                    out.println("<th>Room Type</th>");
                    out.println("<th>Room Location</th>");
                    out.println("<th>Room Charges</th>");
                    out.println("<th>Room Status</th>");
                    out.println("<th>Payment Status</th>");
                    out.println("<th>Update</th>");
                    out.println("<th>Delete</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");
                    for(int i=0;i<Insert.rooms.size();i++) {                        
                        if((Insert.rooms.get(i).roomuid.equals(search))||(Insert.rooms.get(i).roomtype.equals(search))
                                ||(Insert.rooms.get(i).roomloc.equals(search))||(Insert.rooms.get(i).roomstatus.equals(search))
                                ||(Insert.rooms.get(i).paystatus.equals(search))) {
                            out.println("<tr>");
                            out.println("<td>"+Insert.rooms.get(i).roomuid+"</td>");
                            out.println("<td>"+Insert.rooms.get(i).roomtype+"</td>");
                            out.println("<td>"+Insert.rooms.get(i).roomloc+"</td>");
                            out.println("<td>"+Insert.rooms.get(i).roomchg+"</td>");
                            out.println("<td>"+Insert.rooms.get(i).roomstatus+"</td>");
                            out.println("<td>"+Insert.rooms.get(i).paystatus+"</td>");
                            out.println("<td><a href=\"UpdateForm?uid="+Insert.rooms.get(i).roomuid+"\">UPDATE</a></td>");
                            out.println("<td><a href=\"Delete?uid="+Insert.rooms.get(i).roomuid+"\">DELETE</a></td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                }
            }            
        }
        if(flag==false) {            
            out.println("<div id=\"content\">");
            out.println("No relevant rooms found.");
            out.println("<a href=\"AdminRooms\">");
            out.println("<p>View all rooms.</p>");            
            out.println("</a>");
            out.println("</div>");
        }          
        out.println("</div>");
        out.println("</center>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}