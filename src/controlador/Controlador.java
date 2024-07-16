package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ICelda;
import modelo.Tablero;
import vista.IVista;

public class Controlador implements ActionListener {
	
	private Tablero tablero;
	private IVista vista;
	private int alto;
	private int ancho;
	private int cantidadMinas;

	public Controlador(IVista vista,int alto,int ancho,int minas) {
		this.alto = alto;
		this.ancho = ancho;
		this.cantidadMinas = minas;
		this.vista = vista;
		this.vista.setActionListener(this);
	}
	
	public IVista getVista() {
		return vista;
	}

	public void setVista(IVista vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("INICIAR")) {
			if(this.vista.isActiveBtn()) {
				this.tablero = new Tablero(this.alto, this.ancho, this.cantidadMinas);
				this.vista.iniciarJuego(this.alto, this.ancho);
				this.vista.dibujar(tablero);
			}
		} else if (comando.equalsIgnoreCase("PISAR")) {
			ICelda celda = (ICelda) e.getSource();
			int i = celda.getI();
			int j = celda.getJ();
			if (!this.tablero.isPisado(i, j) && !this.tablero.isMarcado(i, j)){
				boolean isMina = this.tablero.pisa(i, j);
				if (isMina){
					this.vista.dibujarFinal(tablero);
					this.vista.perder();
				}
				if (this.tablero.gano()){
					this.vista.dibujarFinal(tablero);

					this.vista.ganar();
				}
			}
			this.vista.dibujar(tablero);
		} else if (comando.equalsIgnoreCase("MARCAR")){
			ICelda celda = (ICelda) e.getSource();
			int i = celda.getI();
			int j = celda.getJ();
			if (!this.tablero.isPisado(i, j))
				this.tablero.marca(i, j);
			this.vista.dibujar(tablero);
		}
	
	}
	
	public void iniciar() {
		this.tablero = new Tablero(this.alto, this.ancho, this.cantidadMinas);
		this.vista.iniciarJuego(this.alto, this.ancho);
		this.vista.dibujar(tablero);
	}
	
}
