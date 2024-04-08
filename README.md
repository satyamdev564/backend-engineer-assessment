## Introduction

Welcome to the solution of backen-engineer-assesment by satyamdev564
- Video
  - Task 2 : Running Code - https://drive.google.com/file/d/1vu80wsdpMxIcaPD_N9uY2n6D480g5J-e/view?usp=sharing
  - Task 3 : Running Code - https://drive.google.com/file/d/1EaHxvcx-x5XhsKgPM5SsuCj5vmz7Ixsx/view?usp=sharing
  - Task 4 : Running Code - https://drive.google.com/file/d/1cyrZng6UHbcrJfMrGIqQ4QTdFEOieDnC/view?usp=sharing

## Setup

### Pre-requisities

To run the application you would require:

- [Java](https://www.azul.com/downloads/#zulu)
- [Temporal](https://docs.temporal.io/cli#install)
- [Docker](https://docs.docker.com/get-docker/)
- [Stripe API Keys](https://stripe.com/docs/keys)

### Other platforms

Please check the official documentation for the installation of Java, Temporal, and Docker for your platform.

### Stripe API Keys

Sign up for a Stripe account and get your API keys from the [Stripe Dashboard](https://dashboard.stripe.com/apikeys).
Then in `application.properties` file add the following line with your secret key.

```properties
stripe.api-key=sk_test_51J3j
```
### Note :
Don't Forget to put your stripe keys in application.properites

### Run:
Considering the pre-requisties are installed let's move on 

Step One :
- Start the local temporal server by writing this command in your windows cmd
  $ temporal server start-dev
- your screen should look something like this
  ![image](https://github.com/satyamdev564/backend-engineer-assessment/assets/59652591/78149ef9-ff1d-44ef-b53f-c9f77b5c7b63)

  
Step Two :
- Start the Docker Desktop application and have a look if it's in running state by checking if the play button is highlighted
- your screen should look something like this
  ![image](https://github.com/satyamdev564/backend-engineer-assessment/assets/59652591/fc0ee4b3-1ed4-4161-a2e2-b1cedf08eb36)

Step Three :
- Clone this repo
- Open windows cmd in whichever place you cloned this repo
- Now we will run gradle clean command to clean this project in case of any incorrect build state
- run this command
  $ ./gradlew clean
- your screen should look something like this
  ![image](https://github.com/satyamdev564/backend-engineer-assessment/assets/59652591/000852d7-5b96-4ad8-839a-1be5afd9fa27)

- Now we will run gradle build command to build this project
- run this command
  $ ./gradlew build
- your screen should look something like this
  ![image](https://github.com/satyamdev564/backend-engineer-assessment/assets/59652591/4f66a8e3-b613-4e1f-9e67-93eba9b92c45)

- Now we will run gradle command for running this springboot project
  ./gradlew bootRun
- your screen should look something like this
  ![image](https://github.com/satyamdev564/backend-engineer-assessment/assets/59652591/4656d410-42ec-429e-a1b1-8dcc56f0ee0e)

Step Four :
- Now the springboot project is running and you can hit the endpoints by passing requests from postman to this url
- [GET] http://localhost:8080/accounts
- [POST] http://localhost:8080/accounts
- [PATCH] http://localhost:8080/accounts/{accountId}
- your screen should look something like this
  ![image](https://github.com/satyamdev564/backend-engineer-assessment/assets/59652591/e74446c4-ea68-428b-ac2d-c5dd3c65ed93)

- Also you can access the Temporal Web UI by going over below url in browser
  http://localhost:8233/
- your screen should look something like this
  ![image](https://github.com/satyamdev564/backend-engineer-assessment/assets/59652591/d8188438-6357-44b9-9c69-4a068ad5e664)
