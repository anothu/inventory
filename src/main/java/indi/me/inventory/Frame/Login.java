/*
 * Created by JFormDesigner on Tue Dec 22 11:24:31 CST 2020
 */

package indi.me.inventory.Frame;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.*;
import javax.annotation.Resource;
import javax.swing.*;

/**
 * @author unknown
 */
@Component
public class Login extends JFrame {

    @Resource
    private SignIn signIn;

    public Login() {
        initComponents();
    }

    private void menuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println("!!!!");
        signIn.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menu2 = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menu3 = new JMenu();
        menuItem10 = new JMenuItem();
        menuItem9 = new JMenuItem();
        menuItem15 = new JMenuItem();
        menuItem16 = new JMenuItem();
        menu4 = new JMenu();
        menuItem11 = new JMenuItem();
        menuItem12 = new JMenuItem();
        menuItem13 = new JMenuItem();
        menuItem14 = new JMenuItem();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7528\u6237");
                menu1.setBackground(new Color(60, 63, 67));

                //---- menuItem2 ----
                menuItem2.setText("\u767b\u5f55");
                menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("\u6ce8\u9500");
                menu1.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("\u6dfb\u52a0\u7528\u6237");
                menu1.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("\u5220\u9664\u7528\u6237");
                menu1.add(menuItem5);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u5b58\u8d27");

                //---- menuItem6 ----
                menuItem6.setText("\u663e\u793a\u6240\u6709\u5b58\u8d27\u4fe1\u606f");
                menu2.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText("\u6dfb\u52a0\u65b0\u5b58\u8d27\u4fe1\u606f");
                menu2.add(menuItem7);

                //---- menuItem8 ----
                menuItem8.setText("\u67e5\u8be2\u5b58\u8d27\u76f8\u5173\u4fe1\u606f");
                menu2.add(menuItem8);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u8ba2\u5355");

                //---- menuItem10 ----
                menuItem10.setText("\u521b\u5efa\u65b0\u8ba2\u5355");
                menu3.add(menuItem10);

                //---- menuItem9 ----
                menuItem9.setText("\u67e5\u8be2\u8fd1\u671f\u8ba2\u5355");
                menu3.add(menuItem9);

                //---- menuItem15 ----
                menuItem15.setText("\u67e5\u8be2\u8fd1\u671f\u8fdb\u8d27");
                menu3.add(menuItem15);

                //---- menuItem16 ----
                menuItem16.setText("\u67e5\u8be2\u8fd1\u671f\u51fa\u8d27");
                menu3.add(menuItem16);
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("\u7b56\u7565");

                //---- menuItem11 ----
                menuItem11.setText("\u5b9a\u671f\u7b56\u7565");
                menu4.add(menuItem11);

                //---- menuItem12 ----
                menuItem12.setText("\u5b9a\u91cf\u7b56\u7565");
                menu4.add(menuItem12);

                //---- menuItem13 ----
                menuItem13.setText("\u6700\u5927\u6700\u5c0f\u7b56\u7565");
                menu4.add(menuItem13);

                //---- menuItem14 ----
                menuItem14.setText("\u67e5\u770b\u4f9b\u6c42\u5173\u7cfb");
                menu4.add(menuItem14);
            }
            menuBar1.add(menu4);
        }
        setJMenuBar(menuBar1);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenu menu2;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JMenuItem menuItem8;
    private JMenu menu3;
    private JMenuItem menuItem10;
    private JMenuItem menuItem9;
    private JMenuItem menuItem15;
    private JMenuItem menuItem16;
    private JMenu menu4;
    private JMenuItem menuItem11;
    private JMenuItem menuItem12;
    private JMenuItem menuItem13;
    private JMenuItem menuItem14;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
