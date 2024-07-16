package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restaurent_management_system.model.dao.LoginDao;
import restaurent_management_system.model.entity.Users;

@Component
public class LoginService {
	@Autowired
	LoginDao lDao;
	
	public Users loginValidate(Users user) {
		return lDao.loginValidate(user);
	}
	
}
