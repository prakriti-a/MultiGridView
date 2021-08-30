package com.prakriti.mutigridview;

import java.util.ArrayList;

public class HGVData {

    // defining info for HGVs
    public String heroes[] = new String[]{"IRON MAN", "CAPTAIN AMERICA", "SPIDERMAN", "THOR", "HULK", "BLACK WIDOW", "HAWKEYE"};
    public int heroImages[] = {R.drawable.ironman, R.drawable.captainamerica, R.drawable.spiderman, R.drawable.thor, R.drawable.hulk,
            R.drawable.blackwidow, R.drawable.hawkeye};

    public String shows[] = new String[]{"THIS IS US", "SUPERNATURAL", "MODERN FAMILY", "FRIENDS", "CRIMINAL MINDS", "COMMUNITY",
            "BROOKLYN 99"};
    public int showImages[] = {R.drawable.thisisus, R.drawable.supernatural, R.drawable.modernfamily, R.drawable.friends,
            R.drawable.criminalminds, R.drawable.community, R.drawable.b99};

    public String channels[] = new String[]{"HBO MAX", "DISNEY+ HOTSTAR", "HULU", "NETFLIX", "PRIME VIDEO", "ROKU", "YOUTUBE"};
    public int channelImages[] = {R.drawable.hbo, R.drawable.hotstar, R.drawable.hulu, R.drawable.netflix, R.drawable.prime,
            R.drawable.roku, R.drawable.youtube};

    ArrayList<int[]> imagesArrayList = new ArrayList<>();
    ArrayList<String[]> namesArrayList = new ArrayList<>();

    public HGVData() {
        namesArrayList.clear();
        namesArrayList.add(heroes);
        namesArrayList.add(shows);
        namesArrayList.add(channels);

        imagesArrayList.clear();
        imagesArrayList.add(heroImages);
        imagesArrayList.add(showImages);
        imagesArrayList.add(channelImages);
    }

    public int getHGVCount() {
        return namesArrayList.size();
    }

    public ArrayList<int[]> getImagesArrayList() {
        return imagesArrayList;
    }

    public ArrayList<String[]> getNamesArrayList() {
        return namesArrayList;
    }
}
