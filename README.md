# NBAGameRankingJavaBackend

## Flow

This repository contains the backend code used to support NBAGameRanking.com.
Every morning, game data is read from RAPIDAPI's NBA API, manipulated and stored in a DynamoDB table via the DynamoDBUpdate Lambda function.
The lambda is called several times in the morning hours to make sure finished games are available for early risers.
The DynamoDBGet Lambda function is then used to fetch the results and is exposed via API Gateway.
The DynamoDBGet Java function is now replaced with a Python function to avoid cold-start latency.

The functions, tables and APIs used are all monitored and extensively logged using CloudWatch.

## Stack
AWS: Amplify, DynamoDB, Lambda, API Gateway, CloudWatch

Languages: Java 11, Python 3.9
