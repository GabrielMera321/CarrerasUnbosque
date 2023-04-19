package co.edu.unbosque.servlets;

import java.io.IOException;
import java.io.PrintWriter;



import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

        if (action == null) {
            action = "default";
        }
        switch(action) {
        case "Estudiante":
        	bottonEstudiante(request,response);
        	break;
        case "Login":
        	bottonLogin(request,response);
        	break;
        }
	}

	private void bottonLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String n = request.getParameter("t1");
		String pwd = request.getParameter("t2");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if(n.equals("Unibosque")&&pwd.equals("Unibosqu3")) {
			response.sendRedirect("administrador.jsp");
		}
		else
		{
			out.println("Usuario o contrasena incorrecta");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		
	}
	private void bottonEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getParameter("action");
		
		if("Estudiante".equals(action)) {
			response.sendRedirect("estudiante.jsp");
		}
	}
}

