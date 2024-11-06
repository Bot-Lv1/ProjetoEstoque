package servico;

import java.util.ArrayList;

public abstract class BaseServico<TDominio> {
    public abstract TDominio Create(TDominio obj);
    public abstract ArrayList<TDominio> LerTodos();
    public abstract TDominio Ler(int codigo);
    public abstract TDominio Atualizar(TDominio obj);
    public abstract TDominio Deletar(int codigo);
}
