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
    public void testBubbleSort2() {
        Integer[] arr = {5,3,19,35,2,7,84,1};
        Sorts.bubbleSort(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort3() {
        Integer[] arr = {5,100,19,0,2,2,84,-2};
        Sorts.bubbleSort(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleEvent(){
        Integer[] arr = makeTestArray();
        Integer[] copy = makeTestArray();
        List<SortEvent<Integer>> events = Sorts.selectionSort(arr);
        for(int i = 0; i < events.size(); i++){
            events.get(i).apply(copy);
        }
        assertTrue(sorted(copy));
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }

    @Test
    public void testInsertSort2() {
        Integer[] arr = {5,3,19,35,2,7,84,1};
        Sorts.insertionSort(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testInsertSort3() {
        Integer[] arr = {5,100,19,0,2,2,84,-2};
        Sorts.insertionSort(arr);
        assertTrue(sorted(arr));
    }


    @Test
    public void testInsertionEvent(){
        Integer[] arr = makeTestArray();
        Integer[] copy = makeTestArray();
        List<SortEvent<Integer>> events = Sorts.insertionSort(arr);
        for(int i = 0; i < events.size(); i++){
            events.get(i).apply(copy);
        }
        assertTrue(sorted(copy));
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test
    public void testSelectSort2() {
        Integer[] arr = {5,3,19,35,2,7,84,1};
        Sorts.selectionSort(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testSelectSort3() {
        Integer[] arr = {5,100,19,0,2,2,84,-2};
        Sorts.selectionSort(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testSelectionEvent(){
        Integer[] arr = makeTestArray();
        Integer[] copy = makeTestArray();
        List<SortEvent<Integer>> events = Sorts.selectionSort(arr);
        for(int i = 0; i < events.size(); i++){
            events.get(i).apply(copy);
        }
        assertTrue(sorted(copy));
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }

    @Test
    public void testMergeSort2() {
        Integer[] arr = {5,3,19,35,2,7,84,1};
        Sorts.mergeSort(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testMergeSort3() {
        Integer[] arr = {5,100,19,0,2,2,84,-2};
        Sorts.mergeSort(arr);
        assertTrue(sorted(arr));
    }



    @Test
    public void testMergeEvent(){
        Integer[] arr = makeTestArray();
        Integer[] copy = makeTestArray();
        List<SortEvent<Integer>> events = Sorts.mergeSort(arr);
        for(int i = 0; i < events.size(); i++){
            events.get(i).apply(copy);
        }
        assertTrue(sorted(copy));
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }

    @Test
    public void testQuickSort2() {
        Integer[] arr = {5,3,19,35,2,7,84,1};
        Sorts.quickSort(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testQuickSort3() {
        Integer[] arr = {5,100,19,0,2,2,84,-2};
        Sorts.quickSort(arr);
        assertTrue(sorted(arr));
    }


    @Test
    public void testQuickEvent(){
        Integer[] arr = makeTestArray();
        Integer[] copy = makeTestArray();
        List<SortEvent<Integer>> events = Sorts.quickSort(arr);
        for(int i = 0; i < events.size(); i++){
            events.get(i).apply(copy);
        }
        assertTrue(sorted(copy));
    }

    @Test
    public void testExchangeSort() {
        testSort(Sorts::exchangeSort);
    }
    @Test
    public void testExchangeSort2() {
        Integer[] arr = {5,3,19,35,2,7,84,1};
        Sorts.exchangeSort(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testExchangeSort3() {
        Integer[] arr = {5,100,19,0,2,2,84,-2};
        Sorts.exchangeSort(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testExchangeEvent(){
        Integer[] arr = makeTestArray();
        Integer[] copy = makeTestArray();
        List<SortEvent<Integer>> events = Sorts.exchangeSort(arr);
        for(int i = 0; i < events.size(); i++){
            events.get(i).apply(copy);
        }
        assertTrue(sorted(copy));
    }
}