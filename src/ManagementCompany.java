
public class ManagementCompany {

	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Property[] properties;
	private double mgmFeePer;
	private String name;
	private String taxID;
	private Plot plot;
	private int size = 0;
	private double highestRent = 0;

	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, 1, 1);
		this.properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(0, 0, 10, 10);
		this.properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public void setMgmFee(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}

	public void setPlot(Plot plot) {
		this.plot = new Plot(plot);
	}

	public String getName() {
		return name;
	}

	public String getTaxID() {
		return taxID;
	}

	public double getMgmFee() {
		return mgmFeePer;
	}

	public Plot getPlot() {
		return new Plot(plot);
	}

	/**
	 * 
	 * @param property
	 * @return
	 */

	public int addProperty(Property property) {

		// create a property array to hold each property

		if (size == MAX_PROPERTY)
			return -1;
		if (property == null)
			return -2;
		if (!plot.encompasses(property.getPlot()))
			return -3;
		for (int i = 0; i < size; i++) {
			if (properties[i].getPlot().overlaps(property.getPlot()))
				return -4;
		}

		properties[size] = property;

		return size++;

	}

	public int addProperty(String name, String city, double rent, String owner) {

		return addProperty(new Property(name, city, rent, owner));

	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {

		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}

	/**
	 * Access the stored property in the array at index i
	 * 
	 * @param i
	 * @return string of property
	 */
	private String displayPropertyAtIndex(int i) {

		String str = String.valueOf(properties[i]);
		return str;
	}

	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	public double maxRentProp() {

		for (int i = 0; i < size; i++) {
			if (properties[i].getRentAmount() > properties[0].getRentAmount()) {
				highestRent = properties[i].getRentAmount();
			}
		}
		return highestRent;
	}

	private int maxRentPropertyIndex() {

		int highestIndex = 0; // track max index

		for (int i = 0; i < size; i++) {
			if (properties[i].getRentAmount() > properties[0].getRentAmount()) {
				highestIndex = i;
			}
		}
		return highestIndex;
	}

	public double totalRent() {

		int total = 0; // track sum

		for (int i = 0; i < size; i++) {
			total += properties[i].getRentAmount();
		}
		return total;
	}

	/**
	 * print results
	 * 
	 */
	@Override
	public String toString() {
		String str = "";
		double fees; // store the fees charged

		System.out.println("List of the properties for " + name + " taxID: " + taxID);
		Property house = new Property();

		for (int i = 0; i < size; i++) {

			str += displayPropertyAtIndex(i);
			System.out.println(str);
		}
		fees = totalRent() * (mgmFeePer / 100);
		System.out.println("\nTotal management Fee: " + fees);
		return str;
	}

}
