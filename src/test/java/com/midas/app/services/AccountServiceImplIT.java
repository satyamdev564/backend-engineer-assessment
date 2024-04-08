package com.midas.app.services;

import com.midas.app.AccountServiceImpl;
import com.midas.app.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestPropertySource(locations = "classpath:application-test.properties")
public class AccountServiceImplIT {

  @Autowired private AccountServiceImpl accountServiceImpl;
  @MockBean private AccountRepository accountRepository;

  //  @Test
  //  @DisplayName("Updated an existing Account")
  //  void accountIsUpdated() {
  //    // Given
  //    Account account = DataProvider.accountDetails();
  //    accountRepository.save(account);
  //
  //    // When
  //    Account updatedAccount =
  // accountServiceImpl.updateAccount(DataProvider.updateAccountDetails());
  //
  //    // Then
  //    verify(accountRepository, times(1)).save(any());
  //    then(account.getFirstName()).isNotEqualTo(updatedAccount.getFirstName());
  //    then(account.getLastName()).isNotEqualTo(updatedAccount.getLastName());
  //    then(account.getEmail()).isNotEqualTo(updatedAccount.getEmail());
  //  }
}
