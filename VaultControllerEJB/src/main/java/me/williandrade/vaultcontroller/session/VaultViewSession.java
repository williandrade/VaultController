package me.williandrade.vaultcontroller.session;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import me.williandrade.vaultcontroller.dao.VaultViewDAO;
import me.williandrade.vaultcontroller.dto.VaultTransactionDTO;
import me.williandrade.vaultcontroller.dto.VaultViewDTO;
import me.williandrade.vaultcontroller.entity.VaultView;
import me.williandrade.vaultcontroller.mapper.VaultViewMapper;
import me.williandrade.vaultcontroller.util.Constants;

@Stateless
@LocalBean
public class VaultViewSession {

	@EJB
	private VaultViewDAO vaultViewDAO;

	@EJB
	private VaultTransactionSession vaultTransactionSession;

	@Inject
	private VaultViewMapper vaultViewMapper;

	public VaultViewDTO findById(Integer id) {
		VaultView vaultView = vaultViewDAO.findById(id);
		return vaultViewMapper.vaultViewToVaultViewDTO(vaultView);
	}

	public VaultViewDTO findByIdComplete(Integer id) {
		VaultView vaultView = vaultViewDAO.findById(id);
		VaultViewDTO result = vaultViewMapper.vaultViewToVaultViewDTO(vaultView);
		this.calculateDTO(result);
		return result;
	}

	public List<VaultViewDTO> findAll() {
		Set<VaultView> entitys = vaultViewDAO.findAll();
		Set<VaultViewDTO> dtos = vaultViewMapper.vaultViewsToVaultViewDTOs(entitys);

		List<VaultViewDTO> result = new ArrayList<>(dtos);

		result.sort((o1, o2) -> {
			return o1.getName().compareTo(o2.getName());
		});
		return result;
	}

	public List<VaultViewDTO> findByVaultId(Integer vaultId) {
		Set<VaultView> entitys = vaultViewDAO.findByVaultId(vaultId);
		Set<VaultViewDTO> dtos = vaultViewMapper.vaultViewsToVaultViewDTOs(entitys);

		List<VaultViewDTO> result = new ArrayList<>(dtos);

		result.sort((o1, o2) -> {
			return o1.getName().compareTo(o2.getName());
		});
		return result;
	}

	public Date getLastViewDateChangeById(Integer id) {
		VaultViewDTO dto = this.findById(id);
		return this.getLastViewDateChange(dto);
	}

	public Date getLastViewDateChange(VaultViewDTO dto) {
		return this.getBeforeNear(dto.getDayLimit(), dto.getTypeLimit());
	}

	private float getActualViewLimit(VaultViewDTO dto) {
		float result = dto.getViewLimit();

		List<VaultTransactionDTO> transactions = vaultTransactionSession.findAllFromPeriodByView(dto.getId());

		for (VaultTransactionDTO transaction : transactions) {
			result = result + transaction.getValue();
		}
		

		return result;
	}

	private void calculateDTO(VaultViewDTO dto) {
		dto.setDateChange(this.getNextNear(dto.getDayLimit(), dto.getTypeLimit()));
		dto.setDateLastChange(this.getBeforeNear(dto.getDayLimit(), dto.getTypeLimit()));
		dto.setViewActualLimit(this.getActualViewLimit(dto));
	}

	private Date getNextNear(int dayLimit, String typeLimit) {
		LocalDate dateChange = LocalDate.now(ZoneId.of(Constants.ZONE));
		LocalDate currentDate = LocalDate.now(ZoneId.of(Constants.ZONE));

		switch (typeLimit) {
		case "MONTH":
			int currentDay = currentDate.getDayOfMonth();

			if (currentDay >= dayLimit) {
				dateChange = dateChange.plusMonths(1);
			}

			dateChange = dateChange.withDayOfMonth(dayLimit);
			break;
		default:
			break;
		}

		return java.util.Date.from(dateChange.atStartOfDay(ZoneId.of(Constants.ZONE)).toInstant());
	}

	private Date getBeforeNear(int dayLimit, String typeLimit) {
		LocalDate dateChange = LocalDate.now(ZoneId.of(Constants.ZONE));
		LocalDate currentDate = LocalDate.now(ZoneId.of(Constants.ZONE));

		switch (typeLimit) {
		case "MONTH":
			int currentDay = currentDate.getDayOfMonth();

			if (currentDay <= dayLimit) {
				dateChange = dateChange.plusMonths(-1);
			}

			dateChange = dateChange.withDayOfMonth(dayLimit);
			break;
		default:
			break;
		}

		return java.util.Date.from(dateChange.atStartOfDay(ZoneId.of(Constants.ZONE)).toInstant());
	}
}
