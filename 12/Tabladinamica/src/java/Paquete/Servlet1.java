package Paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out=response.getWriter();
        int filasi= (int)session.getAttribute("filas");
        int columnasi= (int)session.getAttribute("columnas");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("</head>");
                out.println("<body>");
                out.println("<table border='1'>");
                for(int i=0;i<filasi;i++){
                    out.println("<tr>");
                    for(int j=0;j<columnasi;j++){
                        out.println("<td>"+request.getParameter("parametro"+i+"_"+j)+"</td>");
                    }
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</body");
                out.println("</html>");           
    }
 }