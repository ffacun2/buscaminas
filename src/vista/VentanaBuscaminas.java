package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import modelo.IBuscaminas;
import modelo.ICelda;

@SuppressWarnings("serial")
public class VentanaBuscaminas extends JFrame implements KeyListener, IVista, MouseListener {

	private static Recursos recursos = new Recursos();
	private PanelConCelda[][] casilleros;
    private JPanel contentPane;
    private JPanel panelOeste;
    private JPanel panelCentral;
    private JPanel panel_7;
    private JPanel panel_10;
    private JButton btnIniciar;
    private ActionListener actionListener;

  
    public VentanaBuscaminas() {
    	super("Buscaminas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 319);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		setLocationRelativeTo(null);
	
		this.panelOeste = new JPanel();
		this.contentPane.add(this.panelOeste, BorderLayout.WEST);
		this.panelOeste.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.panel_10 = new JPanel();
		this.panelOeste.add(panel_10);
		this.panel_10.setLayout(new GridLayout(5, 1, 0, 0));
		
		this.panel_7 = new JPanel();
		this.panel_10.add(panel_7);
		
		this.btnIniciar = new JButton("Iniciar");
		this.btnIniciar.setEnabled(false);
		this.btnIniciar.setActionCommand("INICIAR");
		this.panel_7.add(btnIniciar);
	
		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setVisible(false);
		this.setVisible(true);
		
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
    	this.btnIniciar.addActionListener(actionListener);
    	this.actionListener = actionListener;
    }

    
    public void keyPressed(KeyEvent arg0) {
    }

    public void keyReleased(KeyEvent arg0) {
		int ancho = 0;
		int alto = 0;
		int cantidad = 0;
		try {
		    ancho = getAncho();
		    alto = getAlto();
		    cantidad = getCantidad();
		} catch (NumberFormatException e){
		}

		boolean condicion = ancho > 0 && alto > 0 && cantidad > 0 && cantidad < ancho*alto;
		this.btnIniciar.setEnabled(condicion);
    }

    public void keyTyped(KeyEvent arg0){
    }

    public int getAncho(){
    	return 0;
    }

    @Override
    public int getAlto(){
    	return 0;
    }

    @Override
    public int getCantidad() {
    	return 0;
    }

    /**
     * Desabilita la configuracion y crea el crea el panel con las celdas
     */
    @Override
    public void iniciarJuego(int alto, int ancho) {
    	this.panelCentral.setVisible(true);
		this.btnIniciar.setEnabled(false);
		this.panelCentral.setLayout(new GridLayout(0, ancho));
		this.casilleros = new PanelConCelda[alto][ancho];
		for (int i = 0; i < alto; i++)
		    for (int j = 0; j < ancho; j++){
				this.casilleros[i][j] = new PanelConCelda(i, j);
				this.casilleros[i][j].setBorder(new BevelBorder(BevelBorder.RAISED));
				this.panelCentral.add(this.casilleros[i][j]);
				this.casilleros[i][j].addMouseListener(this);
		    }
		this.setBounds(100, 100, this.panelOeste.getWidth() + 35 * ancho, 35 * alto + 25);
		this.setLocationRelativeTo(null);
    }
    
    /**
     * Metodo que dibuja el tablero por cada accion/evento que ocurre (pisar/marcar)
     */
    public void dibujar(IBuscaminas tablero) {
		for (int i = 0; i < tablero.getAlto(); i++)
		    for (int j = 0; j < tablero.getAncho(); j++) {
				if (tablero.isPisado(i, j)) {
				    this.casilleros[i][j].setBorder(new BevelBorder(BevelBorder.LOWERED));
				    this.casilleros[i][j].setBackground(Color.lightGray);
				    if (tablero.isMina(i, j)) {
				    	this.casilleros[i][j].setImageIcon(recursos.getExplosion());
				    } 
				    else{
				    	if (tablero.getEntorno(i, j) > 0)
				    		this.casilleros[i][j].setImageIcon(recursos.getNumero(tablero.getEntorno(i, j)));
				    }
				} 
				else{
				    if (tablero.isMarcado(i, j))
				    	this.casilleros[i][j].setImageIcon(recursos.getBandera());
				    else
				    	this.casilleros[i][j].setImageIcon(null);
				}
		    }
		this.repaint();
    }

    /**
     * Metodo que dibuja el tablero final, ya sea por ganar o perder, mostrando las el total de las minas existentes
     */
    public void dibujarFinal(IBuscaminas tablero) {
		for (int i = 0; i < tablero.getAlto(); i++)
		    for (int j = 0; j < tablero.getAncho(); j++) {
				if (tablero.isMina(i, j)) {
				    if (tablero.isPisado(i, j))
				    	this.casilleros[i][j].setImageIcon(recursos.getExplosion());
				    else
				    	this.casilleros[i][j].setImageIcon(recursos.getMina());
				}
		    }
		this.repaint();
    }
    

    @Override
    public void perder(){
    	JOptionPane.showMessageDialog(this, "Has Perdido, Juego Terminado");
    	this.dispose();
    }

    @Override
    public void ganar(){
    	JOptionPane.showMessageDialog(this, "Felicitaciones, Has Ganado, Juego Terminado");
    	this.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent arg0){
    }

    @Override
    public void mouseEntered(MouseEvent arg0){
    }

    @Override
    public void mouseExited(MouseEvent arg0){
    }

    @Override
    public void mousePressed(MouseEvent arg0){
		ActionEvent event;
		String command;
		ICelda celda = (ICelda) arg0.getSource();
		if (arg0.getButton() != 1)
		    command = "MARCAR";
		else
		    command = "PISAR";
		event = new ActionEvent(celda, 0, command);
		this.actionListener.actionPerformed(event);
    }

    @Override
    public void mouseReleased(MouseEvent arg0){
    }
    
    @Override
    public boolean isActiveBtn() {
    	return this.btnIniciar.isEnabled();
    }
}
