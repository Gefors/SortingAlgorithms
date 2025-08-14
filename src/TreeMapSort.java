import java.util.*;

public class TreeMapSort implements IntSorter {
    @Override
    public void sort(int[] a) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int N = a.length;

        // Fyll symboltabellen med tal och deras frekvens
        for (int i = 0; i < N; i++) {
            int num = a[i];
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }

        // Plocka ut talen i ordning från symboltabellen och uppdatera arrayen
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            // Uppdatera arrayen med rätt antal förekomster av varje tal
            for (int i = 0; i < count; i++) {
                a[index] = num;
                index++;
            }
        }
    }
}
