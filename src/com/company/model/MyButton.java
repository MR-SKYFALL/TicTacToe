package com.company.model;

import javax.swing.*;

public class MyButton extends JButton {
     public int id;
    public String label;
    public MyButton(int id, String label) {
        super(label);
        this.id = id;
        this.label = label;
//        this.change_tab();
    }
    public void change_label(String new_label)
    {
        if(new_label == "o")
        {
            super.setText(new_label);
            this.label = new_label;
            this.change_tab();
        }
        else if(new_label == "x")
        {
            super.setText(new_label);
            this.label = new_label;
            this.change_tab();
        }
        else if(new_label == "-")
        {
            super.setText("");
            this.label = "";
            this.change_tab();
        }
        else
        {
            System.out.println("change label error");
        }


    }
    public  void change_tab()
    {

        int row = this.id/ModelBoard.rozmiar;
        int column = this.id%ModelBoard.rozmiar;

        if(this.label == "")
        {
            ModelBoard.myBoard[row][column] =  "-";
        }
        else
        {
            ModelBoard.myBoard[row][column] =  this.label;
        }


    }

}
