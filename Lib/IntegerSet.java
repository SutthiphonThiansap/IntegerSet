package Lib;

import java.util.ArrayList;
import java.util.Collections;

/*
 * ADT ที่เก็บ Integer แบบเรียงจากน้อยไปมากและห้ามมี null หรือตัวเลขซ้ำ
 */
public class IntegerSet
{
    ArrayList<Integer> numbers;
    //REP Invariant (RI) :
    //- เลขต้องเรียงจากน้อยไปมาก
    //- ห้ามมี null
    //- ห้ามมีตัวเลขซ้ำ
    //
    //Abstraction Funtion (AF) :
    //- AF(numbers) = เซตของจำนวนเต็มใน numbers

    /*
     * Constructor เริ่มต้น สร้างเซตว่าง
     */
    public IntegerSet()
    {
        numbers = new ArrayList<>();
        numbers.isEmpty();
        checkRep();
        
    }
    private void checkRep()
    {
        if (numbers == null) 
        {
            throw new RuntimeException("Set must not be empty!");
        }
        for(int i=0 ; i < numbers.size() - 1;i++)
        {
            if(numbers.get(i) >= numbers.get(i+1))  //nums.get(i) >= nums.get(i + 1)
            {
                throw new RuntimeException("Not strictly increasing or duplicate found!");
            }
        }
    }

    /**
     * เพิ่มตัวเลขเข้าเซต
     * @param x ตัวเลขที่ต้องการเพิ่มเข้าเซต
     */
    public void add(Integer x)
    {
        if (x == null) throw new NullPointerException("Null not allowed");
        int idx = Collections.binarySearch(numbers, x);
        if(idx >= 0) return;
        numbers.add(x);
        checkRep();
    }

    /**
     * ลบตัวเลขออกจากเซต
     * @param x ตัวเลขที่ต้องการลบ
     */
    public void remove(Integer x)
    {
        if (x == null) return;
        numbers.remove(x);
        checkRep();
    }

    /**
     * ตรวจสอบเลขว่ามีอยู่ในเซตหรือไม่
     * @param x ตัวเลขที่ต้องการตรวจสอบ
     * @return true ถ้ามี x อยู่ในเซต , false ถ้าไม่มี
     */
    public boolean contains(Integer x)
    {
        if (x == null) return false;
        return Collections.binarySearch(numbers, x) >= 0;
    }

    /**
     * คืนค่าขนาดของเซต
     * @return จำนวนสมาชิกของเซต
     */
    public int size()
    {
        return numbers.size();
    }

    public String toString()
    {
        return numbers.toString();
    }

    
}