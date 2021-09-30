/*
* From UpdateForm.java
* Makes necessary changes to room, as obtained from update form
* Redirects to AdminRooms.java
*/
package project;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
        String uid=request.getParameter("roomuid");
        String type=request.getParameter("roomtype");
        String loc=request.getParameter("roomloc");
        String chg=request.getParameter("roomchg");
        String pay=request.getParameter("paystatus");
        
        for(int i=0;i<Insert.rooms.size();i++) {
            if(Insert.rooms.get(i).roomuid.equals(uid)) {
                Insert.rooms.get(i).roomtype=type;
                Insert.rooms.get(i).roomloc=loc;
                Insert.rooms.get(i).roomchg=chg;
                Insert.rooms.get(i).paystatus=pay;
                break;
            }
        }
        
        response.sendRedirect("AdminRooms");
    }
}