package fancyfoods.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

import fancyfoods.food.Food;

@Entity
public class FoodImpl implements Food {

	@Id
	private String name;
	private double price;
	private int quantityStock;

	public FoodImpl() {
	}

	public FoodImpl(String name, double price, int quantityStock) {
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public int getQuantityInStock() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getQuantityStock() {
		return quantityStock;
	}

	public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}

}
