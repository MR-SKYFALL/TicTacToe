package com.company.model;

import com.company.controler.Controler;
import com.company.tools.Tools;

//0 -> pusta krataka
//1 -> kolko
//2 -> krzyzyk
public  class  ModelBoard {

    public static int rozmiar = 4;
    public static String[][] myBoard;

    public static int price_field_array_size = (rozmiar+1);
    public static int[] price_field_array;
    public static int bestScore_lvl2 = -1;



//    enum minMax {min, max}

    public ModelBoard() {


        price_field_array = new int [price_field_array_size];
        myBoard = new String[rozmiar][rozmiar];


        for(int i=0;i<rozmiar;i++)
        {

            for(int j=0;j<rozmiar;j++)
            {
                ModelBoard.myBoard[i][j] = "-";

            }



        }

        Tools.show_board();
    }




    public static String line_from_l_d_to_r_u(int col_start, int row_start)
    {
        //0,2
        String result="";

        if((col_start == 0)|| ((row_start==rozmiar-1)))
        {
//            System.out.println("ok");
            int col_end = row_start;
            int row_end= col_start;

                while((row_start>=row_end)&&(col_start<=col_end))
                {
                    result+=ModelBoard.myBoard[row_start][col_start];
                    row_start--;
                    col_start++;
                }



        }
        else
        {
            System.out.println("wrong data");
        }

//        System.out.println(result);
        return result;
    }



    public static String line_from_r_d_to_l_u(int col_start, int row_start)
    {
        String result="";


        if((col_start == rozmiar-1 )|| ((row_start==rozmiar-1)))
        {
//            System.out.println("ok");


            while((row_start>=0)&&(col_start>=0))
            {
                result+=ModelBoard.myBoard[row_start][col_start];
                row_start--;
                col_start--;
            }



        }
        else
        {
            System.out.println("wrong data");
        }

//        System.out.println(result);
        return result;
    }

    public static String line_row (int nr_row)
    {
        String result = "";
        for(int i=0;i<rozmiar;i++)
        {
            result+=myBoard[nr_row][i];
        }
//        System.out.println(result);
        return result;
    }
    public static String line_col (int nr_col)
    {
        String result = "";
        for(int i=0;i<rozmiar;i++)
        {
            result+=myBoard[i][nr_col];
        }

        return result;
    }



    public static int how_many_element_occur(String inscription, String string_pattern , int n)
    {

        int occur_counter = 0;
        int start_pos = 0;

//        inscription = "--xxx--xxxx";
        int ins_length = inscription.length();

        String target_pattern = Tools.replace_string(string_pattern,n);
        int target_pattern_length = target_pattern.length();

        if(string_pattern == "x" || string_pattern == "o")
        {

            while(start_pos<ins_length)
            {
                if(inscription.indexOf(target_pattern,start_pos)!=-1)
                {
                    occur_counter++;
                    int test = inscription.indexOf(target_pattern,start_pos);
                    start_pos=inscription.indexOf(target_pattern,start_pos)+target_pattern_length;

                }
                else
                {
                    break;
                }
            }
//            System.out.println(occur_counter);
            return occur_counter;
        }

        else
        {
            System.out.println("wrong input data - string_pattern");
            return -1;
        }


    }

    public static void get_board_mark()
    {
        Tools.clean_price_field_array();

       // System.out.println("***************************************");
        for (int i=0;i<rozmiar;i++)
        {
            //System.out.println(line_col(i));
            String one_strip = line_col(i);
            Tools.count_ALL_type_accur_in_simple_string(one_strip);
        }
        //System.out.println("***************************************");
        for (int i=0;i<rozmiar;i++)
        {
            //System.out.println(line_row(i));
            String one_strip = line_row(i);
            Tools.count_ALL_type_accur_in_simple_string(one_strip);
        }
        {
           // System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            int licznik = 0;
            int col_start = 0;
            int row_start = 0;
            while (licznik < rozmiar * 2) {
                if (licznik < rozmiar - 1) {
                    //System.out.println(line_from_l_d_to_r_u(col_start, row_start));
                    String one_strip = line_from_l_d_to_r_u(col_start, row_start);
                    Tools.count_ALL_type_accur_in_simple_string(one_strip);
                    row_start++;

                } else {
                    //System.out.println(line_from_l_d_to_r_u(col_start, row_start));
                    String one_strip = line_from_l_d_to_r_u(col_start, row_start);
                    Tools.count_ALL_type_accur_in_simple_string(one_strip);
                    col_start++;

                }
                licznik++;

            }
        }
        {
            //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            int licznik = 0;
            int col_start = rozmiar-1;
            int row_start = 0;
            while (licznik < (rozmiar * 2)-1) {
                if (licznik < rozmiar - 1) {
                   // System.out.println(line_from_r_d_to_l_u(col_start, row_start));
                    String one_strip = line_from_r_d_to_l_u(col_start, row_start);
                    Tools.count_ALL_type_accur_in_simple_string(one_strip);
                    row_start++;

                } else {
                   // System.out.println(line_from_r_d_to_l_u(col_start, row_start));
                    String one_strip = line_from_r_d_to_l_u(col_start, row_start);
                    Tools.count_ALL_type_accur_in_simple_string(one_strip);
                    col_start--;

                }
                licznik++;

            }
        }


    }

