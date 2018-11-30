/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21.dadoduplo;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Lance implements Jogada {
    
    	protected int numDito;
	protected boolean aceitaOUduvida;
	protected int numAtual;
//	private Mensagem mensagem;

	public boolean verificarJogada() {
		// TODO - implement Lance.verificarJogada
		throw new UnsupportedOperationException();
        }
    

    public int getNumDito() {
        return numDito;
    }

    public void setNumDito(int numDito) {
        this.numDito = numDito;
    }

    public boolean isAceitaOUduvida() {
        return aceitaOUduvida;
    }

    public void setAceitaOUduvida(boolean aceitaOUduvida) {
        this.aceitaOUduvida = aceitaOUduvida;
    }

    public int getNumAtual() {
        return numAtual;
    }

    public void setNumAtual(int numAtual) {
        this.numAtual = numAtual;
    }


	

}
