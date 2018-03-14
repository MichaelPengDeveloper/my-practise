package com.test;

import com.google.common.collect.Maps;

import java.util.Calendar;
import java.util.Map;

/**
 * Created by Wangpeng on 2018/1/10.
 */
public class DateUtils {
    public  static  void  main(String[]  args)  {
        Map<String, Object> map = Maps.newHashMap();
        map.put("1", "23232");
        System.out.println(map);
        map.put("1","00000");
        System.out.println(map);
    }
    static  int[]  getDateLength(String  fromDate, String  toDate)  {
        Calendar c1  =  getCal(fromDate);
        Calendar  c2  =  getCal(toDate);
        int[]  p1  =  {  c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DAY_OF_MONTH)  };
        int[]  p2  =  {  c2.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH)  };
        return  new  int[]  {  p2[0]  -  p1[0], p2[0]  *  12  +  p2[1]  -  p1[0]  *  12  -  p1[1], (int)  ((c2.getTimeInMillis()  -  c1.getTimeInMillis())  /  (24  *  3600  *  1000))  };
    }
    static  Calendar  getCal(String  date)  {
        Calendar  cal  =  Calendar.getInstance();
        cal.clear();
        cal.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6))  -  1, Integer.parseInt(date.substring(6, 8)));
        return  cal;
    }
}
