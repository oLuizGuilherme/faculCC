

from marvel import Marvel 

m = Marvel('c168666ec7af849dd950624409816b7e', 'b43cc5009afac9b4cc12b8fad9f56d22de14fe47')

personagens = m.characters

homem_aranha = personagens.get(1011334)

print(homem_aranha['data']['results'][0]['name'])
