package me.williandrade.vaultcontroller.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import me.williandrade.vaultcontroller.entity.VaultView;

@Stateless
@LocalBean
public class VaultViewDAO extends GenericDAO<VaultView> {

	public VaultViewDAO() {
		super(VaultView.class);
	}

	public Set<VaultView> findByVaultId(Integer vaultId) {
		String hql = "Select vv from VaultView vv where vv.vaultBean.id = :id";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("id", vaultId);
		return new HashSet<VaultView>(query.getResultList());
	}

}