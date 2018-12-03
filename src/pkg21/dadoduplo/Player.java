/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21.dadoduplo;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Player {
        protected String nome;
	protected int posicao;
	protected int estado;
	protected int pontuacao;   
	protected int numAtual;
        
        public Player(String nome, int posicao){
            this.setNome(nome);
            this.setPosicao(posicao);
            pontuacao = 0;
            System.out.println("Chegou método construtor da classe Player");
        }
        
        public Player(){
            
        }

	public void receberNumAtual() {
		// TODO - implement Player.receberNumAtual
		throw new UnsupportedOperationException();
	}

	public void gerarMensagem() {
		// TODO - implement Player.gerarMensagem
		throw new UnsupportedOperationException();
	}

	public void aceitar() {
		// TODO - implement Player.aceitar
		throw new UnsupportedOperationException();
	}

	public void duvidar() {
		// TODO - implement Player.duvidar
		throw new UnsupportedOperationException();
	}

	public void declararLance(int numero) {
            
            
//		throw new UnsupportedOperationException();
	}
        
        public void declararLance(boolean aceito){
            
        }

	public void girarDados() {
		// TODO - implement Player.girarDados
		throw new UnsupportedOperationException();
	}

	public void verificaPosicao() {
		// TODO - implement Player.verificaPosicao
		throw new UnsupportedOperationException();
	}

	public void setNome() {
		// TODO - implement Player.setNome
                this.nome = JOptionPane.showInputDialog("Digite seu nome:");
//                throw new UnsupportedOperationException();
	}
        
        
         public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getNumAtual() {
        return numAtual;
    }

    public void setNumAtual(int numAtual) {
        this.numAtual = numAtual;
    }
    
}
