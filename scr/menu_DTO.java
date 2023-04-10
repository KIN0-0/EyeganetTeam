
public class menu_DTO {
	String menuid,menu,category,image;
	int price;
	
	void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	void setMenu(String menu) {
		this.menu = menu;
	}
	void setPrice(int price) {
		this.price = price;
	}
	void setCategory(String category) {
		this.category = category;
	}
	void setImage(String image) {
		this.image = image;
	}
	
	String getMenuid() {
		return menuid;
	}
	String getMenu() {
		return menu;
	}
	int getPrice() {
		return price;
	}
	String getCategory() {
		return category;
	}
	String getImage() {
		return image;
	}
	
}
