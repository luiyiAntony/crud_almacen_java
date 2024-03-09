package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Category;
import modelo.CategoryDAO;
import modelo.Productos;
import modelo.ProductosDAO;

/**
 *
 * @author blablabla
 */
@WebServlet(name = "ProductosController", urlPatterns = { "/ProductosController" })
public class ProductosController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductosDAO productosDAO = new ProductosDAO(); // execute de constructor and connect to database
		CategoryDAO categoryDAO = new CategoryDAO();
		String accion;
		RequestDispatcher dispatcher = null;

		accion = request.getParameter("accion");

		if (accion == null || accion.isEmpty()) {
			dispatcher = request.getRequestDispatcher("Productos/index.jsp"); //
			List<Productos> listaProductos = productosDAO.listarProductos();
			List<Category> listaCategories = categoryDAO.listCategories();
			request.setAttribute("productos", listaProductos);
			request.setAttribute("categories", listaCategories);
		} else if ("filter".equals(accion)) {
			String category_id = request.getParameter("Category_id");
			String range = request.getParameter("Range");
			String price = request.getParameter("Price");
			category_id = category_id == "undefined" ? "all" : category_id;
			range = range == "undefined" ? "all" : range;
			price = price == "undefined" ? "all" : price;
			category_id = category_id == null ? "all" : category_id;
			range = range == null ? "all" : range;
			price = price == null ? "all" : price;
			dispatcher = request.getRequestDispatcher("Productos/index.jsp"); //
			List<Productos> productos;
			if (!("all".equals(category_id) && "all".equals(range))) {
				productos = productosDAO.filterBy(category_id, range, price);
			} else {
				productos = productosDAO.listarProductos();
			}
			List<Category> categories = categoryDAO.listCategories();
			request.setAttribute("productos", productos);
			request.setAttribute("categories", categories);
		} else if ("nuevo".equals(accion)) {
			dispatcher = request.getRequestDispatcher("Productos/nuevo.jsp"); //
		} else if ("modificar".equals(accion)) {
			int id = Integer.parseInt(request.getParameter("id"));
			Productos producto = productosDAO.mostrarProducto(id);
			dispatcher = request.getRequestDispatcher("Productos/modificar.jsp"); //
			request.setAttribute("producto", producto);
		} else if ("insertar".equals(accion)) {
			String codigo = request.getParameter("codigo");
			String nombre = request.getParameter("nombre");
			Double precio = Double.parseDouble(request.getParameter("precio"));
			int existencia = Integer.parseInt(request.getParameter("existencia"));

			// Productos producto = new Productos(0, codigo, nombre, precio, existencia);
			Productos producto = new Productos();
			productosDAO.insertar(producto);

			dispatcher = request.getRequestDispatcher("Productos/index.jsp"); //
			List<Productos> listaProductos = productosDAO.listarProductos();
			request.setAttribute("lista", listaProductos);
		} else if ("actualizar".equals(accion)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String codigo = request.getParameter("codigo");
			String nombre = request.getParameter("nombre");
			Double precio = Double.parseDouble(request.getParameter("precio"));
			int existencia = Integer.parseInt(request.getParameter("existencia"));

			// Productos producto = new Productos(id, codigo, nombre, precio, existencia);
			Productos producto = new Productos();
			productosDAO.actualizar(producto);

			dispatcher = request.getRequestDispatcher("Productos/index.jsp"); //
			List<Productos> listaProductos = productosDAO.listarProductos();
			request.setAttribute("lista", listaProductos);
		} else if ("eliminar".equals(accion)) {
			int id = Integer.parseInt(request.getParameter("id"));
			productosDAO.eliminar(id);
			dispatcher = request.getRequestDispatcher("Productos/index.jsp"); //
			List<Productos> listaProductos = productosDAO.listarProductos();
			request.setAttribute("lista", listaProductos);
		} else {
			dispatcher = request.getRequestDispatcher("Productos/index.jsp"); //
			List<Productos> listaProductos = productosDAO.listarProductos();
			request.setAttribute("lista", listaProductos);
		}

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
