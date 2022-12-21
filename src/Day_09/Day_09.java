package Day_09;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day_09 {

	public static void main(String[] args)
	{
		// 로또 번호 생성기 만들기
		// 1등 부터 5등
		// 45/6
		// 6개 1등 5+보너스 2등 5개 3등 4개4등 3개 5등
		
		int Bonus ;
		//일단은 보너스 생성하고 랜덤하게 해야하니까 랜덤 하나 생성하자
		Random RD = new Random();
		//입력도 받아야 하니까 캐너 생성
		Scanner SC = new Scanner(System.in);
		
		//일단 6개의 번호를 입력을 받고 보자.
		int User[]= {0,0,0,0,0,0};
		a : while (true) 
		{
			System.out.println("생성하실 로또번호를 입력해 주세요");
				for (int i =0; i<6 ; i++)
				{
					User[i] = SC.nextInt();
					if (i < 0)
						{
							System.out.println("번호오류 다시 시작합니다. eroor : 1");
							continue;
						}
				}
					// 입력받은 번호가 오름차열이 아닐수가 있으니 정렬
					Arrays.sort(User);
					// 정렬된 번호 출력
					System.out.println("입력하신 번호는 : "+Arrays.toString(User));
					int C ;
					// 확인후 아닐시 다시 입력칸으로
			
					System.out.println("만약에 고치고 싶다면 1번 아니면 0번 을 입력하세");
					C = SC.nextInt();
			
					if( C == 1)
						{
							continue a;
						}
					
					break a ;
			}
		int SFF[] = {0,0,0,0,0,0};
			for (int i = 0; i<6 ; i++)
			{
				SFF[i] = RD.nextInt(45)+1;
				for (int j =0; j < i ; j++)
				{
					if (SFF[i] == SFF[j])
					{
						--i;
					}
				}
			}
			Arrays.sort(SFF);
			//당첨번호 출력 
			System.out.println("이번당첨번호는 " +Arrays.toString(SFF) );
			//보너스 번호 생성및 출력
		b :while(true)
		{
			Bonus = RD.nextInt(45)+1;
			for (int i = 0; i<6 ; i++)
			{
				if (SFF[i] == Bonus)
				{
					continue b;
				}
					
			}
			break;
		}
		System.out.println("보너스 번호는 : +" + Bonus);
		
			//당신의 당첨번호는 몇등이다 표현
			int bc = 0;
			int ec = 0;
			for (int i = 0; i<6 ; i++)
			{
				for (int j =0; j < 6 ; j++)
				{
					if (User[i] == SFF[j])
					{
						ec +=1;
					}
					else if (User[i] == Bonus)
					{
						bc += 1;
					}
					
				}
			}
			
			//당첨번호 추첨
			
			System.out.println("당첨 갯수는 : "+ ec);
			if(ec==6) 
			{
				System.out.println("축하드립니다 1등 당첨됬습니다.");
			}
			else if (ec==5 && bc==1)
			{
				System.out.println("축하드립니다 2등 당첨됬습니다.");
			}
			else if (ec==5)
			{
				System.out.println("축하드립니다 3등 당첨됬습니다.");
			}
			else if (ec==4)
			{
				System.out.println("축하드립니다 4등 당첨됬습니다.");
			}
			else if (ec==3)
			{
				System.out.println("축하드립니다 5등 당첨됬습니다.");
			}
			else
			{
				System.out.println("낙첨되었습니다.");
			}
			
		

	}

}
