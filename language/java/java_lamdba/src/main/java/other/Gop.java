package other;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Gop {
 public static void main(String[] args) {
	 
	 {
//		 日历对象
		 Calendar currentTime = Calendar.getInstance();
		 
		 currentTime.add(Calendar.MONTH, -1);
		 currentTime.add(Calendar.DAY_OF_MONTH, 1);
		 		 
		 SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
		 String strDate = simpleDateFormat.format(currentTime.getTime());
		 
		 System.out.println(strDate);
	 }

	 {
//		 转成String 类型
//		 System.out.println(String.valueOf(1));
	 }	 

	 {	
//		 Gop gop = new Gop();
//		 System.out.println(gop.returnFlag());
		 
//			 ParsePosition parsePosition=new ParsePosition(0);
//			 System.out.println(parsePosition.toString());
			 
	 }
	 
	 {
		 	//判断两个类是否相等的属性是否相等
//		    public boolean equals(Object obj)
//		    {
//		        if (obj == null) return false;
//		        if (!(obj instanceof ParsePosition))
//		            return false;
//		        ParsePosition other = (ParsePosition) obj;
//		        return (index == other.index && errorIndex == other.errorIndex);
	 }
	 
	 {
			 //当index等于1是 返回65535
			 //当index等于2时返回65534
			 //当index等于-1时返回-1
	//		    public int hashCode() {
	//		        return (errorIndex << 16) | index;
	//		    }
	 }
	 
	 {
		 //获取当前类的名字
//		 getClass().getName()
	 }
 }
public int  returnFlag() {
     int timeFlag = 0;
     Calendar currentTime = Calendar.getInstance();
    
     int hour = currentTime.get(Calendar.HOUR_OF_DAY);
	   if (hour < 12) {
          timeFlag = 1;
          return timeFlag;
          
      } else if (hour < 18) {
          timeFlag = 2;

      } else if (hour < 24) {
          timeFlag = 3;
      }
	   return timeFlag;
}
}

