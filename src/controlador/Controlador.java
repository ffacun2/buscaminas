package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ICelda;
import modelo.Tablero;
import vista.IVista;

public class Controlador implements ActionListener {
	
	private Tablero tablero;
	private IVista vista;

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
				this.tablero = new Tablero(this.vista.getAlto(), this.vista.getAncho(), this.vista.getCantidad());
				this.vista.iniciarJuego(this.vista.getAlto(), this.vista.getAncho());
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
	
}
