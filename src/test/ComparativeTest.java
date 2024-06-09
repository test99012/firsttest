package test;

import java.util.Arrays;

import datos.Functions;
import datos.ParallelQuickSort;
import datos.SecuentialQuickSort;

public class ComparativeTest {

	public static void main(String[] args) {

		int executions = 10;
		int arraySize = 100000;
		double totalSecuential = 0;
		double totalParallel = 0;
		
		for (int i=0; i<executions ; i++) {
			
			double start;
			double end;
			double duration;
			
			int[] array = Functions.randomArray(arraySize, 1, 1000);
			int[] parallelArray = Arrays.copyOf(array, array.length);
			int[] secuentialArray = Arrays.copyOf(array, array.length);
			
			//Ejecucion secuencial
			start = System.nanoTime();
			SecuentialQuickSort.quickSort(secuentialArray, 0, secuentialArray.length - 1);
			end = System.nanoTime();
			duration = (end - start) / 1000;
			totalSecuential += duration;
			
			//Ejecucion paralela
			start = System.nanoTime();
			ParallelQuickSort.parallelQuickSort(parallelArray, 0, parallelArray.length - 1);
			end = System.nanoTime();
			duration = (end - start) / 1000;
			totalParallel += duration ;
			
		}
		
		double averageSecuential = totalSecuential/(double)executions;
		double averageParallel = totalParallel/(double)executions;
		
		System.out.printf("Average secuential duration--> %.2f microseconds \n", averageSecuential);
		System.out.printf("Average parallel duration-->  %.2f microseconds ", averageParallel);
	}
}

