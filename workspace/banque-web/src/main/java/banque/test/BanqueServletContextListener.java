package banque.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BanqueServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) arg0.getServletContext().getAttribute("spring");
		
		context.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		arg0.getServletContext().setAttribute("spring", context);
	}

}
