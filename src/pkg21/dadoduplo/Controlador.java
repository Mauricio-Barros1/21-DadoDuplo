/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21.dadoduplo;

import br.ufsc.inf.leobr.cliente.Jogada;



public class Controlador{


	protected Mesa mesa;
        private static final Controlador controlador = new Controlador();
        private ControladorRede controladorRede;
        private TelaInicial tela;
        
        public Controlador(){
            
            iniciar();
        }
        
        private void iniciar(){
            controladorRede = new ControladorRede(this);
            tela = new TelaInicial(controladorRede);
//            tela.rock();
            tela.setVisible(true);
            
//            tela.setVisible(true);
        }
        
        
        
        public Controlador getInstance(){
            return this.controlador;
        }
        
        
        public void efetuarJogadaRede(Jogada jogada){
            
        }
        

	public void verificaQuemJoga() {
		// TODO - implement Controlador.verificaQuemJoga
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogada
	 */
	public void enviarAtaque(Lance jogada) {
		// TODO - implement Controlador.enviarAtaque
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogada
	 */
	public void enviarDefesa(Lance jogada) {
		// TODO - implement Controlador.enviarDefesa
		throw new UnsupportedOperationException();
	}

	public void iniciarPartida() {
		// TODO - implement Controlador.iniciarPartida
		throw new UnsupportedOperationException();
	}

	public void verificaConexao() {
		// TODO - implement Controlador.verificaConexao
		throw new UnsupportedOperationException();
	}

	public void desconectar() {
		// TODO - implement Controlador.desconectar
		throw new UnsupportedOperationException();
	}

	public void conectar() {
		// TODO - implement Controlador.conectar
		throw new UnsupportedOperationException();
	}

	public void girarDados() {
		// TODO - implement Controlador.girarDados
		throw new UnsupportedOperationException();
	}

}
