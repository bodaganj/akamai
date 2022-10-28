package com.akamai.pages;

import com.akamai.items.JobOfferItem;
import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
@DefaultUrl("https://akamaicareers.inflightcloud.com")
public class AkamaiCareersPage extends AbstractPage {

   @FindBy(xpath = ".//*[@id='keywordLocation']")
   public WebElementFacade findYourCareerInput;

   @FindBy(xpath = ".//*[@id='location']")
   public WebElementFacade filterByCountryInput;

   @FindBy(xpath = ".//*[@title='Search']")
   public WebElementFacade searchButton;

   private final String jobOfferXPath = ".//*[contains(@class,'list-group-item')]";

   @FindBy(xpath = ".//*[@class='list-group']")
   public WebElementFacade jobOffersList;

   public AkamaiCareersPage(WebDriver webDriver) {
      super(webDriver);
   }

   public List<JobOfferItem> getAllJobOffers() {
      return getDataItemsFactory().getElementsNamed(JobOfferItem.class, jobOffersList.thenFindAll(jobOfferXPath), this);
   }
}
