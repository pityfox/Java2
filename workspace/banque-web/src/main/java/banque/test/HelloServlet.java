package banque.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		if (req.getParameter("nom") != null) {
			HttpSession session = req.getSession();
			
			session.setAttribute("nom", req.getParameter("nom"));
			Cookie cookie = new Cookie("nom", req.getParameter("nom"));
			cookie.setMaxAge(60);
			resp.addCookie(cookie);
		}

		Cookie cookieFind = null;

		if (req.getCookies() != null) {
			for (Cookie ck : req.getCookies()) {
				if ("nom".equals(ck.getName())) {
					cookieFind = ck;
					break;
				}
			}
		}

		String nom = req.getParameter("nom");

		nom = (cookieFind != null ? cookieFind.getValue()
				: (req.getParameter("nom") != null ? req.getParameter("nom") : "World"));

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello " + nom + " !!!");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}
