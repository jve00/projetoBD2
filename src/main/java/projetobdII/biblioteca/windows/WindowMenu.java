package projetobdII.biblioteca.windows;
import projetobdII.biblioteca.windows.jpanels.JPanelDeleteLivro;
import projetobdII.biblioteca.windows.jpanels.JPanelListLivro;
import projetobdII.biblioteca.windows.jpanels.JPanelRegisterLivro;
import projetobdII.biblioteca.windows.jpanels.JPanelUpdateLivro;
import javax.swing.*;
import java.awt.*;
public class WindowMenu extends JFrame {
    private JPanel jPanelCenter;
    private JPanel jPanelSul;
    private JMenuBar jMenuBar;
    private JMenu jMenuLivro;
    private JMenu jMenuOpcoes;
    private JMenuItem jMenuItemCadastrar;
    private JMenuItem jMenuItemListar;
    private JMenuItem jMenuItemAtualizar;
    private JMenuItem jMenuItemDeletar;
    private JMenuItem jMenuItemSair;
    private JLabel jLabelVersao;
    public WindowMenu(){
        configWindowMenu();
    }
    private void configWindowMenu(){
        setTitle("Biblioteca");
        //setResizable(false);
        setLayout(new BorderLayout());
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configComponente();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void configComponente(){
        configJMenuItem();
        configJMenu();
        configJMenuBar();
        setJMenuBar(this.jMenuBar);
        configJLabel();
    }
    private void configJMenuBar(){
        this.jMenuBar = new JMenuBar();
        this.jMenuBar.add(this.jMenuLivro);
        this.jMenuBar.add(this.jMenuOpcoes);
        setJMenuBar(this.jMenuBar);
    }
    private void configJMenu(){
        this.jMenuLivro = new JMenu("Livro");
        this.jMenuOpcoes = new JMenu("Opcões");
        this.jMenuLivro.add(this.jMenuItemCadastrar);
        this.jMenuLivro.add(this.jMenuItemAtualizar);
        this.jMenuLivro.add(this.jMenuItemListar);
        this.jMenuLivro.add(this.jMenuItemDeletar);
        this.jMenuOpcoes.add(this.jMenuItemSair);
    }
    private void configJMenuItem(){
        this.jMenuItemCadastrar = new JMenuItem("Cadastrar");
        this.jMenuItemAtualizar = new JMenuItem("Atualizar");
        this.jMenuItemListar = new JMenuItem("Listar");
        this.jMenuItemDeletar = new JMenuItem("Deletar");
        this.jMenuItemSair = new JMenuItem("Sair");

        // Ouvintes anônimos:
        this.jMenuItemCadastrar.addActionListener(e -> configJPanel(new JPanelRegisterLivro()));
        this.jMenuItemAtualizar.addActionListener(e -> configJPanel(new JPanelUpdateLivro()));
        this.jMenuItemListar.addActionListener(e -> configJPanel(new JPanelListLivro()));
        this.jMenuItemDeletar.addActionListener(e -> configJPanel(new JPanelDeleteLivro()));
        this.jMenuItemSair.addActionListener(e -> {
            setVisible(false);
            dispose();
        });
    }
    private void configJLabel(){
        this.jLabelVersao = new JLabel("Versão 1.0");
        this.jPanelSul = new JPanel();
        this.jPanelSul.add(this.jLabelVersao);
        this.add(this.jPanelSul, BorderLayout.SOUTH);
    }
    private void configJPanel(JPanel jPanel){
        if(this.jPanelCenter != null){
            this.jPanelCenter.setVisible(false);
        }
        this.jPanelCenter = jPanel;
        this.jPanelCenter.setVisible(true);
        this.add(this.jPanelCenter, BorderLayout.CENTER);
        this.setVisible(false);
        this.repaint();
        this.setVisible(true);
    }
    public static void main(String[] args){
        new WindowMenu();
    }
}