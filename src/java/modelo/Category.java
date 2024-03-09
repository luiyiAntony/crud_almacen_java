package modelo;

/**
 *
 * @author blablabla
 */
public class Category {
    private Integer Category_id;
    private String Category_name, Category_Description;

    public Category(Integer Category_id, String Category_name, String Category_Description) {
        this.Category_id = Category_id;
        this.Category_name = Category_name;
        this.Category_Description = Category_Description;
    }

    public Category() {
    }

    public void setCategory_id(Integer Category_id) {
        this.Category_id = Category_id;
    }

    public Integer getCategory_id() {
        return this.Category_id;
    }

    public void setCategory_name(String Category_name) {
        this.Category_name = Category_name;
    }

    public String getCategory_name() {
        return this.Category_name;
    }

    public void setCategory_Description(String Category_Description) {
        this.Category_Description = Category_Description;
    }

    public String getCategory_Description() {
        return this.Category_Description;
    }

    @Override
    public String toString() {
        return "{" +
                " Category_id:'" + getCategory_id() + "'" +
                ", Category_name:'" + getCategory_name() + "'" +
                ", Category_Description:'" + getCategory_Description() + "'" +
                "}";
    }
}
