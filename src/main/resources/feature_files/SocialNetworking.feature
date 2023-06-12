Feature: SocialNetworking
  As a User
  I want to be able to use the service - https://jsonplaceholder.typicode.com/
  so that I can make posts

#  @ScenarioToRun
  Scenario Outline: Get a specific Post
    Given service is up and running
    When I send GET request to get a specific post with "<id>"
    Then "<id>", "<title>" and "<body>" request are returned with status code of 200

    Examples:
      | id | title              | body                                                                                                                                                   |
      | 5  | nesciunt quas odio | repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque |
#      | 6  | dolorem eum magni eos aperiam quia | ut aspernatur corporis harum nihil quis provident sequi\nmollitia nobis aliquid molestiae\nperspiciatis et ea nemo ab reprehenderit accusantium quas\nvoluptate dolores velit et doloremque molestiae |

#  @ScenarioToRun
  Scenario Outline: Create a new social networking post
    Given service is up and running
    When I create a new post with the following details "<userId>", "<title>" and "<body>"
    Then I should get reponse of "<userId>", "<title>" and "<body>" returned with status code of 201

    Examples:
      | userId | title                       | body                                                                                 |
      | 109    | My latest holiday to Japan  | I went to Japan with my family and we had a good time                                |
      | 120    | My latest holiday to Brazil | I went to Brazil with my family and we had a good time even more than the Japan trip |

#  @ScenarioToRun
  Scenario Outline: Get a specific Comment
    Given service is up and running
    When I send GET request to get a specific comment with "<id>"
    Then "<id>", "<name>", "<email>" and "<body>" request are returned with status code of 200

    Examples:
      | id | name                          | email               | body                                                                                                                                                                                                                          |
      | 3  | odio adipisci rerum aut animi | Nikita@garfield.biz | quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione |

  @ScenarioToRun
  Scenario Outline: Create a new social networking comment
    Given service is up and running
    When I create a new comment with the following details "<postId>", "<name>", "<email>" and "<body>"
    Then I should get response of "<postId>", "<name>", "<email>" and "<body>" returned with status code of 201

    Examples:
      | postId | name        | email           | body                                                |
      | 2004   | Sheyi Abdul | sheyi@Abdul.com | Just commenting on this recent post of your holiday |