    static public int return_point_form_board()
    {

        get_board_mark();
        int result=0;


        for (int i=1;i<price_field_array_size;i++) {

            int value1 = price_field_array[i];
            int value2 = (int)Math.pow(10, i);

            result += value1 * value2 ;
        }

        return result;
    }

   public static class Best_result {
        public int i;
        public int j;
        public int points;

        public Best_result(int i, int j, int points) {
            this.i = i;
            this.j = j;
            this.points = points;
        }
    }

    public static Best_result best_result = new  Best_result(-1,-1,-1);

   static public int calculate_next_step_for_BOT(int ilosc_krokow )
    {



        for(int i=0;i<rozmiar;i++)
        {
            for(int j=0;j<rozmiar;j++)
            {
                if(myBoard[i][j] == "-")
                {
                    if(ilosc_krokow == 3)
                    {
                        myBoard[i][j] = "x";
                        int local_point = calculate_next_step_for_BOT(--ilosc_krokow);
                        if(best_result.points<local_point)
                        {
                            best_result.points = local_point;
                            best_result.i=i;
                            best_result.j=j;
                        }
                        ModelBoard.myBoard[i][j] = "-";
                        ilosc_krokow++;
                        bestScore_lvl2 =-1;


                    }
                   else if(ilosc_krokow == 2)
                    {
                        myBoard[i][j] = "o";
                       int score = calculate_next_step_for_BOT(--ilosc_krokow);
                        if(score> bestScore_lvl2)
                        {
                            bestScore_lvl2 =score;

                        }
                        ModelBoard.myBoard[i][j] = "-";
                        ilosc_krokow++;


                    }
                    else if(ilosc_krokow == 1)
                    {
                        myBoard[i][j] = "x";
//                        Tools.show_board();
                        int local_point =  return_point_form_board();
                        ModelBoard.myBoard[i][j] = "-";
                        return local_point;

                    }

                }
            }
        }
        if(bestScore_lvl2 ==-1)
        {
            bestScore_lvl2 = return_point_form_board();
        }
        return bestScore_lvl2;

    }


    static public void calculate_next_step_for_BOT_AND_put_mark()
    {
        ModelBoard.best_result.j=-1;
        ModelBoard.best_result.i=-1;
        ModelBoard.best_result.points=-1;
        calculate_next_step_for_BOT(3);

        ModelBoard.myBoard[ModelBoard.best_result.i][ModelBoard.best_result.j] = "x";
        Controler.w1.refresh_board_view();
        System.out.println("------");
        Tools.show_board();

    }


    public static void write_into_board() // funkcja testowa
    {
//        //rek
//        ModelBoard.myBoard[0][0] = "o";
//        ModelBoard.myBoard[0][1] = "x";
//        ModelBoard.myBoard[0][2] = "o";
//        ModelBoard.myBoard[1][0] = "-";
//        ModelBoard.myBoard[1][1] = "x";
//        ModelBoard.myBoard[1][2] = "-";
//        ModelBoard.myBoard[2][0] = "x";
//        ModelBoard.myBoard[2][1] = "o";
//        ModelBoard.myBoard[2][2] = "-";
//---
//        ModelBoard.myBoard[1][0] = "x";
//        ModelBoard.myBoard[2][2] = "o";

//test
//        ModelBoard.myBoard[0][0] = "o";
//        ModelBoard.myBoard[0][1] = "x";
//        ModelBoard.myBoard[0][2] = "o";
//        ModelBoard.myBoard[1][0] = "x";
//        ModelBoard.myBoard[1][1] = "x";
//        ModelBoard.myBoard[1][2] = "o";
//        ModelBoard.myBoard[2][0] = "x";
//        ModelBoard.myBoard[2][1] = "o";
//        ModelBoard.myBoard[2][2] = "x";


//        ModelBoard.myBoard[0][0] = "x";
//        ModelBoard.myBoard[0][1] = "x";
//        ModelBoard.myBoard[0][2] = "x";

    }
}

//1-440
//2-1540
//3-440
//4-1540
//5-440
//6-440