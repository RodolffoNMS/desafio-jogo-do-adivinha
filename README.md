# Jogo do Adivinha 🎲

Bem-vindo ao **Jogo do Adivinha**, um jogo interativo no qual o sistema sorteia um número aleatório e o jogador tenta adivinhar qual é esse número. 

O jogo utiliza condicionais para determinar a pontuação do jogador com base na proximidade do palpite em relação ao número sorteado.

## 🛠️ Estrutura do Código

O código está organizado de forma modular para facilitar a leitura e manutenção:

exibirMenu: Exibe o menu principal e captura a escolha do jogador.

exibirRegras: Exibe as regras do jogo.

jogarRodada: Gerencia a lógica de uma rodada do jogo, incluindo o sorteio do número, a entrada do palpite e a atribuição de pontos.

main: Ponto de entrada do programa, gerencia o fluxo principal do jogo.

---
## 📜 Regras do Jogo:

1. O sistema sorteia um número aleatório entre 1 e 10.
3. O jogador deve fornecer um palpite:
4. Acertou o número: Ganha 10 pontos.
5. Errou por 1 unidade: Ganha 5 pontos.
6. Errou por mais de 1 unidade: Não ganha pontos.
7. O jogo continua até o jogador acertar o número sorteado.
8. A pontuação total é exibida ao final de cada rodada.

---
## 📈 Versões do Código
Esse repositório conta com três branches além da Main, cada uma dessas branches contém versões únicas do código. A saber:

### Entrega Mínima:
1. O sistema sorteia um número aleatório dentro de um intervalo fixo (entre 1 e 10).
2. O jogador fornece um palpite, e o sistema compara o número sorteado com o palpite:
   1. Se o palpite for igual ao número sorteado, o usuário ganha 10.
   2. Se o palpite estiver 1 unidade acima ou abaixo do número sorteado, o usuário ganha
      5 pontos.
   3. Caso contrário, o jogador não ganha pontos.
   4. Assim que o jogador acerta o número o jogo termina. 
3. Ao final, o sistema exibe a pontuação total do jogador.

--- 
### Entrega Média:

1. O jogador pode jogar quantas vezes quiser.
2. A pontuação se acumulada ao longo das rodadas.

---
### Entrega Máxima:

1. Adicionar níveis de dificuldade:
   1. Fácil: Números entre 1 e 10.
   2. Médio: Números entre 1 e 50.
   3. Difícil: Números entre 1 e 100.
3. Exibir ao final do jogo:
   1. A pontuação final do jogador.
   2. Uma lista com os números que o jogador acertou.
   3. Uma lista com os números que o jogador errou.