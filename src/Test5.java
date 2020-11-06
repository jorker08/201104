import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int currentPageNO = sc.nextInt();
		
		int totalCntOfItems = 20; //전체 게시물 개수
		int startPageNO = 1; // 시작 페이지 번호
		int itemsCntPerPage = 3; // 페이지당 출력 게시물 개ㅜ
		int pagecntPerBlock = 5; // 한 페이지 블럭 당 페이지 개수
		int endPageNO =(int) Math.ceil((double)totalCntOfItems / itemsCntPerPage); // 마지막 페이지 번호
		int currentPageBlock =(int) Math.ceil((double) pagecntPerBlock / currentPageNO);  // 현재 페이지 블록
				
		int startPageNoInBlock = (currentPageBlock -1) * pagecntPerBlock + 1;
		System.out.println(startPageNoInBlock);
		
		
		
//		
//		for(int i = startPageNoInBlock; i <= endPageNoInBlock; i++) {
//			System.out.println(i + " ");
//			if(i == currentPageNO) {
//				System.out.println("[" + i + "]");
//			}else {
//				System.out.println(i + " ");
//			}
//		}
	}
}
