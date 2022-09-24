import requests
import json

requestUrl = 'https://gateway.marvel.com:443/v1/public/characters?ts=1&nameStartsWith=Spider-man&apikey=c168666ec7af849dd950624409816b7e&hash=bc6ea52b59e0d04a8649819a1d5c7c26&limit=1'
response = requests.get(requestUrl)

retornoJson = json.loads(response.text)
dataJson = retornoJson['data']

with open('acesso.json', 'w') as j:
    j.write(str(dataJson))