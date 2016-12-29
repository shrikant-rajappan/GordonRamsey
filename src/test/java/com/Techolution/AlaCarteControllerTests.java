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

	public static int knapSack()
	{
		int satisfaction[] = new int[]{10000,16808,50074,8931,27545,77924,64441,84493,7988,82328,78841,44304,17710,29561,93100,51817,99098,13513,23811,80980,36580,11968,1394,25486,25229,40195,35002,16709,15669,88125,9531,27723,28550,97802,40978,8229,60299,28636,23866,39064,39426,24116,75630,46518,30106,19452,82189,99506,6753,36717,54439,51502,83872,11138,53178,22295,21610,59746,53636,98143,27969,261,41595,16396,19114,71007,97943,42083,30768,85696,73672,48591,14739,31617,55641,37336,97973,49096,83455,12290,48906,36124,45814,35239,96221,12367,25227,41364,7845,36551,8624,97386,95273,99248,13497,40624,28145,35736,61626,46043,54680};
		int eatingTime[] = new int[]{100,250,659,273,879,710,166,43,504,730,613,170,158,934,279,336,827,268,634,150,822,673,337,746,92,358,154,945,491,197,904,667,25,854,409,934,982,14,815,537,670,95,502,196,405,299,124,883,567,338,145,898,829,359,398,905,232,176,299,400,413,558,9,969,531,963,366,853,822,713,902,832,58,791,680,7,99,320,224,761,127,507,771,95,845,535,395,739,591,160,948,218,540,386,886,421,969,916,535,12,153};
		int  T = 1000;
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

		return(K[n][T]);
	}

	@Test
	public static void main(String args[])
	{
		System.out.println(knapSack());
	}
}
