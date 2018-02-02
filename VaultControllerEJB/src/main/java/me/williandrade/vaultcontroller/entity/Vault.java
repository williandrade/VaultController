package me.williandrade.vaultcontroller.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the VAULT database table.
 * 
 */
@Entity
@Table(name = "VAULT")
public class Vault implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "AVAILABLE")
	private boolean available;

	@Column(name = "CURRENT_VALUE")
	private float currentValue;

	@Column(name = "NAME")
	private String name;

	// bi-directional many-to-one association to VaultTransaction
	@OneToMany(mappedBy = "vaultBean")
	private Set<VaultTransaction> vaultTransactions;

	// bi-directional many-to-one association to VaultTransaction
	@OneToMany(mappedBy = "vaultBean")
	private Set<VaultView> vaultViews;

	public Vault() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public float getCurrentValue() {
		return this.currentValue;
	}

	public void setCurrentValue(float currentValue) {
		this.currentValue = currentValue;
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

	public Set<VaultView> getVaultViews() {
		return vaultViews;
	}

	public void setVaultViews(Set<VaultView> vaultViews) {
		this.vaultViews = vaultViews;
	}

}