package modelo;

/**
 *
 * @author blablabla
 */
public class Productos {

	private Integer Product_id, Units, Category_id, Manufacturer_id;
	private String Product_name, Picture, Product_description;
	private Double Weight, Price;

	public Productos() {
	}

	public Productos(Integer Product_id, Integer Units, Integer Category_id, Integer Manufacturer_id,
			String Product_name, String Picture, String Product_description, Double Weight, Double Price) {
		this.Product_id = Product_id;
		this.Units = Units;
		this.Category_id = Category_id;
		this.Manufacturer_id = Manufacturer_id;
		this.Product_name = Product_name;
		this.Picture = Picture;
		this.Product_description = Product_description;
		this.Weight = Weight;
		this.Price = Price;
	}

	public Integer getProduct_id() {
		return this.Product_id;
	}

	public void setProduct_id(Integer Product_id) {
		this.Product_id = Product_id;
	}

	public Integer getUnits() {
		return this.Units;
	}

	public void setUnits(Integer Units) {
		this.Units = Units;
	}

	public Integer getCategory_id() {
		return this.Category_id;
	}

	public void setCategory_id(Integer Category_id) {
		this.Category_id = Category_id;
	}

	public Integer getManufacturer_id() {
		return this.Manufacturer_id;
	}

	public void setManufacturer_id(Integer Manufacturer_id) {
		this.Manufacturer_id = Manufacturer_id;
	}

	public String getProduct_name() {
		return this.Product_name;
	}

	public void setProduct_name(String Product_name) {
		this.Product_name = Product_name;
	}

	public String getPicture() {
		return this.Picture;
	}

	public void setPicture(String Picture) {
		this.Picture = Picture;
	}

	public String getProduct_description() {
		return this.Product_description;
	}

	public void setProduct_description(String Product_description) {
		this.Product_description = Product_description;
	}

	public Double getWeight() {
		return this.Weight;
	}

	public void setWeight(Double Weight) {
		this.Weight = Weight;
	}

	public Double getPrice() {
		return this.Price;
	}

	public void setPrice(Double Price) {
		this.Price = Price;
	}

	@Override
	public String toString() {
		return "{" +
				" Product_id='" + getProduct_id() + "'" +
				", Units='" + getUnits() + "'" +
				", Category_id='" + getCategory_id() + "'" +
				", Manufacturer_id='" + getManufacturer_id() + "'" +
				", Product_name='" + getProduct_name() + "'" +
				", Picture='" + getPicture() + "'" +
				", Product_description='" + getProduct_description() + "'" +
				", Weight='" + getWeight() + "'" +
				", Price='" + getPrice() + "'" +
				"}";
	}

}
