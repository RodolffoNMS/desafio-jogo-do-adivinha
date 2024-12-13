/*
 * Antes de ler esse código eu vou desabafar aqui.
 * Primeiro, QUE ÓDIO ESCREVER ISSO AQUI EM PROCEDURAL!
 * Minha primeira linguagem é C então procedural é mamão pra mim certo?
 * ERRADO!
 * Em Java se vc não coloca tudo numa classe não vai rodar(Agora eu vi que tem como fazer de outras maneiras, mas eu nao sabia...
 * Aí o tapado aqui escreveu um código como se fosse C e ficou horas tentando saber o motivo disso nao rodar.
 * Agora que passou "é fácil" mas juro, não foi.
 * Laura eu te amo, mas te odeio tb. hahahahaha
 * Tô brincando.
 * Adorei o desafio até aqui. Imagino que implementar as outras branches será mais fácil.
 * */

import java.util.Random;
import java.util.Scanner;

//Até eu me ligar que deveria declarar um classe para poder escrever como se eu tivesse codando em C eu pastei 2 dias...
public class JogoDoAdivinha {

    // Função para exibir o menu
    public static int exibirMenu(Scanner scanner) {
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Iniciar Jogo");
        System.out.println("2 - Conhecer as Regras");
        System.out.println("3 - Sair");
        System.out.print("Digite sua opção: ");
        return scanner.nextInt();
    }

    // Função para exibir as regras do jogo
    public static void exibirRegras() {
        System.out.println(" Regras do Jogo ");
        System.out.println("1. O sistema irá sortear um número inteiro aleatório dentro de um intervalo fixo, entre 0 a 10.");
        System.out.println("2. Você deve fornecer um palpite:");
        System.out.println(" - Se o seu palpite for igual ao número sorteado, você ganha 10 pontos!.");
        System.out.println(" - Se o seu palpite estiver entre 1 unidade acima ou abaixo, você ganha 5 pontos!.");
        System.out.println(" - Mas se estiver mais de uma unidade você não pontua.");
        System.out.println("3. Suas chances são ilimitadas, isso quebra o jogo (eu sei), mas paciência..."); //Como a entrega é minima vou deixar assim mesmo.
        System.out.println("4. Boa sorte e divirta-se!");
    }

    // Função para jogar uma rodada
    public static int jogarRodada(Scanner scanner, Random gerador, int scoreGlobal) {
        int numeroSorteado = gerador.nextInt(10) + 1; // Sorteia um número entre 1 e 10
        int scorePartida = 0; //Pontuação local (por partida)
        boolean acertou = false;

        while (!acertou) {
            System.out.print("Digite seu palpite (entre 0 e 10): ");
            int palpite = scanner.nextInt();

            if (palpite == numeroSorteado) {
                scorePartida += 10;
                System.out.println("(^_^) Parabéns! Você acertou! Ganhou 10 pontos!");
                acertou = true; // Encerra o loop.
            } else if (palpite == numeroSorteado + 1 || palpite == numeroSorteado - 1) {
                scorePartida += 5;
                System.out.println("Você estava a 1 unidade do número sorteado e ganhou 5 pontos!");
            } else {
                System.out.println("Que pena! Você errou. Tente novamente!");
            }
        }
        return scorePartida;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random gerador = new Random();
        int scoreGlobal = 0; // Pontuação acumulada
        int escolha;

        System.out.println("Seja bem-vindo ao Jogo do Adivinha!");
        do {
            escolha = exibirMenu(scanner); // Exibe o menu e captura a escolha do usuário
            switch (escolha) {
                case 1:
                    System.out.println("Iniciando o jogo...");
                    scoreGlobal = jogarRodada(scanner, gerador, scoreGlobal);
                    System.out.println("Saindo do jogo. Sua pontuação final foi: " + scoreGlobal + " pontos.");
                    System.out.println("Obrigado por jogar! Até a próxima! ");
                    escolha = 3;
                    break;
                case 2:
                    exibirRegras();
                    break;
                case 3:
                    System.out.println("Saindo do jogo. Sua pontuação final foi: " + scoreGlobal + " pontos.");
                    System.out.println("Obrigado por jogar! Até a próxima! ");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (escolha != 3);

        scanner.close();
    }
}