package me.williandrade.vaultcontroller.mapper;

import java.util.HashSet;

import java.util.Set;

import javax.annotation.Generated;

import javax.enterprise.context.ApplicationScoped;

import me.williandrade.vaultcontroller.dto.VaultTransactionDTO;

import me.williandrade.vaultcontroller.entity.User;

import me.williandrade.vaultcontroller.entity.Vault;

import me.williandrade.vaultcontroller.entity.VaultTransaction;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-10-20T17:22:56-0200",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class VaultTransactionMapperImpl implements VaultTransactionMapper {

    @Override

    public VaultTransactionDTO vaultTransactionToVaultTransactionDTO(VaultTransaction vaultTransaction) {

        if ( vaultTransaction == null ) {

            return null;
        }

        VaultTransactionDTO vaultTransactionDTO = new VaultTransactionDTO();

        vaultTransactionDTO.setVaultId( vaultTransactionVaultBeanId( vaultTransaction ) );

        vaultTransactionDTO.setUserId( vaultTransactionUserBeanId( vaultTransaction ) );

        vaultTransactionDTO.setId( vaultTransaction.getId() );

        vaultTransactionDTO.setInteractionDate( vaultTransaction.getInteractionDate() );

        vaultTransactionDTO.setValue( vaultTransaction.getValue() );

        return vaultTransactionDTO;
    }

    @Override

    public VaultTransaction vaultTransactionDTOToVaultTransaction(VaultTransactionDTO vaultTransactionDTO) {

        if ( vaultTransactionDTO == null ) {

            return null;
        }

        VaultTransaction vaultTransaction = new VaultTransaction();

        Vault vaultBean = new Vault();

        User userBean = new User();

        vaultTransaction.setUserBean( userBean );

        vaultTransaction.setVaultBean( vaultBean );

        userBean.setId( vaultTransactionDTO.getUserId() );

        vaultBean.setId( vaultTransactionDTO.getVaultId() );

        vaultTransaction.setId( vaultTransactionDTO.getId() );

        vaultTransaction.setInteractionDate( vaultTransactionDTO.getInteractionDate() );

        vaultTransaction.setValue( vaultTransactionDTO.getValue() );

        return vaultTransaction;
    }

    @Override

    public Set<VaultTransactionDTO> vaultTransactionsToVaultTransactionDTOs(Set<VaultTransaction> vaultTransactions) {

        if ( vaultTransactions == null ) {

            return null;
        }

        Set<VaultTransactionDTO> set = new HashSet<VaultTransactionDTO>();

        for ( VaultTransaction vaultTransaction : vaultTransactions ) {

            set.add( vaultTransactionToVaultTransactionDTO( vaultTransaction ) );
        }

        return set;
    }

    @Override

    public Set<VaultTransaction> vaultTransactionDTOsToVaultTransactions(Set<VaultTransactionDTO> vaultTransactionDTOs) {

        if ( vaultTransactionDTOs == null ) {

            return null;
        }

        Set<VaultTransaction> set = new HashSet<VaultTransaction>();

        for ( VaultTransactionDTO vaultTransactionDTO : vaultTransactionDTOs ) {

            set.add( vaultTransactionDTOToVaultTransaction( vaultTransactionDTO ) );
        }

        return set;
    }

    private int vaultTransactionVaultBeanId(VaultTransaction vaultTransaction) {

        if ( vaultTransaction == null ) {

            return 0;
        }

        Vault vaultBean = vaultTransaction.getVaultBean();

        if ( vaultBean == null ) {

            return 0;
        }

        int id = vaultBean.getId();

        return id;
    }

    private int vaultTransactionUserBeanId(VaultTransaction vaultTransaction) {

        if ( vaultTransaction == null ) {

            return 0;
        }

        User userBean = vaultTransaction.getUserBean();

        if ( userBean == null ) {

            return 0;
        }

        int id = userBean.getId();

        return id;
    }
}

