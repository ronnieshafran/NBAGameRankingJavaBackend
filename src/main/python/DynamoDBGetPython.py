import boto3
import datetime
import json
import os
from decimal import Decimal

dynamodb = boto3.resource('dynamodb')
table_name = 'Games'
date_format = '%Y-%m-%d'
api_key = os.environ['API_KEY']

response_headers = {
    'Access-Control-Allow-Headers': 'x-api-key',
    'Access-Control-Allow-Origin': '*',
    'Content-Type': 'application/json'
}

def handle_request(event, context):
    print(json.dumps(event))

    date = event["queryStringParameters"]["date"]
    print(f'DATE = {date}')
    api_key_header = event['headers'].get('x-api-key')

    if api_key_header != api_key:
        response = {
            'statusCode': 400,
            'headers': response_headers,
            'body': 'Invalid API Key'
        }
        print(json.dumps(response))
        return response

    if not date:
        response = {
            'statusCode': 400,
            'headers': response_headers,
            'body': 'Missing \'date\' query parameter'
        }
        print(json.dumps(response))
        return response

    try:
        datetime.datetime.strptime(date, date_format)
    except ValueError:
        response = {
            'statusCode': 400,
            'headers': response_headers,
            'body': 'Invalid date format. Expected format: yyyy-MM-dd'
        }
        print(json.dumps(response))
        return response

    games = get_games_from_table(date)
    response_map = {'games': games}
    response_body = json.dumps(response_map, default=serialize_item)

    response = {
        'statusCode': 200,
        'headers': response_headers,
        'body': response_body
    }
    print(json.dumps(response))
    return response


def get_games_from_table(date_string):
    table = dynamodb.Table(table_name)
    response = table.query(
        KeyConditionExpression='#date = :date_value',
        ExpressionAttributeNames={'#date': 'date'},
        ExpressionAttributeValues={':date_value': date_string}
    )

    games = response['Items']
    return games


def serialize_item(item):
    if isinstance(item, Decimal):
        return str(item)
    elif isinstance(item, set):
        return list(item)
    elif isinstance(item, dict):
        # Check if the dictionary has already been serialized
        if item in seen_items:
            return "<circular reference>"
        seen_items.add(item)
        return {k: serialize_item(v) for k, v in item.items()}
    elif isinstance(item, list):
        return [serialize_item(i) for i in item]
    else:
        return item