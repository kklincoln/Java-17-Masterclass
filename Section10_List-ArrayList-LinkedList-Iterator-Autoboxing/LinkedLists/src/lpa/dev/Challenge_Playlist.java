package lpa.dev;

import java.util.ArrayList;
import java.util.LinkedList;

public class Challenge_Playlist {
    // ArrayList<Album> albums = new ArrayList<>();

// Album album = new Album("Stormbringer", "Deep Purple");
// album.addSong("Stormbringer", 4.6);
// album.addSong("Love don't mean a thing", 4.22);
// album.addSong("Holy man", 4.3);
// album.addSong("Hold on", 5.6);
// album.addSong("Lady double dealer", 3.21);
// album.addSong("You can't do it right", 6.23);
// album.addSong("High ball shooter", 4.27);
// album.addSong("The gypsy", 4.2);
// album.addSong("Soldier of fortune", 3.13);
// albums.add(album);

// album = new Album("For those about to rock", "AC/DC");
// album.addSong("For those about to rock", 5.44);
// album.addSong("I put the finger on you", 3.25);
// album.addSong("Lets go", 3.45);
// album.addSong("Inject the venom", 3.33);
// album.addSong("Snowballed", 4.51);
// album.addSong("Evil walks", 3.45);
// album.addSong("C.O.D.", 5.25);
// album.addSong("Breaking the rules", 5.32);
// album.addSong("Night of the long knives", 5.12);
// albums.add(album);

// LinkedList<Song> playList = new LinkedList<Song>();
// albums.get(0).addToPlayList("You can't do it right", playList);
// albums.get(0).addToPlayList("Holy man", playList);
// albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
// albums.get(0).addToPlayList(9, playList);
// albums.get(1).addToPlayList(3, playList);
// albums.get(1).addToPlayList(2, playList);
// albums.get(1).addToPlayList(24, playList);  // There is no track 24

        // write code here
        // It has three fields, two Strings called name and artist, and an ArrayList that holds objects of type Song called songs.
        private String name;
        private String artist;
        private ArrayList<Song> songs;


        //A constructor that accepts two Strings (name of the album and artist). It initialises the fields and instantiates songs.
        public Challenge_Playlist(String name, String artist){
            this.name = name;
            this.artist = artist;
            this.songs = new ArrayList<>();
        }

        // -  And three methods, they are:
        //     -  addSong(), has two parameters of type String (title of song), double (duration of song) and returns a boolean. Returns true if the song was added successfully or false otherwise.
        public boolean addSong(String title, double duration){
            //check if song already exists
            if (findSong(title) == null){ //if song not found;
                songs.add(new Song(title, duration)); //call the constructor to create a new Song instance and add to the ArrayList
                return true;
            }
            return false;
        }

        //     -  findSong(), has one parameter of type String (title of song) and returns a Song. Returns the Song if it exists, null if it doesn't exists.
        private Song findSong(String title){
            for (Song checkedSong : songs){ //for song within ArrayList of songs,
                if(checkedSong.getTitle().equalsIgnoreCase(title)){//if the element title = argument title, return the song
                    return checkedSong;
                }
            }
            return null;
        }

        //     -  addToPlayList(), has two parameters of type int (track number of song in album) and LinkedList (the playlist) that holds objects
        // of type Song, and returns a boolean. Returns true if it exists and it was added successfully using the track number, or false otherwise.
        public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
            int index = trackNumber - 1;
            if((index >= 0) && (index <= songs.size())){
                playlist.add(songs.get(index));
                return true;
            }
            return false;
        }


        //     -  addToPlayList(), has two parameters of type String (title of song) and LinkedList (the playlist) that holds objects of type Song, and returns a boolean. Returns true if it exists and it was added successfully using the name of the song, or false otherwise.
        public boolean addToPlayList(String title, LinkedList<Song> playlist){
            Song checkedSong = findSong(title);
            if(checkedSong != null){
                playlist.add(checkedSong);
                return true;
            }
            return false;
        }

    }

class Song {
    // write code here
    //  -   It has two fields, a String called title and a double called duration.
    private String title;
    private double duration;

    // -  A constructor that accepts a String (title of the song) and a double (duration of the song). It initialises title and duration.
    public Song(String title, double duration){
        this.title=title;
        this.duration=duration;
    }

    // -  And two methods, they are:
    //     -  getTitle(), getter for title.
    public String getTitle(){
        return title;
    }
    //     -  toString(), Songs overriding toString method. Returns a String in the following format: "title: duration"
    @Override
    public String toString(){
        return title + ": " + duration;
    }


}
