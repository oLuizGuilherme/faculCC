lista = [1,4,9,3,10,11,2]

# lista = [42 , 23, 44, 100,43, 64,97 ]

outra = []

braba = []

lista.sort()

for i in range(0,len(lista)):
    outra.append(lista[i])
    indice = i+1
    if indice != len(lista):
        um = lista[indice]
    dois = lista[i]+1
    if (um != dois):
        if len(outra) > len(braba):
            braba = outra.copy()
        outra.clear()

print(braba)