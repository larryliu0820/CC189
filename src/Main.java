import Ch1.Ch1Prob7;
import Ch1.Ch1Prob8;
import Ch2.*;
/**
 * Created by larryliu on 5/3/16.
 */
public class Main {
    public static void main(String[] args) {
/*        Ch1.Ch1Prob2 prob2 = new Ch1.Ch1Prob2();
        String a = "adopiua&*&^*()*^H";
        String b = "Hdopiua&*&^*()*^a";
        boolean result = prob2.isPermutation(a, b);
        System.out.println(result);
        boolean result2 = prob2.isPermutationUsingArray(a, b);
        System.out.println(result2);

        Ch1.Ch1Prob3 prob = new Ch1.Ch1Prob3();
        String src = "Mr Jo hn Smi th        ";
        char[] srcArray = src.toCharArray();
        prob.URLify(srcArray, 15);
        System.out.println(srcArray);

        Ch1.Ch1Prob4 prob4 = new Ch1.Ch1Prob4();
        boolean result4 = prob4.isPalindromePermutation("tact coa");
        System.out.println(result4);

        Ch1.Ch1Prob5 prob5 = new Ch1.Ch1Prob5();
        boolean result5 = prob5.isOneEditAway2("pale", "bake");
        System.out.println(result5);

        Ch1.Ch1Prob6 prob6 = new Ch1.Ch1Prob6();
        String out = prob6.compressString("aabcccccaaa");
        System.out.println(out); */

        LinkedList list = new LinkedList();
        int j = 9;
        for (int i = 0; i < 10; i++) {
            list.insertTail(i);
            list.insertTail(j--);
        }
        list.printList();
        Ch2Prob1 prob1 = new Ch2Prob1();
        Ch2Prob2 prob2 = new Ch2Prob2();
        Ch2Prob3 prob3 = new Ch2Prob3();
        Ch2Prob4 prob4 = new Ch2Prob4();
        System.out.println("Last 2nd element = " + prob2.findLastKthElement(list, 2).getData());
        prob1.removeDuplicates(list);
        list.printList();
        System.out.println("3rd element = " + list.getNthNode(3).getData());
        prob3.deleteNode(list.getNthNode(3));
        list.printList();
        prob4.partition(list, 5);
        list.printList();

        LinkedList list2 = new LinkedList();
        LinkedList list3 = new LinkedList();
        /*list2.insertHead(6);
        list2.insertHead(1);
        list2.insertHead(7);
        list2.insertHead(7);

        list3.insertHead(3);
        list3.insertHead(9);
        list3.insertHead(5); */

        Ch2Prob5 prob5 = new Ch2Prob5();
/*        Node result = prob5.sumLists(list2.head, list3.head);
        LinkedList list4 = new LinkedList(result);
        list4.printList();*/

        list2.insertTail(6);
        list2.insertTail(1);
        list2.insertTail(7);
        list2.insertTail(7);

        list3.insertTail(2);
        list3.insertTail(9);
        list3.insertTail(5);

        list2.printList();
        list3.printList();

        Node result = prob5.sumListsForward(list2.head, list3.head);
        LinkedList list4 = new LinkedList(result);
        list4.printList();

    }

    public static void printMatrix(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                System.out.print(mat[i][j] + " ");
            System.out.print("\n");
        }
    }
}
