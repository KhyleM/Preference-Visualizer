/**
 * 
 */
package prj5;

import java.io.File;
import java.util.Scanner;
import prj5.Student.*;
import java.util.Arrays;

/**
 * @author <Zhengdao Jiao> <zhengj7>
 * @author <Khyle Mott> (khyle)
 * @author <Mujid Khan> (mujidk)
 * @version 2018/04/08
 */
public class CoreController {
    private MusicList listOfSongs;
    private LinkedList<Student> listOfPeople;
    private Scanner scan;
    private File songfile;
    private File studentFile;


    /**
     * Default constructor for CoreController
     */
    public CoreController() {
        listOfSongs = new MusicList();
        listOfPeople = new LinkedList<Student>();
        scan = new Scanner("");
        songfile = new File("SongList.csv");
        studentFile = new File("MusicSurveyData.csv");
    }


    /**
     * 
     * @return MusicList
     */
    public MusicList getMusicList() {
        return listOfSongs;
    }


    /**
     * 
     * @return MusicList
     */
    public LinkedList<Student> getStudentList() {
        return listOfPeople;
    }


    /**
     * default scanning song file
     */
    public void scanSong() {
        scanSong("SongList.csv");
    }


    /**
     * default scanSong()
     * 
     * @param input
     *            the name of the songs data file
     */
    public void scanSong(String input) {
        songfile = new File(input);
        try {
            scan = new Scanner(songfile);
        }
        catch (Exception e) {
            System.out.println("FileExistanceError. Check the file"
                + " name and address of your songfile");
        }

        // clear list before scanning
        listOfSongs.clear();
        // start from the second line to read data
        scan.nextLine();

        while (scan.hasNext()) {
            String str = scan.nextLine();
            String[] songInfo = str.split(",");
            listOfSongs.add(new Music(songInfo[0], songInfo[1], Integer.valueOf(
                songInfo[2]), songInfo[3]));
        }
    }


    /**
     * default scanning People file
     */
    public void scanStudent() {
        scanStudent("MusicSurveyData.csv");
    }


    /**
     * default scanStudent()
     * 
     * @param input
     *            the name of the Student data file
     */
    public void scanStudent(String input) {
        studentFile = new File(input);
        try {
            scan = new Scanner(studentFile);
        }
        catch (Exception e) {
            System.out.println("FileExistanceError. Check the file"
                + " name and address of your studentFile");
        }
        // clear list before scanning
        listOfPeople.clear();
        // start from the second line to read data
        scan.nextLine();

        while (scan.hasNext()) {
            String str = scan.nextLine();
            String[] p = str.split(",", -1);
            // int major = -1;
            // int region = -1;
            int hobby = -1;
            Major a = Student.Major.NONE;
            Region b = Student.Region.NONE;
            Hobby c = Student.Hobby.NONE;

            if (p[2].equals("Computer Science")) {
                a = Student.Major.CS;
                // major = 0;
            }
            else if (p[2].equals("Math or CMDA")) {
                a = Student.Major.MC;
                // major = 1;
            }
            else if (p[2].equals("Other Engineering")) {
                a = Student.Major.OE;
                // major = 2;
            }
            else if (p[2].equals("Other")) {
                a = Student.Major.O;
                // major = 3;
            }
            else {
                a = Student.Major.NONE;
                // major = -1;
            }

            if (p[3].equals("Southeast")) {
                b = Student.Region.SE;
                // region = 0;
            }
            else if (p[3].equals("Northeast")) {
                b = Student.Region.NE;
                // region = 1;
            }
            else if (p[3].equals(
                "United States (other than Southeast or Northwest)")) {
                b = Student.Region.US;
                // region = 2;
            }
            else if (p[3].equals("Outside of United States")) {
                b = Student.Region.OUS;
                // region = 3;
            }
            else {
                b = Student.Region.NONE;
                // region = -1;
            }

            if (p[4].equals("reading")) {
                c = Student.Hobby.READING;
                hobby = 0;
                // listOfSongs.getTHobby(0, 1);
            }
            else if (p[4].equals("sports")) {
                c = Student.Hobby.SPORT;
                hobby = 1;
                // listOfSongs.getTHobby(1, 1);
            }
            else if (p[4].equals("music")) {
                c = Student.Hobby.MUSIC;
                hobby = 2;
                // listOfSongs.getTHobby(2, 1);
            }
            else if (p[4].equals("art")) {
                c = Student.Hobby.ART;
                hobby = 3;
                // listOfSongs.getTHobby(3, 1);
            }
            else {
                c = Student.Hobby.NONE;
                hobby = -1;
            }

            Student boy = new Student(a, b, c);
            boy.setChoice(Arrays.copyOfRange(p, 5, p.length));
            listOfPeople.add(boy);

            if (hobby == -1) {
                continue;
            }

            for (int i = 0; i < listOfSongs.size(); i++) {
                Music currentSong = listOfSongs.get(i);
                String[] anwser = boy.getChoice();
                // deal with Heard Data
                if (anwser[2 * i].toLowerCase().contains("yes")) {
                    currentSong.getHeardHobby(hobby, 1);
                }
                // deal with Liked Data
                if (anwser[2 * i + 1].toLowerCase().contains("yes")) {
                    currentSong.getLikedHobby(hobby, 1);
                }

                if (anwser[2 * i].toLowerCase().contains("yes") || anwser[2 * i]
                    .toLowerCase().contains("no")) {
                    currentSong.getTHeardHobby(hobby, 1);
                }
                // deal with Liked Data
                if (anwser[2 * i + 1].toLowerCase().contains("yes") || anwser[2
                    * i + 1].toLowerCase().contains("no")) {
                    currentSong.getTLikedHobby(hobby, 1);
                }
            }
        }

    }


    /**
     * 
     */
    public void sortByTitle() {
        MusicList list = listOfSongs;
        for (int i = 1; i < list.size(); i++) {
            int j = i;
            Music tmp;
            while (j > 0 && ((Music)list.get(j - 1)).getTitle().compareTo(
                ((Music)list.get(j)).getTitle()) > 0) {
                tmp = (Music)list.get(j);
                list.remove(j);
                list.add(j - 1, tmp);
                j = j - 1;
            }
        }
    }


    /**
     * 
     */
    public void sortByArtist() {
        MusicList list = listOfSongs;
        for (int i = 1; i < list.size(); i++) {
            int j = i;
            Music tmp;
            while (j > 0 && ((Music)list.get(j - 1)).getArtist().compareTo(
                ((Music)list.get(j)).getArtist()) > 0) {
                tmp = (Music)list.get(j);
                list.remove(j);
                list.add(j - 1, tmp);
                j = j - 1;
            }
        }
    }


    /**
     * 
     */
    public void sortByGenre() {
        MusicList list = listOfSongs;
        for (int i = 1; i < list.size(); i++) {
            int j = i;
            Music tmp;
            while (j > 0 && ((Music)list.get(j - 1)).getGenre().compareTo(
                ((Music)list.get(j)).getGenre()) > 0) {
                tmp = (Music)list.get(j);
                list.remove(j);
                list.add(j - 1, tmp);
                j = j - 1;
            }
        }
    }


    /**
     * 
     */
    public void sortByDate() {
        MusicList list = listOfSongs;
        for (int i = 1; i < list.size(); i++) {
            int j = i;
            Music tmp;
            while (j > 0 && ((Music)list.get(j - 1)).getDate() - ((Music)list
                .get(j)).getDate() > 0) {
                tmp = (Music)list.get(j);
                list.remove(j);
                list.add(j - 1, tmp);
                j = j - 1;
            }
        }
    }

}
