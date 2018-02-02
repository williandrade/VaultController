package me.williandrade.vaultcontroller.session;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import me.williandrade.vaultcontroller.dao.VaultDAO;
import me.williandrade.vaultcontroller.dto.VaultDTO;
import me.williandrade.vaultcontroller.entity.Vault;
import me.williandrade.vaultcontroller.mapper.VaultMapper;

@Stateless
@LocalBean
public class VaultSession {

	@EJB
	private VaultDAO vaultDAO;

	@Inject
	private VaultMapper vaultMapper;

	public List<VaultDTO> findAll() {
		Set<Vault> entitys = vaultDAO.findAll();
		Set<VaultDTO> dtos = vaultMapper.vaultsToVaultDTOs(entitys);

		List<VaultDTO> result = new ArrayList<>(dtos);

		result.sort((o1, o2) -> {
			return o1.getName().compareTo(o2.getName());
		});
		return result;
	}

}
