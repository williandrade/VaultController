package me.williandrade.vaultcontroller.mapper;

import java.util.HashSet;

import java.util.Set;

import javax.annotation.Generated;

import javax.enterprise.context.ApplicationScoped;

import me.williandrade.vaultcontroller.dto.UserDTO;

import me.williandrade.vaultcontroller.entity.User;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-10-20T17:22:56-0200",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class UserMapperImpl implements UserMapper {

    @Override

    public UserDTO userToUserDTO(User user) {

        if ( user == null ) {

            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );

        userDTO.setName( user.getName() );

        return userDTO;
    }

    @Override

    public User userDTOToUser(UserDTO userDTO) {

        if ( userDTO == null ) {

            return null;
        }

        User user = new User();

        if ( userDTO.getId() != null ) {

            user.setId( userDTO.getId() );
        }

        user.setName( userDTO.getName() );

        return user;
    }

    @Override

    public Set<UserDTO> usersToUserDTOs(Set<User> users) {

        if ( users == null ) {

            return null;
        }

        Set<UserDTO> set = new HashSet<UserDTO>();

        for ( User user : users ) {

            set.add( userToUserDTO( user ) );
        }

        return set;
    }

    @Override

    public Set<User> userDTOsToUsers(Set<UserDTO> userDTOs) {

        if ( userDTOs == null ) {

            return null;
        }

        Set<User> set = new HashSet<User>();

        for ( UserDTO userDTO : userDTOs ) {

            set.add( userDTOToUser( userDTO ) );
        }

        return set;
    }
}

