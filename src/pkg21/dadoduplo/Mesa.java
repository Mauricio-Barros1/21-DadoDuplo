/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21.dadoduplo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Mesa {

protected Player players;
	protected int NumPlayer;
	protected DadoDuploClass dado;
	protected int[] placar;
	protected Player playerAtualAtaque;
	protected Player playerAtualDefesa;
        protected ArrayList<Player> listaPlayers;
	protected Lance lanceAtual;
        
        public Mesa(){
            NumPlayer = 2;
            placar[0] = 0;
            placar[1] = 0;
            listaPlayers.add(new Player());
            listaPlayers.add(new Player());
            
        }
        

	public int enviarNumAtual() {
		// TODO - implement Mesa.enviarNumAtual
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param message
	 */
	public void enviarMsg(String message) {
		// TODO - implement Mesa.enviarMsg
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogada
	 */
	public void enviarJogada(Lance jogada) {
		// TODO - implement Mesa.enviarJogada
		throw new UnsupportedOperationException();
	}

	public int[] girarDados() {
		// TODO - implement Mesa.girarDados
                return dado.giraDados();
//		throw new UnsupportedOperationException();
	}    
    
}
