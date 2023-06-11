package com.java.dataalgo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HackerRank {
    final int ASCII_START =65;
    final int ASCII_END =90;

    public int calcDiagonalDifference(List<List<Integer>> arr) {
        int primaryDiagonal=0;
        int secondaryDiagonal=0;
        int arrSize= arr.size();
        for (int i=0; i< arrSize;i++) {
            primaryDiagonal += arr.get(i).get(i);
            secondaryDiagonal+=arr.get(i).get(arrSize-i-1);
        }
        return Math.abs(primaryDiagonal-secondaryDiagonal);
    }

    public long flipBits(long n) {
        return ~(n | 0xFFFFFFFF00000000L);//flips 32 unsigned integer
    }

    public int findLonelyInteger(List<Integer> a) throws NoSuchElementException {
        HashMap<Integer, Integer> frequency=new HashMap<>();
        for (Integer i: a)
            if (frequency.get(i)!= null)
                frequency.put(i,frequency.get(i)+1);
            else
                frequency.put(i,1);

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet())
            if (entry.getValue()==1)
                return entry.getKey();
        throw new NoSuchElementException();
    }

    public String calcStringsXOR(String s, String t) {
        String res = new String("");
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(i) )
                res += "0";
            else
                res += "1";
        }

        return res;
    }

    public int countSubListMMatchTotalD(List<Integer> s, int d, int m) {
        int counter=0;
        List<Integer> subList;
        for (int i=0; i<s.size();i++) {
            if (i+m<=s.size()) {
                subList = s.subList(i, i+m);
                if (subList.stream().mapToInt(Integer::intValue).sum() == d)
                    counter++;
            }
        }
        return counter;
    }

    public HashMap<String,String> countPositiveAndNegativeElements(List<Integer> arr) {
        int pos = 0;
        int neg = 0;
        int zero = 0;
        for (Integer i : arr)
            if (i > 0)
                pos++;
            else if (i == 0)
                zero++;
            else
                neg++;
        HashMap<String,String> results=new HashMap<String, String>();
        results.put("pos", String.format("%.6f", (double) pos / arr.size()));
        results.put("neg", String.format("%.6f", (double) neg / arr.size()));
        results.put("zero", String.format("%.6f", (double) zero / arr.size()));
        return results;
    }

    public List<Integer> countSort(List<Integer> arr) {
        List<Integer> frequency  = IntStream.range(0,100).mapToObj(i -> 0).collect(Collectors.toList());
        arr.stream().forEach(i -> frequency.set(i, frequency.get(i)+1));
        return frequency;
    }

    public List<Integer> getStringFrequency(List<String> strings, List<String> queries) {
        int freq;
        List<Integer>  freqArr=new ArrayList<>();
        for (String q: queries) {
            freq=0;
            for (String s: strings)
                if(s.equals(q))
                    freq++;
            freqArr.add(freq);
        }
        return freqArr;
    }

    //A pangram is a string that contains every letter of the alphabet.
    public String isPangrams(String s) {
        for (int i = ASCII_START; i<= ASCII_END; i++) {
            String c = String.valueOf((char) i);
            if (!s.toUpperCase().contains(c))
                return "not pangram";
        }
      return "pangram";
    }


    public boolean checkPermutation(int k, List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b,Collections.reverseOrder());
        for (int i=0; i<a.size();i++)
            if (a.get(i)+b.get(i)<k)
                return false;
        return true;

    }


    public long findMinXSumInList(List<Integer> arr, int elementsCount) {
        long min=0;
        arr.sort(Comparator.naturalOrder());
        for (int i=0; i<elementsCount;i++)
            if (i<arr.size())
                min+=arr.get(i);
        return min;
    }

    public long findMaxXSumInList(List<Integer> arr, int elementsCount) {
        long max=0;
        arr.sort(Comparator.naturalOrder());
        for (int i=arr.size()-1; i>=arr.size()-elementsCount;i--)
            if (i>=0)
                max+=arr.get(i);
        return max;
    }

}
