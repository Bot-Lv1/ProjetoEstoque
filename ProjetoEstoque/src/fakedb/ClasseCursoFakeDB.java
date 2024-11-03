package fakedb;

import java.util.ArrayList;

import dominio.ClasseCurso;

public class ClasseCursoFakeDB extends BaseFakeDB<ClasseCurso>{
    
    public ClasseCursoFakeDB(){
        super();
    }

    @Override
    protected void preencherDados() {
       this.tabela = new ArrayList<>();
       this.tabela.add(new ClasseCurso(1, "Engenharia da Computação", "Presencial", 40));
       this.tabela.add(new ClasseCurso(2, "Pedagogia", "Semi-presencial", 50));
       this.tabela.add(new ClasseCurso(3, "Ciências Contábeis", "Semi-presencial", 35));
       this.tabela.add(new ClasseCurso(4, "Letras", "Semi-presencial", 60));
    }

}
