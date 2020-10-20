package test.list;

import main.list.SinglyLinkedList;

public class SinglyLinkedListTest {

    public static boolean testSinglyLinkedList() {

        boolean allTestPassed = true;

        SinglyLinkedList list = new SinglyLinkedList();

        allTestPassed = list.size()==0;

        list.add(2);
        list.addFirst(1);
        list.addLast(4);
        list.addAt(2,3);
        list.addAt(4,5);

        //[1->2->3->4->5]
        allTestPassed = allTestPassed && (list.size()==5);
        allTestPassed = allTestPassed && (list.getFirst()==1) && (list.getLast()==5) && (list.get(2)==3);

        list.removeFirst();
        list.removeLast();
        list.removeAt(1);
        //[2->4]
        allTestPassed = allTestPassed && (list.size()==2);
        allTestPassed = allTestPassed && (list.getFirst()==2) && (list.getLast()==4) && (list.get(1)==4);

        list.removeValue(4);
        //[2]
        allTestPassed = allTestPassed && (list.size()==1);
        allTestPassed = allTestPassed && (list.getFirst()==2) && (list.getLast()==2);

        list.add(3);
        list.add(4);
        list.addFirst(1);
        //[1,2,3,4]
        list.reverse();
        //[4,3,2,1]
        allTestPassed = allTestPassed && (list.size()==4);
        allTestPassed = allTestPassed && (list.getFirst()==4) && (list.getLast()==1) && (list.get(1)==3);

        return allTestPassed;

    }
}
