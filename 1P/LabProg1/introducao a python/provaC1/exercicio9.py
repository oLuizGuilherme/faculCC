litros = float(input('Quantos litros o carro faz por kilômetro?'))

distancia = float(input('Quantos kilômetros foram percorridos?'))

litros_consumidos = litros * distancia

print('Foi percorrido, aproximadamente, {:.2f} Km.'.format(litros_consumidos))