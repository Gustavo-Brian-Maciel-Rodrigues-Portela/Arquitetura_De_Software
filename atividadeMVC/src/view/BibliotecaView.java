package view;

import controller.BibliotecaController;
import model.Livro;

import java.util.List;
import java.util.Scanner;

public class BibliotecaView {
    private BibliotecaController controller;
    private Scanner scanner;

    public BibliotecaView(BibliotecaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Buscar Livro por Título");
            System.out.println("3. Buscar Livro por Autor");
            System.out.println("4. Emprestar Livro");
            System.out.println("5. Devolver Livro");
            System.out.println("6. Listar Todos os Livros");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    buscarLivrosPorTitulo();
                    break;
                case 3:
                    buscarLivrosPorAutor();
                    break;
                case 4:
                    emprestarLivro();
                    break;
                case 5:
                    devolverLivro();
                    break;
                case 6:
                    listarTodosOsLivros();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void adicionarLivro() {
        System.out.print("Digite o título do livro:");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro:");
        String autor = scanner.nextLine();
        System.out.print("Digite o número de registro do livro:");
        String numeroRegistro = scanner.nextLine();

        controller.adicionarLivro(titulo, autor, numeroRegistro);
        System.out.println("Livro adicionado com sucesso!");
    }

    private void buscarLivrosPorTitulo() {
        System.out.print("Digite o título do livro:");
        String titulo = scanner.nextLine();
        List<Livro> livros = controller.buscarLivrosPorTitulo(titulo);
        mostrarLivros(livros);
    }

    private void buscarLivrosPorAutor() {
        System.out.print("Digite o autor do livro:");
        String autor = scanner.nextLine();
        List<Livro> livros = controller.buscarLivrosPorAutor(autor);
        mostrarLivros(livros);
    }

    private void emprestarLivro() {
        System.out.print("Digite o número de registro do livro:");
        String numeroRegistro = scanner.nextLine();
        boolean sucesso = controller.emprestarLivro(numeroRegistro);
        if (sucesso) {
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro não encontrado ou já emprestado.");
        }
    }

    private void devolverLivro() {
        System.out.print("Digite o número de registro do livro:");
        String numeroRegistro = scanner.nextLine();

        controller.devolverLivro(numeroRegistro);
        System.out.println("Livro devolvido com sucesso!");
    }

    private void listarTodosOsLivros() {
        List<Livro> livros = controller.getLivros();
        mostrarLivros(livros);
    }

    private void mostrarLivros(List<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + ", Número de Registro: " + livro.getNumeroRegistro());
            }
        }
    }
}
