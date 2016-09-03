// Dialog1.java
// Printing multiple lines in dialog box

import javax.swing.JOptionPane; // import class JOptionPane

public class Dialog1	// Class isimleri buyuk harfle!
{
	public static void main( String[] args )
	{
		// display a dialog with a message
		// ilk parametre box ın konumu icin NULL tam ortada
		// ikinci parametre box icindeki string
		JOptionPane.showMessageDialog( null, "Welcome to Java" );
	}
}
