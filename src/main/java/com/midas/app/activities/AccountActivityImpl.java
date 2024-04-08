package com.midas.app.activities;

import com.midas.app.models.Account;
import com.midas.app.models.ProviderTypeEnum;
import com.midas.app.providers.external.stripe.StripePaymentProvider;
import com.midas.app.providers.payment.CreateAccount;
import com.midas.app.repositories.AccountRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import io.temporal.activity.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountActivityImpl implements AccountActivity {

  private final StripePaymentProvider stripePaymentProvider;
  private final AccountRepository accountRepository;

  @Override
  public void saveAccount(Account account) {
    accountRepository.save(account);
  }

  @Override
  public Account createPaymentAccount(Account account) {
    Account result = null;

    CustomerCreateParams paymentAccountParams =
        stripePaymentProvider.createAccount(grabOnlyImpDetailsForCreatingAccount(account));

    try {
      Customer customer = Customer.create(paymentAccountParams);
      result = grabNewCreatedAccountDetailsFromStripe(customer);
    } catch (StripeException e) {
      Activity.wrap(e);
    }

    return result;
  }

  private CreateAccount grabOnlyImpDetailsForCreatingAccount(Account account) {
    CreateAccount createAccount = new CreateAccount();
    createAccount.setFirstName(account.getFirstName());
    createAccount.setLastName(account.getLastName());
    createAccount.setEmail(account.getEmail());

    return createAccount;
  }

  private Account grabNewCreatedAccountDetailsFromStripe(Customer customer) {
    if (customer != null) {
      int index = customer.getName().indexOf("-");

      Account account = new Account();
      account.setFirstName(customer.getName().substring(0, index));
      account.setLastName(customer.getName().substring(index + 1));
      account.setEmail(customer.getEmail());
      account.setProviderId(customer.getId());
      account.setProviderTypeEnum(
          ProviderTypeEnum.valueOf(stripePaymentProvider.providerName().toUpperCase()));

      return account;
    } else {
      throw new RuntimeException("Something went wrong while creating account in Stripe");
    }
  }
}
