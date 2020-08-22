package com.company.view;

import com.company.controler.Controler;
import com.company.model.ModelBoard;
import com.company.tools.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBotButtons extends JFrame {

    public ViewBotButtons() throws HeadlessException {
        super("BOT");
        setSize(250,70);
        setLocation(550, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        JButton bot_move_button =  new JButton("ruch bota");
        p.add(bot_move_button);
        Container cp = getContentPane();
        cp.add(p);
        setVisible(true);

        bot_move_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("test click");
                ModelBoard.calculate_next_step_for_BOT_AND_put_mark();


            }
        });

    }
}
