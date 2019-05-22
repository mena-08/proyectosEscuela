import java.util.*;
import java.lang.*;

public class prueba{
    static ArrayList<Estudiante> lista = Estudiante.getEstudiantes(3000);

    public static void main(String[] args)
    {
        Scanner entrada= new Scanner(System.in);
        int aux3=0;
        for(Estudiante e: lista)
        {
            System.out.println(e);
        }
    try{
        System.out.println();
        System.out.println("Ingrese el ID a buscar:");
        aux3=entrada.nextInt();
        System.out.println("Buscando...");

        System.out.println(busqueda_clave(aux3));
        if(busqueda_clave(aux3)!= -1)
        {   
            System.out.println("                            ID    Nombre  Apellidos ");
            System.out.println("Información encontrada:  "+lista.get(aux3-1));
        }else
        {
            System.out.println("Información no encontrada.");
        }
    }catch(Exception ex)
    {
        System.out.println("Solo numeros!!");
    }
        

    }
    

    static public int busqueda_clave(int x)
    {
        int n = lista.size();
        int centro,inf=0,sup=n-1;
        while(inf<=sup)
        {
            centro=(sup+inf)/2;
            Estudiante aux = (Estudiante)lista.get(centro);
            String aux2="";
            for(int i=4;i<8;i++)
            {
                aux2+=aux.id.charAt(i);
            }
            
            if(Integer.parseInt(aux2)==x)
            {
                return centro+1;
            }
            else if(x <Integer.parseInt(aux2))
            {
                sup=centro-1;
            }
            else {
            inf=centro+1;
            }
}
return -1;
}    
}







class Estudiante{
  String nombre, apellidos;
  String id;
  String[] lnombres = {"Maria","Pedro","Karen","Juan","Aquiles","Yahir","Carlos","Azaena"};
  String[] lapellidos = {"Landeros","Obama","Page","Peña","Shlader","Villaseñor"};
  static int estudiantes_contador = 0;
  static ArrayList<Estudiante> getEstudiantes(int n){
      ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
      for(int i=1;i<=n;i++){
          lista.add(new Estudiante());
      }
      return lista;
  }
  Estudiante(){
  	estudiantes_contador++;
        nombre = lnombres[(int)(Math.random()*lnombres.length)];
        apellidos = lapellidos[(int)(Math.random()*lapellidos.length)] + " " +lapellidos[(int)(Math.random()*lapellidos.length)];
        id = getID();
  }
  @Override
  public String toString(){
     return id + " " + nombre + " " + apellidos;
  }
  String getID(){
      String id = "";
      String[] array_apellidos = apellidos.split(" ");
      id += array_apellidos[0].substring(0,2).toUpperCase();
      id += array_apellidos[1].substring(0,1);
      id += nombre.substring(0,1);
      
      int n_ceros = 4 - (int)Math.ceil(Math.log(estudiantes_contador+1)/Math.log(10));
      for(int i=0;i<n_ceros;i++)
      	id+= "0";
      
      id+= String.valueOf(estudiantes_contador);
      return id;      
  }

}



