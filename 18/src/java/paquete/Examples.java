package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Examples extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int val = Integer.parseInt(request.getParameter("val"));
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejemplos</title>");            
            out.println("</head>");
            out.println("<body>");
            switch(val){
                case 1: out.println("<button type='button' onclick='location.href=\"index.html\"'>XXX</button>");break;
                case 2: out.println("<table border='1'><caption>Dígitos Binarios</caption><tr><th>0</th><th>1</th></tr><tr><td>1</td><td>0</td></tr></table>");break;
                case 3: out.println("<img src='generic.jpg'style='width:150px;height:150px;'/><p><cite>Genérico</cite></p> por Anónimo<p><a href='index.html'>atrás</a></p>");break;
                case 4: out.println("<div style='width:200px;height:100px;color:green;background:black;font-size:15px;'><code> >Wake up, Neo</code></div>");break;
                case 5: out.println("<table border='1'><caption>Dígitos Binarios</caption><colgroup><col span='1' style='background-color:blue;'/><col style='background-color:gray;'/></colgroup><tr><th>0</th><th>1</th></tr><tr><td>1</td><td>0</td></tr></table>");break;
                case 6: out.println("Solo disponible en IE :(");break;
                case 7: out.println("<input list='browsers'><datalist id='browsers'><option value='Internet Explorer'><option value='Firefox'><option value=\"Chrome\"><option value=\"Opera\"><option value=\"Safari\"></datalist><p><a href='index.html'>atrás</a></p>");break;
                case 8: out.println("<dl><dt>Café</dt><dd>Bebida caliente</dd><dt>Leche</dt><dd>Bebida fría</dd><dt>Café con Leche</dt><dd>Es como el café pero con leche</dd></dl>");break;
                case 9: out.println("<p>Mi personaje favorito es <del>Vegeta</del> <ins>Goku!</ins>!</p>");break;
            }
            out.println("<p><a href='index.html'>atrás</a></p></body>");
            out.println("</html>");
        }
    }
}
