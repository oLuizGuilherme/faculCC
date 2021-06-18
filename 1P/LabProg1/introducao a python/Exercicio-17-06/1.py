import random

random.seed(42)

lista = []

for i in range(0,10):
    lista.append(random.randint(0,100))

lista.sort()

print(lista)
print(lista[8])
print(lista[2])