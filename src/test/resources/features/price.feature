Feature: Get price by date, product, and brand

  Scenario: Test 1 - Request at 10:00 on June 14 for product 35455 and brand 1
    Given the application is running
    When I send a request to "/price" with:
      | applicationDate       | productId | brandId |
      | 2020-06-14T10:00:00   | 35455     | 1       |
    Then the response status should be 200
    And the response should contain:
      | field     | value   |
      | productId | 35455   |
      | brandId   | 1       |
      | price     | 35.50   |

  Scenario: Test 2 - Request at 16:00 on June 14 for product 35455 and brand 1
    Given the application is running
    When I send a request to "/price" with:
      | applicationDate       | productId | brandId |
      | 2020-06-14T16:00:00   | 35455     | 1       |
    Then the response status should be 200
    And the response should contain:
      | field     | value   |
      | productId | 35455   |
      | brandId   | 1       |
      | price     | 25.45   |

  Scenario: Test 3 - Request at 21:00 on June 14 for product 35455 and brand 1
    Given the application is running
    When I send a request to "/price" with:
      | applicationDate       | productId | brandId |
      | 2020-06-14T21:00:00   | 35455     | 1       |
    Then the response status should be 200
    And the response should contain:
      | field     | value   |
      | productId | 35455   |
      | brandId   | 1       |
      | price     | 35.50   |

  Scenario: Test 4 - Request at 10:00 on June 15 for product 35455 and brand 1
    Given the application is running
    When I send a request to "/price" with:
      | applicationDate       | productId | brandId |
      | 2020-06-15T10:00:00   | 35455     | 1       |
    Then the response status should be 200
    And the response should contain:
      | field     | value   |
      | productId | 35455   |
      | brandId   | 1       |
      | price     | 30.50   |

  Scenario: Test 5 - Request at 21:00 on June 16 for product 35455 and brand 1
    Given the application is running
    When I send a request to "/price" with:
      | applicationDate       | productId | brandId |
      | 2020-06-16T21:00:00   | 35455     | 1       |
    Then the response status should be 200
    And the response should contain:
      | field     | value   |
      | productId | 35455   |
      | brandId   | 1       |
      | price     | 38.95   |
