package main;//判断晴雨天，男女，温度

import java.util.Scanner;
public class weatherandsexandtemp {
	
	public static void main(String[] args) {
		boolean flag = true;
		//check the weather
		System.out.println("weather(sunday/rain)?  ");
		Scanner s = new Scanner(System.in);
		String weather = s.next();
		String goods = "";
		if (weather.equals("rain")) {
			//check the sex1
			System.out.println("sex(man/woman)?  ");
			String sex = s.next();
			if (sex.equals("man")) {
				goods = "black umbrella";				
			}else if(sex.equals("woman")) {
				goods = "flower umbrella";
			}else{
				System.out.println("Erroe:sex");
				flag = false;
			}
		}
		else if(weather.equals("sunday")) {
			//check the sex2
			System.out.println("sex(man/woman)?  ");
			String sex = s.next();
			System.out.println("Temp?  ");
			int tempe = s.nextInt();
			if (tempe >= 0 & tempe >=30 & tempe <= 50) {
				if (sex.equals("man")) {
					goods = "sun glass";				
				}else if(sex.equals("woman")) {
					goods = "sunscreen";
				}else{
				System.out.println("Error:sex");
				flag = false;
				}
			}
			else if (tempe >=0 & tempe <= 40) {
				goods = "nothing";
			}else{
				System.out.println("Error:temp");
				flag = false;
			}
		}else {
			System.out.println("Error:weather");
			flag = false;
		}
		if (flag == true) {
			System.out.println("you should take "+goods);	
		}
		
		
	}
}






// // Scanner的用法
// // public class TestClass {
// // 	public static void main(String[] args) {
// // 		java.util.Scanner s = new java.util.Scanner(System.in);
// // 		String str = s.next();
// // 		System.out.println(str);
// // 	}
// // }


// import java.util.Scanner;  //importScanner的用法

// 		Scanner s = new Scanner(System.in);     //只需要调用一遍
// 		String weather = s.next();