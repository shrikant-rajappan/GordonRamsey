package com.Techolution;

/**
 * Created by shrikant on 28/12/2016.
 */
/*
* This class wil also have the logic to read data from given file and store it
* into two distinct arrays with the index in each representing the dish number.
*/

public class AlaCarte {

    int satisfaction[] = new int[]{60, 100, 120, 150};
    int eatingTime[] = new int[]{10, 20, 30, 20};
    int  T = 50;
    int n = satisfaction.length;


    static int max(int a, int b)
    {
        return (a > b)? a : b;
    }

    public int knapSack()
    {
        int i, t;
        int K[][] = new int[n+1][T+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (t = 0; t <= T; t++)
            {
                if (i==0 || t==0)
                    K[i][t] = 0;
                else if (eatingTime[i-1] <= t)
                    K[i][t] = max(satisfaction[i-1] + K[i-1][t-eatingTime[i-1]],  K[i-1][t]);
                else
                    K[i][t] = K[i-1][t];
            }
        }

        return(K[n][T]);
    }

}


