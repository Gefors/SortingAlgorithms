import java.util.Random;

public class QuickSort implements IntSorter {
    @Override
    public void sort(int[] a) {
        shuffle(a);
        quickSort(a, 0, a.length - 1);

    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            // Partionera och få partitioneringsindex
            int j = partition(arr, lo, hi);

            // Kör quicksort rekursivt på delen från lo till partitionIndex - 1
            quickSort(arr, lo, j - 1);

            // Kör quicksort rekursivt på delen från partitionIndex + 1 till hi
            quickSort(arr, j + 1, hi);
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int i = lo; // Index för att öka
        int j = hi + 1; // Index för att minska
        int p = arr[lo]; // Välj p-elementet som det första elementet

        while (true) {
            // Öka i tills ett element större än eller lika med p hittas
            while (arr[++i] < p) {
                if (i == hi) break;
            }

            // Minska j tills ett element mindre än eller lika med p hittas
            while (p < arr[--j]) {
                if (j == lo) break;
            }

            // Om i är större än eller lika med j, bryt loopen
            if (i >= j) break;

            // Byt plats på elementen på position i och j
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Byt plats på pivot-elementet (lo) och elementet på position j
        int temp = arr[lo];
        arr[lo] = arr[j];
        arr[j] = temp;

        // Returnera det uppdaterade indexet för p-elementet
        return j;
    }


    private void shuffle(int[] a) {
        int N = a.length;
        Random randomGenerator = new Random();
        for (int i = 0; i < N; i++) {
            int r = i + randomGenerator.nextInt(N-i);     // between i and N-1
            int t = a[i]; a[i] = a[r]; a[r] = t;
        }
    }
}
