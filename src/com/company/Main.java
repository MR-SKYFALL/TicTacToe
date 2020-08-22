package com.company;

import com.company.controler.Controler;
import com.company.model.ModelBoard;
import com.company.tools.Tools;

public class Main {

    public static void main(String[] args) {
        ModelBoard test = new ModelBoard();
       ModelBoard.write_into_board();

        Controler controler = new Controler();
        controler.generate_board_view();

        Tools.show_board();



//        ModelBoard.calculate_next_step_for_BOT(3);
//        System.out.println(ModelBoard.simple_result.points);
        System.out.println("i:"+ModelBoard.best_result.i+" j:"+ModelBoard.best_result.j+" points:"+ModelBoard.best_result.points);
      //  ModelBoard.calculate_next_step_for_BOT_AND_put_mark();



    }
}
