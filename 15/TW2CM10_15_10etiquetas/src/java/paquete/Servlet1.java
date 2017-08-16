package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String abbr = request.getParameter("abbr");
        String b = request.getParameter("b");
        String blockquote = request.getParameter("blockquote");
        String bdo = request.getParameter("bdo");
        String br = request.getParameter("br");
        String artt = request.getParameter("artt");
        String artc = request.getParameter("artc");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<abbr title='"+abbr+"'>:)</abbr><br>");
            out.println("<b>"+b+"</b><br>");
            out.println("<blockquote>"+blockquote+"</blockquote><br>");
            out.println("<aside><p><i>inicia aside</i></p><bdo dir='rtl'>"+bdo+"</bdo><br>");
            out.println("<br>"+br+"<br><br>");
            out.println("<article><h1>"+artt+"</h1>");
            out.println("<p>"+artc+"</p></article><br><p><i>termina aside</i></p></aside><br>");
            out.println("<p>Base:"+request.getRealPath("/")+"</p>");
            out.println("<img src='planets.gif' width='307' height='247' alt='Planets'\n"+"usemap='#planetmap'>");
            out.println("<map name='planetmap'>\n"+"<area shape='circle' coords='153,135,70' alt='Mercury' href='mercur.htm'>\n"+"</map>");
            out.println("<address><br>Autor<br>Su página<br>Su teléfono<br>Su casita<br></address>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}