import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class menus2
{
    static JMenu menu = new JMenu("Menu 1");

    static JMenu menu2 = new JMenu("Menu 2");
    static JMenu subMenu = new JMenu("Submenu 1");
    static JMenu subMenu2 = new JMenu("Submenu 2");
    static JMenuItem[] itemsArr = new JMenuItem[8];
    static String names[] = {"Item 1","Item 2","Item 3","Item 4","Item 5","Item 6","Item 7","Item 8"};
    
    public static void main(String[] args) 
    {
        JFrame f = new JFrame("Ejemplo de Menu y MenuItems");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        for(int i=0;i<8;i++)
        {
            itemsArr[i] = new JMenuItem(names[i]);
        }
        //Creamos un JMenuBar, el cual contiene todos los componentes siguientes 
        JMenuBar mb = new JMenuBar();
        //Agregamos los primeros elementos JMenuItem
        menu.add(itemsArr[0]);
        menu.add(itemsArr[1]);
        menu.add(itemsArr[2]);
        // Agregamos JMenuItems, pero ahora a un submenu
        subMenu.add(itemsArr[3]);
        subMenu.add(itemsArr[4]);
        // Agregamos JMenuItems, pero ahora a un submenu
        subMenu2.add(itemsArr[5]);
        subMenu2.add(itemsArr[6]);
        subMenu2.add(itemsArr[7]);
        //Aquí agregamos el submenu 2 al submenu 2
        subMenu.add(subMenu2);
        //Agregamos el submenu al menu principal 
        menu.add(subMenu);
        //Finalmente agregamos los menus al JMenuBar, el contenedor final
        mb.add(menu);
        mb.add(menu2);
        

        f.setJMenuBar(mb);
        f.setSize(400,400);
        f.setVisible(true);
    }
}