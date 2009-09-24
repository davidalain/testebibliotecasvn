package util;
public class ElementoPilha {    
    private ElementoPilha anterior;
    private Object conteudo;
    
    
    public ElementoPilha getAnterior() {
        return anterior;
    }
    public void setAnterior(ElementoPilha anterior) {
        this.anterior = anterior;
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
