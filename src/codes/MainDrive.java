package codes;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

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
				
//				그 결과가 OK일때만
				if (isRangeOk) {

//					입력받은 숫자를 배열에 저장
					myLottoNums[i] = inputNum;
					
//					올바른 결과가 들어갔으면 => while문을 종료.
//					다음 자리의 숫자를 받으러 이동.
					break;
				}
				else {
//					검사에 실패한 경우.
//					안내메세지도 보여주자.
					System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
				}
				
			}

		}

//		저장된 값들 출력

		for (int myNum : myLottoNums) {
			System.out.println(myNum);
		}

	}

}






