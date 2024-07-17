package restaurent_management_system.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value="prototype")
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="menu_seq_gen")
	@SequenceGenerator(name="menu_seq_gen",initialValue=201,sequenceName="menu_seq")
	private int id;
	
	@OneToOne
	@JoinColumn
	private Users user;
	
	@OneToMany(mappedBy="menu")
	private List<FoodProduct> foodproduct;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<FoodProduct> getFoodproduct() {
		return foodproduct;
	}

	public void setFoodproduct(List<FoodProduct> foodproduct) {
		this.foodproduct = foodproduct;
	}
	
}
