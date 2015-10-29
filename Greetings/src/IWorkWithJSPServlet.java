

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IWorkWithJSPServlet
 */
@WebServlet("/helloServletNew")
public class IWorkWithJSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IWorkWithJSPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String counter = (String)request.getSession().getAttribute("counter");
		if(counter==null)
			counter = "1";
		else
			counter = String.valueOf(( Integer.valueOf(counter)) + 1);
		request.getSession().setAttribute("counter", counter);
		request.setAttribute("personalizedGreeting", "Hello "+ request.getParameter("name") + "\nYou visited " + counter +" times!!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/NewGreetingsJSP.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
