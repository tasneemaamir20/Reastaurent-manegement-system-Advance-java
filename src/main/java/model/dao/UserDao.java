package restaurent_management_system.model.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import restaurent_management_system.model.entity.Users;

@Component
public class UserDao extends HibernateDao{
	
	public List<Users> get_all_staff(Users user){
		Query query=em.createQuery("select s from Users s Where s.role= 'staff' and s.branch.id=?1");
		query.setParameter(1, user.getBranch().getId());
		List<Users> staffs=query.getResultList();
		if(!staffs.isEmpty()) {
			return staffs;
		}else {
			return null;
		}
		
		
		
	}
	
	public void add_staff(Users staff) {
		//adding staff in the DB
		et.begin();
		em.merge(staff);
		et.commit();
	}
	
}
