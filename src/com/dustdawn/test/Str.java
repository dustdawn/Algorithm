package com.dustdawn.test;

import java.util.Calendar;

public class Str {
    public static void main(String args[]) {
        String s1 = new String("It is");
        String s2 = "It is";
        //JVM��ר�Ŷ�����ַ������д����������ַ������Ƿ����"It is"�ַ���
        //��������������ַ��ֵ��s2�������������ַ��������½������ַ���
        String s3 = s1;
        String s4 = s2;
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s4);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s4));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 10);
        String strDate = cal.get(Calendar.YEAR) + "��" + (cal.get(Calendar.MONTH) + 1) + "��" + cal.get(Calendar.DATE) + "��";
        System.out.println(strDate);
    }
}
