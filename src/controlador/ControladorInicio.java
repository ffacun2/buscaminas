package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VInicio;
import vista.VentanaBuscaminas;

public class ControladorInicio implements ActionListener{

	private VInicio vista;
	
	public VInicio getVista() {
		return vista;
	}
	
	public void setVista(VInicio vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if( comando.equalsIgnoreCase("PERSONALIZAR")) {
			this.vista.showPersonalizedPanel();
		}
		else if(comando.equalsIgnoreCase("ATRAS")) {
			this.vista.showOptionPanel();
		}
		else if (comando.equalsIgnoreCase("SALIR")) {	
			this.vista.dispose();
		}
		else if (comando.equalsIgnoreCase("ACEPTAR")) {
			Controlador facil = new Controlador(new VentanaBuscaminas(),this.vista.getAlto(),this.vista.getAncho(),this.vista.getCantidadMinas());
			facil.iniciar();
		}
		else if (comando.equalsIgnoreCase("FACIL")) {
			Controlador facil = new Controlador(new VentanaBuscaminas(),8,8,10);
			facil.iniciar();
		}
		else if (comando.equalsIgnoreCase("MEDIUM")) {
			Controlador facil = new Controlador(new VentanaBuscaminas(),16,16,40);
			facil.iniciar();
		}
		else if (comando.equalsIgnoreCase("DIFICIL")) {
			Controlador facil = new Controlador(new VentanaBuscaminas(),16,32,99);
			facil.iniciar();
		}
	}

	
}
