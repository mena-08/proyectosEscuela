import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;


public class tarea{
   static JFrame F=new JFrame("Algoritmos");
   static JTextArea Ta=new JTextArea(10,18);
   static JTextArea Ta2=new JTextArea(2,15);
   static JPanel P1=new JPanel();
   static JPanel P2=new JPanel();
   static JPanel P4=new JPanel(new GridLayout(3,0,1,1));
   static JPanel P3=new JPanel();
   static JButton B=new JButton("K M P");
   static JLabel T3=new JLabel("Patrón");
   static JLabel T2=new JLabel("Texto");
   static JButton B2=new JButton("B M P");
   static JButton B3=new JButton("Minusculas");
   public static void main(String args[]){
	PrintStream S=System.out;
	F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	P1.add(T3,BorderLayout.NORTH);
	P1.add(Ta2,BorderLayout.CENTER);
	P2.add(T2,BorderLayout.NORTH);
	P2.add(Ta,BorderLayout.CENTER);
	P3.add(B);
	P3.add(B2);
	P3.add(B3,BorderLayout.SOUTH);
	P4.add(P1);
	P4.add(P2);
	P4.add(P3);
	F.add(P4);
	
	
	B.addActionListener(new ActionListener()
    	   {  	
		@Override
		public void actionPerformed(ActionEvent e){	
	String buscar_patron=Ta2.getText(); 
	String buscar_texto=Ta.getText();
	int arr[]=new int[buscar_patron.length()];
	int arr2[]=new int[buscar_texto.length()];
	int count=-1, count2=-1, tam=1;
	boolean encontrar=false;
	ArrayList<Integer>index=new ArrayList<Integer>();
	arr[0]=count;
	String encontrados="";
    
    
    for(int i=1; i<buscar_patron.length(); i++){
       
        arr[i]=arr[i-1]+1;
       
       while(arr[i]!=-1 && buscar_patron.charAt(arr[i])!=buscar_patron.charAt(i))
       {
            if(arr[i-1]==-1)
            {
                arr[i]=-1;
            }
        else 
        {
            arr[i]=arr[arr[i-1]];
        }
	   }
    }
    
    for(int i=0; i<buscar_texto.length(); i++)
    {
  	   arr2[i]=count2++;
         if(buscar_texto.charAt(i)!=buscar_patron.charAt(count2))
         {
             count2=arr[count2];
         }
		arr2[i]=count2;
           
        if(count2==buscar_patron.length()-1)
        {
		   encontrar=true;
           for(int j=i-count2; j<=i; j++)
            {
               encontrados+=Character.toString(buscar_texto.charAt(j));
            }
    		index.add(i-count2);
    		tam++;
    		encontrados+=" ";
    		count2=-1;
  	   }
    }
    
	if(encontrar==true){
	   encontrados=encontrados.toUpperCase();
  	   Ta.setText(encontrados);
	}else Ta.setText("");
		   
		}
	   });
	B2.addActionListener(new ActionListener()
    	   {  	
		@Override
		public void actionPerformed(ActionEvent e){	
   	
		   
		   
		   
		}
	   });
	B3.addActionListener(new ActionListener()
    	   {  	
		@Override
		public void actionPerformed(ActionEvent e){	
   		   
		   String minus=Ta.getText();
		   Ta.setText(minus.toLowerCase());
		   
		}
	   });
	
	F.pack();
	F.setSize(400,400);
	F.setLocation(400,100);
	F.setVisible(true);
	
   }
}