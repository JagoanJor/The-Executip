import java.util.Random;

public class Limited extends Data{
	Random rand = new Random();
	
	private String createID;

	public Limited(String id, String name, int fabricPrice, String fabricType, int stock, int disc, int price) {
		super(id, name, fabricPrice, fabricType, stock, disc, price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void generateID() {
		createID = "LI" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		setID(createID);
	}

}
