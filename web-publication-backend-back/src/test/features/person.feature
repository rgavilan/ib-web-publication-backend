#Author: Izertis
#Keywords Summary : PersonController
Feature: Communication between Front Application and Backend PersonController

  Scenario: The front launches a request to the backend to find persons
    Given call to backend person controller
    Then the controller call to servie and find person result to send front

  Scenario: The front launches a request to the backend to group persons by type of area
    Given call to backend university controller
    Then the controller call to servie to find and group persons by type of area to send front
