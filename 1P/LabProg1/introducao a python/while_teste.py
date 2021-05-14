niumber = int(input("Insert number: "))
digits = 0
while int(number) != 0:
    digits += int(number) % 10
    number //= 10
    print(number)
print(f"Resto: {digits % 10}")