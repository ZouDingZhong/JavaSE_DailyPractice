package dataStruct;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _RepeatRemove {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		List list = new LinkedList();
		while(input.hasNext())
		{
			n = input.nextInt();
			list.add(n);
		}
		System.out.println(list);
	}

}
