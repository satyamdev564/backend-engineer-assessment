package com.midas.app.repositories;

import com.midas.app.models.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

  Optional<Account> findByProviderId(String providerId);
}
