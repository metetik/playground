import requests

BASE = "http://127.0.0.1:5000/"

data = [{"likes" : 7, "name" : "Muhammed", "views" : 10000},
        {"likes" : 14, "name" : "Bayram", "views" : 55},
        {"likes" : 70, "name" : "Furkan", "views" : 999999}]

response = requests.get(BASE + "helloworld/mücteba")
#response1 = requests.post(BASE + "helloworld")

print(response.json())
#print(response1.json())

resp = requests.put(BASE + "video/1",{"name" : "video1", "views" : 20, "likes" : 10})
print(resp.json())
input()

resp2 = requests.get(BASE + "video/1")
print(resp2.json())

resp3 = requests.get(BASE + "video/5")
print(resp3.json())

for i in range(len(data)):
    response = requests.put(BASE + "video/" + str(i),data[i])
    print(response.json())

resp4 = requests.delete(BASE + "video/2")
print(resp4)

resp5 = requests.get(BASE + "video/7")
print(resp5.json())

resp6 = requests.delete(BASE + "video/7")
print(resp6.json())

resp7 = requests.get(BASE + "video/7")
print(resp7.json())
