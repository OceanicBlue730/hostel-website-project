/*
* From link on StudentRooms.java
* Removes the room from ArrayList roomuids in ArrayList students
* Changes availability to 'Available' in ArrayList rooms
* Redirects to - StudentRooms.java
*/
package project;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckOut extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email=request.getParameter("email");
        String roomuid=request.getParameter("roomuid");
        
        for(int i=0;i<SignUp.students.size();i++) {
            if(SignUp.students.get(i).roomuids.contains(roomuid)) {
                SignUp.students.get(i).roomuids.remove(roomuid);
                break;
            }
        }
        for(int i=0;i<Insert.rooms.size();i++) {
            if(Insert.rooms.get(i).roomuid.equals(roomuid)) {
                Insert.rooms.get(i).roomstatus="Available";
            }
        }
        
        response.sendRedirect("StudentRooms?email="+email+"");
    }
}