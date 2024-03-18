package projetobdII.biblioteca.windows.jpanels;
import javax.swing.*;
import java.awt.*;

public class JPanelRegisterLivro extends JPanel{
    private JPanel jPanelNorte;
    private JPanel jPanelCenter;
    private JLabel jLabelCadastro;
    private JLabel jLabelNome;
    private JLabel jLabelAutor;
    private JLabel jLabelData;
    private JTextField jTextFieldNome;
    private JTextField jTextFieldAutor;
    private JTextField jTextFieldData;
    private JButton jButtonCadastrar;
    private static final Integer tamanhoTxt = 20;

    public JPanelRegisterLivro(){
        setLayout(new BorderLayout());
        configWindow();
    }
    private void configWindow(){
        configComponente();
    }
    private void configComponente(){
        configJPanelNorte();
        configJPanelCenter();
        configJPanelSul();
    }
    private void configJPanelNorte(){
        this.jPanelNorte = new JPanel();
        this.jLabelCadastro = new JLabel("Cadastro de livros");
        this.jLabelCadastro.setFont(new Font("Arial", Font.BOLD, 40));
        this.jPanelNorte.add(this.jLabelCadastro);
        this.add(this.jPanelNorte, BorderLayout.NORTH);
    }
    private void configJPanelCenter(){
        this.jPanelCenter = new JPanel();

        this.jLabelNome = new JLabel("Nome:");
        this.jLabelAutor = new JLabel("Autor:");
        this.jLabelData = new JLabel("Data:");

        this.jLabelNome.setFont(new Font("Arial", Font.PLAIN, 40));
        this.jLabelNome.setHorizontalAlignment(JLabel.CENTER);
        this.jLabelAutor.setFont(new Font("Arial", Font.PLAIN, 40));
        this.jLabelAutor.setHorizontalAlignment(JLabel.CENTER);
        this.jLabelData.setFont(new Font("Arial", Font.PLAIN, 30));
        this.jLabelData.setHorizontalAlignment(JLabel.CENTER);

        this.jTextFieldNome = new JTextField(tamanhoTxt);
        this.jTextFieldAutor = new JTextField(tamanhoTxt);
        this.jTextFieldData = new JTextField(tamanhoTxt);

        this.jPanelCenter.setLayout(new GridLayout(3, 2, -25, 175));
        this.jPanelCenter.add(this.jLabelNome);
        this.jPanelCenter.add(this.jTextFieldNome);
        this.jPanelCenter.add(this.jLabelAutor);
        this.jPanelCenter.add(this.jTextFieldAutor);
        this.jPanelCenter.add(this.jLabelData);
        this.jPanelCenter.add(this.jTextFieldData);

        this.add(this.jPanelCenter, BorderLayout.CENTER);
    }
    private void configJPanelSul(){

    }
}