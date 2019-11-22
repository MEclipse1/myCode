package other;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.filechooser.FileSystemView;
/**
 * 
 */

/**
 * 
 * @author 包文东
 *@version 0.1
 */
public class CreateDBData {
	/**
	 * table name
	 */
	static	String  tableName = "ShipmentFile";  
	
	/**
	 * table column
	 */
	static	String[] column = { 
							"ShipmentDate",
							"IssueWarehouseCode",  
							"ReceiptWarehouseCode",  //bian liang 
							"IssueQTY",
							"ShipmentNo",
							"ADM_No",
							"ItemNo",
							"UnitPrice",
							"CurrencyUnit",
							"IssueType",
							"ItemType"
	}; 
	
	/**
	 * table data
	 */
	static	String[][]  data = {
						     { 		
						    	"'2018-12-24 14:24:09'",
						    	"'1000'",
						    	"'5000'",
						    	"1000",
						    	"'20181224D'",
						    	"'C00000AA'",
						    	"'7000000A'",
						    	"1000",
						    	"1",
						    	"2",
						    	"2"
						     }
	};
	
	/**
	 * print table data count
	 */
	static int  printCount =11;
	
	/**
	 * table selfIncrement column;
	 */
	static 	String[]  selfIncrement = {
			"ADM_No",
			};

	
	/**
	 * 主函數
	 * @param args
	 */
	public static void main(String[] args) {
		
	 CreateDBData cData = new CreateDBData();
	 	 
	 cData.printSqlStatment();
	}
		
	/**
	 * 打印sql语句段
	 */
	public  void printSqlStatment() {
		String[][] data=addData();
		System.out.println("列长度为："+column.length);
		System.out.println("数据长度为："+data[0].length);
		System.out.print("insert into ");     
		
		System.out.println(tableName);
		
		System.out.print(" (");
		
		for (int i = 0; i < column.length; i++) {  //添加列
			if (i < column.length - 1) {
				System.out.print(column[i] + ",");
			} else {
				System.out.print(column[i]);
			}
		}
		System.out.print(")");
		System.out.println(" values ");
		
		for (int j = 0; j < data.length; j++) {
			System.out.print(" (");
			for (int i = 0; i < data[j].length; i++) {   //添加数据
				if (i < data[j].length - 1) {
					System.out.print(data[j][i] + ",");
				} else {
					System.out.print(data[j][i]);
				}
			}
			if (j<data.length-1) {
				System.out.println("),");	
			} else {
				System.out.println(");");	
			}
		}
	}

	/**
	 * 添加数据
	 * @return
	 */
	private String[][] addData() {
		int[] getselfIncrementIndex=getselfIncrementIndex(); //下标的位置
		 String[]  catchSelfIncrement= initCatchSelfIncrement(); //下标位置的初始值
		String[][] data=CreateDBData.data;                                    //存储数据数组
		String[][] copyData = new String[printCount][data[0].length]; //输出的数组
		
		for (int i = 0; i < copyData.length; i++) {
				for (int j2 = 0; j2 < data[0].length; j2++) {
					copyData[i][j2] = data[0][j2];
					for (int j = 0; j < getselfIncrementIndex.length; j++) {
						if (j2==getselfIncrementIndex[j]) {
							char[] charArray =catchSelfIncrement[j].toCharArray();
								if (charArray[charArray.length-1]==39) { 
									int flag=2;
									if(judgeCharArea(charArray[charArray.length-flag])>=0) {
										charArray[charArray.length-flag]=(char) (charArray[charArray.length-flag]+1);
									}else {
										if (judgeCharArea(charArray[charArray.length-flag])==0) {
											charArray[charArray.length-flag]=48;
										}else if (judgeCharArea(charArray[charArray.length-flag])==1){
											charArray[charArray.length-flag]=65;
										} 
										else {
											charArray[charArray.length-flag]=97;
										}
										flag++;
										charArray[charArray.length-flag]=(char) (charArray[charArray.length-flag]+1);	
									}
								}else {
									int flag=1;
									if(judgeCharArea(charArray[charArray.length-1])>=0) {
										charArray[charArray.length-1]=(char) (charArray[charArray.length-1]+1);
									}else {
										switch (judgeCharArea(charArray[charArray.length-flag])) {
										case 0:	charArray[charArray.length-flag]=48 ; break;
										case 1:	charArray[charArray.length-flag]=65 ; break;
										case 2:	charArray[charArray.length-flag]=97 ; break;
										}
										flag++;
										charArray[charArray.length-flag]=(char) (charArray[charArray.length-flag]+1);
									}	
								}
							copyData[i][j2] = new String(charArray) ;
							catchSelfIncrement[j]=copyData[i][j2];
						}
					}
				}
		}
		return copyData;
	}
	
	/**
	 * 获取自增变量的位置
	 * @return
	 */
	private  int[] getselfIncrementIndex() {
		int[] cacheselfIncrementIndex= {};
		
		if(selfIncrement.length!=0) {
		cacheselfIncrementIndex=new int[selfIncrement.length]; //定义一个长度为selfIncrement.length的变量存储自增变量的下标
		for(int z = 0 ;z < selfIncrement.length ; z++ ) {
			for (int j = 0; j < column.length; j++) {
				if(column[j].equals(selfIncrement[z])) {
					cacheselfIncrementIndex[z]=j;
					}
				}
		}
		
		
		}
		return cacheselfIncrementIndex;
	}
	
    /**
         * 自增变量赋初始值
    */
	private   String[] initCatchSelfIncrement() {
		if(!isNull(getselfIncrementIndex())) {
			String catchSelfIncrement[] =new String[selfIncrement.length];
			int [] getselfIncrementIndex=getselfIncrementIndex();
			for (int j = 0; j < selfIncrement.length; j++) {
				for (int i = 0; i < data[0].length; i++) {
					if (i==getselfIncrementIndex[j]) {
						catchSelfIncrement[j] = data[0][i];
						System.out.println("自增列的初始值為："+catchSelfIncrement[j]+"索引位置为："+i);
					}
				}
			}
			return catchSelfIncrement;
		}else {
			System.out.println("沒有自增的列");
			return null;
		}
	
}

	/**
	 *  输出文件到桌面
	 */
	private  void outPutFile(String string) {
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com=fsv.getHomeDirectory();    //get desktop Path
		String paht= com.getPath()+"/";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//time format
	    final String textType=".txt";
		String fileNam =paht+tableName+df.format(new Date())+textType;
		File file= new File(fileNam);

		try {
		OutputStream out = new FileOutputStream(file,true);
			 byte[] b=	string.getBytes();
			 for (int i = 0; i < b.length; i++) {
		           out.write(b[i]);
		       }
		       out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 判断字符是否属于A-Z a-z 0-9 
	 */
	private int judgeCharArea(char c) {
		int flag=0;
		if (c>=48 && c<48+9) {
			return flag;
		}
		if (c>=65 && c<65+24) {
			return flag+1;
		}
		if (c>=97 && c<97+24) {
			return flag+2;
		}
		return -1;
	}
	
	/**
	 * 判断对象是否为空
	 */
	public boolean isNull(Object obj) {
		return obj==null;
	}
}
	