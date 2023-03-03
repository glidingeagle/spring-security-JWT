Feature: Client - Authentication

Scenario Outline: Client - Authentication - successful

Given a client undergoes authentication

    | email    | fred@gmail.com    |
    | password | fred              |

When API receives request at POST http://localhost:8080/authenticate endpoint

Then the response has:
* http status: 200
* response body property username with value: <username>
* response body property firstName with value: <firstName>
* response body property lastName with value: <lastName>
* response body property email with value: <email>

Examples:
    | username   | firstName    | lastName  | email             |
    | fred       | Fred         | Stone     | fred@gmail.com    |



Scenario Outline: Client - Authentication - unsuccessful

Given a client undergoes authentication

    | email    | <email>    |
    | password | <password> |

When API receives request at POST http://localhost:8080/authenticate endpoint

Then the response has:
* http status: <httpStatusCode>
* response body message as <responseMessage>

Examples:
    | email             | password    | httpStatusCode | responseMessage               |
    | fred@gmail.com    | freddie     | 400            | "INVALID_CREDENTIALS"         |
    | freddie@gmail.com | fred        | 400            | "INVALID_CREDENTIALS"         |
    | freddie@gmail.com | freddie     | 400            | "INVALID_CREDENTIALS"         |