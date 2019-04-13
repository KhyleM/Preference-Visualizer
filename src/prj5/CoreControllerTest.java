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
public class CoreControllerTest extends TestCase {
    private CoreController c;


    /**
     * default setup()
     */
    public void setUp() {
        c = new CoreController();
    }


    /**
     * 
     */
    public void testGetMusicList() {
        c.scanSong("SongListTest1.csv");
        assertEquals(5, c.getMusicList().size());
        assertEquals("American Pie", c.getMusicList().get(2).getTitle());
        assertEquals("Don McLean", c.getMusicList().get(2).getArtist());
        assertEquals(1971, c.getMusicList().get(2).getDate());
        assertEquals("folk rock", c.getMusicList().get(2).getGenre());
    }


    /**
     * testScanSongs()
     */
    public void testScanSongs() {
        assertTrue(c.getMusicList().isEmpty());
        c.scanSong();
        assertFalse(c.getMusicList().isEmpty());
        assertEquals(59, c.getMusicList().size());
        Exception ee = null;
        try {
            c.scanSong("2");
        }
        catch (Exception e) {
            ee = e;
        }
        assertTrue(ee instanceof Exception);
    }


    /**
     * testScanSongs()
     */
    public void testScanStudent() {
        assertTrue(c.getStudentList().isEmpty());
        c.scanStudent();
        assertFalse(c.getStudentList().isEmpty());
        assertEquals(209, c.getStudentList().size());
        assertEquals(59 * 2, c.getStudentList().get(0).getChoice().length);
        Exception ee = null;
        try {
            c.scanStudent("2");
        }
        catch (Exception e) {
            ee = e;
        }
        assertTrue(ee instanceof Exception);
    }


    /**
     * test sort()
     */
    public void testSortByTitle() {
        c.scanSong("SongListNoGenreRepeats.csv");
        c.scanStudent("MusicSurveyDataNoGenreRepeats.csv");
        c.sortByTitle();
        for (int i = 0; i < c.getMusicList().size() - 1; i++) {
            assertTrue(c.getMusicList().get(i).getTitle().compareTo(c
                .getMusicList().get(i + 1).getTitle()) <= 0);
        }

        c.scanSong("SongListTest1.csv");
        c.scanStudent("MusicSurveyDataTest1.csv");
        c.sortByTitle();
        for (int i = 0; i < c.getMusicList().size() - 1; i++) {
            assertTrue(c.getMusicList().get(i).getTitle().compareTo(c
                .getMusicList().get(i + 1).getTitle()) <= 0);
        }

        c.scanSong("SongListTest2.csv");
        c.scanStudent("MusicSurveyDataTest2.csv");
        c.sortByTitle();
        for (int i = 0; i < c.getMusicList().size() - 1; i++) {
            assertTrue(c.getMusicList().get(i).getTitle().compareTo(c
                .getMusicList().get(i + 1).getTitle()) <= 0);
        }
    }


    /**
     * test sort()
     */
    public void testSortByArtist() {
        c.scanSong();
        c.scanStudent();
        c.sortByArtist();
        for (int i = 0; i < c.getMusicList().size() - 1; i++) {
            assertTrue(c.getMusicList().get(i).getArtist().compareTo(c
                .getMusicList().get(i + 1).getArtist()) <= 0);
        }

    }


    /**
     * test sort()
     */
    public void testSortByDate() {
        c.scanSong();
        c.scanStudent();
        c.sortByDate();
        for (int i = 0; i < c.getMusicList().size() - 1; i++) {
            assertTrue(c.getMusicList().get(i).getDate() - c.getMusicList().get(
                i + 1).getDate() <= 0);
        }
    }


    /**
     * test sort()
     */
    public void testSortByGenre() {
        c.scanSong("SongListNoGenreRepeats.csv");
        c.scanStudent();
        c.sortByGenre();
        for (int i = 0; i < c.getMusicList().size() - 1; i++) {
            assertTrue(c.getMusicList().get(i).getGenre().compareTo(c
                .getMusicList().get(i + 1).getGenre()) <= 0);
        }
        // System.out.println(c.getMusicList().getTHobby(0, 0));
        // System.out.println(c.getMusicList().getTHobby(1, 0));
        // System.out.println(c.getMusicList().getTHobby(2, 0));
        // System.out.println(c.getMusicList().getTHobby(3, 0));
        // System.out.println(c.getMusicList().toString());
    }


