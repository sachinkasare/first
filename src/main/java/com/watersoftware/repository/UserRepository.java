package com.watersoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watersoftware.beans.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Integer> {

	public User findByUserid(int userid);
}
