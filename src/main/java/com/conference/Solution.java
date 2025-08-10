package com.conference;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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

        List<List<Conference>> result = findCombinations(conferences);
        printCombination(result);

    }

    private static List<List<Conference>> findCombinations(List<Conference> conferences) {
        List<List<Conference>> combinations = new ArrayList<>();
        int totalTracks = getTotalTracks(conferences);
        for (int track = 0; track < totalTracks; track++) {
            List<Conference> trackConferences = new ArrayList<>();

            List<Conference> morning = getConferences(conferences, new ArrayList<>(), 180, 0);
            trackConferences.addAll(morning);
            morning.forEach(conf -> conf.setBooked(true));

            trackConferences.add(new Conference("Lunch", 60));

            List<Conference> afternoon = getConferences(conferences, new ArrayList<>(), 240, 0);
            trackConferences.addAll(afternoon);
            afternoon.forEach(conf -> conf.setBooked(true));

            combinations.add(trackConferences);
        }
        return combinations;
    }

    private static int getTotalTracks(List<Conference> conferences) {
        int totalMinutes = conferences.stream().mapToInt(Conference::getMinutes).sum();
        return (int) Math.ceil(totalMinutes / 420.0);
    }

    private static List<Conference> getConferences(List<Conference> conferences,
                                                   List<Conference> result,
                                                   int targetMinutes,
                                                   int idx) {
        if (targetMinutes == 0) {
            return result;
        }
        if (idx >= conferences.size() || targetMinutes < 0) {
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

    private static void printCombination(List<List<Conference>> combinations) {
        System.out.println("----------------------------------------------------------------------------------------");
        for (List<Conference> trackList : combinations) {
            System.out.println("############# Track " + (combinations.indexOf(trackList) + 1) + " #############");
            int trackMinutes = 9*60;
            for (Conference conference : trackList) {
                System.out.println((trackMinutes / 60) + ":" + (trackMinutes % 60) + " " + conference.getTitle() + " (" + conference.getMinutes() + " minutes)");
                trackMinutes += conference.getMinutes();
            }
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Total time: " + trackList.stream().mapToInt(Conference::getMinutes).sum() + " minutes");
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }
}
