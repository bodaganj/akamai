package com.akamai.steps;

import com.akamai.pages.AkamaiCareersPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AkamaiCareersSteps extends ScenarioSteps {

   private AkamaiCareersPage akamaiCareersPage;

   @Step
   public void openAkamaiCareersPage() {
      akamaiCareersPage.open();
   }

   @Step
   public void fillInSearchField(String test) {
      akamaiCareersPage.getFindYourCareerInput().type(test);
   }

   @Step
   public void fillInFindByCountryField(String test) {
      akamaiCareersPage.getFilterByCountryInput().type(test);
   }

   @Step
   public void clickSearch() {
      akamaiCareersPage.getSearchButton().click();
   }

   @Step
   public boolean anyJobOffersAreFound() {
      return !akamaiCareersPage.getAllJobOffers().isEmpty();
   }
}
