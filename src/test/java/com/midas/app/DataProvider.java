package com.midas.app;

import com.midas.app.models.Account;
import com.midas.app.models.ProviderTypeEnum;
import java.time.OffsetDateTime;
import java.util.UUID;

public class DataProvider {

  public static Account account() {
    return Account.builder()
        .id(UUID.randomUUID())
        .firstName("dwyane")
        .lastName("johnson")
        .email("therock@gmail.com")
        .createdAt(OffsetDateTime.now())
        .updatedAt(OffsetDateTime.now())
        .providerId("cus_123")
        .providerTypeEnum(ProviderTypeEnum.STRIPE)
        .build();
  }

  public static Account updateAccountDetails() {
    return Account.builder()
        .firstName("brock")
        .lastName("lesnar")
        .email("brocklesnar@gmail.com")
        .build();
  }

  public static Account accountDetails() {
    return Account.builder().firstName("john").lastName("cena").email("johncena@gmail.com").build();
  }
}
