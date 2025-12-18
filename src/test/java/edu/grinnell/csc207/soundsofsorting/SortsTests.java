package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        for(int i = 0; i < arr.length; i++){
            System.err.println(arr[i]);
        }
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }

    @Test
    public void testBubbleEvent(){
        Integer[] arr = makeTestArray();
        List<SortEvent<Integer>> events = Sorts.bubbleSort(arr);
        for(int i = 0; i < events.size(); i++){
            events.get(i).apply(arr);
        }
        assertTrue(sorted(arr));
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }

    @Test
    public void testInsertionEvent(){
        Integer[] arr = makeTestArray();
        List<SortEvent<Integer>> events = Sorts.insertionSort(arr);
        for(int i = 0; i < events.size(); i++){
            events.get(i).apply(arr);
        }
        assertTrue(sorted(arr));
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test
    public void testSelectionEvent(){
        Integer[] arr = makeTestArray();
        List<SortEvent<Integer>> events = Sorts.selectionSort(arr);
        for(int i = 0; i < events.size(); i++){
            events.get(i).apply(arr);
        }
        assertTrue(sorted(arr));
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }

    @Test
    public void testMergeEvent(){
        Integer[] arr = makeTestArray();
        List<SortEvent<Integer>> events = Sorts.mergeSort(arr);
        for(int i = 0; i < events.size(); i++){
            events.get(i).apply(arr);
        }
        assertTrue(sorted(arr));
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }
    @Test
    public void testQuickEvent(){
        Integer[] arr = makeTestArray();
        List<SortEvent<Integer>> events = Sorts.quickSort(arr);
        for(int i = 0; i < events.size(); i++){
            events.get(i).apply(arr);
        }
        assertTrue(sorted(arr));
    }

    @Test
    public void testExchangeSort() {
        testSort(Sorts::exchangeSort);
    }
}