package codes;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
//		6개의 로또 숫자를 저장할 배열
		int[] myLottoNums = new int[6];
		
		for (int i=0 ; i < myLottoNums.length ; i++) {
			
			System.out.print((i+1)+ "번째 로또 번호 입력 : ");
			
			int inputNum = scan.nextInt();
			
			myLottoNums[i] = inputNum;
			
		}
		
		
	}

}










