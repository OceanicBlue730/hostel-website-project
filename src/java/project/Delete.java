/*
* From link on AdminRooms.java
* Removes the room from ArrayList rooms
* Redirects to AdminRooms.java
*/
package project;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uid=request.getParameter("uid");
        for(int i=0;i<Insert.rooms.size();i++) {
            if(Insert.rooms.get(i).roomuid.equals(uid)) {
                Insert.rooms.remove(i);
                break;
            }
        }
        for(int i=0;i<SignUp.students.size();i++) {
            for(int j=0;i<SignUp.students.get(i).roomuids.size();i++) {
                if(SignUp.students.get(i).roomuids.get(j).equals(uid)) {
                    SignUp.students.get(i).roomuids.remove(j);
                    break;
                }
            }
        }
        
        response.sendRedirect("AdminRooms");
    }
}