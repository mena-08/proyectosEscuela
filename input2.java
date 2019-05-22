import java.io.*;


public class input2{
    public static void main(String[] args) throws IOException
    {
        File f = new File(args[0]);
        File f2 = new File(args[1]);   
        //byte aux[] = new byte[];
        double tam =  f2.length();
        
        tam = tam/3;
        
        tam = Math.sqrt(tam);
        int tamAux=(int)tam;
        String hex = Integer.toHexString(tamAux);
        byte aux[] = hex.getBytes(); 

        
        byte[] b = new byte[54];
        int len = (int) f2.length();
        byte[] c = new byte[len];

        DataInputStream in = new DataInputStream(new FileInputStream(f));
        in.read(b, 0, 54);
        //in.read(c, 0, len-54);
        in.close();

        DataInputStream in2 = new DataInputStream(new FileInputStream(f2));
        in2.read(c, 0, len);
        in2.close();


        DataOutputStream out = new DataOutputStream(new FileOutputStream(f2+".bmp"));
        //out.write(b);
        out.write(c);
        for(int i=0;i<54;i++)
        {
            if(i==18)
            {
                out.write();    
            }
            out.write(b[i]);
        }
        out.close();
    }
}