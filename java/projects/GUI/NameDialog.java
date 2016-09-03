// NameDialog.java
// Basic input with a dialog box

import javax.swing.JOptionPane;

public class NameDialog
{
	public static void main( String[] args )
	{	
		// Prompt user to enter name
		String name =
			JOptionPane.showInputDialog("What is your name?");
	
		// Create the message
		String message = 
			String.format("Welcome to Hell! %s", name);
		
		// display the message to welcome the user by name
		JOptionPane.showMessageDialog(null, message);
	}
}
