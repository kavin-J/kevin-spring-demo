package com.example;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by mypos on 2017/3/9.
 */
public class LinkedListTest {
    //LinkedList<Integer>实现链表的排序   使用插入排序
    public static LinkedList<Integer> insertSortForLinkedList(LinkedList<Integer> list) {
        int len = list.size();
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int temp = list.get(i);
            list.remove(i);  //注意这里需要删除元素
            while (j >= 0 && temp < list.get(j)) {
                j--;
            }
            list.add(j + 1, temp);
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] arr = {4,3,7,2,1,9,0,6,7};//new Integer[10];
        LinkedList linkedList = new LinkedList(Arrays.asList(arr));
        insertSortForLinkedList(linkedList);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(linkedList.toArray()));
    }
}
