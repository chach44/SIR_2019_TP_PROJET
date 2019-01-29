package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priseRdv.Participant;

@WebServlet(name="Participant",
urlPatterns={"/Participant"})
public class ParticipantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            
        PrintWriter p = new PrintWriter(resp.getOutputStream());
        p.print("Participant");
        p.flush();
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        
       Participant p = new Participant(req.getParameter("name"), req.getParameter("firstname"), req.getParameter("email"));
        
       PrintWriter print = new PrintWriter(resp.getOutputStream());
       print.print("Felicitation,"+p.getFirstname()+ " "+p.getName()+ " vous etes inscrit");
       print.print("Vous pouvez participer au sondage ");
       
       print.flush();
        
    }    
}

