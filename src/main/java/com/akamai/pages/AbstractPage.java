package com.akamai.pages;

import com.akamai.items.utils.DataItemsFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

@Slf4j
@Getter
public class AbstractPage extends PageObject {

   private final DataItemsFactory dataItemsFactory;

   public AbstractPage(final WebDriver webDriver) {
      super(webDriver);
      dataItemsFactory = DataItemsFactory.getInstance();
   }

   @WhenPageOpens
   public void eventOpened() {
      final WebDriver.Window browserWindow = getDriver().manage().window();
      browserWindow.maximize();
      log.info("Browser got maximized, checking dimensions...");
      Dimension actualDimension = browserWindow.getSize();
      log.info("Width: {}, height: {}", actualDimension.getWidth(), actualDimension.getHeight());
   }
}
