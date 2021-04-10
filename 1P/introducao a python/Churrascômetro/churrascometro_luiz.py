# Quantidade de carne consumida por homem:              623g
# Quantidade de carne consumida por mulher:             478g
# Quantidade de consumida por criança:                  384g
# Quantidade de refrigerante consumida por homem:       1L
# Quantidade de refrigerante consumida por mulher:      1L
# Quantidade de refrigerante consumida por crianças:    0.5L        Fonte: alguma ai

qtd_homens = int(input('Informe a quantidade de homens presentes no churrasco '))
qtd_mulheres = int(input('Informe a quantidade de mulheres presentes no churrasco '))
qtd_crianca = int(input('Informe a quantidade de crianças presentes no churrasco '))

carne_homem = qtd_homens * 0.623
carne_mulher = qtd_mulheres * 0.478
carne_crianca = qtd_crianca * 0.384
carne_geral = carne_crianca + carne_mulher + carne_homem

mensagem = ('A quantidade necessaria de carne para o churrascão vai ser de: ' + str(carne_geral) + 'kg.\n')

calcular_refri = 'a'

while (calcular_refri != 's'  or calcular_refri != 'n'):
    calcular_refri = input('Gostaria de calcular a quantidade de refrigerante? s/n ')
    if (calcular_refri == 's'):
        qtd_refri = qtd_homens * 1 + qtd_mulheres * 1 + qtd_crianca * 0.5
        mensagem = mensagem + 'A quantidade de refri indicado sera de: ' + str(qtd_refri) + 'L.'
        break
    elif (calcular_refri == 'n'):
        mensagem = mensagem + 'kk n quis refri otario'
        break

print(mensagem)
