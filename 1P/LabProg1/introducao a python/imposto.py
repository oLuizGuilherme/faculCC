horas = int(input("Informe o número de horas trablhadas: "))

salario = 19.5 * horas
desconto = 0

if (salario > 2500):
    desconto = (salario * 1.25) - salario
    salario_liquido = salario - desconto

print("O salário líquido é de", salario_liquido, "e o desconto é de", desconto)