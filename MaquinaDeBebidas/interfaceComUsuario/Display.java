package interfaceComUsuario;

import interfaceComUsuario.IDisplay;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display
implements IDisplay {
    JFrame janela = new JFrame();
    JPanel painel = new JPanel(new GridBagLayout());
    Label campoDeTexto = new Label();

    public Display() {
        this.painel.add(this.campoDeTexto);
        this.janela.add(this.painel);
        this.janela.setTitle("Display");
        this.janela.setSize(300, 100);
        this.janela.setVisible(true);
        this.janela.setDefaultCloseOperation(3);
        this.painel.setBackground(Color.BLUE);
    }

    @Override
    public Label mostrarMensagem(String mensagem) {
        String mensagemExibida = mensagem.length() > 26 ? mensagem.substring(0, 25) : mensagem;
        this.campoDeTexto.setText(mensagemExibida);
        return this.campoDeTexto;
    }
}

