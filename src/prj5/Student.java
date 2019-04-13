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
public class Student {
    /**
     * @author <Zhengdao Jiao> <zhengj7>
     * @author <Khyle Mott> (khyle)
     * @version 2018/04/08
     */
    public enum Major {
        /**
         * ¡°CS¡± stands for ¡°Computer Science¡±
         * ¡°MC¡± stands for ¡°Math or CMDA"
         * ¡°OE¡± stands for ¡°Other Engineering"
         * ¡°O¡± stands for ¡°Other¡±
         */
        CS, MC, OE, O, NONE
    }


    /**
     * @author <Zhengdao Jiao> <zhengj7>
     * @author <Khyle Mott> (khyle)
     * @version 2018/04/08
     */
    public enum Region {
        /**
         * ¡°SE¡± stands for ¡°Southeast¡±
         * ¡°NE¡± stands for ¡°Northeast¡±
         * ¡°US¡± stands for ¡°United States
         * (other than Southeast or Northwest)¡±
         * ¡°OUS¡± stands for ¡°Outside of United States
         */
        SE, NE, US, OUS, NONE
    }


    /**
     * @author <Zhengdao Jiao> <zhengj7>
     * @author <Khyle Mott> (khyle)
     * @version 2018/04/08
     */
    public enum Hobby {
        /**
         * ¡°READING¡± stands for ¡°Reading¡±
         * ¡°SPORT¡± stands for ¡°Sport¡±
         * ¡°MUSIC¡± stands for ¡°Music¡±
         * ¡°ART¡± stands for ¡°Art¡±
         */
        READING, SPORT, MUSIC, ART, NONE
    }

    private Major major;
    private Region region;
    private Hobby hobby;
    private String[] choice;


    /**
     * default constructor
     * 
     * @param a
     *            Major
     * @param b
     *            Region
     * @param c
     *            Hobby
     */
    public Student(Major a, Region b, Hobby c) {
        setMajor(a);
        setRegion(b);
        setHobby(c);
        choice = new String[500];
    }


    /**
     * @return the major
     */
    public Major getMajor() {
        return major;
    }


    /**
     * @param major
     *            the major to set
     */
    public void setMajor(Major major) {
        this.major = major;
    }


    /**
     * @return the region
     */
    public Region getRegion() {
        return region;
    }


    /**
     * @param region
     *            the region to set
     */
    public void setRegion(Region region) {
        this.region = region;
    }


    /**
     * @return the hobby
     */
    public Hobby getHobby() {
        return hobby;
    }


    /**
     * @param hobby
     *            the hobby to set
     */
    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }


    /**
     * @return the choice
     */
    public String[] getChoice() {
        return choice;
    }


    /**
     * @param choice
     *            the choice to set
     */
    public void setChoice(String[] choice) {
        this.choice = choice;
    }


    /**
     * @return if choice is empty
     */
    public int numOfChoice() {
        int result = 0;
        for (String every : getChoice()) {
            if (every != null) {
                result++;
            }
        }
        return result;
    }


    /**
     * @return if choice is empty
     */
    public boolean isEmptyChoice() {
        return numOfChoice() == 0;
    }


    /**
     * @return return the string
     */
    public String toString() {
        StringBuilder c = new StringBuilder();
        c.append("[");
        String info = String.valueOf(this.getMajor()) + ", " + String.valueOf(
            this.getRegion()) + ", " + String.valueOf(this.getHobby());
        info = String.format("%1$-20s", info);
        c.append(info);
        c.append("  ===  ");
        for (int i = 0; i < numOfChoice(); i++) {
            String tianjiao2 = getChoice()[i];
            tianjiao2 = String.format("%1$-5s", tianjiao2);
            c.append(tianjiao2);
            if (i != getChoice().length - 1) {
                c.append(", ");
            }
        }
        c.append("]");
        return c.toString();
    }
}
