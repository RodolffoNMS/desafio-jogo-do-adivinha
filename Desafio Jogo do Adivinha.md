# Desafio: Jogo do Adivinha 🎲
Implemente um jogo interativo no qual o sistema sorteia um número aleatório e o usuário tenta adivinhar qual é esse número. O jogo deve utilizar condicionais para determinar a pontuação do usuário com base na proximidade do palpite em relação ao número sorteado. O objetivo principal é trabalhar a lógica de entrada e saída de dados de forma clara e coerente.

---

## 📋 Requisitos do Desafio

### Entrega Mínima:
1. O sistema deve sortear um número aleatório dentro de um intervalo fixo (ex.: 1 a 10).
2. O usuário deve fornecer um palpite, e o sistema deve comparar o número sorteado com o palpite:
   1. Se o palpite for igual ao número sorteado, o usuário ganha 10 pontos.
   2. Se o palpite estiver 1 unidade acima ou abaixo do número sorteado, o usuário ganha 5 pontos.
   3. Caso contrário, o usuário não ganha pontos.
3. Ao final de uma rodada, o sistema deve exibir a pontuação total do usuário.
### Entrega Média:
1. O jogo deve permitir que o usuário jogue várias rodadas.
2. A pontuação deve ser acumulada ao longo das rodadas.
3. O sistema deve perguntar ao usuário se ele deseja continuar jogando ou encerrar o jogo.
### Entrega Máxima:
1. O jogo deve oferecer níveis de dificuldade, que alteram o intervalo de números sorteados:
   1. Fácil: Números entre 1 e 10.
   2. Médio: Números entre 1 e 50.
   3. Difícil: Números entre 1 e 100.
2. Ao final do jogo, o sistema deve exibir:
   1. A pontuação final do usuário.
   2. Uma lista com os números que o usuário acertou.
   3. Uma lista com os números que o usuário errou.
## 📝 Observações
O foco principal do desafio é a utilização de condicionais para implementar a lógica de vitória ou derrota.

O sistema deve ser implementado para rodar no console, com entradas e saídas claras e organizadas.

O código deve ser modular e fácil de entender, com mensagens que orientem o usuário durante o jogo.

## 📊 Exemplos de Comportamento do Sistema

#### Exemplo 1: Entrega Mínima

O sistema sorteia o número 7.

O usuário digita o palpite 6.

O sistema responde:"Quase lá! Você estava a 1 de distância do número sorteado. Você ganhou 5 pontos."

**Pontuação total: 5 pontos.**

#### Exemplo 2: Entrega Média

O sistema permite que o usuário jogue novamente após cada rodada.

O usuário decide continuar jogando e acumula pontos ao longo das rodadas.

#### Exemplo 3: Entrega Máxima

O usuário escolhe o nível de dificuldade Médio (1 a 50).

Após várias rodadas, o sistema exibe:

**Pontuação final: 25 pontos.**

Números acertados: [15, 42].

Números errados: [10, 30, 7].
