/**
 * 
 * This class represents the property with name, city, owner, rent amount and
 * plot details
 * 
 * @author Mark Kasule
 *
 */
public class Property {

	private String propertyName; // name of property
	private String city; // name of the city
	private double rentAmount; // holds the plot object
	private String owner; // name of house owner
	private Plot plot;

	public Property() {
		propertyName = "";
		city = "";
		rentAmount = 0;
		owner = "";
		this.plot = new Plot(0, 0, 1, 1);
	}

	/**
	 * 
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}

	/**
	 * 
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,
			int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}

	/**
	 * 
	 * @param p
	 */
	public Property(Property p) {
		this.propertyName = p.propertyName;
		this.city = p.city;
		this.owner = p.owner;
		this.rentAmount = p.rentAmount;
		this.plot = p.plot;
	}

	/**
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @return owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * 
	 * @return propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * 
	 * @return rent amount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	public void setPlot(int x, int y, int width, int depth) {
		this.plot = new Plot(x, y, width, depth);
	}

	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @param propertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * 
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * 
	 * @return a plot copy
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * print name, city, owner, rent, amount
	 */
	public String toString() {
		String str = "Property Name: " + propertyName + "\n" + "Located in: " + city + "\n" + "Belonging to: " + owner
				+ "\n" + "Rent Amount: " + rentAmount + " ";
		return str;
	}

}