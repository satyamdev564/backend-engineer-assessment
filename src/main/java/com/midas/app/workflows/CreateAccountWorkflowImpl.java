package com.midas.app.workflows;

import com.midas.app.activities.AccountActivity;
import com.midas.app.models.Account;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import java.time.Duration;
import org.slf4j.Logger;

public class CreateAccountWorkflowImpl implements CreateAccountWorkflow {

  private final Logger logger = Workflow.getLogger(CreateAccountWorkflowImpl.class);
  ActivityOptions options =
      ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(5)).build();

  private final AccountActivity activities =
      Workflow.newActivityStub(AccountActivity.class, options);

  @Override
  public Account createAccount(Account details) {

    Account createdCustomerAccount = activities.createPaymentAccount(details);
    logger.info("initiating saving Stripe Account in local DB");

    if (createdCustomerAccount != null) {
      activities.saveAccount(createdCustomerAccount);
      logger.info("saving completed with customer id : {}", createdCustomerAccount.getProviderId());
      return createdCustomerAccount;
    } else {
      throw new RuntimeException("Something went wrong while communicating with stripe");
    }
  }
}
