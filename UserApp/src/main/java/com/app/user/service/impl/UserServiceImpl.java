/**
 * 
 */
package com.app.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.user.data.UserEntity;
import com.app.user.data.UserRepository;
import com.app.user.service.UserService;
import com.app.user.shared.dto.UserDto;

/**
 * @author Akansh_Rai
 *
 */
@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository _repository, BCryptPasswordEncoder _passwordEncoder) {
		this.userRepository = _repository;
		this.passwordEncoder = _passwordEncoder;
	}

	@Override
	public UserDto createUSer(UserDto user) {
		user.setUserId(UUID.randomUUID().toString());
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserEntity userEntity = mapper.map(user, UserEntity.class);
		userEntity.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));

		userRepository.save(userEntity);

		user = mapper.map(userEntity, UserDto.class);
		return user;
	}

	@Override
	public List<UserDto> getUsers() {
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(username);
		if (userEntity == null)
			throw new UsernameNotFoundException(username);
		
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true,
				new ArrayList<>());
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity == null)
			throw new UsernameNotFoundException(email);
		
		return new ModelMapper().map(userEntity, UserDto.class);
		
	}

}
