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

        req.setAttribute("user", user);
        req.getRequestDispatcher("/loginResponse.jsp").forward(req, resp);

    }




}
