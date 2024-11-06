package servico;

import java.util.ArrayList;
import dominio.ClasseCurso;
import repositorio.ClasseCursoRepositorio;

public class ClasseCursoServico extends BaseServico<ClasseCurso> {

    private ClasseCursoRepositorio repositorio;

    public ClasseCursoServico(){
        this.repositorio = new ClasseCursoRepositorio();
    }

    @Override
    public ClasseCurso Create(ClasseCurso obj) {
        return this.repositorio.Create(obj);   
    }
    @Override
    public ArrayList<ClasseCurso> LerTodos() {
        return this.repositorio.ReadAll();
    }

    @Override
    public ClasseCurso Ler(int codigo) {
        return this.repositorio.Read(codigo);
    }

    @Override
    public ClasseCurso Atualizar(ClasseCurso obj) {
        return this.repositorio.Update(obj);
    }

    @Override
    public ClasseCurso Deletar(int codigo) {
       return this.repositorio.Delete(codigo);
    }

}
