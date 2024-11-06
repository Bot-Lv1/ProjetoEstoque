package repositorio;

import dominio.ClasseCurso;
import fakedb.ClasseCursoFakeDB;

public class ClasseCursoRepositorio 
    extends BaseRepositorio<ClasseCurso>{
    
    private ClasseCursoFakeDB db;

    public ClasseCursoRepositorio(){
        this.db = new ClasseCursoFakeDB();
        this.BaseDeDados = this.db.getTabela();
    }

    @Override
    public ClasseCurso Create(ClasseCurso instancia) {
       int pos = this.BaseDeDados.size() - 1;
       ClasseCurso curso = this.BaseDeDados.get(pos);
       int proxCodigo = curso.getCodigo() + 1;

       instancia.setCodigo(proxCodigo);
       this.BaseDeDados.add(instancia);
       return instancia;
    }

    @Override
    public ClasseCurso Read(int codigo) {
        for (ClasseCurso curso : this.BaseDeDados){
            if (curso.getCodigo() == codigo) {
                return curso;
            }
        }
        return null;
    }

    @Override
    public ClasseCurso Update(ClasseCurso instancia) {
        ClasseCurso curso = this.Read(instancia.getCodigo());
        if (curso != null) {
            curso.setDescricao(instancia.getDescricao());
            return curso;
        }
        else{
            return null;
        }
    }

    @Override
    public ClasseCurso Delete(int codigo) {
        ClasseCurso curso = this.Read(codigo);
        if (curso != null) {
            this.BaseDeDados.remove(curso);
            return curso;
        }
        else{
            return null;
        }
    }
}