import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONObject;

public class ArticleDao {

	private ArrayList<Article> articles;
	private int no = 4;

	public ArticleDao() {
		articles = new ArrayList<>();
		Article a1 = new Article(1, "안녕하세요", "내용1", 1, getCurrentDate(), 100, 30);
		Article a2 = new Article(2, "반갑습니다.", "내용2", 2, getCurrentDate(), 50, 20);
		Article a3 = new Article(3, "안녕", "내용3", 3, getCurrentDate(), 30, 10);

		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		
		for(int i = 1; i <= 50 ; i++) {
			Article a4 = new Article();
			a4.setId(i);
			a4.setTitle("제목" + i);
			a4.setBody("내용" + i);
			a4.setMid(1);

			articles.add(a4);
		}
	}
	
	public void writeJsonFile(String filename) {
		String filePath = "C:/test/article_" ++ 
		
		File file = new File("C:/test/article1.json");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

		if (file.isFile() && file.canWrite()) {
			// 쓰기
			bufferedWriter.write("문자열 추가1");
			// 개행문자쓰기
			bufferedWriter.newLine();
			bufferedWriter.write("문자열 추가2");

			bufferedWriter.close();
		}
	} catch (IOException e) {
		System.out.println(e);
	}
	
	
	public void articleToJsonFile(Article article) {
		JSONObject obj = new JSONObject();

		obj.put("id", article.getId());
		obj.put("title", article.getTitle());
		obj.put("body", article.getBody());
		obj.put("mid", article.getMid());
		obj.put("hit", article.getHit());
		obj.put("likeCnt", article.getLikeCnt());
		obj.put("regDate", article.getRegDate());
		
		return obj;
	}
	
	public void insertArticle(Article a) {
		a.setId(no);
		no++;
		a.setRegDate(getCurrentDate());

		articles.add(a);
	}

	public void removeArticle(Article a) {
		articles.remove(a);
	}

	private static String getCurrentDate() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");
		Date time = new Date();
		String time1 = format1.format(time);

		return time1;
	}

	public ArrayList<Article> getSearchedArticlesByFlag(int flag, String keyword) {

		ArrayList<Article> searchedArticles = new ArrayList<>();

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			String str = article.getPropertiesByFlag(flag);
			if (str.contains(keyword)) {
				searchedArticles.add(article);
			}
		}

		return searchedArticles;

	}

	// Article 버전
	public Article getArticleById(int targetId) {
		for (int i = 0; i < articles.size(); i++) {
			int id = articles.get(i).getId();
			if (id == targetId) {
				return articles.get(i);
			}
		}

		return null;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public ArrayList<Article> getSearchedArticlesByBody(String keyword) {
		ArrayList<Article> searchedArticles = new ArrayList<>();

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			String str = article.getBody(); // 각 게시물 제목
			if (str.contains(keyword)) {
				searchedArticles.add(article);
			}
		}

		return searchedArticles;
	}
}
