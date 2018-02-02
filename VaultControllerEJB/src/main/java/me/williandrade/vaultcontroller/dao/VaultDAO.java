package me.williandrade.vaultcontroller.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import me.williandrade.vaultcontroller.entity.Vault;

@Stateless
@LocalBean
public class VaultDAO extends GenericDAO<Vault> {

	public VaultDAO() {
		super(Vault.class);
	}

}