
package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChichaServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        double a1,b1,c1,x1,x2;
        a1= Integer.parseInt(request.getParameter("a"));
        b1= Integer.parseInt(request.getParameter("b"));
        c1= Integer.parseInt(request.getParameter("c"));
        x1=(-b1+Math.sqrt((Math.pow(b1, 2))-4*a1*c1))/2;
        x2=(-b1-Math.sqrt((Math.pow(b1, 2))-4*a1*c1))/2;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ChichaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align=center>x2 = "+x2+"</h1>");
            out.println("<h1 align=center>x1 = "+x1+"</h1>");
            //out.println("<h1>a: " + request.getParameter("a") + "</h1>");
            //out.println("<h1>b: " + request.getParameter("b") + "</h1>");
            //out.println("<h1>c: " + request.getParameter("c") + "</h1>");
            out.println("</body>");
            out.println("</html>");
    }

}
