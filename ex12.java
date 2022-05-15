

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


public class ex12 {
	public static double[][] samples = new double[150][5];
	public static int i,j;
	public static double check;

	public static void main(String[] args) {

		String[] str = null;

		try {
			 FileInputStream file = new FileInputStream("./src/iris.txt");
			 Scanner sc = new Scanner(file);


			 for(i = 0; i<150; i++) {
				 str = sc.nextLine().split(" ");
				 for(j=0; j<str.length; j++) {
					 samples[i][j] = Double.parseDouble(str[j]);
				 }
			 }
			 sc.close();
		 }catch(IOException e){
			 e.printStackTrace();
		 }

			nearestNeighbor(5);


	}
	public static void nearestNeighbor(int x) {
		double accuracyCnt = 0;
		int tmpIndex = 0;
		double loo []  = new double [4];
		double min = 0;
		double dis;
		int k;
		for(i = 0; i<150; i++) {
			for(k = 0; k<4; k++) {
				loo[k] = samples[i][k];
			}
			min = 1000000.0;
			for(j = 0; j<150; j++) {
				if(i != j) {
					dis = 0;
					for(k =0; k<4; k++) {
						dis += Math.pow((loo[k] - samples[j][k]),2);
						//dis += (loo[k] - samples[j][k])*(loo[k] - samples[j][k]);
					}
					if(dis < min) {
						min = dis;
						tmpIndex = j;
					}
				}

			}
			if(samples[i][4] == samples[tmpIndex][4]) {
				accuracyCnt++;
			}
		}
		System.out.println("•ª—Þ¸“x:"+accuracyCnt/150);
		accuracyCnt = accuracyCnt/1.5;
		System.out.println("•ª—Þ¸“x: " +String.format("%.0f",accuracyCnt)+"%");

	}
}

