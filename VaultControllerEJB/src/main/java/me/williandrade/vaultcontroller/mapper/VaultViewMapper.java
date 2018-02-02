package me.williandrade.vaultcontroller.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import me.williandrade.vaultcontroller.dto.VaultViewDTO;
import me.williandrade.vaultcontroller.entity.VaultView;

@Mapper(componentModel = "cdi")
public interface VaultViewMapper {

	@Mappings({ @Mapping(source = "vaultBean.id", target = "vaultId"),
			@Mapping(source = "userBean.id", target = "userId") })
	VaultViewDTO vaultViewToVaultViewDTO(VaultView vaultView);

	@Mappings({ @Mapping(source = "vaultId", target = "vaultBean.id"),
			@Mapping(source = "userId", target = "userBean.id") })
	VaultView vaultViewDTOToVaultView(VaultViewDTO vaultViewDTO);

	Set<VaultViewDTO> vaultViewsToVaultViewDTOs(Set<VaultView> vaultViews);

	Set<VaultView> vaultViewDTOsToVaultViews(Set<VaultViewDTO> vaultViewDTOs);

}