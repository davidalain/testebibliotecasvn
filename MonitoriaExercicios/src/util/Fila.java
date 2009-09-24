package util;
public class Fila {
    private ElementoFila primeiro;
    private ElementoFila ultimo;

    
    protected ElementoFila getUltimo() {
		return ultimo;
	}


	protected void setUltimo(ElementoFila ultimo) {
		this.ultimo = ultimo;
	}


	public ElementoFila getPrimeiro() {
        return primeiro;
    }

    
    public void setPrimeiro(ElementoFila primeiro) {
        this.primeiro = primeiro;
    }
    
    public void inserir_OLD(Object conteudo) {
    	ElementoFila elemento = new ElementoFila();
    	elemento.setConteudo(conteudo);
        ElementoFila ultimo = acharUltimo();
        //ElementoFila ultimo = acharUltimo2();
        if (ultimo == null) {
            setPrimeiro(elemento);
        } else {
            ultimo.setProximo(elemento);
        }
    }
    public void inserir(Object conteudo) {
    	ElementoFila elemento = new ElementoFila();
    	elemento.setConteudo(conteudo);    	
        if (ultimo == null) {
            setPrimeiro(elemento);
        } else {
            ultimo.setProximo(elemento);
        }
        setUltimo(elemento);
    }
    
    // acharUltimo sem recursao
    
    private ElementoFila acharUltimo2() {
        ElementoFila proximo = getPrimeiro();
        ElementoFila ultimo = null;
        if (proximo != null) {
            do {
                ultimo = proximo;
                proximo = ultimo.getProximo();  
            } while (proximo != null);          
        } 
        return ultimo;
    }

    // acharUltimo com recursao
    private ElementoFila acharUltimo() {        
        return acharUltimo(getPrimeiro());
    }
    private ElementoFila acharUltimo(ElementoFila elementoAtual) {
        if (elementoAtual == null) { 
            return null;
        } else if (elementoAtual.getProximo() == null) {
            return elementoAtual;
        } else {
            return acharUltimo(elementoAtual.getProximo());
        }
    }
    
    public void dump() {
        ElementoFila elemento = getPrimeiro();
        while(elemento != null) {
            System.out.println(elemento.getNome());
            elemento = elemento.getProximo();
        }
    }
    
    public Object remover() {
        ElementoFila ret = getPrimeiro();
        if (ret != null) {            
            setPrimeiro(ret.getProximo());
            ret.setProximo(null);
            if (ultimo == ret) {
            	setUltimo(null);
            }
        }
        return ret.getConteudo();
    }
    public Object remover_OLD() {
        ElementoFila ret = getPrimeiro();
        if (ret != null) {            
            setPrimeiro(ret.getProximo());
            ret.setProximo(null);
        }
        return ret.getConteudo();
    }    
    
    public Object ler() {
        return getPrimeiro().getConteudo();
    }    
}
