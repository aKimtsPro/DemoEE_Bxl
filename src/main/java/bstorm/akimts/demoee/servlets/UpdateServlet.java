package bstorm.akimts.demoee.servlets;

import bstorm.akimts.demoee.models.Product;
import bstorm.akimts.demoee.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/product/update")
public class UpdateServlet extends HttpServlet {

    private final ProductService service = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = 0;
        try {
            id = Integer.parseInt( request.getParameter("id") );
        }
        catch (NumberFormatException ex){
            response.sendError(400, "id invalide");
        }

        Product p = service.getOne(id);

        request.setAttribute("product", p);

        request.getRequestDispatcher("/product/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Product p = new Product();

        String name = request.getParameter("name");
        p.setName(name);
        String brand = request.getParameter("brand");
        p.setBrand(brand);
        String category = request.getParameter("category");
        p.setCategory(category);

        double price = 0;
        long id = 0;
        try {
            id = Long.parseLong(request.getParameter("id"));
            p.setId(id);
            price = Double.parseDouble(request.getParameter("price"));
            p.setPrice(price);

            service.update( p );

            response.sendRedirect(request.getContextPath()+"/product/getOne.jsp?id=" + id );

        }
        catch (NumberFormatException ex){
            if( p.getId() != 0 ){
                request.setAttribute("error", "les données entrées sont invalides");
                request.setAttribute("product", p);
                request.getRequestDispatcher("/product/update.jsp").forward(request,response);
            }
            else{
                response.sendError(400, "ID invalide");
            }
        }
    }
}
