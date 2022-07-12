package bstorm.akimts.demoee;

import com.mysql.cj.jdbc.Driver;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.Persistence;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
        System.out.println("Le servlet est créé");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        response.setStatus(200);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
        System.out.println("Le servlet est détruit");
    }
}