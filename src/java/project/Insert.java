/*
* From AdminRooms.java
* Inserts new room in ArrayList rooms if room ID is unique
* Shows message otherwise
* Redirects to AdminRooms.java
*/
package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Insert extends HttpServlet {
    
    class Room {
        String roomuid;
        String roomtype;
        String roomloc;
        String roomchg;
        String roomstatus;
        String paystatus;
    }
    
    static ArrayList<Room> rooms=new ArrayList<Room>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String uid=request.getParameter("roomuid");
        String type=request.getParameter("roomtype");
        String loc=request.getParameter("roomloc");
        String chg=request.getParameter("roomchg");
        
        boolean flag=false;
        for(int i=0;i<rooms.size();i++) {
            if(uid.equals(rooms.get(i).roomuid)) {
                flag=true;
                break;
            }
        }
        
        if(flag==true) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Insert Unsuccessful</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"signupstyle.css\">");
            out.println("<script type=\"text/javascript\">");
            out.println("function success(){alert(\"Logged out successfully!\");}");
            out.println("function insert(){var id=document.getElementById(\"uid\").value;");
            out.println("var type=document.getElementById(\"type\").value;");
            out.println("var loc=document.getElementById(\"loc\").value;");
            out.println("var chg=document.getElementById(\"chg\").value;");
            out.println("alert(\"You entered the following details:-\\nRoom ID: \"+id");
            out.println("+\"\\nRoom type: \"+type+\"\\nRoom location: \"+loc");
            out.println("+\"\\nRoom charge: \"+chg);}");
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
            out.println("Room no. "+uid+" already exists. Please ");
            out.println("<a href=\"admininsert.html\">");
            out.println("use a different ID");            
            out.println("</a>");
            out.println(".");
            out.println("</div>");
            out.println("</center>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");            
        }
        else {
            Room ob=new Room();
            ob.roomuid=uid;
            ob.roomtype=type;
            ob.roomloc=loc;
            ob.roomchg=chg; 
            ob.roomstatus="Available";
            ob.paystatus="Not Paid";
            rooms.add(ob);
            response.sendRedirect("AdminRooms");
        }
    }
}