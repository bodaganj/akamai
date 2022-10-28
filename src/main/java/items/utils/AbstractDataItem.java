package items.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pages.AbstractPage;

@Getter
@AllArgsConstructor
public abstract class AbstractDataItem implements DataItem {

   private final AbstractPage driverDelegate;

   @Override
   public WebDriver getDriver() {
      return driverDelegate.getDriver();
   }
}
