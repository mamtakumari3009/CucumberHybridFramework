Feature: Registeration functionality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to Register Account page
    When User Enter the details into below fields
      | firstName       | Mamta                            |
      | lastName        | Sharma                           |
      | telephone       |                       5987469126 |
      | password        |                            12364 |
      | confirmPassword |                            12364 |
    And User selects Privacy Policy checkbox
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates an account with all fields
    Given User navigates to Register Account page
    When User Enter the details into below fields
      | firstName       | Mamta                             |
      | lastName        | Sharma                            |
      | telephone       |                        5987469126 |
      | password        |                             12364 |
      | confirmPassword |                             12364 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy checkbox
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates a duplicate account with registered email address
    Given User navigates to Register Account page
    When User Enter the details into below fields with duplicate email
      | firstName       | Mamta                             |
      | lastName        | Sharma                            |
      | email           | soulmateconnection00080@gmail.com |
      | telephone       |                        5987469126 |
      | password        |                             12364 |
      | confirmPassword |                             12364 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy checkbox
    And User clicks on Continue button
    Then User account should get a proper warning message about duplicate email address

    Scenario: User creates an account without filling any details
    Given User navigates to Register Account page
    When User do not enter any details into fields
    And User clicks on Continue button
    Then User should get proper warning messages for all mandatory fields 