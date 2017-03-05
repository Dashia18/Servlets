package myLoginServlet;

/**
 * Created by Daria Serebryakova on 03.03.2017.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String user = (String) req.getParameter("login");
        String password = (String) req.getParameter("password");

        final String guestLogin= "Guest";
        final String correctPwdGuest = "1579";

            if(user.equals(guestLogin)){
                //(2) Validation: if user == "Guest" and password == "1579"
                if(password.equals(correctPwdGuest)){
                    resp.setStatus(HttpServletResponse.SC_OK);
                    req.setAttribute("massage1","Congratulations, "+ user + ", you login!");
                    req.getRequestDispatcher("/result.jsp").forward(req, resp);
                }
                else
                {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    req.setAttribute("massage1", user+", password is not correct! ");
                    req.getRequestDispatcher("/result.jsp").forward(req, resp);
                }
            }
            else {
                //(1) No validation: if user == any and password == any
                resp.setStatus(HttpServletResponse.SC_OK);
                req.setAttribute("massage1","Congratulations, "+ user + ", you login!");
                req.getRequestDispatcher("/result.jsp").forward(req, resp);
            }

        }




}
