
public abstract class Data {
	private String ID;
	private String Name;
	private int FabricPrice;
	private String FabricType;
	private int Stock;
	private int Disc;
	private int Price;
	
	public Data(String id, String name, int fabricPrice, String fabricType, int stock, int disc, int price) {
		super();
		this.ID = id;
		this.Name = name;
		this.FabricPrice = fabricPrice;
		this.FabricType = fabricType;
		this.Stock = stock;
		this.Disc = disc;
		this.Price = price;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public int getFabricPrice() {
		return FabricPrice;
	}

	public void setFabricPrice(int fabricPrice) {
		this.FabricPrice = fabricPrice;
	}

	public String getFabricType() {
		return FabricType;
	}

	public void setFabricType(String fabricType) {
		this.FabricType = fabricType;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		this.Stock = stock;
	}

	public int getDisc() {
		return Disc;
	}

	public void setDisc(int disc) {
		this.Disc = disc;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		this.Price = price;
	}

	public abstract void generateID();
}
