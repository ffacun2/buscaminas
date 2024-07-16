package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class VInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel titlePanel;
	private JLabel titleLabel;
	private JPanel buttonPanel;
	private JButton easyButton;
	private JButton mediumButton;
	private JButton hardButton;
	private JPanel exitPanel;
	private JButton personalizeButton;
	private JButton exitButton;
	private JPanel personalizedPanel;
	private JTextField altoField;
	private JLabel altoLabel;
	private JLabel anchoLabel;
	private JLabel minaLabel;
	private JTextField anchoField;
	private JTextField minasField;
	private JButton atrasButton;
	private JButton aceptButton;
	@SuppressWarnings("unused")
	private ActionListener actionListener;

	public VInicio() {
		super("Configuracion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);

		setContentPane(this.contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		this.titlePanel = new JPanel();
		contentPane.add(titlePanel);
		this.titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		
		this.titleLabel = new JLabel("Buscaminas");
		this.titlePanel.add(titleLabel);
		this.titleLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		this.titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.buttonPanel = new JPanel();
		contentPane.add(buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] {250};
		gbl_buttonPanel.rowHeights = new int[] {20};
		gbl_buttonPanel.columnWeights = new double[]{0.0};
		gbl_buttonPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		this.buttonPanel.setLayout(gbl_buttonPanel);
		
		this.easyButton = new JButton("Facil");
		this.easyButton.setActionCommand("FACIL");
		this.easyButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_easyButton = new GridBagConstraints();
		gbc_easyButton.weightx = 1.0;
		gbc_easyButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_easyButton.insets = new Insets(0, 10, 10, 10);
		gbc_easyButton.gridx = 0;
		gbc_easyButton.gridy = 0;
		this.buttonPanel.add(easyButton, gbc_easyButton);
		this.easyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.mediumButton = new JButton("Intermedio");
		this.mediumButton.setActionCommand("MEDIUM");
		this.mediumButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_mediumButton = new GridBagConstraints();
		gbc_mediumButton.insets = new Insets(0, 10, 10, 10);
		gbc_mediumButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_mediumButton.gridx = 0;
		gbc_mediumButton.gridy = 1;
		this.buttonPanel.add(mediumButton, gbc_mediumButton);
		this.mediumButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.hardButton = new JButton("Experto");
		this.hardButton.setActionCommand("DIFICIL");
		this.hardButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_hardButton = new GridBagConstraints();
		gbc_hardButton.insets = new Insets(0, 10, 10, 10);
		gbc_hardButton.fill = GridBagConstraints.BOTH;
		gbc_hardButton.gridx = 0;
		gbc_hardButton.gridy = 2;
		this.buttonPanel.add(hardButton, gbc_hardButton);
		this.hardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.personalizeButton = new JButton("Personalizado");
		this.personalizeButton.setActionCommand("PERSONALIZAR");
		this.personalizeButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_personalizeButton = new GridBagConstraints();
		gbc_personalizeButton.insets = new Insets(0, 10, 0, 10);
		gbc_personalizeButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_personalizeButton.gridx = 0;
		gbc_personalizeButton.gridy = 3;
		this.buttonPanel.add(personalizeButton, gbc_personalizeButton);
		
		this.personalizedPanel = new JPanel();
		contentPane.add(personalizedPanel);
		GridBagLayout gbl_personalizedPanel = new GridBagLayout();
		gbl_personalizedPanel.columnWidths = new int[] {150, 100};
		gbl_personalizedPanel.rowHeights = new int[] {35, 35, 35, 65};
		gbl_personalizedPanel.columnWeights = new double[]{0.0, 1.0};
		gbl_personalizedPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		this.personalizedPanel.setLayout(gbl_personalizedPanel);
		this.personalizedPanel.setVisible(false);
		
		this.altoLabel = new JLabel("Alto");
		this.altoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_altoLabel = new GridBagConstraints();
		gbc_altoLabel.anchor = GridBagConstraints.EAST;
		gbc_altoLabel.insets = new Insets(0, 0, 5, 11);
		gbc_altoLabel.gridx = 0;
		gbc_altoLabel.gridy = 0;
		this.personalizedPanel.add(altoLabel, gbc_altoLabel);
		
		this.altoField = new JTextField();
		this.altoField.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_altoField = new GridBagConstraints();
		gbc_altoField.anchor = GridBagConstraints.WEST;
		gbc_altoField.insets = new Insets(0, 10, 5, 0);
		gbc_altoField.gridx = 1;
		gbc_altoField.gridy = 0;
		this.personalizedPanel.add(altoField, gbc_altoField);
		this.altoField.setColumns(10);
		
		this.anchoLabel = new JLabel("Ancho");
		this.anchoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.anchoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_anchoLabel = new GridBagConstraints();
		gbc_anchoLabel.anchor = GridBagConstraints.EAST;
		gbc_anchoLabel.insets = new Insets(0, 0, 5, 10);
		gbc_anchoLabel.gridx = 0;
		gbc_anchoLabel.gridy = 1;
		this.personalizedPanel.add(anchoLabel, gbc_anchoLabel);
		
		this.anchoField = new JTextField();
		this.anchoField.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_anchoField = new GridBagConstraints();
		gbc_anchoField.anchor = GridBagConstraints.WEST;
		gbc_anchoField.insets = new Insets(0, 10, 5, 0);
		gbc_anchoField.gridx = 1;
		gbc_anchoField.gridy = 1;
		this.personalizedPanel.add(anchoField, gbc_anchoField);
		this.anchoField.setColumns(10);
		
		this.minaLabel = new JLabel("Cantidad Minas");
		this.minaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_minaLabel = new GridBagConstraints();
		gbc_minaLabel.anchor = GridBagConstraints.EAST;
		gbc_minaLabel.insets = new Insets(0, 0, 5, 10);
		gbc_minaLabel.gridx = 0;
		gbc_minaLabel.gridy = 2;
		this.personalizedPanel.add(minaLabel, gbc_minaLabel);
		
		this.minasField = new JTextField();
		this.minasField.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_minasField = new GridBagConstraints();
		gbc_minasField.insets = new Insets(0, 10, 5, 0);
		gbc_minasField.anchor = GridBagConstraints.WEST;
		gbc_minasField.gridx = 1;
		gbc_minasField.gridy = 2;
		this.personalizedPanel.add(minasField, gbc_minasField);
		this.minasField.setColumns(10);
		
		this.atrasButton = new JButton("Atras");
		this.atrasButton.setActionCommand("ATRAS");
		this.atrasButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_atrasButton = new GridBagConstraints();
		gbc_atrasButton.anchor = GridBagConstraints.PAGE_END;
		gbc_atrasButton.insets = new Insets(0, 0, 5, 5);
		gbc_atrasButton.gridx = 0;
		gbc_atrasButton.gridy = 3;
		this.personalizedPanel.add(atrasButton, gbc_atrasButton);
		
		this.aceptButton = new JButton("Aceptar");
		this.aceptButton.setActionCommand("ACEPTAR");
		this.aceptButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_aceptButton = new GridBagConstraints();
		gbc_aceptButton.anchor = GridBagConstraints.PAGE_END;
		gbc_aceptButton.insets = new Insets(0, 0, 5, 0);
		gbc_aceptButton.gridx = 1;
		gbc_aceptButton.gridy = 3;
		this.personalizedPanel.add(aceptButton, gbc_aceptButton);
		
		this.exitPanel = new JPanel();
		contentPane.add(exitPanel);
		GridBagLayout gbl_exitPanel = new GridBagLayout();
		gbl_exitPanel.columnWidths = new int[] {125};
		gbl_exitPanel.rowHeights = new int[] {30};
		gbl_exitPanel.columnWeights = new double[]{0.0};
		gbl_exitPanel.rowWeights = new double[]{0.0};
		this.exitPanel.setLayout(gbl_exitPanel);
		
		this.exitButton = new JButton("Salir");
		this.exitButton.setActionCommand("SALIR");
		this.exitButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_exitButton.gridx = 0;
		gbc_exitButton.gridy = 0;
		this.exitPanel.add(exitButton, gbc_exitButton);
		this.exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		setVisible(true);
	}
	
	public void setActionListener(ActionListener actionListener) {
		this.easyButton.addActionListener(actionListener);
		this.mediumButton.addActionListener(actionListener);
		this.hardButton.addActionListener(actionListener);
		this.personalizeButton.addActionListener(actionListener);
		this.atrasButton.addActionListener(actionListener);
		this.aceptButton.addActionListener(actionListener);
		this.exitButton.addActionListener(actionListener);
		this.actionListener = actionListener;
	}
	
	public void showPersonalizedPanel() {
		this.personalizedPanel.setVisible(true);
		this.buttonPanel.setVisible(false);
		this.exitPanel.setVisible(false);
	}
	
	public void showOptionPanel() {
		this.buttonPanel.setVisible(true);
		this.personalizedPanel.setVisible(false);
		this.exitPanel.setVisible(true);
	}

	public int getAncho() {
		return Integer.parseInt(this.altoField.getText());
	}
	
	public int getAlto() {
		return Integer.parseInt(this.anchoField.getText());
	}

	public int getCantidadMinas() {
		return Integer.parseInt(this.minasField.getText());
	}
}