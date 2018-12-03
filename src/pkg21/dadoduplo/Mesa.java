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
	protected int[] placar = new int[2];
	protected Player player2;
	protected Player player1;
        public ArrayList<Player> listaPlayers;
	protected Lance lanceAtual;
        private int numAtual;

    public int getNumAtual() {
        return numAtual;
    }

    public void setNumAtual(int numAtual) {
        this.numAtual = numAtual;
    }
        
        public Mesa(){
            NumPlayer = 2;
            placar[0] = 0;
            placar[1] = 0;
            listaPlayers = new ArrayList<>();
            dado=new DadoDuploClass();
            numAtual = 0;
//            listaPlayers.add(new Player());
//            listaPlayers.add(new Player());
            
        }
        
        
        public void criarPlayers(String nome1, int posicao1, String nome2, int posicao2){
            
//            listaPlayers.add(new Player(nome1, posicao1));
//            listaPlayers.add(new Player(nome2, posicao2));

            System.out.println("Chegou método criarPlayer da classe Mesa");
            
              player1 = new Player(nome1, posicao1);
              player2 = new Player(nome2, posicao2);
            
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

	public int girarDados() {
		// TODO - implement Mesa.girarDados
//                int[] i = new int[2];
//                i = dado.giraDados();
//                String j = "" + i;
                //TIREI AQUI TIREI AQUI
//                int z = Integer.parseInt(j);
//                numAtual = z;
                int i = dado.giraDados();
                return i;
//                return dado.giraDados();
//		throw new UnsupportedOperationException();
	}

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    
    public void setPlacar(int quem, int pontos){
                       
        this.placar[quem] = this.placar[quem] + pontos;
    }
    
    public void setPlacarAbsoluto(int quem, int placar){
        this.placar[quem] = placar;
    }
    
    public int getPlacar(int quem){
        return this.placar[quem];
    }
        
        
        
    
}
