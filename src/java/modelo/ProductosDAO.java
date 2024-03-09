package modelo;

import config.Conexion;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

/**
 *
 * @author blablabla
 */
public class ProductosDAO {

	Connection conexion;

	// public ProductosDAO() throws ClassNotFoundException {
	public ProductosDAO() {
		Conexion con = new Conexion();
		conexion = con.getConexion();
	}

	public List<Productos> listarProductos() {
		PreparedStatement ps;
		ResultSet rs;

		List<Productos> lista = new ArrayList<>();

		try {
			ps = conexion.prepareStatement(
					"SELECT Product_id, Product_name, Units, Picture, Weight, Category_id, Price, Product_description, Manufacturer_id FROM PRODUCT;");
			rs = ps.executeQuery();
			while (rs.next()) {
				Productos producto = getProductInfo(rs);
				lista.add(producto);
			}

			return lista;

		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public List<Productos> filterBy(String Category_id, String Range, String Price) {
		PreparedStatement ps;
		ResultSet rs;
		List<Productos> productos = new ArrayList<>();

		Category_id = "all".equals(Category_id) ? "Category_id" : Category_id;

		if ("all".equals(Range)) {
			Range = "=";
			Price = "Price";
		}

		if ("less".equals(Range)) {
			Range = "<";
		}

		if ("greater".equals(Range)) {
			Range = ">";
		}

		try {
			String query = "SELECT * FROM PRODUCT WHERE Category_id = " + Category_id + " and Price " + Range + Price;
			System.out.println(query);
			ps = conexion.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Productos producto = getProductInfo(rs);
				productos.add(producto);
			}
			return productos;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public Productos mostrarProducto(int _id) {
		PreparedStatement ps;
		ResultSet rs;

		Productos producto = null;

		try {
			ps = conexion.prepareStatement(
					"SELECT Product_id, Product_name, Units, Picture, Weight, Category_id, Price, Product_description, Manufacturer_id FROM PRODUCT WHERE Product_id = ?");
			ps.setInt(1, _id);
			rs = ps.executeQuery();
			while (rs.next()) {
				producto = getProductInfo(rs);
			}

			return producto;

		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public boolean insertar(Productos producto) {
		PreparedStatement ps;

		try {
			ps = conexion
					.prepareStatement(
							"INSERT INTO PRODUCT (Product_name, Units, Picture, Weight, Category_id, Price, Product_description, Manufacturer_id) values (?, ?, ?, ?, ?, ?, ?, ?,)");
			ps = setProductInfo(ps, producto);
			ps.execute();
			return true;

		} catch (SQLException e) {
			System.out.println(e.toString());
			return false;
		}
	}

	public boolean actualizar(Productos producto) {
		PreparedStatement ps;

		try {
			ps = conexion.prepareStatement(
					"UPDATE PRODUCT SET Product_name = ?, Units = ?, Picture = ?, Weight = ?, Category_id = ?, Price = ?, Product_description = ?, Manufacturer_id = ? WHERE Product_id = ?");
			ps = setProductInfo(ps, producto);
			ps.setInt(9, producto.getProduct_id());
			ps.execute();
			return true;

		} catch (SQLException e) {
			System.out.println(e.toString());
			return false;
		}
	}

	public boolean eliminar(int _id) {
		PreparedStatement ps;

		try {
			ps = conexion.prepareStatement("DELETE FROM PRODUCT WHERE Product_id = ?");
			ps.setInt(1, _id);
			ps.execute();
			return true;

		} catch (SQLException e) {
			System.out.println(e.toString());
			return false;
		}
	}

	private Productos getProductInfo(ResultSet rs) {
		try {
			Integer Product_id = rs.getInt("Product_id");
			String Product_name = rs.getString("Product_name");
			Integer Units = rs.getInt("Units");
			String Picture = rs.getString("Picture");
			Double Weight = rs.getDouble("Weight");
			Integer Category_id = rs.getInt("Category_id");
			Double Price = rs.getDouble("Price");
			String Product_description = rs.getString("Product_description");
			Integer Manufacturer_id = rs.getInt("Manufacturer_id");
			Productos producto = new Productos(Product_id, Units, Category_id, Manufacturer_id, Product_name, Picture,
					Product_description, Weight, Price);
			return producto;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}

	private PreparedStatement setProductInfo(PreparedStatement ps, Productos producto) {
		try {
			ps.setString(1, producto.getProduct_name());
			ps.setInt(2, producto.getUnits());
			ps.setString(3, producto.getPicture());
			ps.setDouble(4, producto.getWeight());
			ps.setInt(5, producto.getCategory_id());
			ps.setDouble(6, producto.getPrice());
			ps.setString(7, producto.getProduct_description());
			ps.setInt(8, producto.getManufacturer_id());
			return ps;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
