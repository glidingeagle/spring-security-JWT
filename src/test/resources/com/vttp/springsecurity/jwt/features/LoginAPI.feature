Feature: Client - Login

Scenario: Client - Login - Authentication Passed

Given a client has a token for login

When API receives request at GET http://localhost:8080/api/auth/signin endpoint

Then the response has:
* http status: 200
* response body message as "Welcome "



Scenario Outline: Client - Login - Authentication Failed

Given a client uses a fabricated <token> for login

When API receives request at GET http://localhost:8080/api/auth/signin endpoint

Then the response has:
* http status: 401

Examples:
    | token                                                                                                              |
    | "Bearer null"                                                                                                      |
    | "null"                                                                                                             |
    | ""                                                                                                                 |
    | "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmcmVkQGdtYWlsLmNvbSIsImV4cCI6MTY3MTQyNDkzMywiaWF0IjoxNjcxNDIxMzMzfQ.MjRO6-ZS0fA3E0U1sgTnWQUkwUoXX2UmerttQcKTVqRg16ggHDkmblyVyEQoybcD6x7p2khq8gN11x8LxPdnXw"                              |