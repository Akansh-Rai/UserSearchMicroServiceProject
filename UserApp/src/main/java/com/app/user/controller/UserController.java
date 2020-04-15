/**
 * 
 */
package com.app.user.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.user.service.UserService;
import com.app.user.shared.dto.UserDto;
import com.app.user.ui.model.CreateUserRequestModel;
import com.app.user.ui.model.CreateUserResponseModel;

/**
 * @author Akansh_Rai
 *
 */
@RestController
@RequestMapping("/users")
@Consumes({ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE })
@Produces({ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE })
public class UserController {

	@Autowired
	private Environment env;

	@Autowired
	UserService userService;

	@GetMapping("/status/check")
	public String status() {
		return "Working fine. Port : " + env.getProperty("local.server.port");
	}

	@GetMapping
	public ResponseEntity<List<CreateUserResponseModel>> getUsers() {
		return null;// new ResponseEntity<List<CreateUserResponseModel>>(userService.getUsers(),
					// HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel user) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = mapper.map(user, UserDto.class);
		UserDto createdUser = userService.createUSer(userDto);
		CreateUserResponseModel returnValue = mapper.map(createdUser, CreateUserResponseModel.class);
		return new ResponseEntity<>(returnValue, HttpStatus.OK);
	}
}