    /**
     * testScanSongs()
     */
    public void testScanSongs2() {
        assertTrue(c.getMusicList().isEmpty());
        c.scanSong("SongListTest1.csv");
        assertFalse(c.getMusicList().isEmpty());
        assertEquals(5, c.getMusicList().size());

        assertEquals("All These Things I've Done", c.getMusicList().get(0)
            .getTitle());
        assertEquals("The Killers", c.getMusicList().get(0).getArtist());
        assertEquals(2005, c.getMusicList().get(0).getDate());
        assertEquals("alternative", c.getMusicList().get(0).getGenre());

        assertEquals("All You Need Is Love", c.getMusicList().get(1)
            .getTitle());
        assertEquals("The Beatles", c.getMusicList().get(1).getArtist());
        assertEquals(1967, c.getMusicList().get(1).getDate());
        assertEquals("pop rock", c.getMusicList().get(1).getGenre());

        assertEquals("American Pie", c.getMusicList().get(2).getTitle());
        assertEquals("Don McLean", c.getMusicList().get(2).getArtist());
        assertEquals(1971, c.getMusicList().get(2).getDate());
        assertEquals("folk rock", c.getMusicList().get(2).getGenre());

        assertEquals("Anarchy in the UK", c.getMusicList().get(3).getTitle());
        assertEquals("The Sex Pistols", c.getMusicList().get(3).getArtist());
        assertEquals(1976, c.getMusicList().get(3).getDate());
        assertEquals("punk", c.getMusicList().get(3).getGenre());

        assertEquals("Another One Bites the Dust", c.getMusicList().get(4)
            .getTitle());
        assertEquals("Queen", c.getMusicList().get(4).getArtist());
        assertEquals(1980, c.getMusicList().get(4).getDate());
        assertEquals("disco", c.getMusicList().get(4).getGenre());
    }


    /**
     * testScanSongs()
     */
    public void testScanStudent2() {
        assertTrue(c.getStudentList().isEmpty());
        c.scanStudent("MusicSurveyDataTest1.csv");
        assertFalse(c.getStudentList().isEmpty());
        assertEquals(6, c.getStudentList().size());
        assertEquals(10, c.getStudentList().get(0).getChoice().length);
        assertTrue(c.getMusicList().isEmpty());
        for (int i = 0; i < c.getStudentList().size(); i++) {
            // System.out.println(c.getStudentList().get(i).toString());
        }
    }


    /**
     * 
     */
    public void testScanStudent3() {
        c.scanSong("SongListTest1.csv");
        c.scanStudent("MusicSurveyDataTest1.csv");
        assertFalse(c.getMusicList().isEmpty());
        assertEquals(5, c.getMusicList().size());

        /**
         * overall information
         */
        // 4 people love sports who have heard the first music
        assertEquals(4, c.getMusicList().get(1).getTHeardHobby(1, 0));
        // 2 people love sports who like the first music
        assertEquals(2, c.getMusicList().get(1).getTLikedHobby(1, 0));

        /*
         * first song
         */
        // 0 people have heard first song also love reading
        assertEquals(0, c.getMusicList().get(0).getHeardHobby(0, 0));

        // 0 people love first song also love reading
        assertEquals(0, c.getMusicList().get(0).getLikedHobby(0, 0));

        // 2 people have heard first song also love sport
        assertEquals(2, c.getMusicList().get(0).getHeardHobby(1, 0));

        // 2 people love first song also love sport
        assertEquals(2, c.getMusicList().get(0).getLikedHobby(1, 0));

        // 0 people have heard first song also love music
        assertEquals(0, c.getMusicList().get(0).getHeardHobby(2, 0));

        // 0 people love first song also love music
        assertEquals(1, c.getMusicList().get(0).getLikedHobby(2, 0));

        // 0 people have heard first song also love art
        assertEquals(0, c.getMusicList().get(0).getHeardHobby(3, 0));

        // 0 people love first song also love art
        assertEquals(0, c.getMusicList().get(0).getLikedHobby(3, 0));

        /**
         * second song
         */
        // 0 people have heard second song also love reading
        assertEquals(1, c.getMusicList().get(1).getHeardHobby(0, 0));

        // 0 people love second song also love reading
        assertEquals(1, c.getMusicList().get(1).getLikedHobby(0, 0));

        // 2 people have heard second song also love sport
        assertEquals(4, c.getMusicList().get(1).getHeardHobby(1, 0));

        // 2 people love second song also love sport
        assertEquals(1, c.getMusicList().get(1).getLikedHobby(1, 0));

        // 0 people have heard second song also love music
        assertEquals(0, c.getMusicList().get(1).getHeardHobby(2, 0));

        // 0 people love second song also love music
        assertEquals(1, c.getMusicList().get(1).getLikedHobby(0, 0));

        // 0 people have heard second song also love art
        assertEquals(0, c.getMusicList().get(1).getHeardHobby(3, 0));

        // 0 people love second song also love art
        assertEquals(0, c.getMusicList().get(1).getLikedHobby(3, 0));
    }


    /**
     * 
     */
    public void testReport() {
        c.scanSong("SongListTest1.csv");
        c.scanStudent("MusicSurveyDataTest1.csv");
        assertFalse(c.getMusicList().isEmpty());
        assertEquals(5, c.getMusicList().size());
        assertEquals(6, c.getStudentList().size());
        c.sortByGenre();
        // System.out.println(c.getMusicList().report());
    }


    /**
     * 
     */
    public void testReport2() {
        c.scanSong("SongListNoGenreRepeats.csv");
        c.scanStudent("MusicSurveyDataNoGenreRepeats.csv");
        assertFalse(c.getMusicList().isEmpty());
        assertEquals(17, c.getMusicList().size());
        assertEquals(209, c.getStudentList().size());
        c.sortByGenre();
        System.out.println(c.getMusicList().report());
        for (int i = 0; i < c.getStudentList().size(); i++) {
            // System.out.println(c.getStudentList().get(i).toString());
        }
        // System.out.println("Total number of songs :" +
        // String.valueOf(c.getMusicList().size()));
        // System.out.println("Total number of people :" +
        // String.valueOf(c.getStudentList().size()));
    }
}
