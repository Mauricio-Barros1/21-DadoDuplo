/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21.dadoduplo;

import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class ControladorRede implements OuvidorProxy {
    
    public Proxy proxy;
    public Controlador controlador;
    public boolean ehJogoRede = false;
    public boolean ehMinhaVez = false;
    private IniciarPartidaUI jframeInicio;
    ControladorRede rede;
    
    public Controlador getControlador(){
        return this.controlador;
    }
     
    public ControladorRede(Controlador controlador){
        super();//NECESSÁRIO?
        this.controlador = controlador;
	proxy = Proxy.getInstance();
	
    }
    public ControladorRede(Controlador controlador, ControladorRede rede){
        super();//NECESSÁRIO?
        this.controlador = controlador;
        this.rede = rede;
	proxy = Proxy.getInstance();
	
    }
     
    //CONECTAR À REDO COM O PROXY
    protected void conectarRede(String nome, String ipServidor) {
        try {
            Proxy.getInstance().conectar(ipServidor, nome);
		//Adiciona o ator como um dos ouvintes do Proxy.
            Proxy.getInstance().addOuvinte(this);
            JOptionPane.showMessageDialog(null, "Você está conectado!");
            
	} catch (JahConectadoException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
	} catch (NaoPossivelConectarException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: "
					+ e.getMessage());
	} catch (ArquivoMultiplayerException e) {
	// TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: "
					+ e.getMessage());
	}
    }
    
    
    /**
	 * Inicia uma partida de rede.
	 * Esse método é chamado por um jogador que está conectado e deseja jogar.
	 * No servidor, um outro jogador, também conectado e que ainda não está jogando será sorteado para inciar uma partida.
	 * O usuário quando chama esse método ainda não iniciou uma partida, mas solicitou seu inicio.
	 */
    //FAZ O REQUERIMENTO PARA INICIAR
	protected void iniciarPartidaRede(IniciarPartidaUI janelaUI) {
//		controlador.iniciarPartidaRede(1);//PUS AQUI PUS AQUI
                this.jframeInicio = janelaUI;
                try {
			Proxy.getInstance().iniciarPartida(2);
                        jframeInicio.setVisible(true);
                        
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
    
     
    
    /**
	 * Indica que o jogador requisitou uma nova partida e que ela foi aceita e
	 * portanto ele deve "se preparar" parar iniciar essa partida.
	 */
        /* 
	 * Esse método efetivamente inicia a partida.
	 * Ele é chamado pelo servidor em todos os jogadores que fizerem parte da partida,
	 * inclusive pelo usuário que fez a solicitação do início da partida.
	 * (non-Javadoc)
	 * @see br.ufsc.inf.leobr.cliente.OuvidorProxy#iniciarNovaPartida(java.lang.Integer)
	 */
	@Override
	public void iniciarNovaPartida(Integer posicao) {
		switch(posicao){
                    
                    case 1:
                        //jogador em ataque
                        
                        ehJogoRede = true;
                        System.out.println("case 1 no m�todo iniciarNovaPartida() - ControladorRede");
                        controlador.iniciarPartidaRede(1);
                        
                        jframeInicio.dispose();
//                        new JanelaAtaqueUI().setVisible(true);
                        
                    break;
                    case 2:
                        //jogador em defesa
                        
                        ehJogoRede = true;
                        System.out.println("case 2 no m�todo iniciarNovaPartida() - ControladorRede");
                        controlador.iniciarPartidaRede(2);
                        
                        jframeInicio.dispose();
//                        new JanelaDefesaUI().setVisible(true);
                    break;
                    case 3:
                        //jogador em espera
                        ehJogoRede = true;
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "Erro no m�todo iniciarNovaPartida() - Controlador");
                    break;
                    
                    
                }
	}
        
        
        /**
	 * Se o jogo estiver sendo realizado em rede, envia a jogada para os outros
	 * jogadores
	 * 
	 * @param linha
	 * @param coluna
	 */
        public void enviarJogadaRede(Lance jogada) {
            if (ehJogoRede) {
//                Jogada jogada = new Lance(numDeclarado, numAtual, bit, aceita);
		try {
                    Proxy.getInstance().enviaJogada(jogada);
//                    ehMinhaVez = false;
		} catch (NaoJogandoException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, e.getMessage());
		}
            }
	}
        
        
        
        /* Método chamado pelo servidor para enviar a jogada do jogo da velha
	 * para os participantes de uma partida.
	 * O único jogador no qual o método não é invocado é aquele que enviou a jogada.
	 * (non-Javadoc)
	 * @see br.ufsc.inf.leobr.cliente.OuvidorProxy#receberJogada(br.ufsc.inf.leobr.cliente.Jogada)
	 */
        //RECEBE JOGADA DO SERVIDOR
	@Override
	public void receberJogada(Jogada jogada) {
		// Recebe uma jogada do outro lado
		Lance lance = (Lance) jogada;
		controlador.receberJogadaRede(jogada);
		ehMinhaVez = true;

	}
        
        
        /**
	 * Desconecta o jogo da rede.
	 */
	protected void desconectar() {
		try {
			ehJogoRede = false;
			Proxy.getInstance().desconectar();
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro: "
					+ e.getMessage());
		}
		
	}
        
        
        //Métodos complementares
	/**
	 * Reinicia uma partida com todos os iniciantes já selecionados.
	 */
	protected void reiniciar() {
		try {
			Proxy.getInstance().reiniciarPartida();
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro: "
					+ e.getMessage());
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(null, "Erro: "
					+ e.getMessage());
		}

	}
        
        
        
        
        /**
	 * Indica que a partida terminou por algum problema Como por exemplo, se um
	 * dos jogadores for desconectado. E o jogo deve finalizar seu estado no
	 * momento que recebe essa mensagem.
	 */
        @Override
	public void finalizarPartidaComErro(String message){
            JOptionPane.showMessageDialog(null, message);
            ehJogoRede = false;
            
        }

	/**
	 * Recebe uma mensagem em forma de String do servidor.
	 * 
	 * @param arg
	 */
        @Override
	public void receberMensagem(String msg){
            
            JOptionPane.showMessageDialog(null,"Mensagem recebida do servidor:" + msg);
            
        }

	

	/**
	 * Caso n�o consigua se comunicar com o servidor, ex O servidor caiu,
	 * conex�o de rede n�o dispon�vel. Esse m�todo � chamado em todos os
	 * ouvintes.
	 */
        @Override
	public void tratarConexaoPerdida(){
            
            JOptionPane.showMessageDialog(null,
		"A conexão com o servidor foi perdida, por favor tente novamente mais tarde.");
            ehJogoRede = false;
            
        }
	
	/**
	 * Caso n�o consigua se comunicar com o servidor, ex O servidor caiu,
	 * conex�o de rede n�o dispon�vel. Esse m�todo � chamado em todos os
	 * ouvintes.
	 */
        @Override
	public void tratarPartidaNaoIniciada(String message){
            
            JOptionPane.showMessageDialog(null,
		"A partida não pode ser iniciada devido ao seguinte erro: "+ message);
            
        }
        
        
        
        public void lancarIniciarPartidaUI(Controlador controlador, ControladorRede rede){
            this.controlador= controlador;
            this.rede = rede;
            jframeInicio = new IniciarPartidaUI(rede);
            jframeInicio.setVisible(true);
        }
        
        public List<String> getNomeAdversario(){
            
            return proxy.obterNomeAdversarios();
//            return Proxy.getInstance().obterNomeAdversario(0);
            
            
        }
        
        public String getNomePlayer(){
            return proxy.getNomeJogador();
//            return Proxy.getInstance().getNomeJogador();
            
        }

    
    
    
}
