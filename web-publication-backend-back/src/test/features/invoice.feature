#Author: Izertis
#Keywords Summary : InvoiceController
Feature: Communication between Front Application and Backend InvoiceController

  Scenario: The front launches a request to the backend to find invoices by a filters
    Given call to backend invoice controller
    Then the controller call to servie and find invoice result to send front
    