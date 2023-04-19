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

@WebServlet("/EstudianteServlet")
public class EstudianteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EstudianteDAO estudianteDAO;

    public void init() {
        estudianteDAO = new EstudianteDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    private void listarEstudiantes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("estudiantes", estudianteDAO.getList());
        request.getRequestDispatcher("lista_estudiantes.jsp").forward(request, response);
    }

	private void agregarEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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

    private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        estudianteDAO.eliminar(nombre);
        response.sendRedirect("index.jsp");
    }

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

        estudianteDAO.actualizar(nombreActual, nuevoNombre, nuevaFechaNacimiento, nuevoColegio, nuevaCarrera, nuevoEstrato, nuevaHomologacion);
        response.sendRedirect("index.jsp");
    }
}

