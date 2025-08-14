public class ModifiedMergeSort implements IntSorter {
    @Override
    public void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] arr, int lo, int hi) {

        if (lo < hi) {
            // Hitta mitten av arrayen
            int mid = lo + (hi - lo) / 2;

            // Sortera vänstra och högra halvor
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);

            // Slå samman de sorterade halvorna
            merge(arr, lo, mid, hi);
        }
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        // Skapa temporärt lagringsutrymme
        int[] tempArray = new int[hi - lo + 1];

        int M = 3;

        if (hi - lo < M) {
            insertionSort(arr, lo, hi);
            return;
        }

        // Kopiera data till temporärt lagringsutrymme
        for (int k = lo; k <= hi; k++) {
            tempArray[k - lo] = arr[k];
        }

        // Initiala värden för loopräknare
        int i = lo;
        int j = mid + 1;

        // Slå samman två halvor tillbaka till arrayen
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // Om den vänstra delen är slut, använd värden från högra delen
                arr[k] = tempArray[j - lo];
                j++;
            }
            else if (j > hi) {
                // Om den högra delen är slut, använd värden från vänstra delen
                arr[k] = tempArray[i - lo];
                i++;
            }
            else if (tempArray[j - lo] < tempArray[i - lo]) {
                // Om värdet i högra delen är mindre än värdet i vänstra delen
                arr[k] = tempArray[j - lo];
                j++;
            }
            else {
                // Annars (om värdet i vänstra delen är mindre eller lika med värdet i högra delen)
                arr[k] = tempArray[i - lo];
                i++;
            }
        }
    }


    private void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && a[j] < a[j - 1]; j--) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

}
