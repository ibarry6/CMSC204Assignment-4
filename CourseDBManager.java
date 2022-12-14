import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class CourseDBManager implements CourseDBManagerInterface {
	public CourseDBStructure cds;

	/**
	 * Constructor
	 */
	public CourseDBManager() {
		cds = new CourseDBStructure(100);
	}

	/**
	 * Add a new class with following the parameters.
	 * 
	 * @param course
	 * @param crn
	 * @param credit
	 * @param room
	 * @param instructor
	 */
	@Override
	public void add(String course, int crn, int credit, String room, String instructor) {
		CourseDBElement cde = new CourseDBElement(course, crn, credit, room, instructor);
		cds.add(cde);
	}

	/**
	 * Get method, it uses CourseDBStructure to get a CourseDBElement from the data
	 * structure.
	 * 
	 * @param crn
	 * @return element if found, else return null
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return cds.get(crn);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Reads every line from a text file
	 * 
	 * @param input
	 * @throws FileNotFoundException
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner sc = new Scanner(input);
		int NumOfCredit, crn;
		CourseDBElement cde;
		String str;
		String[] course;

		while (sc.hasNextLine()) {
			str = sc.nextLine();
			course = str.split(" ", 5);
			crn = Integer.parseInt(course[1]);
			NumOfCredit = Integer.parseInt(course[2]);
			cde = new CourseDBElement(course[0], crn, NumOfCredit, course[3], course[4]);
			cds.add(cde);
		}
	}

	/**
	 * Calls the showAll method in courseDBStructure which traverses through the
	 * hash table and returns them into an array list.
	 * 
	 * @return ArrayList with elements
	 */
	@Override
	public ArrayList<String> showAll() {
		return cds.showAll();
	}

}