package Melhorias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner entdaddos = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem vindo(a)!");
        System.out.println(" O Jogo começou :D");
        jogo();
        mostrarPontucao();
        finalizarJogo();
    }
    public static int numeroDoUser,pontuacao1 = 0, pontode10 = 0, pontuacao2 = 0, pontode5 = 0, rounds, qtAcertos, zerado, pontuacao3;
    public static  int totalPontos;
    public static List<Integer> pontos = new ArrayList<>();
    public static void jogo(){
        System.out.println("Quantas rodadas deseja jogar?");
        rounds = entdaddos.nextInt();
        for (int i = 0; i <rounds ; i++) {
            System.out.println("------------------------------------");
            System.out.println(" Informe um número de 1 a 6: ");
            numeroDoUser = entdaddos.nextInt();

            if (numeroDoUser >= 1 && numeroDoUser <= 6) {
                Random random = new Random();
                int numeroAleatorio = random.nextInt(6)+1 ;
                System.out.println(" O número sorteado foi: " + numeroAleatorio);
                if (numeroDoUser == numeroAleatorio) {
                    System.out.println(" Uau que sorte!\n Seu número é igual ao sorteado, você ganhou 10 pontos");
                    pontuacao1 = 10;
                    pontos.add(pontuacao1);
                    System.out.println("Pontuação atual: " + pontuacao1);
                    pontode10++;
                } else if (numeroDoUser + 1 == numeroAleatorio || numeroDoUser - 1 == numeroAleatorio) {
                    System.out.println("Seu número é diferente em 1 unidade do sorteado, Parabéns! Você ganhou 5 pontos");
                    pontuacao2 = 5;
                    pontos.add(pontuacao2);
                    System.out.println("Pontuação atual: " + pontuacao2);
                    pontode5++;
                } else {
                    System.out.println("Ops :/  Não foi dessa vez");
                    pontuacao3 = 0;
                    zerado++;
                    System.out.println("Pontuação atual: " + pontuacao3);
                }
            } else {
                System.out.println("Numero Inválido");
            }
        }
    }
    public static void mostrarPontucao(){
        System.out.println("-------------------------------------");
        System.out.println("Suas chances acabaram! Visualize seu placar: ");
        for (int i = 0; i <pontos.size() ; i++) {
            totalPontos += pontos.get(i);
        }
        System.out.println("Sua pontuação total é: "+totalPontos);
            if(pontode10+pontode5 == rounds){
                System.out.println("Voce acertou em todas as rodadas");
            } else if (zerado == rounds ) {
                System.out.println("Que pena, você não acertou o número do dado em nenhuma rodada :(");
            } else{
              System.out.println("Voce acertou "+( qtAcertos= pontode10+pontode5)+ " vezes e errou "+ (zerado)+" vez(es)");
            }

    }
    public static void finalizarJogo(){
        System.out.println("--------------------------");
        System.out.println("Deseja reiniciar o jogo? ");
        System.out.println("Informe 1 - SIM \t 2 - NÃO");
        int decisao = entdaddos.nextInt();
        switch (decisao){
            case 1:
                totalPontos=0;
                pontode5 =0;
                pontode10 = 0;
                rounds = 0;
                jogo();
                mostrarPontucao();
                finalizarJogo();
            break;

            case 2:
                System.out.println("Jogo finalizado.");
                System.exit(0);
            break;

            default:
                System.out.println("Opção inválida");
                System.exit(0);
        }
    }
}
