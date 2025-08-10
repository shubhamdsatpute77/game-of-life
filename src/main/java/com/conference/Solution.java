package com.conference;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static final double AVAILABLE_MINUTES_IN_DAY = 420.0;
    public static final int AVAILABLE_MINUTES_MORNING_SESSION = 180;
    public static final int AVAILABLE_MINUTES_AFTERNOON_SESSION = 240;
    public static final int START_HOUR_OF_DAY = 9;
    public static final int MINUTES_IN_HOUR = 60;

    public static void main(String[] args) {
        List<Conference> conferences = List.of(
                new Conference("Writing Fast Tests Against Enterprise Rails", 60),
                new Conference("Overdoing it in Python", 45),
                new Conference("Lua for the Masses", 30),
                new Conference("Ruby Errors from Mismatched Gem Versions", 45),
                new Conference("Common Ruby Errors", 45),
                new Conference("Rails for Python Developers", 5),
                new Conference("Communicating Over Distance", 60),
                new Conference("Accounting-Driven Development", 45),
                new Conference("Woah", 30),
                new Conference("Sit Down and Write", 30),
                new Conference("Pair Programming vs Noise", 45),
                new Conference("Rails Magic", 60),
                new Conference("Ruby on Rails: Why We Should Move On", 60),
                new Conference("Clojure Ate Scala (on my project)", 45),
                new Conference("Programming in the Boondocks of Seattle", 30),
                new Conference("Ruby vs. Clojure for Back-End Development", 30),
                new Conference("Ruby on Rails Legacy App Maintenance", 60),
                new Conference("A World Without HackerNews", 30),
                new Conference("User Interface CSS in Rails Apps", 30)
        );

        List<List<Conference>> allTracks = getAllConferenceTracks(conferences);
        printAllTracks(allTracks);

    }

    private static List<List<Conference>> getAllConferenceTracks(List<Conference> conferences) {
        List<List<Conference>> allTracks = new ArrayList<>();
        int totalTracks = getTotalTracksCount(conferences);
        for (int track = 0; track < totalTracks; track++) {
            List<Conference> conferenceTrack = new ArrayList<>();

            List<Conference> morning = getConferences(conferences, new ArrayList<>(), AVAILABLE_MINUTES_MORNING_SESSION, 0);
            conferenceTrack.addAll(morning);
            morning.forEach(conf -> conf.setBooked(true));

            conferenceTrack.add(new Conference("Lunch", 60));

            List<Conference> afternoon = getConferences(conferences, new ArrayList<>(), AVAILABLE_MINUTES_AFTERNOON_SESSION, 0);
            conferenceTrack.addAll(afternoon);
            afternoon.forEach(conf -> conf.setBooked(true));

            conferenceTrack.add(new Conference("Networking Event", 0));

            allTracks.add(conferenceTrack);
        }
        return allTracks;
    }

    private static int getTotalTracksCount(List<Conference> conferences) {
        int totalMinutes = conferences.stream().mapToInt(Conference::getMinutes).sum();
        return (int) Math.ceil(totalMinutes / AVAILABLE_MINUTES_IN_DAY);
    }

    private static List<Conference> getConferences(List<Conference> conferences,
                                                   List<Conference> result,
                                                   int targetMinutes,
                                                   int idx) {
        if (targetMinutes == 0) {
            return result;
        } else if (idx >= conferences.size() || targetMinutes < 0) {
            return new ArrayList<>();
        }

        List<Conference> result1 = new ArrayList<>(result);
        if (!conferences.get(idx).isBooked()) {
            result1.add(conferences.get(idx));
            result1 = getConferences(conferences, result1, targetMinutes - conferences.get(idx).getMinutes(), idx + 1);
        }
        List<Conference> result2 = new ArrayList<>(result);
        result2 = getConferences(conferences, result2, targetMinutes, idx + 1);

        return result1.size() > result2.size() ? result1 : result2;
    }

    private static void printAllTracks(List<List<Conference>> combinations) {
        System.out.println("----------------------------------------------------------------------------------------");
        for (List<Conference> trackList : combinations) {
            System.out.println("############# Track " + (combinations.indexOf(trackList) + 1) + " #############");
            int trackMinutes = START_HOUR_OF_DAY * MINUTES_IN_HOUR;
            for (Conference conference : trackList) {
                System.out.println(getTimeString(trackMinutes) + " " + conference.getTitle() + " (" + conference.getMinutes() + " minutes)");
                trackMinutes += conference.getMinutes();
            }
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }

    private static String getTimeString(int minutes) {
        int hour24Format = minutes / MINUTES_IN_HOUR;
        String hour12FormatString = String.format("%02d", (hour24Format  > 12 ? hour24Format - 12 : hour24Format));
        int hourMinutes = minutes % MINUTES_IN_HOUR;
        String hourMinutesString = String.format("%02d", hourMinutes);
        return hour24Format  > 12
                ? hour12FormatString + ":" + hourMinutesString + "PM"
                : hour12FormatString + ":" + hourMinutesString + "AM";
    }
}
