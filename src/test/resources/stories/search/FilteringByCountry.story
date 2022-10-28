Meta:

Narrative:
Unlogged customer is able to search for a job

Scenario: Search for a job matching given criteria
Given customer is on Akamai Careers page
When customer specifies Find Your Career: Senior Software Development Engineer in Test
And filter by country: Poland
Then any job offers are found