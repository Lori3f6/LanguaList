package moe.langua.lab;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainTest {
    Random random = new Random();

    public static void main(String[] args) {
        MainTest test = new MainTest();
        test.start();

    }

    private void start() {
        addToStart();
        addToEnd();
        randomAdd();
    }


    private void randomAdd() {
        System.gc();
        System.out.println("Start [Random Add] test.");
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Langualist<Integer> languaList = new Langualist<>();
        System.out.println("Initializing random array...");
        int[] initialArray = getRandomArray(1000000);
        int[] positionArray = getRandomArray(100000, 100000);
        System.out.println("Preparing array for testing...");
        for (int x : initialArray) {
            arrayList.add(x);
            linkedList.add(x);
            languaList.add(x);
        }
        System.out.println("Start testing: random add for 100000 times.");
        long start;
        long end;
        System.gc();
        start = System.currentTimeMillis();
        for (int x : positionArray) {
            arrayList.add(x, 233);
        }
        end = System.currentTimeMillis();
        System.out.println("Time escaped for ArrayList:" + (end - start) + "ms.");
        System.gc();
        start = System.currentTimeMillis();
        for (int x : positionArray) {
            linkedList.add(x, 233);
        }
        end = System.currentTimeMillis();
        System.out.println("Time escaped for LinkedList:" + (end - start) + "ms.");
        System.gc();
        start = System.currentTimeMillis();
        for (int x : positionArray) {
            languaList.add(x, 233);
        }
        end = System.currentTimeMillis();
        System.out.println("Time escaped for LanguaList:" + (end - start) + "ms.");
        if (isSame(arrayList, languaList)) {
            System.out.println("Successful! Test results can be trusted ✅");
        } else {
            System.out.println("Failed! Test results can not be trusted ❌");
        }
        System.out.println("===");
    }

    private void addToStart() {
        System.gc();
        System.out.println("Start [Add To Start] test.");
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Langualist<Integer> languaList = new Langualist<>();
        System.out.println("Initializing random array...");
        int[] initialArray = getRandomArray(1000000);
        int[] randomArray = getRandomArray(100000);
        System.out.println("Preparing array for testing...");
        for (int x : initialArray) {
            arrayList.add(x);
            linkedList.add(x);
            languaList.add(x);
        }
        System.out.println("Start testing: add to start for 100000 times.");
        long start;
        long end;
        System.gc();
        start = System.currentTimeMillis();
        for (int x : randomArray) {
            arrayList.add(0, x);
        }
        end = System.currentTimeMillis();
        System.out.println("Time escaped for ArrayList:" + (end - start) + "ms.");
        System.gc();
        start = System.currentTimeMillis();
        for (int x : randomArray) {
            languaList.add(0, x);
        }
        end = System.currentTimeMillis();
        System.out.println("Time escaped for LanguaList:" + (end - start) + "ms.");
        System.gc();
        start = System.currentTimeMillis();
        for (int x : randomArray) {
            linkedList.add(0, x);
        }
        end = System.currentTimeMillis();
        System.out.println("Time escaped for LinkedList:" + (end - start) + "ms.");

        System.out.println("Verifying testing results...");
        if (isSame(arrayList, languaList)) {
            System.out.println("Successful! Test results can be trusted ✅");
        } else {
            System.out.println("Failed! Test results can not be trusted ❌");
        }
        System.out.println("===");
    }

    private void addToEnd() {
        System.gc();
        System.out.println("Start [Add To End] test.");
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Langualist<Integer> languaList = new Langualist<>();
        System.out.println("Initializing random array...");
        int[] initialArray = getRandomArray(1000000);
        int[] randomArray = getRandomArray(100000);
        System.out.println("Preparing array for testing...");
        for (int x : initialArray) {
            arrayList.add(x);
            linkedList.add(x);
            languaList.add(x);
        }
        System.out.println("Start testing: add to end for 100000 times.");
        long start;
        long end;
        System.gc();
        start = System.currentTimeMillis();
        for (int x : randomArray) {
            arrayList.add(x);
        }
        end = System.currentTimeMillis();
        System.out.println("Time escaped for ArrayList:" + (end - start) + "ms.");
        System.gc();
        start = System.currentTimeMillis();
        for (int x : randomArray) {
            linkedList.add(x);
        }
        end = System.currentTimeMillis();
        System.out.println("Time escaped for LinkedList:" + (end - start) + "ms.");
        System.gc();
        start = System.currentTimeMillis();
        for (int x : randomArray) {
            languaList.add(x);
        }
        end = System.currentTimeMillis();
        System.out.println("Time escaped for LanguaList:" + (end - start) + "ms.");

        System.out.println("Verifying testing results...");
        if (isSame(arrayList, languaList)) {
            System.out.println("Successful! Test results can be trusted ✅");
        } else {
            System.out.println("Failed! Test results can not be trusted ❌");
        }
        System.out.println("===");
    }

    private int[] getRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    private int[] getRandomArray(int size, int bound) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    private boolean isSame(List a, List b) {
        Object[] arrA = a.toArray();
        Object[] arrB = b.toArray();
        if (a.isEmpty() != b.isEmpty()) return false;
        if (arrA.length != arrB.length) return false;
        int index = 0;
        while (index < arrA.length) {
            if ((int) arrA[index] !=
                    (int) arrB[index]) {
                System.out.println("A | index:" + index + " value:" + arrA[index]);
                System.out.println("B | index:" + index + " value:" + arrB[index]);
                return false;
            }
            index++;
        }
        return true;
    }
}
