#Author: Izertis
#Keywords Summary : ProjectController
Feature: Communication between ontological infrastructure and semantic infrastructure

  Scenario: The front launches a request to the backend to find projects by a filters
    Given call to backend project controller
    Then the controller call to servie and find result to send front
    