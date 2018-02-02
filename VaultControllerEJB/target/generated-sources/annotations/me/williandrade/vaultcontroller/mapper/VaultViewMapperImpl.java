package me.williandrade.vaultcontroller.mapper;

import java.util.HashSet;

import java.util.Set;

import javax.annotation.Generated;

import javax.enterprise.context.ApplicationScoped;

import me.williandrade.vaultcontroller.dto.VaultViewDTO;

import me.williandrade.vaultcontroller.entity.User;

import me.williandrade.vaultcontroller.entity.Vault;

import me.williandrade.vaultcontroller.entity.VaultView;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-10-20T17:22:56-0200",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class VaultViewMapperImpl implements VaultViewMapper {

    @Override

    public VaultViewDTO vaultViewToVaultViewDTO(VaultView vaultView) {

        if ( vaultView == null ) {

            return null;
        }

        VaultViewDTO vaultViewDTO = new VaultViewDTO();

        vaultViewDTO.setVaultId( vaultViewVaultBeanId( vaultView ) );

        vaultViewDTO.setUserId( vaultViewUserBeanId( vaultView ) );

        vaultViewDTO.setId( vaultView.getId() );

        vaultViewDTO.setAvailable( vaultView.getAvailable() );

        vaultViewDTO.setDayLimit( vaultView.getDayLimit() );

        vaultViewDTO.setName( vaultView.getName() );

        vaultViewDTO.setTypeLimit( vaultView.getTypeLimit() );

        vaultViewDTO.setViewLimit( vaultView.getViewLimit() );

        return vaultViewDTO;
    }

    @Override

    public VaultView vaultViewDTOToVaultView(VaultViewDTO vaultViewDTO) {

        if ( vaultViewDTO == null ) {

            return null;
        }

        VaultView vaultView = new VaultView();

        Vault vaultBean = new Vault();

        User userBean = new User();

        vaultView.setUserBean( userBean );

        vaultView.setVaultBean( vaultBean );

        userBean.setId( vaultViewDTO.getUserId() );

        vaultBean.setId( vaultViewDTO.getVaultId() );

        vaultView.setId( vaultViewDTO.getId() );

        vaultView.setAvailable( vaultViewDTO.isAvailable() );

        vaultView.setDayLimit( vaultViewDTO.getDayLimit() );

        vaultView.setName( vaultViewDTO.getName() );

        vaultView.setTypeLimit( vaultViewDTO.getTypeLimit() );

        vaultView.setViewLimit( vaultViewDTO.getViewLimit() );

        return vaultView;
    }

    @Override

    public Set<VaultViewDTO> vaultViewsToVaultViewDTOs(Set<VaultView> vaultViews) {

        if ( vaultViews == null ) {

            return null;
        }

        Set<VaultViewDTO> set = new HashSet<VaultViewDTO>();

        for ( VaultView vaultView : vaultViews ) {

            set.add( vaultViewToVaultViewDTO( vaultView ) );
        }

        return set;
    }

    @Override

    public Set<VaultView> vaultViewDTOsToVaultViews(Set<VaultViewDTO> vaultViewDTOs) {

        if ( vaultViewDTOs == null ) {

            return null;
        }

        Set<VaultView> set = new HashSet<VaultView>();

        for ( VaultViewDTO vaultViewDTO : vaultViewDTOs ) {

            set.add( vaultViewDTOToVaultView( vaultViewDTO ) );
        }

        return set;
    }

    private int vaultViewVaultBeanId(VaultView vaultView) {

        if ( vaultView == null ) {

            return 0;
        }

        Vault vaultBean = vaultView.getVaultBean();

        if ( vaultBean == null ) {

            return 0;
        }

        int id = vaultBean.getId();

        return id;
    }

    private int vaultViewUserBeanId(VaultView vaultView) {

        if ( vaultView == null ) {

            return 0;
        }

        User userBean = vaultView.getUserBean();

        if ( userBean == null ) {

            return 0;
        }

        int id = userBean.getId();

        return id;
    }
}

