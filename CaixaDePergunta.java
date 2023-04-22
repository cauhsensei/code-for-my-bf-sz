import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class CaixaDePergunta {
    public static void main(String[] args) {
        JPanel painel = new JPanel();
        JLabel pergunta = new JLabel("Quer namorar comigo?");
        painel.add(pergunta);
        JButton sim = new JButton("Sim");
        painel.add(sim);
        JButton nao = new JButton("Não");
        painel.add(nao);


        sim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Estamos namorando, te amo!");
            }
        });

        nao.addActionListener(new ActionListener() {
            int posX = 0;
            int posY = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                int novoX = (int)(Math.random() * (painel.getWidth() - pergunta.getWidth()));
                int novoY = (int)(Math.random() * (painel.getHeight() - pergunta.getHeight()));

                while(novoX == posX && novoY == posY) {
                    novoX = (int)(Math.random() * (painel.getWidth() - pergunta.getWidth()));
                    novoY = (int)(Math.random() * (painel.getHeight() - pergunta.getHeight()));
                }

                pergunta.setLocation(novoX, novoY);
                sim.setLocation(pergunta.getX(), pergunta.getY() + pergunta.getHeight() + 10);
                nao.setLocation(pergunta.getX() + pergunta.getWidth() - nao.getWidth(), pergunta.getY() + pergunta.getHeight() + 10);

                posX = novoX;
                posY = novoY;
            }
        });


        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(painel);
        janela.setSize(400, 200);
        janela.setVisible(true);
    }
}
