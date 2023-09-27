package org.softuni.mobilele.repository;

import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.service.UserService;
import org.softuni.mobilele.service.impl.UserServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
