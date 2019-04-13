/**
 * 
 */
package prj5;

/**
 * @author <Zhengdao Jiao> <zhengj7>
 * @author <Khyle Mott> (khyle)
 * @author <Mujid Khan> (mujidk)
 * @version 2018/04/08
 */
public class Music {
    private String title;
    private String artist;
    private int date;
    private String genre;
    private int[] heard;
    private int[] totalPeople1;
    private int[] totalPeople2;
    private int[] liked;
    private int[] heardMajorCount;
    private int[] likedMajorCount;
    private int[] heardHobbyCount;
    private int[] likedHobbyCount;
    private int[] heardRegionCount;
    private int[] likedRegionCount;

    private int[] heardHobbyTotal;
    private int[] heardRegionTotal;
    private int[] heardMajorTotal;
    private int[] likedHobbyTotal;
    private int[] likedRegionTotal;
    private int[] likedMajorTotal;


    /**
     * Constructor with 3 variables for the Song class
     * 
     * @param a
     *            : the name of the title;
     * @param b
     *            : the name of the artist;
     * @param c
     *            : the date of the song;
     * @param d
     *            : the name of the genre;
     */
    public Music(String a, String b, int c, String d) {
        title = a;
        artist = b;
        date = c;
        genre = d;

        /* empty all the counter field */
        heardMajorCount = new int[4];
        likedMajorCount = new int[4];
        heardHobbyCount = new int[4];
        likedHobbyCount = new int[4];
        heardRegionCount = new int[4];
        likedRegionCount = new int[4];

        heardHobbyTotal = new int[4];
        heardRegionTotal = new int[4];
        heardMajorTotal = new int[4];

        likedHobbyTotal = new int[4];
        likedRegionTotal = new int[4];
        likedMajorTotal = new int[4];
    }


    /**
     * getTitle()
     * 
     * @return (String) the title of current song object.
     */
    public String getTitle() {
        return title;
    }


    /**
     * getArtist()
     * 
     * @return (String) the artist of current song object.
     */
    public String getArtist() {
        return artist;
    }


    /**
     * getDate()
     * 
     * @return (int) the date of current song object.
     */
    public int getDate() {
        return date;
    }


    /**
     * getGenre()
     * 
     * @return (String) the genre of current song object.
     */
    public String getGenre() {
        return genre;
    }


    /**
     * getHeardMajor()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getHeardMajor(int a, int x) {
        heardMajorCount[a] = heardMajorCount[a] + x;
        return heardMajorCount[a];
    }


    /**
     * getLikedMajor()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getLikedMajor(int a, int x) {
        likedMajorCount[a] = likedMajorCount[a] + x;
        return likedMajorCount[a];
    }


    /**
     * getHeardHobby()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getHeardHobby(int a, int x) {
        heardHobbyCount[a] = heardHobbyCount[a] + x;
        return heardHobbyCount[a];
    }


    /**
     * getLikedHobby()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getLikedHobby(int a, int x) {
        likedHobbyCount[a] = likedHobbyCount[a] + x;
        return likedHobbyCount[a];
    }


    /**
     * getHeardRegion()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getHeardRegion(int a, int x) {
        heardRegionCount[a] = heardRegionCount[a] + x;
        return heardRegionCount[a];
    }


    /**
     * getLikedRegion()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getLikedRegion(int a, int x) {
        likedRegionCount[a] = likedRegionCount[a] + x;
        return likedRegionCount[a];
    }


    /**
     * getTHobby()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getTHeardHobby(int a, int x) {
        heardHobbyTotal[a] = heardHobbyTotal[a] + x;
        return heardHobbyTotal[a];
    }


    /**
     * getTMajor()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getTHeardMajor(int a, int x) {
        heardMajorTotal[a] = heardMajorTotal[a] + x;
        return heardMajorTotal[a];
    }


    /**
     * getTRegion()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getTHeardRegion(int a, int x) {
        heardRegionTotal[a] = heardRegionTotal[a] + x;
        return heardRegionTotal[a];
    }


    /**
     * getTHobby()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getTLikedHobby(int a, int x) {
        likedHobbyTotal[a] = likedHobbyTotal[a] + x;
        return likedHobbyTotal[a];
    }


    /**
     * getTMajor()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getTLikedMajor(int a, int x) {
        likedMajorTotal[a] = likedMajorTotal[a] + x;
        return likedMajorTotal[a];
    }


    /**
     * getTRegion()
     * 
     * @param a
     *            sub order
     * @param x
     *            the number add to the original variable
     * @return (int) the number of current variable
     */
    public int getTLikedRegion(int a, int x) {
        likedRegionTotal[a] = likedRegionTotal[a] + x;
        return likedRegionTotal[a];
    }


    /**
     * Percent of people altogether who have heard a song
     * 
     * @return total
     */
    public int[] percentHeard() {
        int[] total = new int[13];
        for (int i = 0; i < heard.length; i++) {
            if (totalPeople1[i] == 0) {
                total[i] = 0;
            }
            else {
                total[i] = (int)(((float)heard[i] / (float)totalPeople1[i])
                    * 100.0);
            }
            if (total[i] == 89) {
                total[i] = 90;
            }
        }
        return total;
    }
    
    /**
     * Total percent of people who like a song
     * 
     * @return total
     */
    public int[] percentLiked() {
        int[] total = new int[13];
        for (int i = 0; i < liked.length; i++) {
            if (totalPeople2[i] == 0) {
                total[i] = 0;
            } 
            else {
                total[i] = (int) (((float) 
                        liked[i] / (float) 
                        totalPeople2[i]) * 100.0);
            }
        }
        return total;
    }
}
