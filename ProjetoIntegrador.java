/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointegrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Paola Soares
 */
public class ProjetoIntegrador {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nOlá: Está preparado pra essa missãao... ?");
        System.out.println("\n1 - Sim |2 - Não sei ");
        int escolha_menu = entrada.nextInt();
        switch (escolha_menu) {
            case 1:
                System.out.println("Então vamos lá...");
                menu();
                break;
            case 2:
                System.out.println("Iai, vamos lá pra missão mais louca da sua vida...");
                break;
            default:
                System.out.println("Ops: opção inválida");
                break;
        }

    }

    static void menu() throws Exception {
        Scanner entrada = new Scanner(System.in);
        int escolha_menu;
        do {
            System.out.println("\n\n..* BEM - VINDO A CAMANAPA *.. \n\n1 - Instruções \n2 - Jogar \n3 - História \n4 - Créditos \n5 - Sair");
            System.out.println("\n");
            escolha_menu = entrada.nextInt();
            switch (escolha_menu) {
                case 1:
                    instrucoes();
                    break;
                case 2:
                    jogo();
                    break;
                case 3:
                    historia();
                    break;
                case 4:
                    creditos();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("\nOpção inválida, digite novamente: ");
                    break;

            }

        } while (escolha_menu != 1 && escolha_menu != 2 && escolha_menu != 3 && escolha_menu != 4 && escolha_menu != 5);

    }

    static void instrucoes() throws Exception { //intruções para o jogador como proceder no jogo
        Scanner entrada = new Scanner(System.in);
        int escolha_menu = 0;
        do {
            System.out.println("Você escolheu a opção Instruções: ");

            System.out.println("\nEscolha JOGAR para iniciar ou HISTÓRIA para ler a história do mundo de CAMANAPA. ");
            System.out.println("\nO jogo consiste em 7 desafios baseados na matéria Conceitos de Computação, ou seja, você terá de responder perguntas envolvendo conversão de base, mapa de Karnaugh etc.");
            System.out.println("\nAo acertar, pressione ENTER para continuar. Ao errar, pressione ENTER para tentar novamente. ");
            System.out.println("\nVocê possui 3 vidas, logo, pode errar 3 vezes durante o jogo. Caso você perca todas as vidas, de volta ao início. ");
            System.out.println("\nAcerte todas as perguntas com o mínimo de erros para vencer! Boa sorte!");
            System.out.println("1 - sair ");
            escolha_menu = entrada.nextInt();
            if (escolha_menu == 1) {
                menu();
            } else {
                System.out.println("Opção Inválida");
            }
        } while (escolha_menu != 1);
    }

    static int tentativasRestantes = 3;
    static int pontos = 0;

    static ArrayList<Pergunta> criaPerguntas() {

        ArrayList<Pergunta> perguntas = new ArrayList(); // Onde é adicionada as peguntas

        perguntas.add(new Pergunta("Apresento a você Veitch, guardião da ilha tropical. Seu desafio é o seguinte:\n",
                "O valor em binário do decimal 227 é:",
                1,
                "c",
                new String[]{"a) 10101000", "b) 10101101", "c) 11100011", "d) 1011110", "e)1011101"}
        ));

        perguntas.add(new Pergunta(
                "Muito bem, você enfrentará Karnaugh em seu violento mapa nos mais profundos oceanos:\n",
                "Em Arduino para a ultilização de uma estrutura basica, voce necessita apenas de duas partes ou dois blocos. Quais são esses blocos?",
                2,
                "b",
                new String[]{"a) Loop e Led", "b) Setup e Loop", "c) Void e Led ", "d) Void e Setup", "e) High e Low"}
        ));

        perguntas.add(new Pergunta(
                "Conheça Gosling, o grande monstro que habita a região congelada:\n",
                "Há varios tipos de Arduino com especilidades diferentes de harware. Qual dos tipos abaixo pertencem verdadeiramente ao Arduino?",
                3,
                "d",
                new String[]{"a) Arduino quatro", "b) Arduino Rock", "c) Arduino pipow", "d) Arduino Mega ADK", "e) Arduino camp"}
        ));

        perguntas.add(new Pergunta(
                "Enfrente o escorregadio Gygax em seu curioso subsolo.\n",
                "Quando falamos de Portas Logicas, recordamos que eles se tratam de blocos. Qual bloco abaixo faz representatividade a portas logicas?",
                4,
                "c",
                new String[]{"a) Não (and)", "b) E (or)", "c) Não (not)", "d) Não E (nund)", "e) OU  (ou)"}
        ));

        perguntas.add(new Pergunta(
                "Vou te deixar com o grande guardião do deserto Boole, seus ventos e suas conversões.\n",
                "Transforme o ano de 1975 em hexadecimal:",
                5,
                "b",
                new String[]{"a) 16B", "b) 7B7", "c) 11927", "d) 12G5", "e) 29A"}
        ));

        perguntas.add(new Pergunta(
                "Você deve derrotar meu aprendiz Costa, que reina entre as florestas. Boa sorte.\n",
                "O número 2012 será representado, em base binária, por:",
                6,
                "b",
                new String[]{"a) 110111", "b) 11111011100", "c) 111110111000", "d) 111110111", "e) 1111010101"}
        ));

        perguntas.add(new Pergunta(
                "É a minha vez, o grande TAKEO, guardião do fogo e dos vulcões e de toda esta terra na qual está preso!\n",
                "O valor hexadecimal 9 corresponde, em decimal, ao valor:",
                7,
                "d",
                new String[]{"a) 16", "b) 99", "c) 105", "d) 159", "e) 234"}
        ));

        return perguntas;
    }

    static void jogo() throws Exception { // entrada do jogo
        Scanner entrada = new Scanner(System.in);
        int resp;
        System.out.println("BEM - VINDO A CANAMAPA !");
        System.out.println("\n");

        System.out.println("É, é isso mesmo que você ouviu, você está CANAMAPA. Quem sou eu?\n Isso não interessa, me diga quem é você,  qual seu nome?");
        System.out.println("\n");

        System.out.println("Insira o nome:");
        String nome = entrada.next();
        System.out.println("\n");

        System.out.println("    Ótimo, " + nome + ".\n Vamos lá, vou resumir a história pra você. Você está preso em meu mundo,\n e enquanto não cumprir minhas missões, viverá aqui para sempre! Divirta-se nos meus diversos biomas... se puder.");
        System.out.println("\n");

        ArrayList<Pergunta> perguntas = criaPerguntas();
        List<Integer> indices = new ArrayList<>();
        int contadorDePerguntas = 1;
        while (contadorDePerguntas <= perguntas.size()) {
            int indice = pegaPergunta(indices);
            Pergunta pergunta = perguntas.get(indice);

            System.out.println("\n");
            System.out.println(pergunta.historia);//Exibir historia da questão do jogo
            System.out.println(pergunta.enunciado);//Exibir enunciado do jogo
            for (String alternativa : pergunta.alternativas) {//Exibir alternativas do jogo
                System.out.println(alternativa);
            }
            String resposta = entrada.next();
            System.out.println("Resposta correta: " + pergunta.respostaCorreta);

            if (resposta.equals(pergunta.respostaCorreta)) {
                pontos = pontos + 1;
                System.out.println("Pontuação: " + pontos);
                System.out.println(" Parabéns... você acertou, " + nome + ".");
                if (pontos == 7) {
                    System.out.println("NÃO ACREDITO NO QUE ESTÁ ACONTECENDO!");
                    System.out.println("Está bem, você venceu. Tome de volta suas vidas e um passaporte só de ida para seu mundo real sem graça... Devolverei este mundo a Ca, Ma, Na e Pa, seus guardiões originais.\n"
                            + "Se quiser jogar novamente, estarei em algum mundo de códigos te esperando... Eu sempre estarei.");
                }
            } else if (tentativasRestantes > 0) {
                System.out.println(" Resposta errada, " + nome + "!\nVocê tem somente: " + tentativasRestantes + " tentativas");
                tentativasRestantes--;
            } else if (tentativasRestantes == 0) {
                System.out.println(" Errou por 3 vezes seguidas " + nome);
                System.out.println("\n    -*GAME OVER*-");
                System.out.println("Mais sorte na próxima aventura, viajante! A ilha é grande, vá dar uma volta.\nQuando estiver pronto novamente, sabe onde me encontrar.");

                break;
            }
            contadorDePerguntas++;
        }
    }

    static void historia() throws Exception {
        Scanner entrada = new Scanner(System.in);
        int escolha_menu = 0;
        do {
            System.out.println("Seja bem-vindo à CANAMAPA ");

            System.out.println("\nHá muito tempo, em uma galáxia distante... Existia a terra de Camanapa. ");
            System.out.println("\nSeu nome se deu em homenagem aos seus guardiões e desenvolvedores, conhecidos por suas iniciais Ca, Ma, Na e Pa, possuindo, respectivamente, os poderes do Ar, da Água, do Fogo e da Terra.");
            System.out.println("\nUnidos, possuíam também poderes tecnológicos para que Camanapa estivesse em constante evolução. Todos os que ali habitavam aproveitavam o equilíbrio entre natureza e tecnología,\n e passavam suas vidas buscando conhecimento para que esse equilíbrio fosse mantido e aprimorado. ");
            System.out.println("\nPorém, lideranças de diferentes partes do planeta buscavam tomar esse poder das mãos dos guardiões e estabelecer uma nova ordem. Iniciou-se assim a Grande Guerra. ");
            System.out.println("\nLiderados pelo grande Takeo, os mestres das regiões de Java e da Computação travaram uma disputa contra os guardiões de Camanapa, que por serem em menor número, foram derrotados e exilados do planeta.");
            System.out.println("Vagando pelo universo afora, pensando e avaliando soluções para tomar o poder de sua terra de volta, os guardiões decidiram que a melhor pessoa para lidar com a situação e derrotar Takeo seria um grande jogador de RPG.\n Takeo gostava muito de jogos, especialmente RPG, então sua competição para decidir o domínio do planeta girava em torno de um jogo de Conceitos de Computação.");
            System.out.println("Os guardiões, depois de muita pesquisa, descobriram que os grandes jogadores se encontram no planeta Terra.");
            System.out.println("1 - sair ");
            escolha_menu = entrada.nextInt();
            if (escolha_menu == 1) {
                menu();
            } else {
                System.out.println("Opção Inválida");
            }
        } while (escolha_menu != 1);

    }

    static void creditos() throws Exception {
        Scanner entrada = new Scanner(System.in);
        int escolha_menu;
        System.out.println("\n\n Desenvolvedores \n\n->  \n-> Paola Soares \n-> RafaelCamilo \n-> Nadine Silva \n-> Maria Carolina");

        do {

            System.out.println("\n1 - Sair");
            escolha_menu = entrada.nextInt();
            if (escolha_menu == 1) {
                menu();
            } else {
                System.out.println("\nOpção inválida, digite novamente: ");
            }

        } while (escolha_menu != 1);

    }

    public static int pegaPergunta(List<Integer> indices) {
        int max = 6;
        int min = 0;
        do {
            int indice = (int) (Math.random() * (max - min + 1) - min);
            if (!indices.contains(indice)) {
                indices.add(indice);
                return indice;
            }
        } while (true);

    }

    private static class Pergunta {

        String historia;
        String enunciado;
        int pontos;
        String respostaCorreta;
        String[] alternativas;

        public Pergunta(String historia, String enunciado, int pontos, String respostaCorreta, String[] alternativas) {
            this.historia = historia;
            this.enunciado = enunciado;
            this.pontos = pontos;
            this.respostaCorreta = respostaCorreta;
            this.alternativas = alternativas;
        }

    }

}
