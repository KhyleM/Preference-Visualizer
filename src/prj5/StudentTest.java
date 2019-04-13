/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author <Zhengdao Jiao> <zhengj7>
 * @author <Khyle Mott> (khyle)
 * @author <Mujid Khan> (mujidk)
 * @version 2018/04/08
 */
public class StudentTest extends TestCase {
    private Student p;


    /**
     * 
     */
    public void setUp() {
        p = new Student(Student.Major.CS, Student.Region.OUS,
            Student.Hobby.ART);
    }


    /**
     * 
     */
    public void testGetStuff() {
        assertEquals(Student.Major.CS, p.getMajor());
        assertEquals(Student.Region.OUS, p.getRegion());
        assertEquals(Student.Hobby.ART, p.getHobby());
        assertTrue(p.isEmptyChoice());
        assertEquals(0, p.numOfChoice());
        String[] input = new String[] { "Yes", "No", "No" };
        p.setChoice(input);
        assertFalse(p.isEmptyChoice());
        assertEquals(3, p.numOfChoice());
        assertEquals("[CS, OUS, ART          ===  Yes  , No   , No   ]", p
            .toString());
    }
}
