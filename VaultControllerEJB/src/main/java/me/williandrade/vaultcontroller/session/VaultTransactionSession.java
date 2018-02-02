package me.williandrade.vaultcontroller.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import me.williandrade.vaultcontroller.dao.VaultTransactionDAO;
import me.williandrade.vaultcontroller.dto.VaultTransactionDTO;
import me.williandrade.vaultcontroller.dto.VaultViewDTO;
import me.williandrade.vaultcontroller.entity.VaultTransaction;
import me.williandrade.vaultcontroller.mapper.VaultTransactionMapper;

@Stateless
@LocalBean
public class VaultTransactionSession {

	@EJB
	private VaultTransactionDAO vaultTransactionDAO;

	@EJB
	private VaultViewSession vaultViewSession;

	@Inject
	private VaultTransactionMapper vaultTransactionMapper;

	public VaultTransactionDTO create(VaultTransactionDTO vaultTransaction) {
		vaultTransaction.setInteractionDate(new Date());
		VaultTransaction entity = vaultTransactionMapper.vaultTransactionDTOToVaultTransaction(vaultTransaction);
		entity = vaultTransactionDAO.insert(entity);
		vaultTransaction = vaultTransactionMapper.vaultTransactionToVaultTransactionDTO(entity);
		return vaultTransaction;
	}

	public List<VaultTransactionDTO> findAllByUserAndVoult(Integer userId, Integer vaultId) {
		Set<VaultTransaction> entitys = vaultTransactionDAO.findAllByUserAndVoult(userId, vaultId);
		Set<VaultTransactionDTO> dtos = vaultTransactionMapper.vaultTransactionsToVaultTransactionDTOs(entitys);

		List<VaultTransactionDTO> result = new ArrayList<>(dtos);

		result.sort((o1, o2) -> {
			return o1.getInteractionDate().compareTo(o2.getInteractionDate());
		});
		return result;
	}

	public List<VaultTransactionDTO> findAllByUserAndVoultAndDate(Integer userId, Integer vaultId, Date limit) {
		Set<VaultTransaction> entitys = vaultTransactionDAO.findAllByUserAndVoultAndDate(userId, vaultId, limit);
		Set<VaultTransactionDTO> dtos = vaultTransactionMapper.vaultTransactionsToVaultTransactionDTOs(entitys);

		List<VaultTransactionDTO> result = new ArrayList<>(dtos);

		result.sort((o1, o2) -> {
			return o1.getInteractionDate().compareTo(o2.getInteractionDate());
		});
		return result;
	}

	public List<VaultTransactionDTO> findAllByView(Integer viewId) {
		VaultViewDTO vaultViewDTO = vaultViewSession.findById(viewId);

		return this.findAllByUserAndVoult(vaultViewDTO.getUserId(), vaultViewDTO.getVaultId());
	}

	public List<VaultTransactionDTO> findAllFromPeriodByView(Integer viewId) {
		VaultViewDTO vaultViewDTO = vaultViewSession.findById(viewId);
		Date lastChange = vaultViewSession.getLastViewDateChange(vaultViewDTO);
		return this.findAllByUserAndVoultAndDate(vaultViewDTO.getUserId(), vaultViewDTO.getVaultId(), lastChange);
	}

	public List<VaultTransactionDTO> findAllByVoult(Integer vaultId) {
		Set<VaultTransaction> entitys = vaultTransactionDAO.findAllByVoult(vaultId);
		Set<VaultTransactionDTO> dtos = vaultTransactionMapper.vaultTransactionsToVaultTransactionDTOs(entitys);

		List<VaultTransactionDTO> result = new ArrayList<>(dtos);

		result.sort((o1, o2) -> {
			return o1.getInteractionDate().compareTo(o2.getInteractionDate());
		});
		return result;
	}
	
	public void delete(Integer transactionId) {
		vaultTransactionDAO.delete(transactionId);
	}

}
