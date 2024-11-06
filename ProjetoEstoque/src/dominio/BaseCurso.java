package dominio;


public abstract class BaseCurso{
    protected int codigo;
    protected String nome;
    protected String descricao;
    protected int cargaHoraria;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public BaseCurso(){
    }
    public BaseCurso(int codigo, String nome, String descricao, int cargaHoraria){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }
     

}