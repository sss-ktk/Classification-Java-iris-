

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


public class ex14 {
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

		//for(int l = 0; l<3; l++) {
			nearestNeighbor(0);
		//}


	}
	public static void nearestNeighbor(int x) {
		double accuracyCnt = 0;
		int tmpIndex = 0;
		double loo []  = new double [2];
		double min = 0;
		double dis;
		int k;
		for(i = 0; i<150; i++) {
			for(k = 0; k<loo.length; k++) {
				loo[k] = samples[i][k+x];
			}
			min = 1000000.0;
			for(j = 0; j<150; j++) {
				if(i != j) {
					dis = 0;
					for(k =0; k<loo.length; k++) {
						dis += Math.pow((loo[k] - samples[j][k]),2);
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
		accuracyCnt = accuracyCnt/1.5;
		System.out.println(x+1+","+(x+2)+"次元ベクトルのみの場合");
		System.out.println("　分類精度: " +String.format("%.2f",accuracyCnt)+"%");
		//System.out.println(accuracyCnt);
	}
}

