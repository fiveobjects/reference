package org.openapex.samples.misc.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JLabelNumberDisplayIssue57578659 {
    public static void main(String[] args) {
        DBP prozor = new DBP();
        prozor.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        prozor.setVisible(true);
        prozor.setLocation(600, 250);
        prozor.setLayout(null);


    }

}
class DBP extends JFrame {
    private JLabel oznaka;
    private int brojac;
    private boolean upgraded1;
    private boolean upgraded2;
    private boolean upgraded3;
    private boolean isup1;
    private boolean isup2;
    private boolean isup3;

    public DBP(){
        setTitle("Cookie Clicker");
        setSize(800, 480);
        setLayout (new FlowLayout(FlowLayout.CENTER, 30, 20));



        oznaka = new JLabel("No points!");
        oznaka.setPreferredSize(new Dimension(100, 20));

        add(oznaka);
        JButton dugme = new JButton("Click");
        add(dugme);





        JButton upgrade = new JButton("Buy first upgrade!");
        upgrade.setBounds(317, 50, 150, 50);
        add(upgrade);
        upgrade.setVisible(false);

        JButton upgrade2 = new JButton("Buy second upgrade!");
        upgrade2.setBounds(317, 100, 150, 50);
        add(upgrade2);
        upgrade2.setVisible(false);

        JButton upgrade3 = new JButton("Buy third upgrade!");
        upgrade3.setBounds(317, 150, 150, 50);
        add(upgrade3);
        upgrade3.setVisible(false);



        dugme.addActionListener(new ActionListener(){


            public void actionPerformed(ActionEvent e){

                brojac++;

                if(upgraded1){
                    isup1 = true;
                }

                if(upgraded2){
                    isup2 = true;
                }

                if(upgraded3){
                    isup3 = true;
                }

                if (isup1){
                    brojac += -1;
                }

                if(isup1){
                    brojac += 2;
                }

                if(isup3){
                    brojac += 4;
                }

                oznaka.setText("Points " + brojac);
                if (brojac >= 5 && !upgraded1){
                    upgrade.setVisible(true);

                }
                if(brojac >= 10 && !upgraded2){
                    upgrade2.setVisible(true);
                    if (isup1){
                        upgrade2.setBounds(317, 50, 150, 50);
                    }
                }
                if(brojac >= 50 && !upgraded3){
                    upgrade3.setVisible(true);
                    if (isup1 && isup2){
                        upgrade3.setBounds(317, 50, 150, 50);
                    }else if (isup1 && !isup2){
                        upgrade3.setBounds(317, 100, 150, 50);
                    }else {
                        upgrade3.setBounds(317, 150, 150, 50);
                    }
                }
            }
        });


        upgrade.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                upgraded1 = true;
                isup1 = true;
                upgrade.setVisible(false);
                brojac -= 5;
                oznaka.setText("Points " + brojac);
            }
        });

        upgrade2.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                upgraded2 = true;
                isup2 = true;
                upgrade2.setVisible(false);
                brojac -= 10;
                oznaka.setText("Points " + brojac);
            }
        });

        upgrade3.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                upgraded3 = true;
                isup3 = true;
                upgrade3.setVisible(false);
                brojac -= 50;
                oznaka.setText("Points " + brojac);
            }
        });

    }
}
