import json

player_name = ['Bernd Leno', 'Emiliano Martnez', 'Matt Macey', 'Hctor Bellern']
player = {}
for i in player_name:
    #player_page = requests.get('https://www.premierleague.com/players/10483/{}/stats'.format(i))
    #cont = soup(player_page.content, 'lxml')
    data = {"stat1": 1, "stat2": 2}
    player[i] = data

print(player)
print(json.dumps(player))

with open('../data/player.json', 'w') as f:
    json.dump(player, f)
