package com.Techolution;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlaCarteControllerTests {

	@Test
	public void contextLoads() {
	}

	static int max(int a, int b)
	{
		return (a > b)? a : b;
	}

	@Test
	//public static int knapSack(int T, int eatingTime[], int satisfaction[], int n)
	public void knapSack()
	{
		int satisfaction[] = new int[]{60, 100, 120, 150};
		int eatingTime[] = new int[]{10, 20, 30, 20};
		int  T = 50;
		int n = satisfaction.length;
		//System.out.println(knapSack(W, wt, val, n));

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

		assertThat(220, equalTo(K[n][T]));
	}

}
