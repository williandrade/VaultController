package me.williandrade.vaultcontroller.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the VAULT_TRANSACTIONS database table.
 * 
 */
@Entity
@Table(name = "VAULT_TRANSACTIONS")
public class VaultTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INTERACTION_DATE")
	private Date interactionDate;

	@Column(name = "VALUE")
	private float value;

	// bi-directional many-to-one association to Vault
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VAULT")
	private Vault vaultBean;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER")
	private User userBean;

	public VaultTransaction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getInteractionDate() {
		return this.interactionDate;
	}

	public void setInteractionDate(Date interactionDate) {
		this.interactionDate = interactionDate;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
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

}