package me.williandrade.vaultcontroller.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import me.williandrade.vaultcontroller.entity.VaultTransaction;

@Stateless
@LocalBean
public class VaultTransactionDAO extends GenericDAO<VaultTransaction> {

	public VaultTransactionDAO() {
		super(VaultTransaction.class);
	}

	public Set<VaultTransaction> findAllByUserAndVoult(Integer userId, Integer vaultId) {
		String hql = "Select vt from VaultTransaction vt where vt.vaultBean.id = :vaultId and vt.userBean.id = :userId";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("vaultId", vaultId);
		query.setParameter("userId", userId);
		return new HashSet<VaultTransaction>(query.getResultList());
	}

	public Set<VaultTransaction> findAllByUserAndVoultAndDate(Integer userId, Integer vaultId, Date limit) {
		String hql = "Select vt from VaultTransaction vt where vt.vaultBean.id = :vaultId and vt.userBean.id = :userId and interactionDate >= :dateLimit";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("vaultId", vaultId);
		query.setParameter("userId", userId);
		query.setParameter("dateLimit", limit);
		return new HashSet<VaultTransaction>(query.getResultList());
	}

	// public Set<VaultTransaction> findAllByViewId(Integer viewId) {
	// String hql = "Select vt from VaultTransaction vt where vt.vaultBean.id =
	// :vaultId";
	// Query query = this.getEm().createQuery(hql);
	// query.setParameter("vaultId", vaultId);
	// return new HashSet<VaultTransaction>(query.getResultList());
	// }

	public Set<VaultTransaction> findAllByVoult(Integer vaultId) {
		String hql = "Select vt from VaultTransaction vt where vt.vaultBean.id = :vaultId";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("vaultId", vaultId);
		return new HashSet<VaultTransaction>(query.getResultList());
	}

}