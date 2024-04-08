package com.midas.app.services;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.midas.app.AccountServiceImpl;
import com.midas.app.DataProvider;
import com.midas.app.exceptions.ResourceNotFoundException;
import com.midas.app.models.Account;
import com.midas.app.repositories.AccountRepository;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {

  @InjectMocks private AccountServiceImpl accountServiceImpl;

  @Mock private AccountRepository accountRepository;

  @Test
  @DisplayName("Happy Flow - updating existing account details")
  void existingAccountDetailsGetsUpdated() {
    // Given
    Account account = DataProvider.account();

    // When
    when(accountRepository.findByProviderId(any())).thenReturn(Optional.of(account));
    accountServiceImpl.updateAccount(account);

    // Then
    verify(accountRepository, times(1)).save(any());
  }

  @Test
  @DisplayName("Account is not present in DB - Resource Not Found")
  void accountIsNotPresent() {
    // Given
    Account account = DataProvider.account();

    // When
    when(accountRepository.findByProviderId(any())).thenReturn(Optional.empty());

    ResourceNotFoundException exception =
        assertThrows(
            ResourceNotFoundException.class, () -> accountServiceImpl.updateAccount(account));

    // Then
    then("Resource not found").isEqualTo(exception.getMessage());
    verify(accountRepository, times(0)).save(any());
  }
}
