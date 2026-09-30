import java.util.*;

record Pergunta(String enunciado, List<String> opcoes, String respostaCorreta, int pontos) {}

// Sem 'public' antes de class JogoQuiz
class JogoQuiz {
    private String jogador;
    private int vidas = 3, pontuacao = 0, acertos = 0, erros = 0;

    public JogoQuiz(String jogador) {
        this.jogador = jogador;
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        List<Pergunta> perguntas = List.of(
                new Pergunta("[MÚLTIPLA ESCOLHA] Qual princesa perdeu seu sapatinho de cristal no baile?", List.of("Ariel", "Cinderela", "Bela", "Rapunzel"), "2", 10),
                new Pergunta("[VERDADEIRO / FALSO] A princesa Mulan é acompanhada pelo dragão Mushu em sua jornada.", null, "V", 20),
                new Pergunta("[MÚLTIPLA ESCOLHA] Qual é o nome da princesa que vive no reino de Arendelle e tem poderes de gelo?", List.of("Moana", "Elsa", "Merida", "Tiana"), "2", 10),
                new Pergunta("[VERDADEIRO / FALSO] A Princesa Aurora, da Bela Adormecida, morde uma maçã envenenada dada pela Bruxa Má.", null, "F", 20),
                new Pergunta("[MÚLTIPLA ESCOLHA] Qual princesa sonha em abrir seu próprio restaurante em Nova Orleans?", List.of("Tiana", "Jasmine", "Pocahontas", "Branca de Neve"), "1", 10)
        );

        System.out.println("=========================================\n        QUIZ DAS PRINCESAS DISNEY        \n=========================================");
        System.out.println("Jogador: " + jogador + " | Vidas: " + vidas);

        for (Pergunta p : perguntas) {
            if (vidas <= 0) break;

            System.out.println("\n" + p.enunciado());
            if (p.opcoes() != null) {
                for (int i = 0; i < p.opcoes().size(); i++) System.out.println("  " + (i + 1) + ") " + p.opcoes().get(i));
            } else {
                System.out.println("  Digite 'V' para Verdadeiro ou 'F' para Falso.");
            }

            System.out.print("Sua resposta: ");
            if (sc.nextLine().trim().equalsIgnoreCase(p.respostaCorreta())) {
                pontuacao += p.pontos();
                acertos++;
                System.out.println("-> RESPOSTA CORRETA! +" + p.pontos() + " pontos.");
            } else {
                vidas--;
                erros++;
                System.out.println("-> RESPOSTA INCORRETA! Vidas restantes: " + vidas);
            }
        }

        System.out.println("\n=========================================");
        System.out.println(vidas > 0 ? "   PARABÉNS! VOCÊ VENCEU O QUIZ!" : "   GAME OVER! Suas vidas acabaram.");
        System.out.println("=========================================\nPontuação Total: " + pontuacao + "\nAcertos: " + acertos + "\nErros: " + erros + "\n=========================================");
        sc.close();
    }
}


