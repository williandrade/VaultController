package me.williandrade.vaultcontroller.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the USER database table.
 * 
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	// bi-directional many-to-one association to VaultTransaction
	@OneToMany(mappedBy = "userBean")
	private Set<VaultTransaction> vaultTransactions;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<VaultTransaction> getVaultTransactions() {
		return this.vaultTransactions;
	}

	public void setVaultTransactions(Set<VaultTransaction> vaultTransactions) {
		this.vaultTransactions = vaultTransactions;
	}

}