package me.williandrade.vaultcontroller.session;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import me.williandrade.vaultcontroller.dao.UserDAO;
import me.williandrade.vaultcontroller.mapper.UserMapper;

@Stateless
@LocalBean
public class UserSession {

	@EJB
	private UserDAO userDAO;

	@Inject
	private UserMapper userMapper;

}
