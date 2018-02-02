package me.williandrade.vaultcontroller.dto;

import java.util.Date;

public class VaultViewDTO {

	private int id;
	private boolean available;
	private int dayLimit;
	private String name;
	private String typeLimit;
	private int vaultId;
	private int userId;
	private float viewLimit;
	private float viewActualLimit;
	private Date dateChange;
	private Date dateLastChange;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getDayLimit() {
		return dayLimit;
	}

	public void setDayLimit(int dayLimit) {
		this.dayLimit = dayLimit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeLimit() {
		return typeLimit;
	}

	public void setTypeLimit(String typeLimit) {
		this.typeLimit = typeLimit;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getViewLimit() {
		return viewLimit;
	}

	public void setViewLimit(float viewLimit) {
		this.viewLimit = viewLimit;
	}

	public int getVaultId() {
		return vaultId;
	}

	public void setVaultId(int vaultId) {
		this.vaultId = vaultId;
	}

	public float getViewActualLimit() {
		return viewActualLimit;
	}

	public void setViewActualLimit(float viewActualLimit) {
		this.viewActualLimit = viewActualLimit;
	}

	public Date getDateChange() {
		return dateChange;
	}

	public void setDateChange(Date dateChange) {
		this.dateChange = dateChange;
	}

	public Date getDateLastChange() {
		return dateLastChange;
	}

	public void setDateLastChange(Date dateLastChange) {
		this.dateLastChange = dateLastChange;
	}

}
