import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.*;
import java.util.*;

public class kmpFinal {
    static JTextField txtPatron = new JTextField(20);
    static JTextArea txto = new JTextArea(20, 20);
    static JButton kmp = new JButton("KMP");
    static JButton min = new JButton("MINUSCULA");
    static JButton bhm = new JButton("BMH");
    static JButton del = new JButton("BORRAR");
    static String patron;
    static String texto;
    public static void main(String[] args) {
        JFrame f = new JFrame("Reemplazo de cadenas");
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

        JScrollPane scr1 = new JScrollPane(txto);

        JPanel p3 = new JPanel(new FlowLayout());

        p1.add(new JLabel("Palabra a buscar: "));
        p1.add(txtPatron);
        f.add(p1, BorderLayout.NORTH);

        p2.add(new JLabel("Ingrese el texto:"));
        p2.add(scr1);
        f.add(p2, BorderLayout.CENTER);

        p3.add(kmp);
        p3.add(min);
        p3.add(bhm);
        p3.add(del);
        f.add(p3, BorderLayout.SOUTH);

        kmp.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = txto.getText();
                patron = txtPatron.getText();
                
                //texto.getChars(0, texto.length()-1, charaux, 0);
                try {
                    kmpFinal.searchKMP(texto, patron);
                } catch (Exception ex) 
                {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        del.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            txto.setText("");
            txtPatron.setText("");    
            }
        });

        min.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                texto = txto.getText();
                txto.setText(texto.toLowerCase());    
            }
        });

        bhm.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = txto.getText();
                patron = txtPatron.getText();
                try {
                    kmpFinal.searchBHM(texto,patron);    
                } catch (Exception ex) 
                {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });

        f.pack();
        f.setSize(500,500);
        f.setVisible(true);
    }

    static void searchKMP(String txt, String patron) throws Exception
    {
        int txtLen = txt.length();
        int patLen= patron.length();
        int[] valores = valPatron(patron);
        int indPat=0;
        int indTxt=0;
        char[] aux = new char[txtLen];
        texto.getChars(0, texto.length(), aux, 0);


        while(indTxt<txtLen)
        {

                    //j                   //i
            if(patron.charAt(indPat)==txt.charAt(indTxt))
            {
                indPat++;
                indTxt++;
            }
            if(indPat==patLen)
            {   
                int indice = indTxt-indPat;
                
                for(int i=indice; i<(indice+(patLen));i++)
                {
                    aux[i] = Character.toUpperCase(aux[i]);
                    System.out.println(aux[i]);
                }
                String aux2 = new String(aux);
                txto.setText(aux2);
                indPat = valores[indPat-1];
            }
            else if(indTxt<txtLen && patron.charAt(indPat) != txt.charAt(indTxt))
            {
                if(indPat!=0)
                {
                    indPat = valores[indPat-1];
                }
                else
                {
                    indTxt+=1;
                    
                }
            }
        }

    }

   static int[] valPatron(String pat)
    {
       int n=pat.length();
       int[] valores= new int[n];
       valores[0] = 0;
       for(int i=1;i<n;i++)
       {
           int j= valores[i-1];
           while(j>0 && pat.charAt(i) != pat.charAt(j))
           {
               j = valores[j-1];

           }
           if(pat.charAt(i)==pat.charAt(j))
           {
               j++;
           }
           valores[i]=j;
       }
       return valores;
    }

   public static void searchBHM(String texto, String patron) 
   {
    HashMap<Character, Integer> mapText = new HashMap<Character, Integer>();
	ArrayList<Integer> keyPatron= new ArrayList<Integer>();
    int aux=patron.length();
    int txtLen=texto.length();
    int aux1=0, aux2=0, iter=0;
    String concat="";
    
    for(int i=0;i<aux;i++)
    {
        mapText.put(patron.charAt(i), aux);
    }

    while(aux!=1) 
    {
      for(int i=0;i<aux;i++) 
      {
        mapText.replace(patron.charAt(i), aux-1);
	    aux--;
        if(aux==1)
        {
            break;
        }
	  }
    }
    //Actualizar
    aux = patron.length();

    while(iter<txtLen) 
    {
	  aux1=0;
      while (aux2<txtLen && texto.charAt(aux2)==patron.charAt(aux1)) 
      {
        if (aux1==aux-1) 
        {
	      keyPatron.add(aux2-aux1);
	      concat=texto.substring(iter, aux2 + 1).toUpperCase();
	      break;
	    }
	    aux1++;
	    aux2++;
	  }
      if(aux-1+iter <texto.length()&& mapText.containsKey(texto.charAt(aux-1+iter)))
      {
          iter+= mapText.get(texto.charAt(aux-1+iter));
      }
      else
      {
          iter+=aux;
      }
	  aux2=iter;
	}
	txto.setText(texto.replace(patron, concat));
   }
}