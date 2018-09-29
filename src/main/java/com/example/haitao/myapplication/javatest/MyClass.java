package com.example.haitao.myapplication.javatest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MyClass {
    public static void  main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.print(f(i) + "  ");
        }
        System.out.print("\n");

        for (int i = 1; i < 15; i++) {
            System.out.print(down(i) + "  ");
        }
        System.out.print("\n");
        System.out.print(convertDate());
    }
    //斐波那契
    public static int f(int n) {
        if (n > 2) {
            return f(n - 1) + f(n -2);
        } else if (n == 1 || n == 2)  {
            return n;
        } else {
            return 0;
        }
    }
    //小球弹起
    public static double down(double n) {
        double height = 100, total = 0;
        for (int i = 1; i < n; i++) {
            height /= 2;
            total += height;
        }
        return total;
    }
    //日历
    public static String convertDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.WEEK_OF_YEAR, 10);
        calendar.set(Calendar.DAY_OF_WEEK, 1); //1:周日 7:周六
        Date date = calendar.getTime();
        return new SimpleDateFormat("MM-dd", Locale.getDefault()).format(date);
    }
}
