package com.example.fall.retrofit.response;

import java.util.List;

public class Faal {
    public String title;
    public String plainText;
    public String htmlText;
    public List<Verse> verses;

    public static class Verse {
        public String id;
        public int vOrder;
        public String text;
    }
}
