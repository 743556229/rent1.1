package cn.edu.qdu.rent;

import java.util.Scanner;

public class RentSysem {
	Scanner input=new Scanner(System.in);
	
	
	//��ӭϵͳ
	public void welcom(){
		System.out.println("--------���ã���ӭ����--------");
	}
	
	
	
	//�⳵ϵͳ
	public void rentCar(){
		boolean flag=true;
		int j=0;
		double fee;
		double fee1=0;
		String[] information=new String[10];
		String no1;
		do{ 
			
			System.out.print("������Ҫ���������ĳ���1.�γ� 2.������:");
			int choice=input.nextInt();
			//���ѡ���ǽγ�
			if(choice==1){
				System.out.print("��ѡ������Ҫ�Ľγ�����(1.bmw 2.Audi 3.benc):");
				String[] typeCar={"bmw","Audi","benc"};
				int[] feeCar={500,400,600};
				int i=input.nextInt();
				System.out.print("�����복�ƺţ�");
				no1=input.next();
				Auto c=new Car(no1);
				((Car) c).setType(typeCar[i-1]);
				System.out.print("����Ҫ�⼸�죿");
				int days=input.nextInt();
				fee=c.rent(days);
				fee1=fee1+fee;
				information[j]=".���Ϊ:�γ�"+"  ����Ϊ��"+typeCar[i-1]+"  �����Ϊ��"+feeCar[i-1]
						+"  ����Ϊ��"+days+"  ���ƺţ�"+no1;
			}
			//���ѡ���ǿͳ�
			else if(choice==2){
				System.out.print("��ѡ������Ҫ�Ľγ�����(1.<=16 2.>16):");
				int[] typeBus={16,22};
				String[] typeBus1={"<=16",">16"};
				int[] feeBus={1000,2000};
				int i=input.nextInt();
				System.out.print("�����복�ƺţ�");
				no1=input.next();
				Auto b=new Bus(no1);
				((Bus) b).setSeatCount(typeBus[i-1]);
				System.out.print("����Ҫ�⼸�죿");
				int days=input.nextInt();
				fee=b.rent(days);
				fee1=fee1+fee;
				information[j]=".���Ϊ:�ͳ�"+"  ����Ϊ��"+typeBus1[i-1]+"  �����Ϊ��"+feeBus[i-1]
						+"  ����Ϊ��"+days+"  ���ƺţ�"+no1;
			}
			//�Ƿ����
			System.out.print("���Ƿ�Ҫ���� y/n:");
			String cont=input.next();
			//������⳵����Ϣ
			if(cont.equals("n")){
				System.out.println("����ĳ���:");
				for(int k=0;k<=j;k++){
					System.out.println(k+1+information[k]);
				}
				flag=false;
				System.out.println("�ܷ���Ϊ��"+fee1+"Ԫ");
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
