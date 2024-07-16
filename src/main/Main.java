package main;

import controlador.ControladorInicio;
import vista.VInicio;

public class Main{

    public static void main(String[] args){

    	ControladorInicio control = new ControladorInicio();
    	control.setVista(new VInicio());
    }

}
