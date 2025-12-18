package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T>{

    public List<Integer> indices = new ArrayList<Integer>();

    public SwapEvent(){}

    public SwapEvent(List<Integer> indices){
        this.indices = indices;
    }

    /**
     * A function that swaps the position of two elements of an array
     * @param <T> : the type of the elements being swapped
     * @param arr : The array that holds the elements
     * @param i : The first element being swapped
     * @param j : The second element being swapped
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    @Override
    public void apply(T[] arr) {
        swap(arr, indices.get(0), indices.get(1));
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return indices;
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
   
}
