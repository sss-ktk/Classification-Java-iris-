

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


public class ex8 {

	public static void main(String[] args) {

		double[][] samples = new double[150][5];
		int i,j;
		String[] str = null;
		double check;
		double accuracyCnt = 0;
		double p = 0.01;
		double t = 0;

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

		double w_vec [] = {0.33, 0.23, -0.38, -0.05, 0.47};
		double [] sampleClassified = new double [150]; //array to hold output from classifying samples

		/****************** ex8 *******************************/
		/****************** updating weight vectors using perceptron  *******************************/
		System.out.println("for p = "+p);
		for(t = 0; t<15; t++) {
			/**** checking for setosa samples ***/
			//System.out.println("t="+t+" Setosa");
			for(i = 0; i<50; i++) {
				check = w_vec[0];
				for(j = 0; j<4; j++) {
					check += samples[i][j] * w_vec[j+1];
				}
				if(check < 0) {
				/*	System.out.println("#"+i+" was wrong");
					System.out.println("b4 UPDATE");
					for (double element: w_vec) {
			            System.out.println(element);
			        }
			        */
					w_vec[0] += p;
					for(j = 0; j<4; j++) {
						w_vec[j+1] = w_vec[j+1] + p*samples[i][j];
					}
					/*
					System.out.println("After UPDATE");
					for (double element: w_vec) {
			            System.out.println(element);
			        }
					System.out.println();
					*/
				}


			}
			/**** checking for Versicolor ***/
			//System.out.println("t="+t+" Versicolor");
			for(i = 50; i<100; i++) {
				check = w_vec[0];
				for(j = 0; j<4; j++) {
					check += samples[i][j] * w_vec[j+1];
				}
				if(check > 0) {
					w_vec[0] -= p;
					for(j = 0; j<4; j++) {
						w_vec[j+1] = w_vec[j+1] - p*samples[i][j];
					}
				}

			}
			/********************/
		}
		/********** end of updating weights for 15 times *****/

		for(i = 0; i<100; i++) {
			check = w_vec[0];
			for(j = 0; j<4; j++) {
					check += samples[i][j] * w_vec[j+1];

			}
			if(check > 0) {
				sampleClassified[i] = 1.0;
			}else {
				sampleClassified[i] = 2.0;
			}
			if(samples[i][4] == sampleClassified[i]) {
				accuracyCnt++;
			}
		}
		System.out.println("w_vec are");
		for (double element: w_vec) {
            System.out.printf("%.2f ", element);
        }
		System.out.println();
		System.out.println("Classification accuracy for ex7 was " + String.format("%.0f",accuracyCnt)+"%");

		/*********** checking for p = 0.1 ********************************/
		double w_vec2 [] = {0.33, 0.23, -0.38, -0.05, 0.47};
		p = 0.1;
		accuracyCnt	= 0;
		System.out.println();

		System.out.println("for p = "+p);
		for(t = 0; t<15; t++) {
			/**** checking for setosa samples ***/
			for(i = 0; i<50; i++) {
				check = w_vec2[0];
				for(j = 0; j<4; j++) {
					check += samples[i][j] * w_vec2[j+1];
				}
				if(check < 0) {
					w_vec2[0] += p;
					for(j = 0; j<4; j++) {
						w_vec2[j+1] = w_vec2[j+1] + p*samples[i][j];
					}
				}


			}
			/**** checking for Versicolor ***/
			for(i = 50; i<100; i++) {
				check = w_vec2[0];
				for(j = 0; j<4; j++) {
					check += samples[i][j] * w_vec2[j+1];
				}
				if(check > 0) {
					w_vec2[0] -= p;
					for(j = 0; j<4; j++) {
						w_vec2[j+1] = w_vec2[j+1] - p*samples[i][j];
					}
				}

			}
			/********************/
		}
		/********** end of updating weights for 15 times *****/

		for(i = 0; i<100; i++) {
			check = w_vec2[0];
			for(j = 0; j<4; j++) {
					check += samples[i][j] * w_vec2[j+1];

			}
			if(check > 0) {
				sampleClassified[i] = 1.0;
			}else {
				sampleClassified[i] = 2.0;
			}
			if(samples[i][4] == sampleClassified[i]) {
				accuracyCnt++;
			}
		}
		System.out.println("w_vec are");
		for (double element: w_vec2) {
            System.out.printf("%.2f ", element);
        }
		System.out.println();
		System.out.println("Classification accuracy for ex7 was " + String.format("%.0f",accuracyCnt)+"%");

	}

}

