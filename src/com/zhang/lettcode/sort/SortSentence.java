package com.zhang.lettcode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortSentence {

    public static String sortSentence(String sentence) {
        //�ָ��ַ���
        String[] words = sentence.split(" ");
        //����ʽ��̣�������
        Arrays.sort(words, ((o1, o2) -> {
            return o1.charAt(o1.length() - 1) - o2.charAt(o2.length() - 1);
        }));
        //����builder���󣬣������洢�ַ���
        StringBuilder builder = new StringBuilder();
        int count = 0;
        //ƾ���ַ���ͬʱ�����ַ���ĩβ������
        for (String word : words) {
            if (count > 0) {
                builder.append(" ");
            }
            builder.append(word, 0, word.length() - 1);
            count++;
        }
        return builder.toString();

    }

    public static String sortByMap(String sentence) {

        Map<Integer, String> wordMap = new HashMap<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            wordMap.put(Integer.parseInt(String.valueOf(word.charAt(word.length() - 1))), word.substring(0, word.length() - 1));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            builder.append(wordMap.get(i + 1));
            builder.append(" ");
        }
        return builder.toString().trim();

    }

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
        System.out.println(sortByMap("is2 sentence4 This1 a3"));
    }

}
