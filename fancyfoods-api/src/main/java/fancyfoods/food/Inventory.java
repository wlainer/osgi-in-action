package fancyfoods.food;

import java.util.List;

public interface Inventory {
	
	Food getFood(String name);
	
	List<Food> getFoodWhoseNameContains(String name, int maxResults);
	
	void createFood(String name, double price, int quantity);
	
	int removeStock(String name, int quantity);
	
	int getFoodCount();

}
