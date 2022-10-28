package items.utils;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.locators.SmartFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import pages.AbstractPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class DataItemsFactory {

   private static DataItemsFactory instance;

   private DataItemsFactory() {
   }

   public static DataItemsFactory getInstance() {
      synchronized (DataItemsFactory.class) {
         if (Objects.isNull(instance)) {
            instance = new DataItemsFactory();
         }
      }
      return instance;
   }

   public <T extends DataItem> List<T> getElementsNamed(final Class<T> clazz,
                                                        final List<WebElementFacade> baseElements,
                                                        final AbstractPage driverDelegate) {
      final List<T> pageDataList = new ArrayList<>();
      log.info("Processing data lines of type {}", clazz.getCanonicalName());
      for (WebElementFacade baseElement : baseElements) {
         try {
            T dataItem = getElementNamed(clazz, baseElement, driverDelegate);
            pageDataList.add(dataItem);
         } catch (ReflectiveOperationException e) {
            log.error("Error instantiating data line object. Line for base element {} is not included to result " +
                         "list", baseElement.toString(), e);
         }
      }
      return pageDataList;
   }

   private <T extends DataItem> T getElementNamed(final Class<T> clazz,
                                                  final WebElementFacade baseElement,
                                                  final AbstractPage driverDelegate) throws ReflectiveOperationException {
      WebDriverAdaptor webDriverAdaptor = new WebDriverAdaptor(baseElement, driverDelegate.getDriver());
      ElementLocatorFactory finder = new DefaultElementLocatorFactory(webDriverAdaptor);
      FieldDecorator decorator = new SmartFieldDecorator(finder, webDriverAdaptor, driverDelegate);

      T dataItem = clazz.getDeclaredConstructor(AbstractPage.class).newInstance(driverDelegate);
      PageFactory.initElements(decorator, dataItem);
      log.debug("{}", dataItem);
      return dataItem;
   }
}
