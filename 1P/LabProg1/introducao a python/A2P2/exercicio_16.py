alunos_acima_media = 0
for i in range(0,10):
    c1 = float(input('Informe a nota da C1 '))
    c2 = float(input('Informe a nota da C2 '))
    media = (c1 + c2)/2

    if (media > 7):
        alunos_acima_media += 1
    
    print(f'A média do aluno {i+1} é {media}')

print(f'A quantidade de alunos acima da média é {alunos_acima_media}')