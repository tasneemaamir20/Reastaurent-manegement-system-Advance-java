package restaurent_management_system.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Entity
@Component
@Scope(value="prototype")
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="item_seq_gen")
	@SequenceGenerator(name="item_seq_gen",initialValue=301,sequenceName="item_seq")
	private int id;
	
	private int productid;
	private String name;
	private String type;
	private int quantity;
	private double price;
	
	@ManyToOne
	@JoinColumn
	private FoodOrder foodOrder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public FoodOrder getFoodorder() {
		return foodOrder;
	}

	public void setFoodorder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}
	
}
