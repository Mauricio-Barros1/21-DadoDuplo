/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21.dadoduplo;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.Proxy;
import java.util.List;



public class Controlador{


	protected Mesa mesa;
        private static final Controlador controlador = new Controlador();
        private ControladorRede controladorRede;
        private TelaInicial tela;
        private IniciarPartidaUI telaIniciaJogo;
        private JanelaAtaqueUI ataqueUI;
        private JanelaDefesaUI defesaUI;
        private boolean defesaEhVez = false;
        private boolean ataqueEhVez = true;
        private Player player1;
        private Player player2;
        
        public Controlador(){
            
            iniciar();
        }
        
        private void iniciar(){
            controladorRede = new ControladorRede(this);
            tela = new TelaInicial(controladorRede);
            
//            tela.rock();
            tela.setVisible(true);
            mesa = new Mesa();
            
//            tela.setVisible(true);
        }
        
        public int getNumAtual(){
            return mesa.getNumAtual();
        }
        
        public void setNumAtual(int num){
            
            mesa.setNumAtual(num);
            
        }
        
        public void iniciarPartidaRede(int posicao){
            
            int flag = 0;
            
            switch(posicao){
            
                case 1:
                    
                    System.out.println("case 1 no método iniciarPartidaRede - Controlador");
//                    String idJ1 = Proxy.getInstance().getNomeJogador();
                    String idJ1 = controladorRede.getNomePlayer();
                    System.out.println("nome player case 1 :" + idJ1);
                    
                    
                    List <String> idJ2 = controladorRede.getNomeAdversario();
                    System.out.println("nome adversario case 1 :" + idJ2.get(0));
                    
//                    String idJ2 = "adversario";
                    mesa.criarPlayers(idJ1, posicao, idJ2.get(0), 2);
//                    mesa.criarPlayers("eu", 1, "adve", 2);
                    ataqueEhVez = true;
                    defesaEhVez = false;
                    ataqueUI = new JanelaAtaqueUI(this);
                    ataqueUI.setPlayer(mesa.getPlayer1());
                    ataqueUI.setNumAtual(0);
                    ataqueUI.setVisible(true);
                    
          
                    
                break;
                case 2:
                    
                    System.out.println("case 2 no método iniciarPartidaRede - Controlador");
//                    String idJ12 = Proxy.getInstance().getNomeJogador();
                    String idJ12 = controladorRede.getNomePlayer();
                    System.out.println("nome player case 2 :" + idJ12);
                    
                    
//                    String idJ22 = Proxy.getInstance().obterNomeAdversarios().get(0);
                    List <String> idJ22 = controladorRede.getNomeAdversario();
                    System.out.println("nome adversario case 2 :" + idJ22.get(0));
//                    String idJ22 = "adversario";
                    mesa.criarPlayers(idJ12, posicao, idJ22.get(0), 1);
                    ataqueEhVez = false;
                    defesaEhVez = true;
                    defesaUI = new JanelaDefesaUI(this);
                    defesaUI.setPlayer(mesa.getPlayer1());
                    defesaUI.setNumAtual(0);
                    defesaUI.setVisible(true);
                    
                    
                    
                break;
                    
            }
            
            
        }
        
        
        
        public Controlador getInstance(){
            return this.controlador;
        }
        
        
        public void receberJogadaRede(Jogada jogada){
            Lance lance = (Lance) jogada;
//            int num = lance.getNumDito();
//            defesaUI.setTela(num);
            int bitControl = lance.getBitControle();
            int numAtual = lance.getNumAtual();
            int numDito = lance.getNumDito();
            int numReal = lance.getNumReal();
            boolean aceita = lance.isAceita();
            switch(bitControl){
                
                case 1:
                    defesaUI.setTela(numDito);
                    defesaUI.setNumDito(numDito);
                    defesaUI.setNumReal(numReal);
                    defesaEhVez = true;
                    ataqueEhVez = false;
                break;
                case 0:
                    
                    ataqueEhVez = true;
                    defesaEhVez = false;
                    
                    if(aceita){
                        mesa.setNumAtual(numDito);
                        
                        Player player = ataqueUI.getPlayer();
                       
                        
//                        Player playerDef = defesaUI.getPlayer();
                        enviarAtaque(new Lance(0, mesa.getNumAtual(), 0,  3, false));
                       
                        ataqueUI.dispose();
//                        defesaUI.dispose();
                        
//                        ataqueUI = new JanelaAtaqueUI(this);
//                        ataqueUI.setVisible(true);
//                        ataqueUI.setPlayer(playerDef);
                        
                        defesaUI = new JanelaDefesaUI(this);
                        defesaUI.setVisible(true);
                        defesaUI.setPlayer(player);
                        defesaUI.setNumAtual(mesa.getNumAtual());
                    }else{
                        
                        if(numReal == numDito){
                            //player deesa perde 2 pontos
                            if(ataqueEhVez){
                                mesa.setPlacar(1, 2);
                            }else if(defesaEhVez){
                                mesa.setPlacar(0, 2);
                            }                          
                            
                        }else{
                            //player ataque perde 1 ponto
                            if(ataqueEhVez){
                                mesa.setPlacar(0, 1);
                            }else if(defesaEhVez){
                                mesa.setPlacar(1, 1);
                            }
                        }
                        
                        enviarLance(new Lance(mesa.getPlacar(0), mesa.getPlacar(1), 0, 4, false));
                        mesa.setNumAtual(0);
                        Player player = ataqueUI.getPlayer();
                        ataqueUI.dispose();
                        defesaUI = new JanelaDefesaUI(this);
                        defesaUI.setVisible(true);
                        defesaUI.setPlayer(player);
                        defesaUI.setPlacar(mesa.getPlacar(0));
                        defesaUI.setNumAtual(0);
                        
                    }
                    
                break;
                case 3:
                    
                    setNumAtual(numAtual);
                    Player player = defesaUI.getPlayer();
                    defesaUI.dispose();
                    
                    ataqueEhVez = true;
                    defesaEhVez = false;
                    
                    ataqueUI = new JanelaAtaqueUI(this);
                    ataqueUI.setVisible(true);
                    ataqueUI.setPlayer(player);
                    ataqueUI.setNumAtual(this.mesa.getNumAtual());
                    
                    
                break;
                case 4:
                    //ajeitar p placar 
                    //trocar de UI
                    //numdito e numatual
                    int placaradv = numDito;
                    int placarplayer = numAtual;
                    mesa.setPlacarAbsoluto(0, placarplayer);
                    mesa.setPlacarAbsoluto(1, placaradv);
                    
                    Player player2 = defesaUI.getPlayer();
                    defesaUI.dispose();
                    ataqueUI = new JanelaAtaqueUI(this);
                    ataqueUI.setVisible(true);
                    ataqueUI.setPlayer(player2);
                    ataqueUI.setPlacar(mesa.getPlacar(0));
                    ataqueUI.setNumAtual(0);
                    
                    
                break;
                
            }
            
            
            
            
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
		
            controladorRede.enviarJogadaRede(jogada);
            
	}
        
        public void enviarLance(Lance jogada){
            controladorRede.enviarJogadaRede(jogada);
        }

	/**
	 * 
	 * @param jogada
	 */
	public void enviarDefesa(Lance jogada) {
            
		controladorRede.enviarJogadaRede(jogada);
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

	public int girarDados() {
		return mesa.girarDados();
	}

}
