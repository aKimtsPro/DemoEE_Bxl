package bstorm.akimts.demoee;

import bstorm.akimts.demoee.models.Product;
import bstorm.akimts.demoee.service.ProductService;
import jakarta.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// localhost:8080/{app-context}/product
// Ce qui se passe quand on fait tout dans le Servlet...
@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {

//    @EJB
    private final ProductService pService = ProductService.getInstance();

    @Override
    public void init() throws ServletException {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if( id == null )
            getAll(response);
        else
            getOne(response, Integer.parseInt(id));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    private void getAll(HttpServletResponse response) throws IOException{

        response.setContentType("text/html");

        response.setStatus(200);

        PrintWriter out = response.getWriter();
        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "  <meta charset=\"UTF-8\">\n" +
                        "  <title>Title</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\n" +
                        "  <h1>Liste des produits</h1>\n" +
                        "\n" +
                        "  <ul>\n"
        );


        for (Product product : pService.getAll()) {
            out.println(
                    "    <li>\n" +
                            "      <div>\n" +
                            "        <p><span>id: </span> " + product.getId() + " </p>\n" +
                            "        <p><span>nom: </span> " + product.getName() + " </p>\n" +
                            "        <p><span>marque: </span> " + product.getBrand() + " </p>\n" +
                            "        <p><span>categorie: </span> " + product.getCategory() + " </p>\n" +
                            "        <p><span>prix: </span> " + product.getPrice() + " $ </p>\n" +
                            "      </div>\n" +
                            "    </li>\n"
            );
        }


        out.println(
                "  </ul>\n" +
                        "\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>"
        );

    }
    private void getOne(HttpServletResponse response, int id) throws IOException {

        Product p = pService.getAll().stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);


        if( p == null ) {
            response.setStatus(404);

        }

        PrintWriter out = response.getWriter();
        out.println(
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "  <meta charset=\"UTF-8\">\n" +
            "  <title>Title</title>\n" +
            "</head>\n" +
            "<body>\n");
        out.println("<h1>Details d'un produit</h1>");
        out.println("<div>\n" +
            "  <p><span>id: </span> " + p.getId() + " </p>\n" +
            "  <p><span>nom: </span> "+ p.getName() +" </p>\n" +
            "  <p><span>marque: </span> "+p.getBrand()+" </p>\n" +
            "  <p><span>categorie: </span> "+p.getCategory()+" </p>\n" +
            "  <p><span>prix: </span> "+p.getPrice()+" $ </p>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>"
        );

    }

}
