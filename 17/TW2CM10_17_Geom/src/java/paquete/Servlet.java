package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kolt
 */
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String xval,yval,xbeg,ybeg,xend,yend;
        xval = (String)request.getParameter("xval");
        yval = (String)request.getParameter("yval");
        xbeg = (String)request.getParameter("xbeg");
        ybeg = (String)request.getParameter("ybeg");
        xend = (String)request.getParameter("xend");
        yend = (String)request.getParameter("yend");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Canvas</title>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h1></h1>");
            out.println("<canvas id='canvitas' width='"+xval+"' height='"+yval+"'style='border:1px solid #000000;'>");
            out.println("</canvas>");
            out.println("</body>");
            out.println("<script>\n"
                    + "var c=document.getElementById(\"canvitas\");\n" +
                      "var ctx=c.getContext(\"2d\");\n" +
                      "ctx.fillStyle=\"#AAAAAA\";\n" +
                      "ctx.fillRect("+xbeg+","+ybeg+","+xend+","+yend+");\n"
                    + "</script>");
            out.println("</html>");
        }
    }
}
