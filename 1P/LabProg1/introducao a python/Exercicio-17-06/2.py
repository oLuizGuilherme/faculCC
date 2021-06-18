import random

random.seed(42)

windows = []

x = []
y = []

soma_x = 0
soma_y = 0

for i in range(0,10):
    windows.append(random.randint(1,20))

windows.sort()

x.append(windows[0])
soma_x = x[0]
for i in range(1,10):
    if (soma_x > soma_y):
        y.append(windows[i])
        soma_y += windows[i]
    else:
        x.append(windows[i])
        soma_x += windows[i]

dif = soma_x - soma_y

print(windows)
print(x)
print(y)
print(dif)