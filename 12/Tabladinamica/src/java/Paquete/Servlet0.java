package Paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet0 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out=response.getWriter();
        String filas= request.getParameter("filas");
        String columnas= request.getParameter("columnas");
        int filasi= Integer.parseInt(filas);
        int columnasi= Integer.parseInt(columnas);
        session.setAttribute("filas", filasi);
        session.setAttribute("columnas", columnasi);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Mandar a Servlet1</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form method='get' action='Servlet1'>");
                for(int i=0;i<filasi;i++){
                    for(int j=0;j<columnasi;j++)
                        out.println("<input type='text' name='parametro"+i+"_"+j+"'/>");
                    out.println("</br>");
                }
                out.println("<input type='submit'/>");
                out.println("</form>");
                out.println("</body");
                out.println("</html>");           
    }
 }