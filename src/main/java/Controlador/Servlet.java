package Controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Login;
import Modelo.Persona;


public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("password");
        String mensaje = "";

        try {
            boolean credencialesValidas = Login.validar(usuario, clave);

            if (credencialesValidas) {
                Persona usuarioAutenticado = Login.datos(usuario);
                request.setAttribute("datosUsuario", usuarioAutenticado);
                mensaje = "Acceso autorizado";
            } else {
                mensaje = "Credenciales invalidas, intente nuevamente";
            }
        } catch (Exception e) {
            e.printStackTrace();
            mensaje = "Error interno al procesar la solicitud";
        }

        request.setAttribute("mensaje", mensaje);
        RequestDispatcher despachador = request.getRequestDispatcher("mostrarResultado.jsp");
        despachador.forward(request, response);
    }

}