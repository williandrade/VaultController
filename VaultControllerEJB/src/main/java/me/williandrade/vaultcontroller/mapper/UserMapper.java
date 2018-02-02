package me.williandrade.vaultcontroller.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import me.williandrade.vaultcontroller.dto.UserDTO;
import me.williandrade.vaultcontroller.entity.User;

@Mapper(componentModel = "cdi")
public interface UserMapper {
	
	UserDTO userToUserDTO(User user);

	User userDTOToUser(UserDTO userDTO);

	Set<UserDTO> usersToUserDTOs(Set<User> users);

	Set<User> userDTOsToUsers(Set<UserDTO> userDTOs);

}
