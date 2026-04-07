package Improv;

import java.util.ArrayList;
import java.util.Arrays;

public class RandomKey {
    // 24 Major and Minor Keys
    ArrayList<String> allKeys = new ArrayList<>(Arrays.asList(
        "C Major", "G Major", "D Major", "A Major", "E Major", "B Major", 
        "F# Major", "C# Major", "F Major", "Bb Major", "Eb Major", "Ab Major",
        "A Minor", "E Minor", "B Minor", "F# Minor", "C# Minor", "G# Minor", 
        "D# Minor", "A# Minor", "D Minor", "G Minor", "C Minor", "F Minor"
    ));
    public String getRandomKey() {
        int index = (int) (Math.random() * allKeys.size());
        return allKeys.get(index);
    }
}
