package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

/**
 *
 * @author blablabla
 */
public class CategoryDAO {
    Connection conexion;

    public CategoryDAO() {
        Conexion conn = new Conexion();
        conexion = conn.getConexion();
    }

    public List<Category> listCategories() {
        PreparedStatement ps;
        ResultSet rs;
        List<Category> categories = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("SELECT Category_id, Category_name, Category_Description FROM CATEGORY");
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer Category_id = rs.getInt("Category_id");
                String Category_name = rs.getString("Category_name");
                String Category_Description = rs.getString("Category_Description");
                Category category = new Category(Category_id, Category_name, Category_Description);
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
