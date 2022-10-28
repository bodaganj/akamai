package com.akamai.items.utils;

import com.akamai.pages.AbstractPage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
@AllArgsConstructor
public abstract class AbstractDataItem implements DataItem {

   private final AbstractPage driverDelegate;

   @Override
   public WebDriver getDriver() {
      return driverDelegate.getDriver();
   }
}
