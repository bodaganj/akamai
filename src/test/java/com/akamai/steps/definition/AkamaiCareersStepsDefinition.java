package com.akamai.steps.definition;

import com.akamai.steps.AkamaiCareersSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.Assertions.assertThat;

public class AkamaiCareersStepsDefinition {

   @Steps
   private AkamaiCareersSteps productSteps;

   @Given("customer is on Akamai Careers page")
   public void openProductPage() {
      productSteps.openAkamaiCareersPage();
   }

   @When("customer specifies Find Your Career: $position")
   public void specifyFindYourCareerField(final String position) {
      productSteps.fillInSearchField(position);
   }

   @When("filter by country: $country")
   public void specifyFilterByCountryField(final String country) {
      productSteps.fillInFindByCountryField(country);
   }

   @Then("any job offers are found")
   public void anyJobOffersAreFound() {
      assertThat(areThereAnyJobOffers())
         .as("There should be any job offers.")
         .isTrue();
   }

   @Then("no job offers are found")
   public void noJobOffersAreFound() {
      assertThat(areThereAnyJobOffers())
         .as("There should be no job offers.")
         .isFalse();
   }

   private boolean areThereAnyJobOffers() {
      productSteps.clickSearch();
      return productSteps.anyJobOffersAreFound();
   }
}
