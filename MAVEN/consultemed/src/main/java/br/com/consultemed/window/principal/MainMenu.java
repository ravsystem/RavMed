package br.com.consultemed.window.principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.consultemed.connection.Conexao;
import br.com.consultemed.window.agendamento.BuscarAgendamento;
import br.com.consultemed.window.agendamento.NovoAgendamento;
import br.com.consultemed.window.consulta.BuscarConsulta;
import br.com.consultemed.window.consulta.NovaConsulta;
import br.com.consultemed.window.medico.BuscarMedico;
import br.com.consultemed.window.medico.NovoMedico;
import br.com.consultemed.window.operador.NovoOperador;
import br.com.consultemed.window.paciente.BuscarPaciente;
import br.com.consultemed.window.paciente.NovoPaciente;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	public Dimension tk = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setUndecorated(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Integer.valueOf((int) tk.getWidth()), Integer.valueOf((int) tk.getHeight()));
		
		Conexao.iniciarFabrica();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConsulta = new JMenu("CONSULTA");
		mnConsulta.setFont(new Font("SansSerif", Font.BOLD, 35));
		menuBar.add(mnConsulta);
		
		JMenuItem mntmNova = new JMenuItem("Nova");
		mntmNova.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				NovaConsulta frame = new NovaConsulta();
				frame.setResizable(false);
				frame.setUndecorated(true);
				frame.setLocationRelativeTo(null);
				frame.setAlwaysOnTop(true);
				frame.setVisible(true);
			}
		});
		mntmNova.setFont(new Font("SansSerif", Font.PLAIN, 20));
		mnConsulta.add(mntmNova);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BuscarConsulta frame = new BuscarConsulta();
				frame.setResizable(false);
				frame.setUndecorated(true);
				frame.setLocationRelativeTo(null);
				frame.setAlwaysOnTop(true);
				frame.setVisible(true);
			}
		});
		mntmBuscar.setFont(new Font("SansSerif", Font.PLAIN, 20));
		mnConsulta.add(mntmBuscar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		menuBar.add(Box.createGlue());
		
		JMenu mnAgendamento = new JMenu("AGENDAMENTO");
		mnAgendamento.setFont(new Font("SansSerif", Font.BOLD, 35));
		menuBar.add(mnAgendamento);
		
		JMenuItem mntmNovo = new JMenuItem("Novo");
		mntmNovo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				NovoAgendamento frame = new NovoAgendamento();
				frame.setResizable(false);
				frame.setUndecorated(true);
				frame.setLocationRelativeTo(null);
				frame.setAlwaysOnTop(true);
				frame.setVisible(true);
			}
		});
		mntmNovo.setFont(new Font("SansSerif", Font.PLAIN, 20));
		mnAgendamento.add(mntmNovo);
		
		JMenuItem mntmBuscar_1 = new JMenuItem("Buscar");
		mntmBuscar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BuscarAgendamento frame = new BuscarAgendamento();
				frame.setResizable(false);
				frame.setUndecorated(true);
				frame.setLocationRelativeTo(null);
				frame.setAlwaysOnTop(true);
				frame.setVisible(true);
			}
		});
		mntmBuscar_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		mnAgendamento.add(mntmBuscar_1);
		
		menuBar.add(Box.createGlue());
		
		JMenu mnPaciente = new JMenu("PACIENTE");
		mnPaciente.setFont(new Font("SansSerif", Font.BOLD, 35));
		menuBar.add(mnPaciente);
		
		JMenuItem mntmNovo_1 = new JMenuItem("Novo");
		mntmNovo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				NovoPaciente frame = new NovoPaciente();
				frame.setResizable(false);
				frame.setUndecorated(true);
				frame.setLocationRelativeTo(null);
				frame.setAlwaysOnTop(true);
				frame.setVisible(true);
				}
		});
		mntmNovo_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		mnPaciente.add(mntmNovo_1);
		
		JMenuItem mntmBuscar_2 = new JMenuItem("Buscar");
		mntmBuscar_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BuscarPaciente frame = new BuscarPaciente();
				frame.setResizable(false);
				frame.setUndecorated(true);
				frame.setLocationRelativeTo(null);
				frame.setAlwaysOnTop(true);
				frame.setVisible(true);
			}
		});
		mntmBuscar_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		mnPaciente.add(mntmBuscar_2);
		
		menuBar.add(Box.createGlue());
		
		JMenu mnMedico = new JMenu("MEDICO");
		mnMedico.setFont(new Font("SansSerif", Font.BOLD, 35));
		menuBar.add(mnMedico);
		
		JMenuItem mntmNovo_2 = new JMenuItem("Novo");
		mntmNovo_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				NovoMedico frame = new NovoMedico();
				frame.setResizable(false);
				frame.setUndecorated(true);
				frame.setLocationRelativeTo(null);
				frame.setAlwaysOnTop(true);
				frame.setVisible(true);
			}
		});
		mntmNovo_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		mnMedico.add(mntmNovo_2);
		
		JMenuItem mntmBuscar_3 = new JMenuItem("Buscar");
		mntmBuscar_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BuscarMedico frame = new BuscarMedico();
				frame.setResizable(false);
				frame.setUndecorated(true);
				frame.setLocationRelativeTo(null);
				frame.setAlwaysOnTop(true);
				frame.setVisible(true);
			}
		});
		mntmBuscar_3.setFont(new Font("SansSerif", Font.PLAIN, 20));
		mnMedico.add(mntmBuscar_3);
		
		menuBar.add(Box.createGlue());
		menuBar.add(Box.createGlue());
		menuBar.add(Box.createGlue());
		menuBar.add(Box.createGlue());
		menuBar.add(Box.createGlue());
		menuBar.add(Box.createGlue());
		menuBar.add(Box.createGlue());
		menuBar.add(Box.createGlue());
		menuBar.add(Box.createGlue());
		
		JMenu mnOperador = new JMenu("OPERADOR");
		mnOperador.setFont(new Font("SansSerif", Font.BOLD, 35));
		menuBar.add(mnOperador);
		
		JMenuItem mntmNovo_3 = new JMenuItem("Novo");
		mntmNovo_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				NovoOperador frame = new NovoOperador();
				frame.setResizable(false);
				frame.setUndecorated(true);
				frame.setLocationRelativeTo(null);
				frame.setAlwaysOnTop(true);
				frame.setVisible(true);
			}
		});
		mntmNovo_3.setFont(new Font("SansSerif", Font.PLAIN, 20));
		mnOperador.add(mntmNovo_3);
		
		menuBar.add(Box.createGlue());
		
		JMenu menu = new JMenu("-");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				setExtendedState(ICONIFIED);
			}
		});
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setExtendedState(ICONIFIED);
			}
		});
		menu.setFont(new Font("SansSerif", Font.BOLD, 40));
		menuBar.add(menu);
		
		JMenu mnX = new JMenu("X");
		mnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		mnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		mnX.setFont(new Font("SansSerif", Font.BOLD, 35));
		menuBar.add(mnX);
		
	}

}
