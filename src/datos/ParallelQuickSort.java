package datos;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelQuickSort {

	public static void parallelQuickSort(int[] array, int lowIndex, int highIndex) {

		// se crea una tarea principal con el array a ordenar
		SortTask mainTask = new SortTask(array, lowIndex, highIndex);

		// se crea una pileta de hilos
		ForkJoinPool pool = new ForkJoinPool();

		// se ejecuta la tarea
		pool.invoke(mainTask);
		pool.close();

	}

	// clase de la tarea
	@SuppressWarnings("serial")
	private static class SortTask extends RecursiveAction {
		
		private int[] array;;
		private int lowIndex;
		private int highIndex;

		public SortTask(int[] array, int lowIndex, int highIndex) {
			this.array = array;
			this.lowIndex = lowIndex;
			this.highIndex = highIndex;
		}

		// tarea de ordenamiento
		@Override
		protected void compute() {

			if (highIndex > lowIndex) {

				// la posición del pivote se determina de igual manera que el algoritmo secuencial
				int p = SecuentialQuickSort.partition(array, lowIndex, highIndex);

				// se crean dos nuevas tareas para los subarrays izquierdo y derecho
				SortTask leftfTask = new SortTask(array, lowIndex, p - 1);
				SortTask rightTask = new SortTask(array, p + 1, highIndex);

				// se ejecutan las tareas
				invokeAll(leftfTask, rightTask);
			}
			
		}
		
	}
	
}
