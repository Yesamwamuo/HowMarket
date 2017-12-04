package com.mannysight.howmarket.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by wamuo on 12/3/2017.
 */

@Entity(tableName = "word_table")
public class Word {
//    @PrimaryKey(autoGenerate = true)
//    private int id;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String word;

    public Word(String word) {

        this.word = word;
    }

    public String getWord() {
        return word;
    }


}
