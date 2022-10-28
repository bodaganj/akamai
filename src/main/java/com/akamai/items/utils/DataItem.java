package com.akamai.items.utils;

import com.akamai.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public interface DataItem {

   AbstractPage getDriverDelegate();

   WebDriver getDriver();
}
