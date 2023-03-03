Feature: Client - Registration

Scenario: Client - Registration - successful

Given a client register to the API

    | userId     | 01               |
    | username   | wilma            |
    | firstName  | Wilma            |
    | lastName   | Armstrong        |
    | email      | wilma@gmail.com  |
    | password   | wilma            |

    # | user_id   | username  | firstName | lastName      | email             | password  |
    # | 01        | wilma     | Wilma     | Armstrong     | wilma@gmail.com   | wilma     |

When API receives request at POST http://localhost:8080/signup endpoint

Then the response has: 
* http status: 200
* response body message as "User registered successfully."



Scenario Outline: Client - Registration - successful/unsuccessful

Given a client register to the API

    | userId     | <user_id>    |
    | username   | <username>   |
    | firstName  | <firstName>  |
    | lastName   | <lastName>   |
    | email      | <email>      |
    | password   | <password>   |

When API receives request at POST http://localhost:8080/signup endpoint

Then the response has: 
* http status: <httpStatusCode>
* response body message as <responseMessage>

Examples:
    | user_id     | username  | firstName  | lastName     | email                 | password    | httpStatusCode | responseMessage                         |
    | null        | wilma001  | Wilma      | Armstrong    | wilma001@gmail.com    | wilma001    | 200            | "User registered successfully."         |
    | null        | null      | Wilma      | Armstrong    | wilma002@gmail.com    | wilma002    | 400            | "Error occured in registering user."    |
    | null        | wilma003  | null       | Armstrong    | wilma003@gmail.com    | wilma003    | 400            | "Error occured in registering user."    |
    | null        | wilma004  | Wilma      | null         | wilma004@gmail.com    | wilma004    | 400            | "Error occured in registering user."    |
    | null        | wilma005  | Wilma      | Armstrong    | null                  | wilma005    | 400            | "Error occured in registering user."    |
    | null        | wilma006  | Wilma      | Armstrong    | wilma006@gmail.com    | null        | 400            | "Error occured in registering user."    |
    | 01          | wilma     | Wilma      | Armstrong    | wilma@gmail.com       | wilma       | 400            | "Error occured in registering user."    |
    

# document.getElementsByTagName("video")[0]