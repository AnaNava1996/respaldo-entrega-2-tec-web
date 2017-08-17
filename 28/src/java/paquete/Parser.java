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
import org.jdom2.DocType;

public class Parser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
                DocType dctype = new DocType("struts-config","-//Apache Software Foundation//DTD Struts Configuration 1.3//EN","http://jakarta.apache.org/struts/dtds/struts-config_1_3.dtd");

		Element strut = new Element("struts-config");
		Document doc = new Document(strut);
                doc.setDocType(dctype);

		
                Element gfor = new Element("global-forwards");
                Element forw = new Element("forwards");
                Element act = new Element("action");
                Element plugin1 = new Element("plugin");
                Element plugin2 = new Element("plugin");
                Element prop1 = new Element("set-property");
                Element prop2 = new Element("set-property");
                Element prop3 = new Element("set-property");
		//strut.setAttribute(new Attribute("id", "1"));
		doc.getRootElement().addContent(new Element("form-beans").setText("\n"));
		doc.getRootElement().addContent(new Element("global-exceptions").setText("\n"));
                forw.setAttribute(new Attribute("name","welcome"));
                forw.setAttribute(new Attribute("path","/Welcome.do"));
                act.setAttribute("path","welcome");
                act.setAttribute("forward","/welcomeStruts.jsp");
                prop1.setAttribute("property","definitions-config");prop1.setAttribute("value","/WEB-INF/tiles-defs.xml");
                prop2.setAttribute("property","moduleAware");prop2.setAttribute("value","true");
                prop3.setAttribute("property","pathnames");prop3.setAttribute("value","/WEB-INF/validator-rules.xml,/WEB-INF/validation.xml");
                plugin1.addContent(prop1);plugin1.addContent(prop2);
                plugin2.addContent(prop3);
		gfor.addContent(forw);
		doc.getRootElement().addContent(gfor);
                doc.getRootElement().addContent(new Element("action-mappings").addContent(act));
                doc.getRootElement().addContent(new Element("controller").setAttribute("processorClass","org.apache.struts.tiles.TilesRequestProcessor"));
                doc.getRootElement().addContent(new Element("message-resources").setAttribute("parameter","com/myapp/struts/ApplicationResource"));
                doc.getRootElement().addContent(plugin1);
                
		//doc.getRootElement().addContent(strut);

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
