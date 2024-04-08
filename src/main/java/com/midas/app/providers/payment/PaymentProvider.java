package com.midas.app.providers.payment;

import com.stripe.param.CustomerCreateParams;

public interface PaymentProvider {
  /** providerName is the name of the payment provider */
  String providerName();

  /**
   * createAccount creates a new account in the payment provider.
   *
   * @param details is the details of the account to be created.
   * @return Account
   */
  CustomerCreateParams createAccount(CreateAccount details);
}
