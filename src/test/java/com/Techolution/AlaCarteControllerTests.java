package com.Techolution;

import javafx.beans.binding.IntegerBinding;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
@RunWith(SpringJUnit4ClassRunner.class)


public class AlaCarteControllerTests{

	protected final String FILENAME="C:\\dev\\data.txt";
	protected ArrayList<String> satisfaction;
	protected ArrayList<String> eatingTime;

	@Test
	public void contextLoads() {
	}

	static int max(int a, int b)
	{
		return (a > b)? a : b;
	}

	@Test
	public void knapsack()
	{
		System.out.println("Starting the Spring boot knapSack Test ");
		ArrayList<String> satisfaction=new ArrayList<>();
		ArrayList<String> eatingTime=new ArrayList<>();

		System.out.println("Starting the Spring boot knapSack Test ");
		Logger.getGlobal().info("Start Validation Test : ");
		try
		{
		FileReader fileReader = new FileReader(FILENAME);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			bufferedReader.close();
			//return lines.toArray(new String[lines.size()]);
			System.out.println("  ");
			int i;
			int j;

			for (String item : lines) {
				String value[] = item.split(" ");
				for(i=0,j=i+1;i<value.length;i++) {
					satisfaction.add(value[i]);
					eatingTime.add(value[j]);
				}
			}

		} catch(Exception e)
		{
			System.out.println("System cannot read the file "+e.getMessage());
		}

		//int satisfaction[] = new int[]{10000,16808,50074,8931,27545,77924,64441,84493,7988,82328,78841,44304,17710,29561,93100,51817,99098,13513,23811,80980,36580,11968,1394,25486,25229,40195,35002,16709,15669,88125,9531,27723,28550,97802,40978,8229,60299,28636,23866,39064,39426,24116,75630,46518,30106,19452,82189,99506,6753,36717,54439,51502,83872,11138,53178,22295,21610,59746,53636,98143,27969,261,41595,16396,19114,71007,97943,42083,30768,85696,73672,48591,14739,31617,55641,37336,97973,49096,83455,12290,48906,36124,45814,35239,96221,12367,25227,41364,7845,36551,8624,97386,95273,99248,13497,40624,28145,35736,61626,46043,54680};
		//int eatingTime[] = new int[]{100,250,659,273,879,710,166,43,504,730,613,170,158,934,279,336,827,268,634,150,822,673,337,746,92,358,154,945,491,197,904,667,25,854,409,934,982,14,815,537,670,95,502,196,405,299,124,883,567,338,145,898,829,359,398,905,232,176,299,400,413,558,9,969,531,963,366,853,822,713,902,832,58,791,680,7,99,320,224,761,127,507,771,95,845,535,395,739,591,160,948,218,540,386,886,421,969,916,535,12,153};

		int  T = 10000;
		int n = satisfaction.size();
		//int n = satisfaction.length;

		int i, t;
		int K[][] = new int[n+1][T+1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++)
		{
			for (t = 0; t <= T; t++)
			{
				if (i==0 || t==0)
					K[i][t] = 0;
				else if (Integer.parseInt(eatingTime.get(i-1)) <= t)
					K[i][t] = max(Integer.parseInt(satisfaction.get(i-1)) + K[i-1][t-Integer.parseInt(eatingTime.get(i-1))],  K[i-1][t]);
				//else if (eatingTime[i-1] <= t)
				//	K[i][t] = max(satisfaction[i-1] + K[i-1][t-eatingTime[i-1]],  K[i-1][t]);

				else
					K[i][t] = K[i-1][t];
			}
		}
		System.out.println("--------------------------------------");
		System.out.println("*****  For T=10000 the total satisfaction is == "+K[n][T]+"  *****");
		System.out.println("--------------------------------------");
	}

	public static void main(String args[])
	{
		System.setProperty("spring.config.name", "knapsack-server");

		SpringApplication.run(AlaCarteControllerTests.class, args);
		AlaCarteControllerTests test1=new AlaCarteControllerTests();
		/*try {
			System.out.println("Caling the File Array Provider");
			test1.testFileArrayProvider();
		} catch (Exception e)
		{
			System.out.println("Unable to open the file "+e.getMessage());
		}*/
		test1.knapsack();
	}

	// This is an alternate test method for testing File sanity
	/*@Test
    public final void testFileArrayProvider() throws IOException {
        ArrayList<String> satisfaction=new ArrayList<>();
		ArrayList<String> eatingTime=new ArrayList<>();

		Logger.getGlobal().info("Starting Data Validation Test : ");
		try
		{
		FileReader fileReader = new FileReader(FILENAME);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			bufferedReader.close();
			//return lines.toArray(new String[lines.size()]);
			System.out.println("  ");
			int i;
			int j;

			for (String item : lines) {
				String value[] = item.split(" ");
				for(i=0,j=i+1;i<value.length;i++) {
					satisfaction.add(value[i]);
					eatingTime.add(value[j]);
				}
			}

		} catch(Exception e)
		{
			System.out.println("System cannot read the file "+e.getMessage());
		}
    }*/
}
