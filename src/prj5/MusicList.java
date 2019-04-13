package prj5;

import java.util.Iterator;

/**
 * @author <Zhengdao Jiao> <zhengj7>
 * @author <Khyle Mott> (khyle)
 * @author <Mujid Khan> (mujidk)
 * @version 2018/04/08
 */
public class MusicList extends LinkedList<Music> {

    /**
     * search song by title
     * 
     * @return true if the song with given title exists in the list
     * @param input
     *            title name
     */
    public boolean containsTitle(String input) {
        Iterator<Music> p = this.iterator();
        while (p.hasNext()) {
            if (p.next().getTitle().equals(input)) {
                return true;
            }
        }
        return false;
    }


    /**
     * @return the string()
     */
    public String toString() {
        StringBuilder c = new StringBuilder();
        Iterator<Music> p = this.iterator();
        while (p.hasNext()) {
            Music s = p.next();
            int tianjiao = 0;
            c.append("Song Title: " + s.getTitle() + "\n");
            c.append("Song Artist: " + s.getArtist() + "\n");
            c.append("Song Genre: " + s.getGenre() + "\n");
            c.append("Song Year: " + String.valueOf(s.getDate()) + "\n");
            c.append("Heard\n");
            /* ========================== */
            c.append("reading:");
            tianjiao = s.getTHeardHobby(0, 0) == 0
                ? 0
                : s.getHeardHobby(0, 0) * 100 / s.getTHeardHobby(0, 0);
            c.append(tianjiao);
            /* ========================== */
            c.append(" art:");
            tianjiao = s.getTHeardHobby(3, 0) == 0
                ? 0
                : s.getHeardHobby(3, 0) * 100 / s.getTHeardHobby(3, 0);
            c.append(tianjiao);
            /* ========================== */
            c.append(" sports:");
            tianjiao = s.getTHeardHobby(1, 0) == 0
                ? 0
                : s.getHeardHobby(1, 0) * 100 / s.getTHeardHobby(1, 0);
            c.append(tianjiao);
            /* ========================== */
            c.append(" music:");
            tianjiao = s.getTHeardHobby(2, 0) == 0
                ? 0
                : s.getHeardHobby(2, 0) * 100 / s.getTHeardHobby(2, 0);
            c.append(tianjiao);
            c.append("\n");

            c.append("Likes\n");
            /* ========================== */
            c.append("reading:");
            tianjiao = s.getTLikedHobby(0, 0) == 0
                ? 0
                : s.getLikedHobby(0, 0) * 100 / s.getTLikedHobby(0, 0);
            c.append(tianjiao);
            /* ========================== */
            c.append(" art:");
            tianjiao = s.getTLikedHobby(3, 0) == 0
                ? 0
                : s.getLikedHobby(3, 0) * 100 / s.getTLikedHobby(3, 0);
            c.append(tianjiao);
            /* ========================== */
            c.append(" sports:");
            tianjiao = s.getTLikedHobby(1, 0) == 0
                ? 0
                : s.getLikedHobby(1, 0) * 100 / s.getTLikedHobby(1, 0);
            c.append(tianjiao);
            /* ========================== */
            c.append(" music:");
            tianjiao = s.getTLikedHobby(2, 0) == 0
                ? 0
                : s.getLikedHobby(2, 0) * 100 / s.getTLikedHobby(2, 0);
            c.append(tianjiao);
            c.append("\n");
            if (p.hasNext()) {
                c.append("\n");
            }
        }
        return c.toString();
    }


    /**
     * 
     * @return the report()
     */
    public String report() {
        StringBuilder c = new StringBuilder();
        Iterator<Music> p = this.iterator();
        while (p.hasNext()) {
            Music s = p.next();
            c.append("Song Title: " + s.getTitle() + "\n");
            c.append("Song Artist: " + s.getArtist() + "\n");
            c.append("Song Genre: " + s.getGenre() + "\n");
            c.append("Song Year: " + String.valueOf(s.getDate()) + "\n");
            c.append("Heard\n");
            /* ========================== */
            c.append("reading:");
            c.append(String.valueOf(s.getHeardHobby(0, 0)) + "/" + String
                .valueOf(s.getTHeardHobby(0, 0)));
            /* ========================== */
            c.append(" art:");
            c.append(String.valueOf(s.getHeardHobby(3, 0)) + "/" + String
                .valueOf(s.getTHeardHobby(3, 0)));
            /* ========================== */
            c.append(" sports:");
            c.append(String.valueOf(s.getHeardHobby(1, 0)) + "/" + String
                .valueOf(s.getTHeardHobby(1, 0)));
            /* ========================== */
            c.append(" music:");
            c.append(String.valueOf(s.getHeardHobby(2, 0)) + "/" + String
                .valueOf(s.getTHeardHobby(2, 0)));
            c.append("\n");

            c.append("Likes\n");
            /* ========================== */
            c.append("reading:");
            c.append(String.valueOf(s.getLikedHobby(0, 0)) + "/" + String
                .valueOf(s.getTLikedHobby(0, 0)));
            /* ========================== */
            c.append(" art:");
            c.append(String.valueOf(s.getLikedHobby(3, 0)) + "/" + String
                .valueOf(s.getTLikedHobby(3, 0)));
            /* ========================== */
            c.append(" sports:");
            c.append(String.valueOf(s.getLikedHobby(1, 0)) + "/" + String
                .valueOf(s.getTLikedHobby(1, 0)));
            /* ========================== */
            c.append(" music:");
            c.append(String.valueOf(s.getLikedHobby(2, 0)) + "/" + String
                .valueOf(s.getTLikedHobby(2, 0)));
            c.append("\n");
            if (p.hasNext()) {
                c.append("\n");
            }
        }
        return c.toString();
    }

}
