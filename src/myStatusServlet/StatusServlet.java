package myStatusServlet;

/**
 * Created by Daria Serebryakova on 03.03.2017.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


@WebServlet("/statusServlet")
public class StatusServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doGet(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {



        String userAgent = req.getHeader("User-Agent");
        Date Msg_time = new Date();

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm");
        df.setTimeZone(TimeZone.getTimeZone("GMT+03"));
        String formattedDate = df.format(Msg_time);

        resp.setStatus(HttpServletResponse.SC_OK);
        req.setAttribute("massage1","Date and time now:  " + formattedDate );
        req.setAttribute("massage2","Your browser is:  " +userAgent);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);



    }
}
