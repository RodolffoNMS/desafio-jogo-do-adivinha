/*
 * Rá!
 * Dessa vez foi minha vez de desenhar com ASCII (hehehe)
 * Ninguém disse que só pq é um desafio que não posso estilizar.
 * Deu trabalho? Claro! Muito!, mas como eu creio em memes, o "undiagnosed but something ain't right". serve pra mim...
 * */

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class JogoDoAdivinha {

    // Função para exibir o menu
    public static int exibirMenu(Scanner scanner) {
        System.out.println(" _____                                 _____ ");
        System.out.println("( ___ )                               ( ___ )");
        System.out.println(" |   |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|   | ");
        System.out.println(" |   |  __  __                         |   | ");
        System.out.println(" |   | |  \\/  |   ___   _ __    _   _  |   | ");
        System.out.println(" |   | | |\\/| |  / _ \\ | '_ \\  | | | | |   | ");
        System.out.println(" |   | | |  | | |  __/ | | | | | |_| | |   | ");
        System.out.println(" |   | |_|  |_|  \\___| |_| |_|  \\__,_| |   | ");
        System.out.println(" |   |                                 |   | ");
        System.out.println(" |   |                                 |   | ");
        System.out.println(" |   |Escolha uma das opções abaixo:   |   | ");
        System.out.println(" |   |1 - Iniciar Jogo                 |   | ");
        System.out.println(" |   |2 - Conhecer as Regras           |   | ");
        System.out.println(" |   |3 - Sair                         |   | ");
        System.out.println(" |___|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|___| ");
        System.out.println("(_____)                               (_____)");
        System.out.print("Digite sua opção: ");
        return scanner.nextInt();
    }

    // Função para exibir as regras do jogo
    public static void exibirRegras() {
        System.out.println(" _____                                                                                                   _____ ");
        System.out.println("( ___ )                                                                                                 ( ___ )");
        System.out.println(" |   |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|   | ");
        System.out.println(" |   |                          ____                                                                     |   | ");
        System.out.println(" |   |                         |  _ \\    ___    __ _   _ __    __ _   ___   _                            |   | ");
        System.out.println(" |   |                         | |_) |  / _ \\  / _` | | '__|  / _` | / __| (_)                           |   | ");
        System.out.println(" |   |                         |  _ <  |  __/ | (_| | | |    | (_| | \\__ \\  _                            |   | ");
        System.out.println(" |   |                         |_| \\_\\  \\___|  \\__, | |_|     \\__,_| |___/ (_)                           |   | ");
        System.out.println(" |   |                                         |___/                                                     |   | ");
        System.out.println(" |   |                                                                                                   |   | ");
        System.out.println(" |   |                                                                                                   |   | ");
        System.out.println(" |   |1. O sistema irá sortear um número inteiro aleatório dentro de um intervalo fixo, entre 0 a 10.    |   | ");
        System.out.println(" |   |2. Você deve fornecer um palpite:                                                                  |   | ");
        System.out.println(" |   | - Se o seu palpite for igual ao número sorteado, você ganha 10 pontos!.                           |   | ");
        System.out.println(" |   | - Se o seu palpite estiver entre 1 unidade acima ou abaixo, você ganha 5 pontos!.                 |   | ");
        System.out.println(" |   | - Mas se estiver mais de uma unidade você não pontua.                                             |   | ");
        System.out.println(" |   |3. Você tem apenas um único palpite.                                                               |   | ");
        System.out.println(" |   |4. Boa sorte e divirta-se!                                                                         |   | ");
        System.out.println(" |___|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|___| ");
        System.out.println("(_____)                                                                                                 (_____)");

    }

    // Função para jogar uma rodada
    public static int jogarRodada(Scanner scanner, Random gerador, int limite, List<Integer> numerosAcertados, List<Integer> numerosErrados)  {
        int numeroSorteado = gerador.nextInt(limite) + 1; // Sorteia um número entre 1 e o limite
        int scorePartida = 0; // Pontuação local (por partida)
        int palpite;

        String nivelNome;
        switch (limite) {
            case 10:
                nivelNome = "Fácil";
                break;
            case 50:
                nivelNome = "Médio";
                break;
            case 100:
                nivelNome = "Difícil";
                break;
            default:
                nivelNome = "fácil";
        }
        System.out.println("Iniciando o jogo no nível " + nivelNome + "...");

        while (true) { //Validador de entrada.
            System.out.print("Digite seu palpite (entre 1 e " + limite + "): ");
            palpite = scanner.nextInt();
            if (palpite >= 1 && palpite <= limite) {
                break; // Entrada válida, sai do loop.
            } else {
                System.out.println("Palpite inválido! Por favor, insira um número entre 1 e " + limite + ".");
            }
        }        

        if (palpite == numeroSorteado) {
            scorePartida += 10;
            numerosAcertados.add(numeroSorteado); // Adiciona o número acertado à lista
            System.out.println("\\ (•◡•) / Parabéns! Você acertou! Ganhou 10 pontos!┗(▀̿Ĺ̯▀̿ ̿)┓ ");
        } else if (palpite == numeroSorteado + 1 || palpite == numeroSorteado - 1) {
            scorePartida += 5;
            System.out.println("¯\\_(ツ)_/¯ Quase! você estava a 1 unidade do número sorteado e ganhou 5 pontos! (¬_¬)");
        } else {
            numerosErrados.add(palpite); // Adiciona o palpite errado à lista
            System.out.println("(ಠ_ಠ) Que pena! Você errou... Tente novamente!(つ◉益◉)つ ");
        }
        return scorePartida;
    }

    // Função para verificar e aceitar somente os números 1, 2 e 3
    public static int verificarNivelDificuldade(Scanner scanner) {
        int nivel;
        while (true) {
            System.out.print("Escolha o nível de dificuldade (1 - Fácil, 2 - Médio, 3 - Difícil): ");
            nivel = scanner.nextInt();
            if (nivel == 1 || nivel == 2 || nivel == 3) {
                break; // Entrada válida, sai do loop
            } else {
                System.out.println("Opção inválida! Por favor, digite apenas 1, 2 ou 3.");
            }
        }
        return nivel;
    }

    // Função para determinar o limite com base no nível de dificuldade
    public static int determinarLimite(int nivel) {
        int limite = 10; // Padrão: Fácil
        if (nivel == 2) {
            limite = 50; // Médio
        } else if (nivel == 3) {
            limite = 100; // Difícil
        }
        return limite;
    }


    // Função para exibir o resumo final
    public static void exibirResumoFinal(int scoreGlobal, List<Integer> acertados, List<Integer> errados) {
        System.out.println("Resumo Final:");
        System.out.println("Pontuação Final: " + scoreGlobal + " pontos.");
        if (acertados.isEmpty()) {// Caso true, retona "Nenhum"
            System.out.println("Números Acertados: Nenhum");
        } else { // Caso False, converte a lista para String e substitui os colchetes.
            System.out.println("Números Acertados: " + acertados.toString().replace("[", "").replace("]", "")); //Primeira vez que uso replace (sugestão de um colega)
        }
        
        if (errados.isEmpty()) {
            System.out.println("Números Errados: Nenhum");
        } else {
            System.out.println("Números Errados: " + errados.toString().replace("[", "").replace("]", ""));
        }
        /*
         * ALternativamente podemos usar:
         * System.out.println("Números Acertados: " + (acertados.isEmpty() ? "Nenhum" : acertados));
         * System.out.println("Números Errados: " + (errados.isEmpty() ? "Nenhum" : errados));
         * Mas para um junin, ler if else é mais fácil. 
         */
        System.out.println("Obrigado por jogar! Até a próxima! ┏(-_-)┛┗(-_- )┓");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random gerador = new Random();
        int scoreGlobal = 0; // Pontuação acumulada
        int escolha;
        List<Integer> numerosAcertados = new ArrayList<>();
        List<Integer> numerosErrados = new ArrayList<>();

        System.out.println("/============================================================================================\\");
        System.out.println("||                                                                                          ||");
        System.out.println("||  ____        _         ____                  __     ___           _                      ||");
        System.out.println("|| / ___|  ___ (_) __ _  | __ )  ___ _ __ ___   \\ \\   / (_)_ __   __| | ___     __ _  ___   ||");
        System.out.println("|| \\___ \\ / _ \\| |/ _` | |  _ \\ / _ \\ '_ ` _ \\   \\ \\ / /| | '_ \\ / _` |/ _ \\   / _` |/ _ \\  ||");
        System.out.println("||  ___) |  __/| | (_| | | |_) |  __/ | | | | |   \\ V / | | | | | (_| | (_) | | (_| | (_) | ||");
        System.out.println("|| |____/ \\___|/ |\\__,_| |____/ \\___|_| |_| |_|    \\_/ _|_|_| |_|\\__,_|\\___/   \\__,_|\\___/  ||");
        System.out.println("||   (_) ___ |__/ _  ___     __| | ___      / \\   __| (_)_   _(_)_ __ | |__   __ _| |       ||");
        System.out.println("||   | |/ _ \\ / _` |/ _ \\   / _` |/ _ \\    / _ \\ / _` | \\ \\ / / | '_ \\| '_ \\ / _` | |       ||");
        System.out.println("||   | | (_) | (_| | (_) | | (_| | (_) |  / ___ \\ (_| | |\\ V /| | | | | | | | (_| |_|       ||");
        System.out.println("||  _/ |\\___/ \\__, |\\___/   \\__,_|\\___/  /_/   \\_\\__,_|_| \\_/ |_|_| |_|_| |_|\\__,_(_)       ||");
        System.out.println("|| |__/       |___/                                                                         ||");
        System.out.println("||                                                                                          ||");
        System.out.println("\\============================================================================================/");

        do {
            escolha = exibirMenu(scanner); // Exibe o menu e captura a escolha do usuário
            switch (escolha) {
                case 1:
                    int nivel = verificarNivelDificuldade(scanner);
                    int limite = determinarLimite(nivel);
                    System.out.println("Você escolheu o nível " + nivel + ". O limite será: " + limite);
                    scoreGlobal += jogarRodada(scanner, gerador, limite, numerosAcertados, numerosErrados);
                    System.out.println("Sua pontuação atual é: " + scoreGlobal + " pontos.");
                    break;
                case 2:
                    exibirRegras();
                    break;
                case 3:
                exibirResumoFinal(scoreGlobal, numerosAcertados,numerosErrados);
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (escolha != 3);

        scanner.close();
    }
}