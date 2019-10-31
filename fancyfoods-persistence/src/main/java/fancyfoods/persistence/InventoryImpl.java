package fancyfoods.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fancyfoods.food.Food;
import fancyfoods.food.Inventory;

public class InventoryImpl implements Inventory {

	EntityManager em;

	@Override
	public Food getFood(String name) {
		return em.find(FoodImpl.class, name);
	}

	@Override
	public List<Food> getFoodWhoseNameContains(String name, int maxResults) {
		String query = "SELECT f FROM FOOD f WHERE f.name LIKE '%" + name + "%' ORDER BY f.quantity DESC";
		Query q = em.createQuery(query);
		q.setMaxResults(maxResults);
		List<Food> list = q.getResultList();
		return list;
	}

	@Override
	public void createFood(String name, double price, int quantity) {
		FoodImpl food = new FoodImpl(name, price, quantity);
		em.persist(food);
	}

	@Override
	public int removeStock(String name, int quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFoodCount() {
		Query query = em.createQuery("SELECT COUNT(f) FROM FOOD f");
		Number count = (Number) query.getSingleResult();
		return count.intValue();
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
