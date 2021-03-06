package banque.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import banque.dao.ClientDao;
import banque.model.Adresse;
import banque.model.Client;
import banque.model.Titre;

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
			list(request, response);

			break;
		case "add":
			add(request, response);
			
			break;
		case "edit":
			edit(request, response);
			
			break;
		case "save":
			save(request, response);

			list(request, response);

			break;
		case "delete":
			delete(request, response);

			list(request, response);

			break;
		default:
			break;
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clients = clientDao.findAll();

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/clients.jsp");

		request.setAttribute("clients", clients);

		rd.forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientEdit.jsp");

		request.setAttribute("titres", Titre.values());

		rd.forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		Client client = clientDao.find(id);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientEdit.jsp");

		request.setAttribute("client", client);
		request.setAttribute("titres", Titre.values());

		rd.forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Long id = request.getParameter("id") != null && !request.getParameter("id").isEmpty()
				? Long.valueOf(request.getParameter("id")) : null;
		int version = request.getParameter("version") != null && !request.getParameter("version").isEmpty()
				? Integer.valueOf(request.getParameter("version")) : 0;
		Titre titre = Titre.valueOf(request.getParameter("titre"));
		String nom = request.getParameter("nom") != null && !request.getParameter("nom").isEmpty()
				? request.getParameter("nom") : null;
		String prenom = request.getParameter("prenom") != null && !request.getParameter("prenom").isEmpty()
				? request.getParameter("prenom") : null;
		Date dtNaissance = null;
		try {
			dtNaissance = sdf.parse(request.getParameter("dtNaissance"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String commentaire = request.getParameter("commentaire") != null
				&& !request.getParameter("commentaire").isEmpty() ? request.getParameter("commentaire") : null;
		String rue = request.getParameter("rue") != null && !request.getParameter("rue").isEmpty()
				? request.getParameter("rue") : null;
		String codePostal = request.getParameter("codePostal") != null && !request.getParameter("codePostal").isEmpty()
				? request.getParameter("codePostal") : null;
		String ville = request.getParameter("ville") != null && !request.getParameter("ville").isEmpty()
				? request.getParameter("ville") : null;

		Client client = new Client();
		client.setId(id);
		client.setVersion(version);
		client.setTitre(titre);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setDtNaissance(dtNaissance);
		client.setCommentaire(commentaire);
		client.setAdr(new Adresse(rue, codePostal, ville));

		if (client.getId() == null) {
			clientDao.create(client);
		} else {
			clientDao.update(client);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		Client client = clientDao.find(id);

		clientDao.delete(client);
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
