#Author: Izertis
#Keywords Summary : ProjectController
Feature: Communication between Front Application and Backend ProjectController

  Scenario: The front launches a request to the backend to find projects by a filters
    Given call to backend project controller
    Then the controller call to servie and find project result to send front
    