package vista;

import javax.swing.ImageIcon;

public class Recursos {
    private ImageIcon bandera = new ImageIcon("icon/bandera.png");
    private ImageIcon explosion = new ImageIcon("icon/explosion.png");
    private ImageIcon mina = new ImageIcon("icon/mina.png");
    private ImageIcon numeros[] = new ImageIcon[8];
    
    {
    	for (int i = 0; i < 8; i++)
    		numeros[i] = new ImageIcon("icon/"+String.valueOf(i + 1) + ".png");
    }

    public ImageIcon getBandera() {
    	return bandera;
    }

    public void setBandera(ImageIcon bandera){
    	this.bandera = bandera;
    }

    public ImageIcon getExplosion(){
    	return explosion;
    }

    public void setExplosion(ImageIcon explosion){
    	this.explosion = explosion;
    }

    public ImageIcon getMina(){
    	return mina;
    }

    public void setMina(ImageIcon mina){
    	this.mina = mina;
    }

    public ImageIcon getNumero(int i){
    	return this.numeros[i - 1];
    }

    public void setNumero(int i, ImageIcon numero){
    	numeros[i - 1] = numero;
    }

}
