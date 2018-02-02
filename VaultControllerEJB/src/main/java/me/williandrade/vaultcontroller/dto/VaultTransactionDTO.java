package me.williandrade.vaultcontroller.dto;

import java.util.Date;

public class VaultTransactionDTO {

	private int id;
	private Date interactionDate;
	private float value;
	private int vaultId;
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getInteractionDate() {
		return interactionDate;
	}

	public void setInteractionDate(Date interactionDate) {
		this.interactionDate = interactionDate;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getVaultId() {
		return vaultId;
	}

	public void setVaultId(int vaultId) {
		this.vaultId = vaultId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
