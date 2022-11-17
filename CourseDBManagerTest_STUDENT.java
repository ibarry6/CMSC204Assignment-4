
import static org.junit.Assert.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class CourseDBManagerTest_STUDENT {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204", 11111, 4, "SC111", "Ibrahima Barry");
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	public void testShowAll() {
		dataMgr.add("CMSC204", 11111, 4, "SC111", "Ibrahima Barry");
		dataMgr.add("CMSC204", 22222, 4, "SC222", "Mory Sangare");
		dataMgr.add("CMSC204", 33333, 4, "SC333", "Amadou Bah");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0), "\nCourse:CMSC204 CRN:33333 Credits:4 Instructor:Amadou Bah Room:SC333");
		assertEquals(list.get(1), "\nCourse:CMSC204 CRN:22222 Credits:4 Instructor:Mory Sangare Room:SC222");
		assertEquals(list.get(2), "\nCourse:CMSC204 CRN:11111 Credits:4 Instructor:Ibrahima Barry Room:SC111");

	}

	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("StudentTest.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 22222 4 SC222 Mory Sangare");
			inFile.print("CMSC204 11111 4 SC111 Ibrahima Barry");
			inFile.close();
			
			dataMgr.readFile(inputFile);
			assertEquals("CMSC204", dataMgr.get(22222).getID());
			assertEquals("CMSC204", dataMgr.get(11111).getID());
			assertEquals("SC111", dataMgr.get(11111).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}