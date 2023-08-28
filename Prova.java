import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Prova {
    public static void main(String[] args) {
        // scanner
        Scanner teclado = new Scanner(System.in);
        // coleção para armazenar os alunos e conceitos, sendo aluno a chave e conceito o valor
        Map<String, String> alunos = new HashMap<>();
        // variável para armazenar a opção do usuário
        int opcao = 0;
        // vetor para armazenar a quantidade de cada conceito como proposto na atividade avaliativa
        int[] qntdConceitos = { 0, 0, 0, 0 };
        // vetor para identificar os conceitos válidos
        Character[] conceitos = { 'O', 'B', 'R', 'I' };
        do {
            try {
                // função para limpar a tela e ficar melhor visualmente
                ClearScreen();
                // Menu de Opções
                System.out.println("Bem vindos ao sistema de notas");
                System.out.println("Escolha uma opção: ");
                System.out.println("1 - Cadastrar aluno e conceito");
                System.out.println("2 - Listar alunos e conceitos");
                System.out.println("3 - Calcular e exibir a quantidade de cada conceito");
                System.out.println("4 - Exibir os alunos com o conceito mais alto");
                System.out.println("5 - Sair");
                // ler a opção do usuário
                opcao = teclado.nextInt();
                // esperar para continuar
                teclado.nextLine();
            } catch (Exception e) {
                // caso o usuário digite algo diferente de um número inteiro
                System.out.println("Opção inválida");
                // esperar para continuar
                teclado.nextLine();
            }
            switch (opcao) {
                case 1:

                    ClearScreen();
                    // definir a variavel para verificar se o conceito é válido
                    int erro = 0;
                    System.out.println("Digite o nome completo do aluno: ");
                    // ler o nome do aluno
                    String nome = teclado.nextLine();
                    System.out.println("Digite o conceito do aluno: ");
                    // ler o conceito do aluno
                    String conceito = teclado.nextLine();
                    // transformar em letra maiuscula para garantir que o if funcione
                    conceito = conceito.toUpperCase();
                    // for pra verificar qual é o conceito valido e aumentar o contador
                    for (int i = 0; i < conceitos.length; i++) {
                        if (conceitos[i] == conceito.charAt(0)) {
                            qntdConceitos[i]++;
                            // colocando os dados no map se o conceito for válido
                            alunos.put(nome, conceito);
                        } else {
                            // adicionar o erro para verificar depois
                            erro++;
                        }
                    }
                    // erro == 4 porque foi verificado 4 vezes para cada conceito, se for 4 é porque o conceito é invalido
                    if (erro == 4) {
                        System.out.println("Conceito inválido");
                        teclado.nextLine();
                    }

                    break;
                case 2:
                    ClearScreen();
                    // for each para ler os dados do map
                    // o key set retorna as chaves do map para procurar os valores e mostrar
                    for (String aluno : alunos.keySet()) {
                        System.out.println("Aluno: " + aluno + " Conceito: " + alunos.get(aluno));

                    }
                    teclado.nextLine();
                    break;
                case 3:
                    ClearScreen();
                    // for para ler o vetor e mostrar a quantidade alunos que tiraram tal conceito
                    for (int i = 0; i < conceitos.length; i++) {
                        System.out.println("Quantidade de conceitos " + conceitos[i] + ": " + qntdConceitos[i]);
                    }
                    teclado.nextLine();
                    break;
                case 4:
                    ClearScreen();
                    // verificar se alguem tirou nota maxima
                    if (qntdConceitos[0] > 0) {
                        System.out.println("Alunos com conceito O: ");
                        // for each para verificar quais alunos que tiraram nota maxima
                        for (String aluno : alunos.keySet()) {
                            if (alunos.get(aluno).equals(conceitos[0].toString())) {
                                System.out.println(aluno);
                            }
                        }
                    }

                    teclado.nextLine();
                    break;
                case 5:
                    break;
                    // caso o usuario digite uma opção inválida	
                default:
                    ClearScreen();
                    System.out.println("Opção inválida");
                    teclado.nextLine();
                    break;

            }
            // finalizando loop
        } while (opcao != 5);
        // fechando o scanner
        teclado.close();
    }

    // limpar a tela
    private static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}