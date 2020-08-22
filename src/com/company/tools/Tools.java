package com.company.tools;

import com.company.model.ModelBoard;

import static com.company.model.ModelBoard.rozmiar;

public class Tools {




    public static void show_board()
    {
        System.out.println("");
        System.out.println("");
        for(int i=0;i<rozmiar;i++)
        {
            String tmp ="";
            for(int j=0;j<rozmiar;j++)
            {

                    tmp += ModelBoard.myBoard[i][j]+" ";

            }
            System.out.println(tmp);


        }

//        System.out.println(ModelBoard.myBoard[1][1]);

    }

    public static String replace_string(String some_String, int n)
    {
        String result ="";
        for(int i=0;i<n;i++)
        {
            result+=some_String;
        }
        return result;

    }

    public static void clean_price_field_array()
    {
        for(int i=0;i< ModelBoard.price_field_array_size-1;i++)
        {
            ModelBoard.price_field_array[i+1]=0;
        }
    }

    public static void count_ALL_type_accur_in_simple_string(String one_strip)
    {


        for(int i=0;i< ModelBoard.price_field_array_size-1;i++)
        {
            ModelBoard.price_field_array[i+1] += ModelBoard.how_many_element_occur(one_strip,"x",i+1);

        }

        for(int i=0;i<ModelBoard.price_field_array_size-1;i++)
        {
            ModelBoard.price_field_array[i+1] -= ModelBoard.how_many_element_occur(one_strip,"o",i+1);

        }

    }

}
