package Exercicio4ListaEncadeada;

import util.Pessoa;

public class MainTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 10 ; i++){
			
			System.out.println(i);
			
			if (i == 5){
				throw new RuntimeException("i é 5");
			}
			
			
		}
		
	}

}
