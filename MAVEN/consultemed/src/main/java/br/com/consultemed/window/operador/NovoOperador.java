package br.com.consultemed.window.operador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.consultemed.connection.Conexao;
import br.com.consultemed.model.Operador;
import br.com.consultemed.model.OperadorTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NovoOperador extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTable table;
	private JPasswordField txtSenha;
	private JTextField txtId;
	private String oper_tipos[] = {"SECRETARIO(A)","SUPERVISOR(A)","MEDICO(A)","SUPORTE"};
	private static Integer auxline;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoOperador frame = new NovoOperador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NovoOperador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		List<Operador> produts = Conexao.listarOperador();
		
		ArrayList dados = new ArrayList();
		
		for(int i = 0; i < produts.size(); i++) {
			
			Operador operador = new Operador();
			operador.setId(produts.get(i).getId());
			operador.setNome(produts.get(i).getNome());
			dados.add(operador);
		}
		
		OperadorTableModel modelo = new OperadorTableModel(dados);
		
		JLabel lblNovoOperador = new JLabel("Novo Operador");
		lblNovoOperador.setBounds(10, 11, 343, 67);
		lblNovoOperador.setFont(new Font("SansSerif", Font.BOLD, 45));
		
		JLabel lblUsuario = new JLabel("Usuario.:");
		lblUsuario.setBounds(5, 99, 79, 24);
		lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		JLabel lblSenha = new JLabel("Senha.:");
		lblSenha.setBounds(5, 147, 79, 24);
		lblSenha.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		JLabel lblTipo = new JLabel("Tipo.:");
		lblTipo.setBounds(5, 195, 79, 24);
		lblTipo.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				txtUsuario.setText(txtUsuario.getText().toUpperCase());
			}
		});
		txtUsuario.setBounds(88, 96, 323, 30);
		txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtUsuario.setColumns(10);
		
		JComboBox cbTipo = new JComboBox(oper_tipos);
		cbTipo.setBounds(88, 192, 323, 30);
		cbTipo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contentPane.setLayout(null);
		contentPane.add(lblNovoOperador);
		contentPane.add(lblUsuario);
		contentPane.add(lblSenha);
		contentPane.add(lblTipo);
		contentPane.add(txtUsuario);
		contentPane.add(cbTipo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtUsuario.getText().equals("") || txtSenha.getText().equals("")) {
					
					JOptionPane.showMessageDialog(NovoOperador.this, "Por favor Cidadăo, tenha vergonha na cara e preencha o usuário e senha para poder salvar!!");
					
				}else {
					
					String usuario = txtUsuario.getText();
					String senha = txtSenha.getText();
					String tipo = cbTipo.getSelectedItem().toString();
					
						Operador oper = new Operador();
						oper.setNome(usuario);
						oper.setSenha(senha);
						oper.setTipo(tipo);
						
						try {
						
						Conexao.guardar(oper);
						
						}catch(NullPointerException f) {
							JOptionPane.showMessageDialog(NovoOperador.this,"Ops.. Deve ter faltado preencher algo ai moral: \n" +f);
						}
						catch(Exception npe){
							JOptionPane.showMessageDialog(NovoOperador.this, "Ops.. Erro ao gravar Operador: \n" +npe);
						}
						
						modelo.addOperador(oper);
						table.getModel();
						
						txtUsuario.setText("");
						txtSenha.setText("");
						cbTipo.setSelectedIndex(0);
						txtId.setText("");
						
						JOptionPane.showMessageDialog(NovoOperador.this, "Operador Salvo com Sucesso!");
					
					txtUsuario.setText("");
					txtId.setText("");
					txtSenha.setText("");
					cbTipo.setSelectedIndex(0);
					
					}
			}
		});
		btnSalvar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnSalvar.setBounds(10, 387, 89, 33);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtUsuario.setText("");
				txtId.setText("");
				txtSenha.setText("");
				cbTipo.setSelectedIndex(0);
			}
		});
		btnLimpar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnLimpar.setBounds(109, 387, 89, 33);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NovoOperador.this.dispose();
			}
		});
		btnVoltar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnVoltar.setBounds(208, 387, 89, 33);
		contentPane.add(btnVoltar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Operador operaremovetable = new Operador();
				Operador operador = new Operador();
				
				String id = txtId.getText();
				
				if(id.equals("") || id.equals(null)) {
					
					JOptionPane.showMessageDialog(NovoOperador.this, "Selecione uma linha, depois clique no pequeno Lápis acima da tabela para poder editar!");
					
				}else {
				
					Long idaux = Long.valueOf(id);
				
					try {
						operaremovetable = Conexao.selecionaOperador(idaux);
					}catch(NullPointerException f) {
						JOptionPane.showMessageDialog(NovoOperador.this,"Erro ao Listar Operadores: \n" +f);
					}
					catch(Exception npe){
						JOptionPane.showMessageDialog(NovoOperador.this, "Erro ao Listar Operadores: \n" +npe);
					}
					operador.setId(idaux);
					operador.setNome(txtUsuario.getText());
					operador.setSenha(txtSenha.getText());
					operador.setTipo(cbTipo.getSelectedItem().toString());
					
					
					modelo.removeOperador(auxline);
					
					try {
						
						Conexao.alterar(operador);
					
					}
					catch(Exception npe){
						JOptionPane.showMessageDialog(NovoOperador.this, "Erro ao alterar Operador: \n" +npe);
					}
					
					txtUsuario.setText("");
					txtSenha.setText("");
					cbTipo.setSelectedIndex(0);
					txtId.setText("");
					
					modelo.addOperador(operador);
					table.getModel();
					
					JOptionPane.showMessageDialog(NovoOperador.this, "Operador Alterado com sucesso!!");
					
				}
			}
		});
		btnAtualizar.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnAtualizar.setBounds(307, 387, 104, 33);
		contentPane.add(btnAtualizar);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setToolTipText("");
		table.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.setBounds(458, 76, 228, 344);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(472, 99, 452, 321);
		contentPane.add(scrollPane);
		
		//contentPane.add(table);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtSenha.setBounds(88, 144, 323, 30);
		contentPane.add(txtSenha);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnSalvar.setVisible(true);
				btnAtualizar.setVisible(false);
				
				txtUsuario.setText("");
				txtSenha.setText("");
				cbTipo.setSelectedIndex(0);
				txtId.setText("");
				
				btnNovo.setVisible(false);
			}
		});
		btnNovo.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnNovo.setBounds(10, 253, 89, 33);
		btnNovo.setVisible(false);
		contentPane.add(btnNovo);
		
		ImageIcon iconEdit = new ImageIcon(NovoOperador.class.getResource("/br/com/consultemed/img/edit.png"));
		Image imaEdit = iconEdit.getImage();
		Image imagemEdit = imaEdit.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		Icon icoEdit = new ImageIcon(imagemEdit);
		
		JButton btnEdit = new JButton(icoEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Operador Operador = new Operador();
				
				auxline = table.getSelectedRow();
				String id = table.getValueAt(auxline, 0).toString();
				
				if(id.equals("") || id.equals(null)) {
					
					JOptionPane.showMessageDialog(NovoOperador.this, "Selecione uma linha para poder editar!");
					
				}else {
					
					btnSalvar.setVisible(false);
					btnAtualizar.setVisible(true);
					btnNovo.setVisible(true);
				
					Long idaux = Long.valueOf(id);
					
					try {
					
						Operador = Conexao.selecionaOperador(idaux);
					
					}
					catch(Exception npe){
						JOptionPane.showMessageDialog(NovoOperador.this, "Erro ao listar Operadores: \n" +npe);
					}
					
					txtId.setText(String.valueOf(Operador.getId()));
					txtUsuario.setText(Operador.getNome());
					txtSenha.setText(Operador.getSenha());
					cbTipo.setSelectedItem(Operador.getTipo());
				}
			}
		});
		btnEdit.setBounds(880, 58, 44, 30);
		contentPane.add(btnEdit);
		
		ImageIcon iconRe = new ImageIcon(NovoOperador.class.getResource("/br/com/consultemed/img/delete.png"));
		Image imaRe = iconRe.getImage();
		Image imagemRe = imaRe.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		Icon icoRe = new ImageIcon(imagemRe);
		
		JButton btnRemov = new JButton(icoRe);
		btnRemov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Operador operador = new Operador();
				
				auxline = table.getSelectedRow();
				String id = table.getValueAt(auxline, 0).toString();
				
				if(id.equals("") || id.equals(null)) {
					
					JOptionPane.showMessageDialog(NovoOperador.this, "Selecione uma linha para poder excluir!");
					
				}else {
				
					Long idaux = Long.valueOf(id);
					
					operador = Conexao.selecionaOperador(idaux);
					
					if(JOptionPane.showConfirmDialog(NovoOperador.this, "Deseja mesmo excluir o Operador selecionado?") == 0) {
					
						try {
							
							Conexao.removeOperador(operador);
						
						}
						catch(Exception npe){
							JOptionPane.showMessageDialog(NovoOperador.this, "Erro ao remover Operador: \n" +npe);
						}
						
						modelo.removeOperador(auxline);
						
						txtUsuario.setText("");
						txtSenha.setText("");
						cbTipo.setSelectedIndex(0);
						txtId.setText("");
						
						JOptionPane.showMessageDialog(NovoOperador.this, "Operador Excluido com sucesso!!");
					
					}
				}
			}
		});
		btnRemov.setBounds(826, 58, 44, 30);
		contentPane.add(btnRemov);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(780, 58, 36, 30);
		contentPane.add(txtId);
		txtId.setVisible(false);
		txtId.setColumns(10);
		
		ImageIcon iconB = new ImageIcon(NovoOperador.class.getResource("/br/com/consultemed/img/back.png"));
		Image imaB = iconB.getImage();
		Image imagemB = imaB.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		Icon icoB = new ImageIcon(imagemB);
		
		JLabel lblback = new JLabel(icoB);
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				NovoOperador.this.dispose();
			}
		});
		lblback.setBounds(880, 11, 44, 36);
		contentPane.add(lblback);
	}
}
