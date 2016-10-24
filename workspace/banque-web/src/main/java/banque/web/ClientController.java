package banque.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import banque.dao.ClientDao;
import banque.model.Client;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/client")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientDao clientDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		ApplicationContext context = (ApplicationContext) getServletContext().getAttribute("spring");
		clientDao = context.getBean(ClientDao.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "list";

		switch (action) {
		case "list":
			List<Client> clients = clientDao.findAll();

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/clients.jsp");
			
			request.setAttribute("clients", clients);
			
			rd.forward(request, response);
			
			break;
		case "add":

			break;
		case "edit":

			break;
		case "save":

			break;
		case "delete":

			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
