package prj5;

import java.awt.Color;
import java.io.FileNotFoundException;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

public class GUIMusicWindow {
    private static int BAR_HEIGHT = 10;
    private boolean group;
    private boolean sortStyle;
    private int multiSort;
    private int titleSort;
    private int index;
    private boolean started;
    private String clickedTop;
    private Window myWindow;
    private CoreController myMusic;
    private LinkedList<Shape> legendItems;
    private LinkedList<Shape> bars;
    private Shape startingInst;

    
    public GUIMusicWindow(String fileNamePeople, String fileNameSongs)
        throws FileNotFoundException {
        myWindow = new Window();
        myWindow.setTitle("Music Preference Visualization");
        legendItems = new LinkedList<Shape>();
        bars = new LinkedList<Shape>();
        group = false;
        sortStyle = false;
        started = false;
        multiSort = 0;
        titleSort = 0;
        index = 0;
        myMusic = new CoreController();
        
        // Buttons
        Button prev = new Button("← Prev");
        myWindow.addButton(prev, WindowSide.NORTH);
        prev.onClick(this);
        Button artist = new Button("Sort by Artist Name");
        myWindow.addButton(artist, WindowSide.NORTH);
        artist.onClick(this);
        Button song = new Button("Sort by Song Name");
        myWindow.addButton(song, WindowSide.NORTH);
        song.onClick(this);
        Button year = new Button("Sort by Release Year");
        myWindow.addButton(year, WindowSide.NORTH);
        year.onClick(this);
        Button genre = new Button("Sort by Genre");
        myWindow.addButton(genre, WindowSide.NORTH);
        genre.onClick(this);
        Button next = new Button("Next →");
        myWindow.addButton(next, WindowSide.NORTH);
        next.onClick(this);
        Button hobby = new Button("Represent Hobby");
        myWindow.addButton(hobby, WindowSide.SOUTH);
        hobby.onClick(this);
        Button major = new Button("Represent Major");
        myWindow.addButton(major, WindowSide.SOUTH);
        major.onClick(this);
        Button region = new Button("Represent Region");
        myWindow.addButton(region, WindowSide.SOUTH);
        region.onClick(this);
        Button quit = new Button("Quit");
        myWindow.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this);
    }


    public Window getWindow() {
        return myWindow;
    }


    public void clickedQuit(Button button) {
        System.exit(0);
    }


    public void clickedNext(Button button) {
        if (started) {
            clearBars();
        }
    }


    public void clickedPrev(Button button) {
        if (started) {
            clearBars();
            index -= 18;
            if (index < 0) {
                index = index + myMusic.getMusicList().size();
            }
            barsSetUp(multiSort);
        }
    }

    /**
     * Controls the represent major button
     * 
     * @param button
     */
    public void clickedRepresentMajor(Button button) {
        group = true;
        clickedTop = "Major";
        multiSort = 2;
        index = 0;
        if (sortStyle && !started) {
            instanctiate();
        }
        if (started) {
            legendSetUp();
            clearBars();
            barsSetUp(multiSort);
        }
    }

    /**
     * Controls the represent region button
     * 
     * @param button
     */
    public void clickedRepresentRegion(Button button) {
        group = true;
        clickedTop = "Region";
        multiSort = 3;
        index = 0;
        if (sortStyle && !started) {
            instanctiate();
        }
        if (started) {
            legendSetUp();
            clearBars();
            barsSetUp(multiSort);
        }
    }


    public void clickedRepresentHobby(Button button) {
        group = true;
        clickedTop = "Hobby";
        multiSort = 1;
        index = 0;
        if (sortStyle && !started) {
            instanctiate();
        }
        if (started) {
            legendSetUp();
            clearBars();
            barsSetUp(multiSort);
        }
    }


    public void clickedSortbySongName(Button button) {
        sortStyle = true;
        titleSort = 1;
        index = 0;
        instanctiate();
        myMusic.sortByTitle();
        ;
        if (started) {
            clearBars();
            barsSetUp(multiSort);
        }
    }

    
    public void clickedSortbyGenre(Button button) {
        sortStyle = true;
        titleSort = 2;
        index = 0;
        instanctiate();
        myMusic.sortByGenre();
        if (started) {
            clearBars();
            barsSetUp(multiSort);
        }
    }


    public void clickedSortbyArtistName(Button button) {
        sortStyle = true;
        titleSort = 1;
        index = 0;
        instanctiate();
        myMusic.sortByArtist();
        if (started) {
            clearBars();
            barsSetUp(multiSort);
        }
    }


    public void clickedSortbyReleaseYear(Button button) {
        sortStyle = true;
        titleSort = 0;
        index = 0;
        instanctiate();
        myMusic.sortByDate();
        if (started) {
            clearBars();
            barsSetUp(multiSort);
        }
    }


    private void instanctiate() {
        if (group && sortStyle && !started) {
            // Glyph
            Shape bar = new Shape(105, 60, 4, 40, Color.BLACK);
            myWindow.addShape(bar);
            bar = new Shape(315, 60, 4, 40, Color.BLACK);
            myWindow.addShape(bar);
            bar = new Shape(525, 60, 4, 40, Color.BLACK);
            myWindow.addShape(bar);

            bar = new Shape(105, 150, 4, 40, Color.BLACK);
            myWindow.addShape(bar);
            bar = new Shape(315, 150, 4, 40, Color.BLACK);
            myWindow.addShape(bar);
            bar = new Shape(525, 150, 4, 40, Color.BLACK);
            myWindow.addShape(bar);

            bar = new Shape(105, 240, 4, 40, Color.BLACK);
            myWindow.addShape(bar);
            bar = new Shape(315, 240, 4, 40, Color.BLACK);
            myWindow.addShape(bar);
            bar = new Shape(525, 240, 4, 40, Color.BLACK);
            myWindow.addShape(bar);

            Shape title = new TextShape(myWindow.getGraphPanelWidth() - 100,
                160, "Song Title");
            myWindow.addShape(title);
            title.setBackgroundColor(Color.WHITE);

            bar = new Shape(myWindow.getGraphPanelWidth() - 65, 175, 4, 30,
                Color.BLACK);
            myWindow.addShape(bar);

            Shape heard = new TextShape(myWindow.getGraphPanelWidth() - 62, 180,
                "liked");
            myWindow.addShape(heard);
            heard.setBackgroundColor(Color.WHITE);
            Shape liked = new TextShape(myWindow.getGraphPanelWidth() - 106,
                180, "heard");
            myWindow.addShape(liked);
            liked.setBackgroundColor(Color.WHITE);

            Shape legendBottom1 = new Shape(myWindow.getGraphPanelWidth() - 3,
                15, 3, 200, Color.BLACK); 
            
            myWindow.addShape(legendBottom1);

            Shape legendOver1 = new Shape(myWindow.getGraphPanelWidth() - 113,
                15, 113, 3, Color.BLACK);
            myWindow.addShape(legendOver1);

            Shape legendBottom2 = new Shape(myWindow.getGraphPanelWidth() - 113,
                15, 3, 203, Color.BLACK);
            myWindow.addShape(legendBottom2);

            Shape legendOver2 = new Shape(myWindow.getGraphPanelWidth() - 113,
                215, 113, 3, Color.BLACK);
            myWindow.addShape(legendOver2);

            legendSetUp();

            myWindow.removeShape(startingInst);

            started = true;
        }
    }


    private void legendSetUp() {
        if (started) {
            clearLegend();
        }

        Shape myTextLegend = new TextShape(myWindow.getGraphPanelWidth() - 111,
            20, clickedTop + " Legend");
        legendItems.add(myTextLegend);
        myWindow.addShape(myTextLegend);
        myTextLegend.setBackgroundColor(Color.WHITE);
        Shape thing1;
        Shape thing2;
        Shape thing3;
        Shape thing4;

        if (clickedTop.equals("Hobby")) {
            thing1 = new TextShape(myWindow.getGraphPanelWidth() - 111, 40,
                "Read", Color.MAGENTA);
            thing2 = new TextShape(myWindow.getGraphPanelWidth() - 111, 60,
                "Art", Color.BLUE);
            thing3 = new TextShape(myWindow.getGraphPanelWidth() - 111, 80,
                "Sport", Color.ORANGE);
            thing4 = new TextShape(myWindow.getGraphPanelWidth() - 111, 100,
                "Music", Color.GREEN);
        }
        else if (clickedTop.equals("Major")) {
            thing1 = new TextShape(myWindow.getGraphPanelWidth() - 111, 40,
                "Computer", Color.MAGENTA);
            Shape thing12 = new TextShape(myWindow.getGraphPanelWidth() - 111,
                60, "Science", Color.MAGENTA);
            myWindow.addShape(thing12);
            thing12.setBackgroundColor(Color.WHITE);
            legendItems.add(thing12);
            thing2 = new TextShape(myWindow.getGraphPanelWidth() - 111, 80,
                "Other", Color.BLUE);
            Shape thing22 = new TextShape(myWindow.getGraphPanelWidth() - 111,
                100, "Engineering", Color.BLUE);
            myWindow.addShape(thing22);
            thing22.setBackgroundColor(Color.WHITE);
            legendItems.add(thing22);
            thing3 = new TextShape(myWindow.getGraphPanelWidth() - 111, 120,
                "Math or CMDA", Color.ORANGE);
            thing4 = new TextShape(myWindow.getGraphPanelWidth() - 111, 140,
                "Other", Color.GREEN);
        }
        else {
            thing1 = new TextShape(myWindow.getGraphPanelWidth() - 111, 40,
                "Northeast", Color.MAGENTA);
            thing2 = new TextShape(myWindow.getGraphPanelWidth() - 111, 60,
                "Southeast", Color.BLUE);
            thing3 = new TextShape(myWindow.getGraphPanelWidth() - 111, 80,
                "Other US", Color.ORANGE);
            Shape thing12 = new TextShape(myWindow.getGraphPanelWidth() - 111,
                100, "Region", Color.ORANGE);
            myWindow.addShape(thing12);
            thing12.setBackgroundColor(Color.WHITE);
            legendItems.add(thing12);
            thing4 = new TextShape(myWindow.getGraphPanelWidth() - 111, 120,
                "Outside US", Color.GREEN);
        }
        myWindow.addShape(thing1);
        thing1.setBackgroundColor(Color.WHITE);
        myWindow.addShape(thing2);
        thing2.setBackgroundColor(Color.WHITE);
        myWindow.addShape(thing3);
        thing3.setBackgroundColor(Color.WHITE);
        myWindow.addShape(thing4);
        thing4.setBackgroundColor(Color.WHITE);
        legendItems.add(thing1);
        legendItems.add(thing2);
        legendItems.add(thing3);
        legendItems.add(thing4);
    }
    
    private void clearLegend() {
        for (int i = 0; i < legendItems.size(); i++) {
            myWindow.removeShape(legendItems.get(i));
        }
        legendItems.clear();
    }


    private void clearBars() {
        for (int i = 0; i < bars.size(); i++) {
            myWindow.removeShape(bars.get(i));
        }
        bars.clear();
    }


    private void barsSetUp(int mult) {
        int x = 1;
        int y = 1;
        for (int i = 0; i < 9; i++) {
            setGraph(myMusic.getMusicList().get(index).percentHeard(), myMusic
                .getMusicList().get(index).percentLiked(), mult, x, y, myMusic
                    .getMusicList().get(index));
            x = (x + 1) % 4;
            if (x == 0) {
                y++;
                x++;
            }
            index = (index + 1) % myMusic.getMusicList().size();
        }
    }


    private void setGraph(
        int[] heard,
        int[] liked,
        int sorted,
        int x,
        int y,
        Music song) {
        x = 210 * (x - 1) + 105;
        y = 90 * (y - 1) + 90;
        Shape bar11 = new Shape(x - heard[1 * sorted], y - 30, heard[1
            * sorted], BAR_HEIGHT, Color.MAGENTA);
        myWindow.addShape(bar11);
        bars.add(bar11);
        Shape bar12 = new Shape(x + 4, y - 30, liked[1 * sorted],
            BAR_HEIGHT, Color.MAGENTA);
        myWindow.addShape(bar12);
        bars.add(bar12);
        Shape bar21 = new Shape(x - heard[2 * sorted], y - 20, heard[2
            * sorted], BAR_HEIGHT, Color.BLUE);
        myWindow.addShape(bar21);
        bars.add(bar21);
        Shape bar22 = new Shape(x + 4, y - 20, liked[2 * sorted],
            BAR_HEIGHT, Color.BLUE);
        myWindow.addShape(bar22);
        bars.add(bar22);
        Shape bar31 = new Shape(x - heard[3 * sorted], y - 10, heard[3
            * sorted], BAR_HEIGHT, Color.ORANGE);
        myWindow.addShape(bar31);
        bars.add(bar31);
        Shape bar32 = new Shape(x + 4, y - 10, liked[3 * sorted],
            BAR_HEIGHT, Color.ORANGE);
        myWindow.addShape(bar32);
        bars.add(bar32);
        Shape bar41 = new Shape(x - heard[4 * sorted], y, heard[4
            * sorted], BAR_HEIGHT, Color.GREEN);
        myWindow.addShape(bar41);
        bars.add(bar41);
        Shape bar42 = new Shape(x + 4, y, liked[4 * sorted], BAR_HEIGHT,
            Color.GREEN);
        myWindow.addShape(bar42);
        bars.add(bar42);

        String title = song.getTitle();
        if (title.length() > 25) {
            String title2 = title.substring(21);
            title = title.substring(0, 21);
            Shape songTitle = new TextShape(x - 100, y - 80, title);
            myWindow.addShape(songTitle);
            songTitle.setBackgroundColor(Color.WHITE);
            bars.add(songTitle);
            Shape songTitle2 = new TextShape(x - 100, y - 65, title2);
            myWindow.addShape(songTitle2);
            songTitle2.setBackgroundColor(Color.WHITE);
            bars.add(songTitle2);
        }
        else {
            Shape songTitle = new TextShape(x - 100, y - 65, song.getTitle());
            myWindow.addShape(songTitle);
            songTitle.setBackgroundColor(Color.WHITE);
            bars.add(songTitle);
        }
        if (titleSort == 1) {
            Shape songAuthor = new TextShape(x - 100, y - 50, "by, " + song
                .getArtist());
            myWindow.addShape(songAuthor);
            songAuthor.setBackgroundColor(Color.WHITE);
            bars.add(songAuthor);
        }
        else if (titleSort == 2) {
            Shape songAuthor = new TextShape(x - 100, y - 50, "Genre: " + song
                .getGenre());
            myWindow.addShape(songAuthor);
            songAuthor.setBackgroundColor(Color.WHITE);
            bars.add(songAuthor);
        }
        else {
            Shape songAuthor = new TextShape(x - 100, y - 50, "Released: "
                + song.getDate());
            myWindow.addShape(songAuthor);
            songAuthor.setBackgroundColor(Color.WHITE);
            bars.add(songAuthor);
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        @SuppressWarnings("unused")
        GUIMusicWindow window;
        if(args.length > 0) {
            window = new GUIMusicWindow(args[0], args[1]);
        }
        else {
            window = new GUIMusicWindow("MusicSurveyData.csv","SongList.csv");
        }
        
    }
}
