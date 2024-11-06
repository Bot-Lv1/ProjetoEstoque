package visao;

import java.util.ArrayList;

import dominio.ClasseCurso;
import servico.ClasseCursoServico;

public class ClasseCursoMenu extends BaseMenu {

    private ClasseCursoServico srv;

    public ClasseCursoMenu(){
        super();
        this.srv = new ClasseCursoServico();
    }

    @Override
    public void ExibirMenu() {
       int opcao = 0;
       while(opcao != 9)
        {
            Util.ClearConsole();
            System.out.println("Classe Curso");
            System.out.println("Menu de Opções");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.print("Digite sua opção: ");
            opcao = this.scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break; 
                case 9:
                    System.out.println("Saindo...");
                    break;           
                default:
                    System.out.println("Opção inválida");
                    break;
            }


        }
    }

    @Override
    public void Listar() {
        Util.ClearConsole();
        System.out.println("Listando...");

        ArrayList<ClasseCurso> lista = this.srv.LerTodos();
        for (ClasseCurso curso : lista){
            this.ImprimirEmLinha(curso);
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.ClearConsole();
        System.out.println("Localizando...");

        System.out.print("Informe o código da Classe do Curso: ");
        int codigo = this.scanner.nextInt();

        ClasseCurso curso = this.srv.Ler(codigo);
        if (curso != null){
            this.ImprimirEmLinha(curso);
        }
        else{
            System.out.println("Problema - Classe do Curso não foi encontrada");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
       Util.ClearConsole();
       System.out.println("Adionando...");

       System.out.print("Informe o Nome da Classe do Curso: "); 
       String nome = this.scanner.next();

       System.out.print("Informe a Descrição da Classe do Curso: "); 
       String descricao = this.scanner.next();

       System.out.print("Informe a Carga Horária da Classe do Curso: "); 
       int cargaHoraria = this.scanner.nextInt(); 

       ClasseCurso curso = new ClasseCurso();
       curso.setCodigo(0);
       curso.setNome(nome);
       curso.setDescricao(descricao);
       curso.setCargaHoraria(cargaHoraria);

       ClasseCurso cursoNovo = this.srv.Criar(curso);
       if (cursoNovo != null) {
            System.out.println("Classe de Curso adicionada com sucesso");
       }
       else{
        System.out.println("Problema - Classe de Curso não foi adicionada");
       }

       System.out.println("Clique <ENTER> para continuar...");
       this.scanner.nextLine();
       this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.ClearConsole();
        System.out.println("Atualizando...");

        System.out.print("Informe o código da Classe do Curso: ");
        int codigo = this.scanner.nextInt();

        ClasseCurso curso = this.srv.Ler(codigo);
        if (curso != null) {
            System.out.print("Informe o Nome da Classe do Curso: ");
            String nome = this.scanner.next();

            System.out.print("Informe a Descrição da Classe do Curso: ");
            String descricao = this.scanner.next();

            System.out.print("Informe a Carga Horária da Classe do Curso: ");
            int cargaHoraria = this.scanner.nextInt();

            curso.setDescricao(descricao);
            curso.setNome(nome);
            curso.setCargaHoraria(cargaHoraria);

            if (this.srv.Atualizar(curso) != null) {
                System.out.println("Classe do Curso atualizada com sucesso");
            }
            else{
                System.out.println("Problema - Classe do Curso não foi atualizada");
            }
        }
        else{
            System.out.println("Problema - Classe do Curso não foi encontrada");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
       Util.ClearConsole();
       System.out.println("Removendo...");

       System.out.print("Informe o código da Classe do Curso: ");
       int codigo = this.scanner.nextInt();

       ClasseCurso curso = this.srv.Ler(codigo);
       if (curso != null) {
            if (this.srv.Deletar(codigo) != null) {
                System.out.println();
                ImprimirEmLinha(curso);
                System.out.println();
                System.out.println("Classe do Curso removida com sucesso");
            }
            else{
                System.out.println("Problema - Classe do Curso não foi removida");
            }
        }
        else{
            System.out.println("Problema - Classe do Curso não foi encontrada");
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void ImprimirEmLinha(ClasseCurso curso){
        String msg = "Classe do Curso - ";
        msg += "Código: " + curso.getCodigo() + " | ";
        msg += "Nome: " + curso.getNome() + " | ";
        msg += "Descrição: " + curso.getDescricao() + " | ";
        msg += "Carga Horária: " + curso.getCargaHoraria();
        System.out.println(msg);
    }
}
