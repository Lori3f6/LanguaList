package moe.langua.lab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainTest {
    private static int total = 1000000;
    private static List<Integer> aList = new ArrayList<Integer>();
    private static List<Integer> lList = new LinkedList<Integer>();

    private static void testBatchInsert() {
        Random r = new Random();
        //测试ArrayList
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            aList.add(r.nextInt());//在最后插入数据，使用add()方法
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList中插入" + total + "条数据，共花费：" + (endTime - beginTime));

        //测试LinkedList
        beginTime = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            lList.add(r.nextInt());//在最后插入数据，使用add()方法
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList中插入" + total + "条数据，共花费：" + (endTime - beginTime));
    }

    /**
     * 测试遍历访问全部数据
     */
    private static void testTraverseAccess() {
        //测试ArrayList
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < aList.size(); i++) {
            aList.get(i);//通过get(int i)方法获得
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList中遍历全部数据，共花费：" + (endTime - beginTime));

        //测试LinkedList
        beginTime = System.currentTimeMillis();
        for (int i = 0; i < lList.size(); i++) {
            lList.get(i);//通过get(int i)方法获得
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList中遍历全部数据，共花费：" + (endTime - beginTime));
    }

    /**
     * 测试随机访问数据
     */
    private static void testRandomAccess() {
        int num = 1000;
        Random r = new Random();

        //测试ArrayList
        long beginTime = System.currentTimeMillis();
        for(int i = 0; i < num; i++) {
            aList.get(r.nextInt(aList.size()));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList中随机访问" + num + "数据，共花费：" + (endTime - beginTime));

        //测试LinkedList
        beginTime = System.currentTimeMillis();
        for(int i = 0; i < num; i++) {
            lList.get(r.nextInt(aList.size()));
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList中随机访问" + num + "数据，共花费：" + (endTime - beginTime));
    }

    /**
     * 演示随机插入数据
     */
    private static void testRandomInsert() {
        int num = 1000;
        Random r = new Random();

        //测试ArrayList
        long beginTime = System.currentTimeMillis();
        for(int i = 0; i < num; i++) {
            //通过list.add(int index, Integer element)在指定位置插入数据
            aList.add(r.nextInt(aList.size()), r.nextInt());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList中随机插入" + num + "数据，共花费：" + (endTime - beginTime));

        //测试LinkedList
        beginTime = System.currentTimeMillis();
        for(int i = 0; i < num; i++) {
            //通过list.add(int index, Integer element)在指定位置插入数据
            lList.add(r.nextInt(lList.size()), r.nextInt());
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList中随机插入" + num + "数据，共花费：" + (endTime - beginTime));
    }

    /**
     * 演示随机删除数据
     */
    private static void testRandomDelete() {
        int num = 1000;
        Random r = new Random();

        //测试ArrayList
        long beginTime = System.currentTimeMillis();
        for(int i = 0; i < num; i++) {
            //通过list.remove(int index)在指定位置删除数据
            aList.remove(r.nextInt(aList.size()));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList中随机删除" + num + "数据，共花费：" + (endTime - beginTime));

        //测试LinkedList
        beginTime = System.currentTimeMillis();
        for(int i = 0; i < num; i++) {
            //通过list.remove(int index)在指定位置删除数据
            lList.remove(r.nextInt(lList.size()));
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList中随机删除" + num + "数据，共花费：" + (endTime - beginTime));
    }

    public static void main(String[] args) {
        testBatchInsert();
        testTraverseAccess();
        testRandomAccess();
        testRandomInsert();
        testRandomDelete();
    }
}
