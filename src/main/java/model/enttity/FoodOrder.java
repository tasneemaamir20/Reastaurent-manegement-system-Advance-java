package restaurent_management_system.model.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Entity
@Component
@Scope(value="prototype")
public class FoodOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="food_order_seq_gen")
	@SequenceGenerator(name="food_order_seq_gen",initialValue=401,sequenceName="food_order_seq")
	private int id;
	

	private String status;
	private double totalPrice;
	private LocalDate orderCreated;
	private LocalDate orderDeliveryTime;
	private String customerName;
	private long phone;
	
	@ManyToOne
	@JoinColumn
	private Users user;
	
	@OneToMany(mappedBy="foodOrder")
	private List<Item> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getOrderCreated() {
		return orderCreated;
	}

	public void setOrderCreated(LocalDate orderCreated) {
		this.orderCreated = orderCreated;
	}

	public LocalDate getOrderDeliveryTime() {
		return orderDeliveryTime;
	}

	public void setOrderDeliveryTime(LocalDate orderDeliveryTime) {
		this.orderDeliveryTime = orderDeliveryTime;
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
