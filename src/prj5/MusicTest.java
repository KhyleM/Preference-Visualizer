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
public class MusicTest extends TestCase {
    private Music song;


    /**
     * 
     */
    public void setUp() {
        song = new Music("title", "artist", 1996, "genre");
    }


    /**
     * 
     */
    public void testGetStuff() {
        assertEquals("title", song.getTitle());
        assertEquals("artist", song.getArtist());
        assertEquals(1996, song.getDate());
        assertEquals("genre", song.getGenre());
    }


    /**
     * 
     */
    public void testGetMethod() {
        assertEquals(0, song.getHeardMajor(0, 0));
        assertEquals(0, song.getHeardMajor(1, 0));
        assertEquals(0, song.getHeardMajor(2, 0));
        assertEquals(0, song.getHeardMajor(3, 0));

        assertEquals(1, song.getHeardMajor(0, 1));
        assertEquals(2, song.getHeardMajor(1, 2));
        assertEquals(3, song.getHeardMajor(2, 3));
        assertEquals(4, song.getHeardMajor(3, 4));

        assertEquals(1, song.getHeardMajor(0, 0));
        assertEquals(2, song.getHeardMajor(1, 0));
        assertEquals(3, song.getHeardMajor(2, 0));
        assertEquals(4, song.getHeardMajor(3, 0));

        assertEquals(0, song.getHeardMajor(0, -1));
        assertEquals(0, song.getHeardMajor(1, -2));
        assertEquals(0, song.getHeardMajor(2, -3));
        assertEquals(0, song.getHeardMajor(3, -4));

        for (int i = 1; i <= 120; i++) {
            assertEquals((1 + i) * i / 2, song.getHeardMajor(0, i));
            assertEquals((1 + i) * i / 2, song.getLikedMajor(0, i));
            assertEquals((1 + i) * i / 2, song.getHeardRegion(0, i));
            assertEquals((1 + i) * i / 2, song.getLikedRegion(0, i));
            assertEquals((1 + i) * i / 2, song.getHeardHobby(0, i));
            assertEquals((1 + i) * i / 2, song.getLikedHobby(0, i));
        }

    }


    /**
     * 
     */
    public void testGetMethod2() {
        assertEquals(0, song.getTHeardHobby(0, 0));
        assertEquals(0, song.getTHeardHobby(1, 0));
        assertEquals(0, song.getTHeardHobby(2, 0));
        assertEquals(0, song.getTHeardHobby(3, 0));

        assertEquals(1, song.getTHeardHobby(0, 1));
        assertEquals(2, song.getTHeardHobby(1, 2));
        assertEquals(3, song.getTHeardHobby(2, 3));
        assertEquals(4, song.getTHeardHobby(3, 4));

        assertEquals(1, song.getTHeardHobby(0, 0));
        assertEquals(2, song.getTHeardHobby(1, 0));
        assertEquals(3, song.getTHeardHobby(2, 0));
        assertEquals(4, song.getTHeardHobby(3, 0));

        assertEquals(0, song.getTHeardHobby(0, -1));
        assertEquals(0, song.getTHeardHobby(1, -2));
        assertEquals(0, song.getTHeardHobby(2, -3));
        assertEquals(0, song.getTHeardHobby(3, -4));

        for (int i = 1; i <= 120; i++) {
            assertEquals((1 + i) * i / 2, song.getTHeardHobby(0, i));
            assertEquals((1 + i) * i / 2, song.getTHeardMajor(0, i));
            assertEquals((1 + i) * i / 2, song.getTHeardRegion(0, i));

            assertEquals((1 + i) * i / 2, song.getTLikedHobby(0, i));
            assertEquals((1 + i) * i / 2, song.getTLikedMajor(0, i));
            assertEquals((1 + i) * i / 2, song.getTLikedRegion(0, i));
        }

    }
}
