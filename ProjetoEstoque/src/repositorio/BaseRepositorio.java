package repositorio;

import java.util.ArrayList;

public abstract class BaseRepositorio<TDominio> {

    protected ArrayList<TDominio> BaseDeDados;
    
    public abstract TDominio Create(TDominio instancia);

    public ArrayList<TDominio> ReadAll(){
        return this.BaseDeDados;
    }

    public abstract TDominio Read(int codigo);

    public abstract TDominio Update(TDominio instancia);

    public abstract TDominio Delete(int codigo);
}


