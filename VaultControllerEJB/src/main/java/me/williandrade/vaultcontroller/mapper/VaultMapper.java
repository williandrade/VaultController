package me.williandrade.vaultcontroller.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import me.williandrade.vaultcontroller.dto.VaultDTO;
import me.williandrade.vaultcontroller.entity.Vault;

@Mapper(componentModel = "cdi")
public interface VaultMapper {

	VaultDTO vaultToVaultDTO(Vault vault);

	Vault vaultDTOToVault(VaultDTO vaultDTO);

	Set<VaultDTO> vaultsToVaultDTOs(Set<Vault> vaults);

	Set<Vault> vaultDTOsToVaults(Set<VaultDTO> vaultDTOs);

}
