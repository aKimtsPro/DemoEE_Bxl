package bstorm.akimts.demoee.servlets;

import bstorm.akimts.demoee.models.Product;
import bstorm.akimts.demoee.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddProductServlet", value = "/product/add")
public class AddProductServlet extends HttpServlet {

    private final ProductService service = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/product/add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String category = request.getParameter("category");

        try {
            double price = Double.parseDouble( request.getParameter("price") );
            Product toInsert = new Product(name, brand, category, price);
            long id = service.insert(toInsert);

            response.sendRedirect(request.getContextPath()+"/product/getOne.jsp?id=" + id); // renvoi une reponse de redirection
            // request.getRequestDispatcher( "/product/getOne.jsp?id=" + id ).forward(request, response); // continue la creation de la reponse autre part
        }
        catch (NumberFormatException ex){
            request.getRequestDispatcher("/product/add.jsp" ).forward(request, response);
        }
    }
}
