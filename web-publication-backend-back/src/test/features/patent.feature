#Author: Izertis
#Keywords Summary : PatentController
Feature: Communication between Front Application and Backend PatentController

  Scenario: The front launches a request to the backend to find patents by a filters
    Given call to backend patent controller
    Then the controller call to servie and find patent result to send front
    