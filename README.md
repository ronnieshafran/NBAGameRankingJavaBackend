# NBAGameRankingJavaBackend

## Flow

This repository contains the backend code used to support NBAGameRanking.com.
Every morning, the DynamoDBUpdate Lambda function is triggered by EventBridge timed events. The function reads game data from RAPIDAPI's NBA API, manipulates it and stores it in a DynamoDB table.

The lambda is called several times in the morning hours to make sure finished games are available for early risers.

The DynamoDBGet Lambda function is then used to fetch the results and is exposed via API Gateway.

The DynamoDBGet Java function was replaced with a Python function to avoid cold-start latency (3500ms vs 320 ms).

The functions, tables and APIs used are all monitored and extensively logged using CloudWatch.


![Backend Flow Chart](https://user-images.githubusercontent.com/63145449/230341702-3db408d1-b42a-4e39-9c58-f1585f413f86.jpg)
## Stack
AWS: Amplify, DynamoDB, Lambda, API Gateway, CloudWatch, EventBridge

Languages: Java 11, Python 3.9

