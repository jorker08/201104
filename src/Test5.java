import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test5 {
	public static void main(String[] args) {
		// Json 읽기 (decoding)
//		String jsonStr = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
//		JSONArray array = (JSONArray) JSONValue.parse(jsonStr);
//
//		System.out.println(array.get(1));
//		System.out.println();
//
//		JSONObject obj2 = (JSONObject) array.get(1);
//		System.out.println("Field \"1\"");
//		System.out.println(obj2.get("1"));
//
//		JSONObject obj = new JSONObject();
//		String jsonText;
//
//		obj.put("name", "foo");
//		obj.put("num", new Integer(100));
//		obj.put("balance", new Double(1000.21));
//		obj.put("is_vip", new Boolean(true));
//		jsonText = obj.toString();
//
//		System.out.println("Encode a JSON Object - to String");
//		System.out.print(jsonText);
//		
//		JSONObject jobj = (JSONObject)JSONValue.parse(jsonText);
//		String s1 = (String)jobj.get("name");
//		
//		System.out.println(s1);

		try {
			// 파일 객체 생성
			File file = new File("C:/test/article.json");
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

		// 파일읽기
		try {
			// 파일 객체 생성
			File file = new File("C:/test/test.txt");
			// 입력 스트림 생성
			FileReader filereader = new FileReader(file);
			// 입력 버퍼 생성
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				System.out.println(line);
			}
			// .readLine()은 끝에 개행문자를 읽지 않는다.
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
