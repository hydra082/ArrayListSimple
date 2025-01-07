package lesson_1;

public class Main {
    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        String s2 = "Hello world";
        String s3 = "    fly me    to the moon    ";
        String s1 = "I love Java";

        String p1 = "abc";
        String p2 = "112233";
        String p3 = "aba";
        String p4 = "112211";

        System.out.println("Method turnString");
        Homework.turnString(s1);
        System.out.println();

        System.out.println("Method getDistinctNumbers");
        Homework.getDistinctNumbers(ints);
        System.out.println();

        System.out.println("Method findSecondMaxElement");
        System.out.println(Homework.findSecondMaxElement(arr));
        System.out.println();

        System.out.println("Method lengthOfLastWord");
        System.out.println(Homework.lengthOfLastWord(s2));
        System.out.println(Homework.lengthOfLastWord(s3));
        System.out.println();

        System.out.println("Method isPalindrome");
        System.out.println(Homework.isPalindrome(p1));
        System.out.println(Homework.isPalindrome(p2));
        System.out.println(Homework.isPalindrome(p3));
        System.out.println(Homework.isPalindrome(p4));
        System.out.println();

        System.out.println("finally");
    }
}
