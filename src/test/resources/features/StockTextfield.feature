Feature:  Stock select textfield

  Scenario Outline: Validate Stock select textfield

    Given Open the AI Stock Application
    When user selects stocks as <stock> and clicks on predict button
    Then Result should be display

   Examples: 
      | stock |
      | AAPL  |
      | AMZN  |
      | GOOG  |
      | META  |
      | TSLA  |