package util;
public class ElementoFila {    
    private ElementoFila proximo;
    private Object conteudo;
        
    public ElementoFila getProximo() {
        return proximo;
    }
    public void setProximo(ElementoFila proximo) {
        this.proximo = proximo;
    }
    
    public Object getConteudo() {
        return conteudo;
    }
    
    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }
    public String getNome() {
        if (getConteudo() != null) {
            return getConteudo().toString();
        } else {
            return "null";
        }
    }
    public String toString() {
        return getNome();
    }
}
