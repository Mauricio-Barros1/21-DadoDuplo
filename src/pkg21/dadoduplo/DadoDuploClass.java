/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21.dadoduplo;

import java.util.Random;

/**
 *
 * @author user
 */
public class DadoDuploClass {  
        
    protected int numAtual;
	protected int numAnterior;

	public int getNumatual() {
		// TODO - implement DadoDuplo.getNumatual
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Numatual
	 */
	public void setNumatual(int Numatual) {
		// TODO - implement DadoDuplo.setNumatual
		throw new UnsupportedOperationException();
	}

	public int giraDados() {
		// TODO - implement DadoDuplo.giraDados
//                int[] numerosGirados = new int[2];
//                Random gerador = new Random();
//                numerosGirados[0] = gerador.nextInt(6);
//		numerosGirados[1] = gerador.nextInt(6);
//                return numerosGirados;

            int numeroGirado;
            Random gerador = new Random();
            numeroGirado = (gerador.nextInt(21) + 1);
            
            return numeroGirado;

                
	}

	public void zerar() {
		// TODO - implement DadoDuplo.zerar
		throw new UnsupportedOperationException();
	}

	public void getNumAnterior() {
		// TODO - implement DadoDuplo.getNumAnterior
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numAnterior
	 */
	public void setNumAnterior(int numAnterior) {
		this.numAnterior = numAnterior;
	}    
}
