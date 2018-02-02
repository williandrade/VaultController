package me.williandrade.vaultcontroller.mapper;

import java.util.HashSet;

import java.util.Set;

import javax.annotation.Generated;

import javax.enterprise.context.ApplicationScoped;

import me.williandrade.vaultcontroller.dto.VaultDTO;

import me.williandrade.vaultcontroller.entity.Vault;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-10-20T17:22:56-0200",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class VaultMapperImpl implements VaultMapper {

    @Override

    public VaultDTO vaultToVaultDTO(Vault vault) {

        if ( vault == null ) {

            return null;
        }

        VaultDTO vaultDTO = new VaultDTO();

        vaultDTO.setId( vault.getId() );

        vaultDTO.setAvailable( vault.getAvailable() );

        vaultDTO.setCurrentValue( vault.getCurrentValue() );

        vaultDTO.setName( vault.getName() );

        return vaultDTO;
    }

    @Override

    public Vault vaultDTOToVault(VaultDTO vaultDTO) {

        if ( vaultDTO == null ) {

            return null;
        }

        Vault vault = new Vault();

        vault.setId( vaultDTO.getId() );

        vault.setAvailable( vaultDTO.isAvailable() );

        vault.setCurrentValue( vaultDTO.getCurrentValue() );

        vault.setName( vaultDTO.getName() );

        return vault;
    }

    @Override

    public Set<VaultDTO> vaultsToVaultDTOs(Set<Vault> vaults) {

        if ( vaults == null ) {

            return null;
        }

        Set<VaultDTO> set = new HashSet<VaultDTO>();

        for ( Vault vault : vaults ) {

            set.add( vaultToVaultDTO( vault ) );
        }

        return set;
    }

    @Override

    public Set<Vault> vaultDTOsToVaults(Set<VaultDTO> vaultDTOs) {

        if ( vaultDTOs == null ) {

            return null;
        }

        Set<Vault> set = new HashSet<Vault>();

        for ( VaultDTO vaultDTO : vaultDTOs ) {

            set.add( vaultDTOToVault( vaultDTO ) );
        }

        return set;
    }
}

