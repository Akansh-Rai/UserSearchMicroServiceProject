/**
 * 
 */
package com.app.user.data;

import org.springframework.data.repository.CrudRepository;;

/**
 * @author Akansh_Rai
 *
 */
public interface UserRepository extends  CrudRepository<UserEntity, Long>{
	
	
	UserEntity findByEmail(String email);
	
}
