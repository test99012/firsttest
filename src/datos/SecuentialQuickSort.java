package datos;

public class SecuentialQuickSort {

	public static void quickSort(int[] array, int lowIndex, int highIndex) {

		// mientras haya elementos por ordenar
		if (lowIndex < highIndex) {

			// determina la posición del pivote
			int partitionIndex = partition(array, lowIndex, highIndex);

			// ordena recursivamente los subarrays a la izquierda y derecha
			quickSort(array, lowIndex, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, highIndex);
		}
		
	}

	static int partition(int[] array, int lowIndex, int highIndex) {

		// posición inicial del pivote
		int pivot = array[highIndex];

		// índice para la posición del menor elemento
		int i = (lowIndex - 1);

		// se compara cada elemento del array con el pivote y se permuta en caso de ser
		// necesario
		for (int j = lowIndex; j < highIndex; j++) {

			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
			
		}

		// ubica al pivote en su posicion correspondiente y la retorna
		swap(array, i + 1, highIndex);
		return (i + 1);
		
	}

	static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
}
