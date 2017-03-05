package myEmailSendServlet;

/**
 * Created by Daria Serebryakova on 05.03.2017.
 */




import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;






@WebServlet("/emailSendServlet")
public class EmailSendServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String username = "daria.serebryakova.test@gmail.com";
        final String password = "daria377test188";
        //Allow sending mail from applications on gmail account:
        // https://www.google.com/settings/security/lesssecureapps

        String email = (String) req.getParameter("email");
        String subject = (String) req.getParameter("subject");
        String cc = (String) req.getParameter("cc");
        String text = (String) req.getParameter("text");


        Properties props=new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            //от кого
            message.setFrom(new InternetAddress(username));
            String to = email+", "+cc;
            //кому
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, true));
            //Заголовок письма
            message.setSubject(subject);
            //Содержимое

            message.setText(text);

            //Отправляем сообщение
            Transport.send(message);

            resp.setStatus(HttpServletResponse.SC_OK);
            req.setAttribute("massage1","Congratulations, your mail sent!");
            req.getRequestDispatcher("/result.jsp").forward(req, resp);


        } catch (MessagingException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            req.setAttribute("massage1","Message error, your mail not sent!");
            req.getRequestDispatcher("/result.jsp").forward(req, resp);

            throw new RuntimeException(e);
        }

        resp.setStatus(HttpServletResponse.SC_OK);
        req.setAttribute("massage1","Congratulations, your mail sent!");
        req.getRequestDispatcher("/result.jsp").forward(req, resp);




    }




}
