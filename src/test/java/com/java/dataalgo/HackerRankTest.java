package com.java.dataalgo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class HackerRankTest {
    HackerRank hr;
    List<Integer> arr;

    @BeforeEach
    public void setUp(){
        hr=new HackerRank();
        arr=new ArrayList<>();
    }

    @Test
    void countPositiveAndNegativeElements() {
        arr.add(-4); arr.add(3); arr.add(-9);
        arr.add(0); arr.add(4); arr.add(1);
        HashMap<String, String> results=hr.countPositiveAndNegativeElements(arr);
        assertEquals(results.get("pos"),"0.500000");
        assertEquals(results.get("neg"),"0.333333");
        assertEquals(results.get("zero"),"0.166667");
    }

    @Test
    void findMinXSumInListLongNumbers_WillReturnMinXSum() {
        List<Integer> arr=new ArrayList<>();
        arr.add(256741038); arr.add(623958417); arr.add(467905213); arr.add(714532089); arr.add(938071625);
        assertEquals(hr.findMinXSumInList(arr,4),2063136757);
    }

    @Test
    void findMaxXSumInListLongNumbers_WillReturnMaxXSum() {
        arr.add(256741038); arr.add(623958417); arr.add(467905213); arr.add(714532089); arr.add(938071625);
        assertEquals(hr.findMaxXSumInList(arr,2),1652603714);
    }

    @Test
    void findLonelyInteger_WillRetrunVal() {
        arr.add(1); arr.add(2); arr.add(3); arr.add(2); arr.add(1); arr.add(1);
        assertEquals(hr.findLonelyInteger(arr),3);
    }

    @org.junit.jupiter.api.Test
    void findLonelyInteger_WillThrowException() {
        arr.add(1); arr.add(2); arr.add(3); arr.add(2); arr.add(1); arr.add(1); arr.add(3);
        assertThrows(NoSuchElementException.class,
                     ()->hr.findLonelyInteger(arr));
    }

    @Test
    void calcDiagonalDifference() {
//        11 2 4
//        4 5 6
//        10 8 -12
        List<List<Integer>> arr2Dim=new ArrayList<>();
        List<Integer> tempArr=new ArrayList<>();
        tempArr.add(11); tempArr.add(2); tempArr.add(4);
        arr2Dim.add(tempArr);
        tempArr=new ArrayList<>();
        tempArr.add(4); tempArr.add(5); tempArr.add(6);
        arr2Dim.add(tempArr);
        tempArr=new ArrayList<>();
        tempArr.add(10); tempArr.add(8); tempArr.add(-12);
        arr2Dim.add(tempArr);

        assertEquals(hr.calcDiagonalDifference(arr2Dim),15);
    }


    @Test
    void flipBits_longDataType() {
       assertEquals(String.valueOf(hr.flipBits(2147483647)), "2147483648");
       assertEquals(String.valueOf(hr.flipBits(1)), "4294967294");
       assertEquals(String.valueOf(hr.flipBits(0)), "4294967295");
    }

    @Test
    void calcStringsXOR() {
        String s="0110000111010011110001";
        String t="0001111000010100010101";
        assertEquals(hr.calcStringsXOR(s,t),"0111111111000111100100");
    }

    @Test
    void getStringFrequency() {
        List<String> s=new ArrayList<>();
        List<String> q=new ArrayList<>();
        s.add("aba"); s.add("aba"); s.add("baba"); s.add("xzxb");
        q.add("aba"); q.add("xzxb"); q.add("ab");
        assertEquals(hr.getStringFrequency(s,q).get(0), 2);
        assertEquals(hr.getStringFrequency(s,q).get(1), 1);
        assertEquals(hr.getStringFrequency(s,q).get(2), 0);
    }

    @Test
    void countSubListMMatchTotalD_OneElementList() {
        int d=4;
        int m=1;
        List<Integer> s=new ArrayList<>();
        s.add(4);
        assertEquals(hr.countSubListMMatchTotalD(s,d,m),1);
    }

    @Test
    void countSubListMMatchTotalD_LongList() {
        int d=4;
        int m=2;
        List<Integer> s=new ArrayList<>();
        s.add(2); s.add(2); s.add(1); s.add(3); s.add(2);
        assertEquals(hr.countSubListMMatchTotalD(s,d,m),2);
    }
    @Test
    void isPangrams_true() {
        assertEquals(hr.isPangrams("We promptly judged antique ivory buckles for the next prize"), "pangram");
    }

    @Test
    void isPangrams_false() {
        assertEquals(hr.isPangrams("We promptly judged antique ivory buckles for the prize"), "not pangram");
    }

    @Test
    void countSort_ActualAsExpected() {
        List<Integer> res=hr.countSort(Arrays.asList(63,25,73,1,98,73,56,84,86,57,16,83,8,25,81,56,9,53,98,67,99,12,83,89,80,91,39,86,76,85,74,39,25,90,59,10,94,32,44,3,89,30,27,79,46,96,27,32,18,21,92,69,81,40,40,34,68,78,24,87,42,69,23,41,78,22,6,90,99,89,50,30,20,1,43,3,70,95,33,46,44,9,69,48,33,60,65,16,82,67,61,32,21,79,75,75,13,87,70,33));
        List<Integer> expectedResult=new ArrayList<>(Arrays.asList(0,2,0,2,0,0,1,0,1,2,1,0,1,1,0,0,2,0,1,0,1,2,1,1,1,3,0,2,0,0,2,0,3,3,1,0,0,0,0,2,2,1,1,1,2,0,2,0,1,0,1,0,0,1,0,0,2,1,0,1,1,1,0,1,0,1,0,2,1,3,2,0,0,2,1,2,1,0,2,2,1,2,1,2,1,1,2,2,0,3,2,1,1,0,1,1,1,0,2,2));
        assertEquals(res.equals(expectedResult),true);
    }

    @Test
    void countSort_ActualNotAsExpected() {
        List<Integer> res=hr.countSort(Arrays.asList(63,25,73,1,98,73,56,84,86,57,16,83,8,25,81,56,9,53,98,67,99,12,83,89,80,91,39,86,76,85,74,39,25,90,59,10,94,32,44,3,89,30,27,79,46,96,27,32,18,21,92,69,81,40,40,34,68,78,24,87,42,69,23,41,78,22,6,90,99,89,50,30,20,1,43,3,70,95,33,46,44,9,69,48,33,60,65,16,82,67,61,32,21,79,75,75,13,87,70,33));
        List<Integer> expectedResult=new ArrayList<>(Arrays.asList(0,2,0,12,0,0,1,0,1,2,1,0,1,1,0,0,2,0,1,0,1,2,1,1,1,3,0,2,0,0,2,0,3,3,1,0,0,0,0,2,2,1,1,1,2,0,2,0,1,0,1,0,0,1,0,0,2,1,0,1,1,1,0,1,0,1,0,2,1,3,2,0,0,2,1,2,1,0,2,2,1,2,1,2,1,1,2,2,0,3,2,1,1,0,1,1,1,0,2,2));
        assertEquals(res.equals(expectedResult),false);
    }

    @Test
    void checkPermutation_Permutalbe() {
        List<Integer> a=new ArrayList<>(Arrays.asList(3,1,5,4,1,5,4,4,2,3,4,4,5,4,4,2,4,5,4,2,4,1,1,1,2,3,4,3,4,2,2,2,5,1,1,1,2,1,3,5,3,4,4,4,5,1,5,4,5,5,2,2,3,5,4,3,3,2,4,2,5,4,4,5,3,4,2,3,3,3,5,2,5,4,4,1,5,1,1,1,4,2,5,5,2,1,3,3,1,1,5,5,5));
        List<Integer> b=new ArrayList<>(Arrays.asList(9,5,7,5,7,0,6,9,4,1,11,14,7,2,2,13,14,10,10,1,5,9,12,2,4,5,11,2,8,10,7,7,11,11,7,5,4,7,8,11,13,6,8,2,3,6,11,5,10,5,9,8,6,13,8,12,5,7,14,7,4,5,0,9,3,6,8,6,10,11,10,3,2,10,10,8,6,11,10,6,6,14,3,10,3,10,2,0,4,8,14,11,1));
        assertEquals(hr.checkPermutation(5, a, b), true);
    }

    @Test
    void checkPermutation_NotPermutalbe() {
        List<Integer> a=new ArrayList<>(Arrays.asList(15,58,59,6,58,69,18,43,15,17,63,13,21,33,1,1,68,68,24,18,33,33,27,42,59,24,2,47,67,41,53,3,43,31,34,66,33,48,56,1,53,31,30,47,64,23,43,28,32,3,19,4,11,64,9,24,60,68,1,19,49,63,37,12,43,48,42,63,63,23,47,33,28,37,15,19,2,40,64,8,29,65,8,11,32,51,19,59,7,5,8,64,24,64,19,47,3,9,53,42,8,53,42,4,62,22,54,22,19,47,57,1,64,68,1,3,37,13,54,57,42,26,21,39,65,27,61,53,20,1,39,1,29,22,43,11,66,18,1,14,69,58,32,24,10,31));
        List<Integer> b=new ArrayList<>(Arrays.asList(1,14,4,48,58,3,46,63,49,3,34,28,62,68,64,66,57,37,33,31,64,12,67,43,52,1,27,12,53,41,59,39,43,1,6,62,65,2,43,38,5,26,3,5,48,33,32,11,46,65,30,38,41,52,47,47,57,18,21,6,24,53,12,2,67,15,60,62,23,42,20,13,34,17,1,27,48,9,53,12,37,27,53,66,63,21,19,15,29,40,46,3,38,1,26,26,51,1,44,45,57,70,60,37,19,32,1,60,2,39,5,18,19,51,7,13,66,13,61,23,1,28,2,50,23,31,28,30,55,52,1,46,35,56,61,42,58,44,5,9,1,5,11,7,15,38));
        assertEquals(hr.checkPermutation(71, a, b), false);
    }

    @Test
    void convertTime12To24() {
        String h12="07:05:45PM";
        try {
            assertEquals(hr.convertTime12To24(h12), "19:05:45");
        }
        catch (Exception e){
            Assertions.fail("Exception occured: "+ e.getMessage());
        }
    }

    @Test
    void countSockPairs() {
        List<Integer> sockPerColorArr=new ArrayList<>(Arrays.asList(50,49,38,49,78,36,25,96,10,67,78,58,98,8,53,1,4,7,29,6,59,93,74,3,67,47,12,85,84,40,81,85,89,70,33,66,6,9,13,67,75,42,24,73,49,28,25,5,86,53,10,44,45,35,47,11,81,10,47,16,49,79,52,89,100,36,6,57,96,18,23,71,11,99,95,12,78,19,16,64,23,77,7,19,11,5,81,43,14,27,11,63,57,62,3,56,50,9,13,45));
        assertEquals(hr.countSockPairs(sockPerColorArr),28);
    }

    @Test
    void countSockPairs_emptyArr() {
        List<Integer> sockPerColorArr=new ArrayList<>();
        assertEquals(hr.countSockPairs(sockPerColorArr),0);
    }

    @Test
    void findMedian_oddArray() {
       List <Integer> arr=new ArrayList<>(Arrays.asList(7,1,2,5,4,3,6));
       assertEquals(hr.findMedian(arr),4);
    }

    @Test
    void findMedian_evenArray() {
        List <Integer> arr=new ArrayList<>(Arrays.asList(12,1,2,8,4,3));
        assertEquals(hr.findMedian(arr),3.5);
    }

    @Test
    void FlippingMatrix(){
        List<List<Integer>> arr=new ArrayList<>(Arrays.asList(
                Arrays.asList(112,42,114,119),
                Arrays.asList(56,125,101,49),
                Arrays.asList(15,78,56,43),
                Arrays.asList(62,98,83,108)
        ));
        assertEquals(hr.flippingMatrix(arr), 414);
    }

}