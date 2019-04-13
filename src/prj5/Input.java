/**
 * 
 */
package prj5;

/**
 *
 * @author <Zhengdao Jiao> <zhengj7>
 * @author <Khyle Mott> (khyle)
 * @author <Mujid Khan> (mujidk)
 * @version 2018/04/08
 */
public class Input {
    private static CoreController cc = new CoreController();


    /**
     * @param args
     */
    public static void main(String[] args) {
        args = new String[] {"MusicSurveyDataTest1.csv","SongListTest1.csv"};
        cc.scanSong(args[1]);
        cc.scanStudent(args[0]);

        cc.sortByGenre();
        System.out.println(cc.getMusicList().toString());

        // System.out.println("\n");

        cc.sortByTitle();
        System.out.println(cc.getMusicList().toString());
    }

}
