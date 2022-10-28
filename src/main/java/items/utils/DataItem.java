package items.utils;

import org.openqa.selenium.WebDriver;
import pages.AbstractPage;

public interface DataItem {

   AbstractPage getDriverDelegate();

   WebDriver getDriver();
}
