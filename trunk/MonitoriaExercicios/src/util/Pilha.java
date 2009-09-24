package util;
public class Pilha {
    private ElementoPilha ultimo;

    
    public ElementoPilha getUltimo() {
        return ultimo;
    }

    
    public void setUltimo(ElementoPilha ultimo) {
        this.ultimo = ultimo;
    }
    
    public void empilhar(Object conteudo) {
        ElementoPilha elemento = new ElementoPilha();
        elemento.setConteudo(conteudo);         
        elemento.setAnterior(getUltimo());            
        setUltimo(elemento);            
    }
    public void dump() {
        ElementoPilha elemento = getUltimo();
        while(elemento != null) {
            System.out.println(elemento.getNome());
            elemento = elemento.getAnterior();
        }
    }
    public Object desempilhar() {
        ElementoPilha ret = getUltimo();
        if (ret != null) {            
            setUltimo(ret.getAnterior());
            ret.setAnterior(null);
            return ret.getConteudo(); 
        } else {
            return null;
        } 
    }
    public Object ler() {
        if (getUltimo() != null) {
            return getUltimo().getConteudo();
        } else {
            return null;
        }
    }
    public boolean estaVazio() {
        return getUltimo() == null; 
    }
}
