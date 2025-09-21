package servlets.testServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(
        name="userinfo",
        urlPatterns={"/UserInfo"}
)
public class UserInfo extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println(
            "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<meta charset='UTF-8'>" +
            "<title>Récapitulatif</title>" +
            "<link rel='stylesheet' type='text/css' href='userInfo.css'>" +
            "</head>" +
            "<body>" +
            "<div class='container'>" +
            "<div class='logo-container'><img src='istic.png' alt='Logo'></div>" +
            "<ul>" +
            "<li><strong>Nom :</strong> " + req.getParameter("name") + "</li>" +
            "<li><strong>Prénom :</strong> " + req.getParameter("firstname") + "</li>" +
            "<li><strong>Âge :</strong> " + req.getParameter("age") + "</li>" +
            "</ul>" +
            "</div>" +
            "</body></html>"
        );
    }
}
