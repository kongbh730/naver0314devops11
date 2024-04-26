package test.data;

public class CarDto {
	private String model;
	private String photo;
	private int price;
	private int count;
	private String color;
	
	public CarDto() {
		super();
	}

	public CarDto(String model, String photo, int price, int count, String color) {
		super();
		this.model = model;
		this.photo = photo;
		this.price = price;
		this.count = count;
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
