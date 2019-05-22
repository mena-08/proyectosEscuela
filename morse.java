import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class morse
{
    static JButton morToLet = new JButton("<-T-M-");
	static JButton letToMor = new JButton("-T-M->");
	static JButton limpiar = new JButton("Limpiar");
	static String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    static JTextArea ta = new JTextArea(10,30);
	static JTextArea t2 = new JTextArea(10,30);
	public static void main(String args[])
	{
		JFrame f = new JFrame("Codigo Morse");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		JScrollPane scr1 = new JScrollPane(ta);
		JScrollPane scr2 = new JScrollPane(t2);
		
		//Creacion del arreglo de caracteres ascii
		char minus = 97;
		char[] arrMinus = new char[26];
        for(int i=0;i<26;i++)
        {        
           arrMinus[i]=minus;
            minus++;    
		}	

	letToMor.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			try{
			String aux2=ta.getText();
			String aux="";
			char[] charArray2 = new char[aux2.length()];
			for(int i=0;i<aux2.length();i++)
			{
				charArray2[i]=aux2.charAt(i);
			}
			for(int j=0;j<aux2.length();j++){
				for(int i=0;i<26;i++){
					if(charArray2[j]==arrMinus[i])
						{ 
							aux+=morse[i]+"   ";
						}
				t2.setText(aux);
				}
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Revise el contenido del texto!");
		}
	}
	});

	morToLet.addActionListener(new ActionListener(){
		@Override
			public void actionPerformed(ActionEvent e) {
			try {
			String aux2=t2.getText();
			String [] split = aux2.split(" ");
			String aux="";
			for(int j=0;j<split.length;j++){
				for(int i=0;i<26;i++){
					if(split[j].equals(morse[i]))
						{
							aux+=String.valueOf(arrMinus[i])+" ";
						}
						ta.setText(aux);
				}
			}
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Revise el contenido del texto!");
			}
		}
	});
	limpiar.addActionListener(new ActionListener(){
		@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");	t2.setText("");
			}
	});

	pane.add(letToMor);
    pane.add(morToLet);
	pane.add(limpiar);
	f.add(scr1);
    f.add(pane);
    f.add(scr2);
	f.pack();
	f.setVisible(true);
	JOptionPane.showMessageDialog(null, "Instrucciones:\nSolo texto en el primer campo.\n"
		+"Segundo campo para Codigo Morse(separado por 2 espacios).");
	}
}