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
public class MusicListTest extends TestCase {
    private MusicList list;


    /**
     * 
     */
    public void setUp() {
        list = new MusicList();
    }


    /**
     * 
     */
    public void testContainsTitle() {
        assertFalse(list.containsTitle("1"));
        list.add(new Music("1", "2", 3, "4"));
        assertFalse(list.containsTitle("2"));
        list.add(new Music("a", "2", 3, "4"));
        list.add(new Music("2", "2", 3, "4"));
        list.add(new Music("b", "2", 3, "4"));
        list.add(new Music("c", "2", 3, "4"));
        assertTrue(list.containsTitle("2"));
        assertTrue(list.containsTitle("a"));
        assertTrue(list.containsTitle("b"));
        assertTrue(list.containsTitle("c"));
        assertFalse(list.containsTitle("m"));
        assertFalse(list.containsTitle("k"));
    }


    /**
     * 
     */
    public void testToString() {
        assertEquals("", list.toString());
        list.add(new Music("1", "2", 3, "4"));
        String result = "Song Title: 1" + "\n" + "Song Artist: 2" + "\n"
            + "Song Genre: 4" + "\n" + "Song Year: 3" + "\n" + "Heard" + "\n"
            + "reading:0 art:0 sports:0 music:0" + "\n" + "Likes" + "\n"
            + "reading:0 art:0 sports:0 music:0" + "\n";
        assertEquals(list.toString(), result);

        list.get(0).getHeardHobby(0, 1);
        list.get(0).getHeardHobby(1, 1);
        list.get(0).getHeardHobby(2, 1);
        list.get(0).getHeardHobby(3, 1);

        list.get(0).getLikedHobby(0, 1);
        list.get(0).getLikedHobby(1, 1);
        list.get(0).getLikedHobby(2, 1);
        list.get(0).getLikedHobby(3, 1);

        list.get(0).getTLikedHobby(0, 1);
        list.get(0).getTLikedHobby(1, 1);
        list.get(0).getTLikedHobby(2, 1);
        list.get(0).getTLikedHobby(3, 1);

        list.get(0).getTHeardHobby(0, 1);
        list.get(0).getTHeardHobby(1, 1);
        list.get(0).getTHeardHobby(2, 1);
        list.get(0).getTHeardHobby(3, 1);

        result = "Song Title: 1" + "\n" + "Song Artist: 2" + "\n"
            + "Song Genre: 4" + "\n" + "Song Year: 3" + "\n" + "Heard" + "\n"
            + "reading:100 art:100 sports:100 music:100" + "\n" + "Likes" + "\n"
            + "reading:100 art:100 sports:100 music:100" + "\n";

        assertEquals(list.toString(), result);
    }

}
