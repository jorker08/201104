import java.util.ArrayList;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		
		ArrayList<Article> article = new ArrayList<>();
		
		for(int i = 1; i <= 50; i++) {
			Article a1 = new Article();
			a1.setId(i);
			a1.setTitle("제목: " + i);
			a1.setBody("내용: " + i);
			
			article.add(a1);
		}
		
		
		Scanner sc = new Scanner(System.in);
		int currentPageNO = 12; // 현재 페이지
		int totalCntOfItems = article.size(); //전체 게시물 개수
		int startPageNo = 1; // 시작 페이지 번호
		int itemsCntPerPage = 3; // 페이지당 출력 게시물 개수
		int pagecntPerBlock = 5; // 한 페이지 블럭 당 페이지 개수
		int endPageNO =(int)Math.ceil((double)totalCntOfItems / itemsCntPerPage); // 마지막 페이지 번호

		
		if(currentPageNO < startPageNo) {
			currentPageNO = startPageNo;
		}
		
		if(currentPageNO > endPageNO) {
			currentPageNO = endPageNO;
		}
		
		int currentPageBlock= (int)Math.ceil((double)currentPageNO / pagecntPerBlock);
		int startPageNoInBlock = (currentPageBlock - 1) * pagecntPerBlock + 1 ;	
		int endPageNoInBlock = startPageNoInBlock + pagecntPerBlock - 1;
		
		if(endPageNoInBlock > endPageNO) {
			endPageNoInBlock = endPageNO;
		}
		
		int startIndex = (currentPageNO -1) * itemsCntPerPage;
		int endIndex = startIndex + pagecntPerBlock -1;
		if(endIndex > totalCntOfItems) {
			endIndex = totalCntOfItems;
		}
				
		
		
		for(int i = startIndex; i < endIndex; i++) {
			System.out.println("번호 : "+ article.get(i).getId());
			System.out.println("제목 : "+ article.get(i).getTitle());
			System.out.println("내용 : "+ article.get(i).getBody());
			System.out.println("=============================");		
		}
		
		
		for(int i = startPageNoInBlock; i <= endPageNoInBlock; i++) {
			
			if(i == currentPageNO) {
				System.out.print("[" + i + "] ");
			}else {
				System.out.print(i + " ");
			}
		}
	}
}
