package jamocha;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Emp {

	public static void main(String[] args) {
		view();
	}

	public static void view() {
		System.out.println("===================================================");
		System.out.println("Select from following Options");
		System.out.println("1  View All");
		System.out.println("2  Add New");
		System.out.println("3  Modify");
		System.out.println("4  Delete");
		System.out.println("5  Exit");
		System.out.println("===================================================");
		System.out.println();
		System.out.println("Choose your Option");
		select();

	}

	public static void select() {
		Scanner scan = new Scanner(System.in);
		try {

			int n = scan.nextInt();
			//
			Employee o = new Employee();
			switch (n) {
			case 1:
				o.viewAll();
				break;
			case 2:
				o.addNew();
				break;
			case 3:
				o.modify();
				break;
			case 4:
				o.delete();
				break;
			case 5:
				o.exit();
			default:
				System.out.println("Enter valid Input");
				select();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Enter valid Input");
			select();
		} finally {
			scan.close();
		}

	}
}
