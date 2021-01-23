package codes;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		미리 당첨번호를 설정.
		int[] winNumbers = {9, 18, 19, 30, 34, 40};
//		보너스번호 : 5개 맞춘 경우에만 활용.
		int bonusNum = 20;

		Scanner scan = new Scanner(System.in);

//		6개의 로또 숫자를 저장할 배열
		int[] myLottoNums = new int[6];

		for (int i = 0; i < myLottoNums.length; i++) {
			
//			for - 각각의 자리에 맞게 숫자를 대입하도록 하는 역할.
//			올바른 숫자를 넣을때까지 반복.
			
			while (true) {

//				숫자 입력
				System.out.print((i + 1) + "번째 로또 번호 입력 : ");
				int inputNum = scan.nextInt();

//				입력해도 되는 숫자인지? 검사하고
//				검사 1. 입력받은 숫자가 1 ~ 45 사이의 값인가?
//				1 ~ 45 사이: 1보다는 크거나 같고, 동시에, 45보다는 작거나 같다.
				boolean isRangeOk = (1 <= inputNum && inputNum <= 45);
				
//				추가검사 : 중복인지 아닌지.
//				중복인가? => 내가 입력한 숫자가 => 이미 배열안에 들어있다면? 중복 (사용 불가)
				
//				중복검사 결과
//				써도 괜찮다고 했다가 => 같은 숫자를 발견한다면, 쓰면 안된다고 말을 변경.
				boolean isDuplOk = true;
				
//				배열 안의 숫자를 모두 꺼내보자.
				for (int myNum : myLottoNums) {
//					입력한 값과 myNum이 같은지? => 같다면 중복검사 탈락.
					if (inputNum == myNum) {
//						중복값 발견! 검사 탈락처리.
						isDuplOk = false;
						
//						중복 확정되면 for문 종료.
						break;
					}
				}
				
//				범위도 OK고, 중복여부도 통과해야
				if (isRangeOk && isDuplOk) {

//					입력받은 숫자를 배열에 저장
					myLottoNums[i] = inputNum;
					
//					올바른 결과가 들어갔으면 => while문을 종료.
//					다음 자리의 숫자를 받으러 이동.
					break;
				}
				else if (!isRangeOk) {
//					범위 검사에 실패했다면
					System.out.println("1~45의 숫자로만 입력 가능합니다.");
				}
				else {
//					범위 검사는 맞았다면
					System.out.println("이미 입력된 번호입니다.");
					System.out.println("다른 숫자로 입력해주세요.");
				}
				
			}

		}

		
//		응용문제 2 - 입력된 값들을 작은값부터로 정리하기.
		
//		2-1 Bubble Sort
//		가로로 2개씩 비교해서, 자리바꿈 for - 빠른 for : j
//		총 6번 이 과정을 반복하게하는 for - 느린 for : i
		
		for (int i=0 ; i < myLottoNums.length ; i++) {
			
//			배열의 j+1 번칸 까지 접근 : 하나 덜 가야 안전하다. 
//			(j=5가 된다면, j+1은 6이라서, 배열범위 벗어남 에러) 
			for (int j=0 ; j < myLottoNums.length-1 ; j++) {
				
//				ex. j: 0,  배열0번칸/배열1번칸 비교 => 바꿔야 하면 바꾸자.
//				ex. j: 1,  배열1번칸/배열2번칸 비교 => 바꿔야 하면 바꾸자.
				if (myLottoNums[j] > myLottoNums[j+1]) {
//					앞의 숫자가 더 크다!
//					잘못된 자리므로 서로 바꿔주자.

//					변수 응용문제 => 변수 값 교환 로직 재사용.
					int backUp = myLottoNums[j];
					myLottoNums[j] = myLottoNums[j+1];
					myLottoNums[j+1] = backUp;
					
				}
				
			}
			
		}
		
//		저장된 값들 출력

		for (int myNum : myLottoNums) {
			System.out.println(myNum);
		}
		
		
//		내가 입력한 숫자들과, 당첨번호들을 비교 => 몇개 맞췄는지? 결과로 획득.
		int correctNumCount = 0;
		
//		내 번호 하나 : 당첨번호 6개와 비교.
		for (int myNum : myLottoNums) {
			
//			당첨번호 6개 반복
			for (int winNum : winNumbers) {
				
//				내 번호와 당첨번호가 같은가? => 같다면? 숫자 하나 맞췄다!
				if (myNum == winNum) {
					
//					맞춘 숫자 갯수 증가
					correctNumCount++;
				}
				
			}
			
		}
		
//		맞춘 숫자가 몇개인지 기록되어있다. correctNumCount에.
//		이 갯수를 가지고 등수 판단
		
		if (correctNumCount == 6) {
			System.out.println("1등");
		}
		else if (correctNumCount == 5) {
//			보너스번호 맞췄는지? 추가검사.
//			못찾은 상태로 초기화. => 보너스번호를 찾으면 true로 바꾸자.
			boolean isBonusNumOk = false;
			
//			내 번호 목록을 다시 돌아보면서 => 보너스번호와 비교해보자.
			for (int myNum : myLottoNums) {
				
//				내 번호와 보너스 번호가 일치한걸 찾았다면
				if (myNum == bonusNum) {
//					보너스번호 맞춤으로 설정.
					isBonusNumOk = true;
				}
			}
			
//			보너스번호 당첨 여부에 따라, 등수 갈림.
			if (isBonusNumOk) {
				System.out.println("2등");
			}
			else {
				System.out.println("3등");
			}
			
		}
		else if (correctNumCount == 4) {
			System.out.println("4등");
		}
		else if (correctNumCount == 3) {
			System.out.println("5등");
		}
		else {
			System.out.println("꽝");
		}
		

	}

}








