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

import banque.dao.AgenceDao;
import banque.model.Adresse;
import banque.model.Agence;
import banque.model.AgenceId;
import banque.model.Titre;

@WebServlet("/agence")
public class AgenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AgenceDao agenceDao;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgenceController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		ApplicationContext context = (ApplicationContext) getServletContext().getAttribute("spring");
		agenceDao = context.getBean(AgenceDao.class);
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
		List<Agence> agences = agenceDao.findAll();

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/agences.jsp");

		request.setAttribute("agences", agences);

		rd.forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/agenceEdit.jsp");
		rd.forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer numBanque = Integer.valueOf(request.getParameter("numBanque"));
		Integer numAgence = Integer.valueOf(request.getParameter("numAgence"));
		AgenceId id = new AgenceId(numBanque, numAgence);
		Agence agence = agenceDao.find(id);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/agenceEdit.jsp");

		request.setAttribute("agence", agence);

		rd.forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer numBanque = Integer.valueOf(request.getParameter("numBanque"));
		Integer numAgence = Integer.valueOf(request.getParameter("numAgence"));
		AgenceId id = new AgenceId(numBanque, numAgence);
		
		int version = request.getParameter("version") != null && !request.getParameter("version").isEmpty()
				? Integer.valueOf(request.getParameter("version")) : 0;
		String rue = request.getParameter("rue") != null && !request.getParameter("rue").isEmpty()
				? request.getParameter("rue") : null;
		String codePostal = request.getParameter("codePostal") != null && !request.getParameter("codePostal").isEmpty()
				? request.getParameter("codePostal") : null;
		String ville = request.getParameter("ville") != null && !request.getParameter("ville").isEmpty()
				? request.getParameter("ville") : null;
		String horaires = request.getParameter("horaires") != null && !request.getParameter("horaires").isEmpty()
				? request.getParameter("horaires") : null;
		
		String libelle = request.getParameter("libelle") != null && !request.getParameter("libelle").isEmpty()
				? request.getParameter("libelle") : null;
		
		Agence agence = new Agence();
		agence.setId(id);
		agence.setVersion(version);
		agence.setAdresse(new Adresse(rue, codePostal, ville));
		agence.setHoraires(horaires);
		agence.setLibelle(libelle);
		
		if (Boolean.getBoolean(request.getParameter("new"))) {
			agenceDao.create(agence);
		} else {
			agenceDao.update(agence);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer numBanque = Integer.valueOf(request.getParameter("numBanque"));
		Integer numAgence = Integer.valueOf(request.getParameter("numAgence"));
		AgenceId id = new AgenceId(numBanque, numAgence);
		Agence agence = agenceDao.find(id);

		agenceDao.delete(agence);
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
