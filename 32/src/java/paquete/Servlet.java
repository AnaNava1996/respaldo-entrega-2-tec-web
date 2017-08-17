package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ifram = (String) request.getParameter("ifram");
        String barra = request.getParameter("barra");
        String footer = request.getParameter("footer");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("<style>\n" +
"      div{\n" +
"      background:#AAAAAA;\n" +
"      border:2px solid black;\n" +
"      padding:10px;\n" +
"      }\n" +
"      iframe{\n" +
"      border:1px solid "+ifram+";\n" +
"      padding:10px;\n" +
"      width:500px;\n" +
"      }\n" +
"      \n" +
"    </style></head>");
            out.println("<body>");
            out.println("<div><p>ESTO ES UN DIV</p>\n" +
"      <iframe src=\"embed.html\">TEST</iframe>\n" +
"    </div>\n" +
"    <div>\n" +
"      <ol>\n" +
"	<li>Esta es</li>\n" +
"	<li>Una</li>\n" +
"	<li>Lista</li>\n" +
"      </ol>\n" +
"    </div>\n" +
"    <div>\n" +
"      <img src=\"planets.gif\" width=\"145\" height=\"126\" alt=\"Planets\" usemap=\"#planetmap\"/>\n" +
"      <map name=\"planetmap\">\n" +
"	<area shape=\"rect\" coords=\"0,0,82,126\" title=\"Sol\"/>\n" +
"	<area shape=\"circle\" coords=\"90,58,3\" title=\"Mercurio\"/>\n" +
"	<area shape=\"circle\" coords=\"124,58,8\" title=\"Venus\"/>\n" +
"      </map>\n" +
"    </div>\n" +
"    <div>\n" +
"      <p>Esto es un menú</p>\n" +
"      <menu type=\"context\" id=\"mymenu\">\n" +
"	<menuitem label=\"Refresh\" onclick=\"window.location.reload();\">Recargar</menuitem>\n" +
"	<menuitem label=\"Twitter\" onclick=\"window.open('http://www.twitter.com/')\">\n" +
"	  Facebook\n" +
"	</menuitem>\n" +
"	<menuitem label=\"Facebook\" onclick=\"window.open('http://www.facebook.com/')\">\n" +
"	  Twitter\n" +
"	</menuitem>\n" +
"      </menu>\n" +
"    </div>\n" +
"    <div>\n" +
"      <p>Param: Autoplay</p>\n" +
"      <object data=\"horse.wav\">\n" +
"	<param name=\"autoplay\" value=\"true\">\n" +
"      </object>\n" +
"    </div>\n" +
"    <div>\n" +
"      <p>Barra de progreso en progreso...</p>\n" +
"      <progress value="+Integer.parseInt(barra)+" max=\"100\"></progress>\n" +
"    </div>");
            out.println("<div>\n" +
"      <select>\n" +
"	<option value=\"1\">Dale</option>\n" +
"	<option value=\"2\">A tu cuerpo</option>\n" +
"	<option value=\"3\">Alegría</option>\n" +
"	<option value=\"4\">Macarena</option>\n" +
"      </select>\n" +
"    </div>\n" +
"    <div>\n" +
"      <pre>\n" +
"	\"pre\" sirve para      preservar\n" +
"	los         espacios         en\n" +
"	b   l   a   n   c   o   y   los\n" +
"	saltos de línea\n" +
"      </pre>\n" +
"    </div>\n" +
"    <footer><p>"+footer+"</p></footer></body>");
            out.println("</html>");
        }
    }
}
