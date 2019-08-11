package com.example.android.miwok;

public class Word {

    private String miwokTranslation;
    private String englishTranslation;
    private int imageID = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int audioID;

   public Word(String miwok, String english, int image,int audio){
       miwokTranslation = miwok;
       englishTranslation = english;
       imageID = image;
       audioID = audio;
   }

   public Word(String miwok,String english, int audio){
       miwokTranslation = miwok;
       englishTranslation = english;
       audioID = audio;
   }

    public int getAudioID() {
        return audioID;
    }

    public String getMiwok(){
        return miwokTranslation;
    }

    public String getEnglish() {
        return englishTranslation;
    }

    public int getImageID() {
        return imageID;
    }

    public boolean hasImage(){
       return imageID != NO_IMAGE_PROVIDED;
    }
}
