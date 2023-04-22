package co.edu.unbosque.model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.http.Part;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * La clase EstudianteServlet es un servlet que gestiona las solicitudes y
 * respuestas HTTP relacionadas con los estudiantes. Utiliza un objeto de la
 * clase EstudianteDAO para realizar operaciones CRUD (Crear, Leer, Actualizar y
 * Eliminar) en la lista de estudiantes.
 */
public class EstudianteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EstudianteDAO estudianteDAO;

	public void init() {
		estudianteDAO = new EstudianteDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			action = "default";
		}

		switch (action) {
		case "agregar":
			agregarEstudiante(request, response);
			break;
		case "eliminar":
			eliminarEstudiante(request, response);
			break;
		case "actualizar":
			actualizarEstudiante(request, response);
			break;
		case "listar":
			listarEstudiantes(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}

	/**
	 * Lista todos los estudiantes y los muestra en una página JSP.
	 *
	 * @param request  La solicitud HttpServletRequest.
	 * @param response La respuesta HttpServletResponse.
	 * @throws ServletException Si ocurre un error relacionado con el servlet.
	 * @throws IOException      Si ocurre un error relacionado con la
	 *                          entrada/salida.
	 */
	private void listarEstudiantes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Estudiantes en DAO: " + estudianteDAO.getList());
		request.setAttribute("estudiantes", estudianteDAO.getList());
		request.getRequestDispatcher("lista_estudiantes.jsp").forward(request, response);
	}

	/**
	 * Agrega un nuevo estudiante y redirige al usuario a la página de inicio.
	 *
	 * @param request  La solicitud HttpServletRequest.
	 * @param response La respuesta HttpServletResponse.
	 * @throws IOException      Si ocurre un error relacionado con la
	 *                          entrada/salida.
	 * @throws ServletException Si ocurre un error relacionado con el servlet.
	 */
	private void agregarEstudiante(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String nombre = request.getParameter("nombre");
		String fechaNacimientoString = request.getParameter("fecha_nacimiento");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString, formatter);
		String colegio = request.getParameter("colegio");
		String carrera = request.getParameter("carrera");
		String estrato = request.getParameter("estrato");
		boolean homologacion = Boolean.parseBoolean(request.getParameter("homologacion"));

		// Manejar archivo de imagen subido
		Part fotoPart = request.getPart("foto");
		String filePathString = null;
		if (fotoPart != null && fotoPart.getSize() > 0) {
			String fileName = fotoPart.getSubmittedFileName();
			filePathString = "C:/imagenes-estudiantes/" + fileName;
			fotoPart.write(filePathString);

		}
		Path filePath = filePathString != null ? Paths.get(filePathString) : null;

		estudianteDAO.agregar(nombre, fechaNacimiento, colegio, carrera, estrato, homologacion, filePath);
		response.sendRedirect("index.jsp");
	}

	/**
	 * Elimina un estudiante y redirige al usuario a la página de inicio.
	 *
	 * @param request  La solicitud HttpServletRequest.
	 * @param response La respuesta HttpServletResponse.
	 * @throws IOException Si ocurre un error relacionado con la entrada/salida.
	 */
	private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nombre = request.getParameter("nombre");
		estudianteDAO.eliminar(nombre);
		response.sendRedirect("index.jsp");
	}

	/**
	 * Actualiza la información de un estudiante y redirige al usuario a la página
	 * de inicio.
	 *
	 * @param request  La solicitud HttpServletRequest.
	 * @param response La respuesta HttpServletResponse.
	 * @throws IOException Si ocurre un error relacionado con la entrada/salida.
	 */
	private void actualizarEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nombreActual = request.getParameter("nombreActual");
		String nuevoNombre = request.getParameter("nuevoNombre");
		String nuevaFechaNacimientoString = request.getParameter("nuevaFechaNacimiento");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate nuevaFechaNacimiento = LocalDate.parse(nuevaFechaNacimientoString, formatter);
		String nuevoColegio = request.getParameter("nuevoColegio");
		String nuevaCarrera = request.getParameter("nuevaCarrera");
		String nuevoEstrato = request.getParameter("nuevoEstrato");
		boolean nuevaHomologacion = Boolean.parseBoolean(request.getParameter("nuevaHomologacion"));

		estudianteDAO.actualizar(nombreActual, nuevoNombre, nuevaFechaNacimiento, nuevoColegio, nuevaCarrera,
				nuevoEstrato, nuevaHomologacion);
		response.sendRedirect("index.jsp");
	}
}
