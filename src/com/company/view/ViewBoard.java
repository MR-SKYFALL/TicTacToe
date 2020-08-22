package com.company.view;

import com.company.model.ModelBoard;
import com.company.model.MyButton;
import com.company.tools.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.model.ModelBoard.rozmiar;

public class ViewBoard extends JFrame {
    public static JPanel p = new JPanel();
    public ViewBoard() {
        super("PLANSZA");

        int size =  rozmiar ;

        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        p.setLayout(new GridLayout(size, size, 5, 10));



        for (int i=0;i<size*size;i++)
        {

            String label = ModelBoard.myBoard[i/rozmiar][i%rozmiar];
            if(label=="-"){label="";}
            MyButton mybutton = new MyButton(i,label);

            mybutton.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {

//                    System.out.println("klik");
                    int id = ( (MyButton) e.getSource() ).id;
                    String text_with_button = ( (MyButton) e.getSource() ).label;
                    //System.out.println(text_with_button);
//                    System.out.println("test");
                    if(text_with_button == "")
                    {
                        ( (MyButton) e.getSource() ).change_label("x");
                    }
                    else if(text_with_button == "x")
                    {
                        ( (MyButton) e.getSource() ).change_label("o");
//                        ModelBoard.line_col(0);
                    }
                    else if(text_with_button == "o")
                    {
                        ( (MyButton) e.getSource() ).change_label("-");
                    }
                    else
                    {
                        System.out.println("error");
                    }
                    Tools.show_board();



                }
            });


//          mybutton.addActionListener(this);

            p.add(mybutton);
        }







//---------------------------------------------

        Container cp = getContentPane();

        cp.add(p);




        setVisible(true);


    }
    public void refresh_board_view()
    {

        int i=0,j=0,max=rozmiar;
        for (Component local_button : p.getComponents()) {
            //System.out.println("i:"+i+" j:"+j);
            ((MyButton)local_button).change_label(ModelBoard.myBoard[i][j]) ;
            j++;
            if(j==max)
            {
                j=0;
                i++;
            }



        }
    }


}

