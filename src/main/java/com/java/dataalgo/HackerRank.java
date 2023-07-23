package com.java.dataalgo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HackerRank {
    final int ASCII_CAPITAL_LETTERS_START =65;
    final int ASCII_CAPITAL_LETTERS_END =90;


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
        HashMap<String,String> results=new HashMap<>();
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
    public boolean isPangrams(String s) {
        for (int i = ASCII_CAPITAL_LETTERS_START; i<= ASCII_CAPITAL_LETTERS_END; i++) {
            String c = String.valueOf((char) i);
            if (!s.toUpperCase().contains(c))
                return false;
        }
      return true;
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


    public String convertTime12To24(String s) throws ParseException {
        SimpleDateFormat h24=new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat h12=new SimpleDateFormat("hh:mm:ssa");
        try {
            Date date=h12.parse(s);
            return h24.format(date).toString();
        } catch (ParseException e) {
            throw e;
        }
    }

    public int countSockPairs(List<Integer> sockPerColorList) {
        HashMap<Integer,Integer> colorsMap=new HashMap<>();
        for (int color : sockPerColorList){
            int currentVal= colorsMap.getOrDefault(color,0);
            colorsMap.put(color,currentVal+1);
        }
        int pairsCount=0;
        for (Integer color : colorsMap.keySet())
            pairsCount+=colorsMap.get(color)/2;
        return pairsCount;
    }

    public double findMedian(List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        int ind = (arr.size() + 1) / 2 - 1;
        if (arr.size()%2!=0)
            return (arr.get(ind));
        else
            return ((arr.get(ind)+arr.get(ind+1))/2.0);
    }

    public int flippingMatrix(List<List<Integer>> arr) {
        int sum=0;
        int n=arr.size()/2;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int num1 = arr.get(i).get((2*n) - j - 1);
                int num2 = arr.get(i).get(j);
                int num3 = arr.get((2*n) - i - 1).get(j);
                int num4 = arr.get((2*n) - i - 1).get((2*n) - j - 1);
                sum += Math.max(num1, Math.max(num2, Math.max(num3, num4)));
            }
        }
        return sum;
    }

    public int getPageFlipsCount(int n, int p) {
        int f2b=p/2;
        int b2f=(n-p)/2;
        if (n%2==0 && p%2!=0)
            b2f++;
        return Math.min(f2b,b2f);
    }


    public String encryptUsingCaesarCipher(String s, int k) {
        String lettersL="abcdefghijklmnopqrstuvwxyz";
        String lettersU="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cipheredString="";
        for (int i=0; i<s.length();i++) {
            if (lettersL.indexOf(s.charAt(i))!=-1)
                cipheredString+= lettersL.charAt((lettersL.indexOf(s.charAt(i))+k)%26);
            else if (lettersU.indexOf(s.charAt(i))!=-1)
                cipheredString+= lettersU.charAt((lettersU.indexOf(s.charAt(i))+k)%26);
            else
            cipheredString+=s.charAt(i);

        }
        return cipheredString;
    }

    //Using Lists (not optimal)
    public int calculateSlidingArrUnfairnessUsingLists(int k, List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        List<Integer> unfairness=new ArrayList<>();
        for (int i=0; i+k-1<arr.size();i++)
            unfairness.add(arr.get(i+k-1)-arr.get(i));
        return unfairness.stream().min(Integer::compareTo).get();
    }

    //memory usage and time complexity optimised
    public int calculateSlidingArrUnfairness(int k, List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        int unfairness=arr.get(k-1)-arr.get(0);
        for (int i=1; i+k-1<arr.size();i++)
            if (arr.get(i+k-1)-arr.get(i)<unfairness)
                unfairness=arr.get(i+k-1)-arr.get(i);
        return unfairness;
    }

}
