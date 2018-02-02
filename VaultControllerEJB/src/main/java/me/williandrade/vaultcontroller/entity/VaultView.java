package me.williandrade.vaultcontroller.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the VAULT_VIEW database table.
 * 
 */
@Entity
@Table(name = "VAULT_VIEW")
public class VaultView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "AVAILABLE")
	private boolean available;

	@Column(name = "DAY_LIMIT")
	private int dayLimit;

	@Column(name = "NAME")
	private String name;

	@Column(name = "TYPE_LIMIT")
	private String typeLimit;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER")
	private User userBean;

	// bi-directional many-to-one association to Vault
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VAULT")
	private Vault vaultBean;

	@Column(name = "VIEW_LIMIT")
	private float viewLimit;

	public VaultView() {
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

	public int getDayLimit() {
		return this.dayLimit;
	}

	public void setDayLimit(int dayLimit) {
		this.dayLimit = dayLimit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeLimit() {
		return this.typeLimit;
	}

	public void setTypeLimit(String typeLimit) {
		this.typeLimit = typeLimit;
	}

	public Vault getVaultBean() {
		return this.vaultBean;
	}

	public void setVaultBean(Vault vaultBean) {
		this.vaultBean = vaultBean;
	}

	public User getUserBean() {
		return this.userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

	public float getViewLimit() {
		return this.viewLimit;
	}

	public void setViewLimit(float viewLimit) {
		this.viewLimit = viewLimit;
	}

}