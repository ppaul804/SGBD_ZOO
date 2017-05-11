import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
    
    private JLabel lbUsuario, lbSenha;    
    private JTextField tfUsuario;
    private JPasswordField pfSenha;
    private JButton btEntrar, btNovoUsua, btSair;
    
    Login(String titulo){
        super(titulo);
        setLayout(new FlowLayout());

        lbUsuario = new JLabel("Usuário:");
        add(lbUsuario);

        tfUsuario = new JTextField(15);
        add(tfUsuario);

        lbSenha = new JLabel("Senha:  ");
        add(lbSenha);

        pfSenha = new JPasswordField(15);
        add(pfSenha);
        
        btEntrar = new JButton("Entrar");
        btEntrar.setToolTipText("Entrar na aplicação");
        add(btEntrar);

        btNovoUsua = new JButton("Novo Usuário");
        btNovoUsua.setToolTipText("Cadastrar novo usuário");
        add(btNovoUsua);

        btSair = new JButton("Sair");
        btSair.setToolTipText("Fechar aplicação");
        add(btSair);

        // Cria o objeto da classe interna ButtonHandler e o registra para tratamento de evento de botão.
        ButtonHandler handler = new ButtonHandler();
        // Registra o objeto criado para tratar os ActionEvents dos dois botões.
        btEntrar.addActionListener(handler);
        btNovoUsua.addActionListener(handler);
        btSair.addActionListener(handler);
        pfSenha.addActionListener(handler);
        
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            
            if(evento.getSource() == btEntrar || evento.getSource() == pfSenha){
                ConexaoMySQL conexao = new ConexaoMySQL();
                conexao.conectar();
            } else if (evento.getSource() == btNovoUsua){
                NovoUsuario objNovoUsuario = new NovoUsuario();               
                objNovoUsuario.setSize(268, 115);
                objNovoUsuario.setLocationRelativeTo(null);
                objNovoUsuario.setResizable(false);
                //objNovoUsuario.setIconImage(new ImageIcon(getClass().getResource("Imagens/icone_cadastro.png")).getImage());
                objNovoUsuario.setVisible(true);
                objNovoUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } else if (evento.getSource() == btSair){
                dispose();
            }
            
        }
    }
    
}