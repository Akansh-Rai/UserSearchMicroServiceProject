/**
 * 
 */
package com.app.accountmanagement.ws.AccountManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akansh_Rai
 *
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	@GetMapping
	public String getAccount() {
		return "Welcome to account";
	}
}
