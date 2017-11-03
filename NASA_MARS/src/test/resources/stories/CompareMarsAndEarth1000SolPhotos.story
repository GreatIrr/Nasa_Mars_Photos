Meta: First Mars story

Narrative:
As a user
I want to get photos from Curiosity from 100 sol and appropriate Earth date
So that I can check that both api return

Scenario: Compare first 10 photos from Mars and Earth apis
Given User is a good guy
When User sends Mars '<sol>' Sol request and remembers Mars response
And User sends Earth '<sol>' Sol request and remembers Earth response
Then User sees that Mars And Earth responses are equal

Examples:
| sol  |
| 1000 |
| 500  |