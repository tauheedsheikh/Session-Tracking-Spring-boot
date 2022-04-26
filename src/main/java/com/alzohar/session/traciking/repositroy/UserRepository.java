package com.alzohar.session.traciking.repositroy;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alzohar.session.traciking.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	
	@Query("SELECT u FROM User u WHERE u.email =:email")
	public User findByEmail( String email);


}

