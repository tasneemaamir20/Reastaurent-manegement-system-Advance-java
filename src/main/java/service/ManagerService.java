package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restaurent_management_system.model.dao.UserDao;
import restaurent_management_system.model.entity.Users;

@Component
public class ManagerService {
	@Autowired
	UserDao uDao;
	
		public List<Users> get_all_staff(Users user){
			return uDao.get_all_staff(user);
		}
		
		public boolean add_staff(Users staff) {
			int before=0;
			try {
				before=get_all_staff(staff).size();
			}catch(NullPointerException e) {
				
			}
			uDao.add_staff(staff);
			int after=0;
			try {
				after=get_all_staff(staff).size();
			}catch(NullPointerException e) {
				
			}
			
			
			return (after>before)?true:false;
			
		}
}
