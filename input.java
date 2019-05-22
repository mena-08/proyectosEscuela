//Reader & Writer
//Input y Outputstream

import java.io.*;


public class input{
    public static void main(String[] args) throws IOException
    {
        File f = new File(args[0]);
        //Scanner entrada = new Scanner(System.in);
       // String aux = entrada.nextLine();
        byte[] b = new byte[54];
        
        int len = (int) f.length();
        byte[] c = new byte[len-54];
        //DataOutputStream out = new DataOutputStream(new FileOutputStream("salida.db"));
        //out.writeInt(2568);
        //out.close();

        DataInputStream in = new DataInputStream(new FileInputStream(f));
        in.read(b, 0, 53);
        in.read(c, 0, len-54);

        in.close();

        DataOutputStream out = new DataOutputStream(new FileOutputStream("salida.bmp"));
        out.write(b);
        for(int i=len-55;i>=0;i--)
        {
            out.write(c[i]);
        }
        out.close();
        
    }
}