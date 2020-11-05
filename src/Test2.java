import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test2 {
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Num> nlist = new ArrayList<Num>();

		list.add(4);
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(3);
		Collections.sort(list);
		printList(list);

//		nlist.add(new Num(4, 5));
//		nlist.add(new Num(1, 1));
//		nlist.add(new Num(2, 4));
//		nlist.add(new Num(5, 3));
//		nlist.add(new Num(3, 2));
//
//		for (int i = 0; i < nlist.size(); i++) {
//			System.out.println(nlist.get(i).n2);
//		}
//
//		
//		for (int i = 0; i < nlist.size(); i++) {
//			System.out.println(nlist.get(i).n2);
//		}
		
	}
	public static void printList(ArrayList<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}

class Mycompartor implements Comparator<Num>{
	@Override
	public int compare(Num o1, Num o2) {
		if(o1.n1 > o2.n2) {
			return 1; // 0,1 바꿔라
		}
		return -1; // -1 바꾸지마라
	}
}

class Num {
	
	int n1;
	int n2;
	
	Num(int a, int b) {
		n1 = a;
		n2 = b;
	}
}
