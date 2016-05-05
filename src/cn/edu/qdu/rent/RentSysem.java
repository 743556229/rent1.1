package cn.edu.qdu.rent;

import java.util.Scanner;

public class RentSysem {
	Scanner input=new Scanner(System.in);
	
	
	//欢迎系统
	public void welcom(){
		System.out.println("--------您好，欢迎光临--------");
	}
	
	
	
	//租车系统
	public void rentCar(){
		boolean flag=true;
		int j=0;
		double fee;
		double fee1=0;
		String[] information=new String[10];
		String no1;
		do{ 
			
			System.out.print("请问您要租哪种类别的车（1.轿车 2.汽车）:");
			int choice=input.nextInt();
			//如果选的是轿车
			if(choice==1){
				System.out.print("请选择您想要的轿车类型(1.bmw 2.Audi 3.benc):");
				String[] typeCar={"bmw","Audi","benc"};
				int[] feeCar={500,400,600};
				int i=input.nextInt();
				System.out.print("请输入车牌号：");
				no1=input.next();
				Auto c=new Car(no1);
				((Car) c).setType(typeCar[i-1]);
				System.out.print("您需要租几天？");
				int days=input.nextInt();
				fee=c.rent(days);
				fee1=fee1+fee;
				information[j]=".类别为:轿车"+"  车型为："+typeCar[i-1]+"  日租价为："+feeCar[i-1]
						+"  天数为："+days+"  车牌号："+no1;
			}
			//如果选的是客车
			else if(choice==2){
				System.out.print("请选择您想要的轿车类型(1.<=16 2.>16):");
				int[] typeBus={16,22};
				String[] typeBus1={"<=16",">16"};
				int[] feeBus={1000,2000};
				int i=input.nextInt();
				System.out.print("请输入车牌号：");
				no1=input.next();
				Auto b=new Bus(no1);
				((Bus) b).setSeatCount(typeBus[i-1]);
				System.out.print("您需要租几天？");
				int days=input.nextInt();
				fee=b.rent(days);
				fee1=fee1+fee;
				information[j]=".类别为:客车"+"  车型为："+typeBus1[i-1]+"  日租价为："+feeBus[i-1]
						+"  天数为："+days+"  车牌号："+no1;
			}
			//是否继续
			System.out.print("您是否要继续 y/n:");
			String cont=input.next();
			//输出所租车的信息
			if(cont.equals("n")){
				System.out.println("您租的车有:");
				for(int k=0;k<=j;k++){
					System.out.println(k+1+information[k]);
				}
				flag=false;
				System.out.println("总费用为："+fee1+"元");
			}
			j=j+1;
		}
		while(flag);
	}
	
	public static void main(String[] args) {
		RentSysem rent=new RentSysem();
		rent.welcom();
		rent.rentCar();
	}

}
