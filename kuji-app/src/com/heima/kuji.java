package com.heima;

import java.util.Random;
import java.util.Scanner;

public class kuji {
    public static void main(String[] args) {
        int[] luckNumbers = createLuckNumbers();
        printArray(luckNumbers);
        int[] userNumbers = userInputNumbers();

        judge(luckNumbers,userNumbers);


    }
    public static int[] createLuckNumbers(){
        int[] numbers = new int[7];
        Random r = new Random();
        for (int i = 0; i < numbers.length-1; i++) {
            while (true){
                int data = r.nextInt(33)+1;
                boolean flag = true;
                for (int j = 0; j < i; j++) {
                    if(numbers[j] == data){
                        flag = false;
                        break;
                    }
                }
                if(flag == true){
                    numbers[i] = data;
                    break;
                }
            }
        }
        int data = r.nextInt(15)+1;
        numbers[numbers.length-1] = data;

        return numbers;
    }

    public static int[] userInputNumbers(){
        int[] number = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < number.length-1; i++) {
            System.out.println("第" + (i + 1) + "を入力してくたさい：");
            int data = sc.nextInt();
            number[i] = data;
        }
        System.out.println("ブルーを入力してくたさい：");
        number[number.length-1] = sc.nextInt();
        return number;
    }

    public static void judge(int[] luckNumbers, int[] userNumbers){
        int redHitNumbers = 0;
        int blueHitNumbers = 0;

        for (int i = 0 ;i < userNumbers.length-1; i++) {
            for (int j = 0; j < luckNumbers.length-1; j++) {
                if(luckNumbers[j] == userNumbers[i]){
                    redHitNumbers++;
                }
            }
        }
        blueHitNumbers = userNumbers[6] == luckNumbers[6]? 1:0;

        if(blueHitNumbers ==1 && redHitNumbers<3){
            System.out.println("おめでとうございます！１００円当たり！");
        } else if (blueHitNumbers == 1 && redHitNumbers==3||blueHitNumbers==0 && redHitNumbers==4) {
            System.out.println("おめでとうございます！1000円当たり！");
        } else if (blueHitNumbers == 1 && redHitNumbers == 4 || blueHitNumbers == 0 && redHitNumbers == 5) {
            System.out.println("おめでとうございます！10000円当たり！");
        } else if (blueHitNumbers == 1 && redHitNumbers == 5) {
            System.out.println("おめでとうございます！100000円当たり！");
        } else if (blueHitNumbers == 0 && redHitNumbers == 6) {
            System.out.println("おめでとうございます！1千万円当たり！");
        } else if (blueHitNumbers == 1 && redHitNumbers == 6) {
            System.out.println("おめでとうございます！5億円当たり！");
        } else {
            System.out.println("残念です");
        }
    }

    public static void printArray(int[] luckNumbers){
        for (int i = 0; i < luckNumbers.length; i++) {
            System.out.print(luckNumbers[i]+"\t");
        }
        System.out.println();
    }
}