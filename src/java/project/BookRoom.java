/*
* From CheckIn.java
* Inserts room UID into ArrayList roomuids of ArrayList students if there are no rooms of the same type
* Else links to check in page (CheckIn.java, to check in to another room) 
  and students' rooms(StudentRooms.java, to check out from previous)
* Changes availability to 'Not Available' in ArrayList rooms if inserted and redirects to - StudentRooms.java
*/
package project;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BookRoom extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();  
        String email=request.getParameter("email");
        String roomuid=request.getParameter("roomuid");
        String type="";
        
        for(int i=0;i<Insert.rooms.size();i++) {
            if(Insert.rooms.get(i).roomuid.equals(roomuid)) {//accessing room type
               type=Insert.rooms.get(i).roomtype;
            }
        }
        
        boolean flag=false;
        for(int i=0;i<SignUp.students.size();i++) {
            if(SignUp.students.get(i).email.equals(email)) {
                for(int j=0;j<SignUp.students.get(i).roomuids.size();j++) {
                    for(int k=0;k<Insert.rooms.size();k++) {
                        if(Insert.rooms.get(k).roomuid.equals(SignUp.students.get(i).roomuids.get(j))) {
                            if(Insert.rooms.get(k).roomtype.equals(type)) {
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Check In Unsuccessful</title>");
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
                                out.println("<div id=\"content\">");
                                out.println("You have already checked into a room of the same type.");
                                out.println("<a href=\"CheckIn?email="+email+"\">");
                                out.println("<p>Check in to a different type of room.</p>");            
                                out.println("</a>");
                                out.println("<p>OR</p>");
                                out.println("<a href=\"StudentRooms?email="+email+"\">");
                                out.println("<p>Check out from the previous room.</p>");
                                out.println("</a>");
                                out.println("</div>");
                                out.println("</center>");
                                out.println("</div>");
                                out.println("</body>");
                                out.println("</html>");
                                flag=true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        if(flag==false) {
            for(int i=0;i<SignUp.students.size();i++) {
                if(SignUp.students.get(i).email.equals(email)) {
                    SignUp.students.get(i).roomuids.add(roomuid);                    
                }
            }
            for(int i=0;i<Insert.rooms.size();i++) {
                if(Insert.rooms.get(i).roomuid.equals(roomuid)) {
                    Insert.rooms.get(i).roomstatus="Not Available";                    
                }
            }
            response.sendRedirect("StudentRooms?email="+email);
        }
    }
}