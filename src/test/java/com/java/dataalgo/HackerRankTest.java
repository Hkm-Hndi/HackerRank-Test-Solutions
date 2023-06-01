package com.java.dataalgo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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
}