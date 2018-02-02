package me.williandrade.vaultcontroller.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import me.williandrade.vaultcontroller.dto.VaultTransactionDTO;
import me.williandrade.vaultcontroller.entity.VaultTransaction;

@Mapper(componentModel = "cdi")
public interface VaultTransactionMapper {

	@Mappings({ @Mapping(source = "vaultBean.id", target = "vaultId"),
			@Mapping(source = "userBean.id", target = "userId") })
	VaultTransactionDTO vaultTransactionToVaultTransactionDTO(VaultTransaction vaultTransaction);

	@Mappings({ @Mapping(source = "vaultId", target = "vaultBean.id"),
			@Mapping(source = "userId", target = "userBean.id") })
	VaultTransaction vaultTransactionDTOToVaultTransaction(VaultTransactionDTO vaultTransactionDTO);

	Set<VaultTransactionDTO> vaultTransactionsToVaultTransactionDTOs(Set<VaultTransaction> vaultTransactions);

	Set<VaultTransaction> vaultTransactionDTOsToVaultTransactions(Set<VaultTransactionDTO> vaultTransactionDTOs);

}
