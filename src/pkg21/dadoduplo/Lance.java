/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21.dadoduplo;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Lance implements Jogada {
    
    	protected int numDito;
//	protected boolean aceitaOUduvida;
	protected int numAtual;
        private int bitControle;
        private int numReal;
        private String msg;

    public int getBitControle() {
        return bitControle;
    }

    public void setBitControle(int bitControle) {
        this.bitControle = bitControle;
    }
        private boolean aceita;
//	private Mensagem mensagem;
        
        public Lance(int numDeclarado, int numAtual, int numReal, int bit, boolean aceita, String msg){
            numDito =numDeclarado;
            this.numAtual = numAtual;
            this.bitControle = bit;
            this.aceita = aceita;
            this.numDito = numDeclarado;
            this.numReal = numReal;
            this.msg= msg;
        }

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

    public boolean isAceita() {
        return aceita;
    }

    public void setAceita(boolean aceitaOUduvida) {
        this.aceita = aceitaOUduvida;
    }

    public int getNumAtual() {
        return numAtual;
    }

    public void setNumAtual(int numAtual) {
        this.numAtual = numAtual;
    }

    public int getNumReal() {
        return numReal;
    }

    public void setNumReal(int numReal) {
        this.numReal = numReal;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


	

}
