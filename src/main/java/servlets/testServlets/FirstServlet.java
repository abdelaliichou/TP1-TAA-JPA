package servlets.testServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// this class is the route that will be called when calling the /test
// and based on the type of the request (GET, POST...) a function will be called automatically

@WebServlet(
        name="test",
        urlPatterns={"/test"}
)
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        PrintWriter p = new PrintWriter(resp.getOutputStream());
        p.print("Hello ichou abdelali from doGet -> /test");
        p.flush();
        // super.doGet(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
