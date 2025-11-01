package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T>{
    public List<Integer> indices;

    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    @Override
    public void apply(T[] arr) {
        for(int i = 0; i < indices.size(); i+=2){
            swap(arr, indices.get(i), indices.get(i+1));
        }
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return indices;
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
    // TODO: implement me
}
