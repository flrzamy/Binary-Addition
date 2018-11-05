//This Program is designed for binary additions


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello there! Do you need to do a binary addition?   (Y/N)");

        Scanner sc =  new Scanner(System.in);
        String ans = sc.nextLine();

        //Reject invalid input.
        while (!ans.equalsIgnoreCase("N") && !ans.equalsIgnoreCase("Y")) {
            System.out.println("Invalid input. Please try again.");
            System.out.println("Do you need to do a binary addition?   (Y/N)");
            ans = sc.nextLine();

        }

        if (ans.equalsIgnoreCase("N")) {
            System.out.println("Alright. See you next time!");
            System.exit(0);
        }

        //Read the 1st num.
        System.out.println("Please input the first binary number:");
        String num1str = sc.nextLine();
        char [] num1ch = num1str.toCharArray();
        Boolean isBinary = true;

        //Reject invalid input.
        if (num1str.length() == 0) {
            isBinary = false;
        } else {
            for (char ch : num1ch) {
                if (ch != '1' && ch != '0') isBinary = false;
            }
        }
        while (!isBinary) {
            System.out.println("Invalid input. Please try again.");
            System.out.println("Please input the first binary number:");
            num1str = sc.nextLine();
            num1ch = num1str.toCharArray();
            isBinary = true;
            if (num1str.length() == 0) {
                isBinary = false;
            } else {
                for (char ch : num1ch) {
                    if (ch != '1' && ch != '0') isBinary = false;
                }
            }
        }

        //Read the 2nd num.
        System.out.println("Please input the second binary number:");
        String num2str = sc.nextLine();
        char [] num2ch = num2str.toCharArray();

        //Reject invalid input.
        isBinary = true;
        if (num2str.length()==0) {
            isBinary = false;
        } else {
            for (char ch : num2ch) {
                if (ch != '1' && ch != '0') isBinary = false;
            }
        }
        while (!isBinary) {
            System.out.println("Invalid input. Please try again.");
            System.out.println("Please input the second binary number:");
            num2str = sc.nextLine();
            num2ch = num2str.toCharArray();
            isBinary = true;
            if (num2str.length()==0) {
                isBinary = false;
            } else {
                for (char ch : num2ch) {
                    if (ch != '1' && ch != '0') isBinary = false;
                }
            }
        }

        //Performing calculation.
        System.out.println("All inputs are valid.");


        String result = "";
        int len1 = num1str.length();
        int len2 = num2str.length();
        String zeros = "";
        int len = len2;

        if (len1<len2) {
            for (int i=0; i<len2-len1; i++) zeros = zeros+'0';
            num1str = zeros + num1str;

        }
        zeros = "";
        if (len1>len2) {
            len = len1;
            for (int i = 0; i < len1 - len2; i++) zeros = zeros + '0';
            num2str = zeros + num2str;

        }

        //Reverse the numbers.
        StringBuilder num1 = new StringBuilder();
        num1.append(num1str);
        num1.reverse();
        num1str = num1.toString();
        num1ch = num1str.toCharArray();

        StringBuilder num2  = new StringBuilder();
        num2.append(num2str);
        num2.reverse();
        num2str = num2.toString();
        num2ch = num2str.toCharArray();


        int sum;
        int carry = 0;
        for (int i=0; i<len; i++) {
            sum = Character.getNumericValue(num1ch[i]) + Character.getNumericValue(num2ch[i])+carry;
            if (sum > 1) {
                carry = 1;
                sum = sum-2;
            } else {
                carry = 0;
            }
            result = result + (char)(sum+'0');
        }
        if (carry == 1) {
            result = result + '1';
        }

        //Use stringbuilder to reverse the string.
        StringBuilder finalResult = new StringBuilder();
        finalResult.append(result);
        finalResult.reverse();

        System.out.println("The sum is " + finalResult + ".");
        System.out.println("Thank you! See you next time.");

    }
}
