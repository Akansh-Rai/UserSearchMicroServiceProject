/**
 * 
 */
package com.app.user.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.user.shared.dto.UserDto;

/**
 * @author Akansh_Rai
 *
 */
public interface UserService extends UserDetailsService {

	public UserDto createUSer(UserDto Details);

	public List<UserDto> getUsers();

	public UserDto getUserDetailsByEmail(String email);
}
