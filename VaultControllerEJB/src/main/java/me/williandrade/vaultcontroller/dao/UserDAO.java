package me.williandrade.vaultcontroller.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import me.williandrade.vaultcontroller.entity.User;

@Stateless
@LocalBean
public class UserDAO extends GenericDAO<User> {

	public UserDAO() {
		super(User.class);
	}

}
