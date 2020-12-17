#Author: Izertis
#Keywords Summary : BookController
Feature: Communication between Front Application and Backend BookController

  Scenario: The front launches a request to the backend to find books by a filters
    Given call to backend book controller
    Then the controller call to servie and find book result to send front
    