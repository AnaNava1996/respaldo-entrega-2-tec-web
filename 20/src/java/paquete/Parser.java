package paquete;

import java.io.FileWriter;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Parser extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
                String nombre = (String) request.getParameter("nombre");
                String apellido = (String) request.getParameter("apellido");
                String tipo = (String) request.getParameter("tipo");
                String salario = (String) request.getParameter("salario");

		Element escuela = new Element("escuela");
		Document doc = new Document(escuela);
                doc.detachRootElement();
		doc.setRootElement(escuela);

		Element staff = new Element("profesor");
		staff.setAttribute(new Attribute("id", "1"));
		staff.addContent(new Element("nombre").setText(nombre));
		staff.addContent(new Element("apellido").setText(apellido));
		staff.addContent(new Element("tipo").setText(tipo));
		staff.addContent(new Element("salario").setText(salario));

		doc.getRootElement().addContent(staff);

		// new XMLOutputter().output(doc, System.out);
		XMLOutputter xmlOutput = new XMLOutputter();

		// display nice nice
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter(request.getServletContext().getRealPath("/")+"file.xml"));

		System.out.println("File Saved!");
	  } catch (IOException io) {
		System.out.println(io.getMessage());
	  }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Parser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
            response.sendRedirect("file.xml");
        }
    }
}
