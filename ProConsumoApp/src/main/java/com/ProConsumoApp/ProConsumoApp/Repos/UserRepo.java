package com.ProConsumoApp.ProConsumoApp.Repos;

import com.ProConsumoApp.ProConsumoApp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

    public User findByNombre(String nombre);
}
