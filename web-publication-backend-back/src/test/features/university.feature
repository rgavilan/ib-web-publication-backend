#Author: Izertis
#Keywords Summary : UniversityController
Feature: Communication between Front Application and Backend UniversityController

  Scenario: The front launches a request to the backend to find universities by a filters
    Given call to backend university controller
    Then the controller call to servie and find university result to send front

  Scenario: The front launches a request to the backend to group universities by quality seal
    Given call to backend university controller
    Then the controller call to servie to find and group universities by quality seal to send front
    
  Scenario: The front launches a request to the backend to group universities by financing
    Given call to backend university controller
    Then the controller call to servie to find and group universities by financing to send front
