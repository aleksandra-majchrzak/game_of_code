package com.example.gameofcode;

import com.orm.SugarApp;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohru on 21.05.2017.
 */

public class GocApplication extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();

        if (Character.listAll().isEmpty()) {
            List<Character> characterList = new ArrayList<>();
            characterList.add(new Character("Jon Snow", "man", "Stark", "Northmen", true, "jon_snow"));
            characterList.add(new Character("Cersei Lannister", "woman", "Lannister", "Andal", true, "cersei_lannister"));
            characterList.add(new Character("Daenerys Targaryen", "moman", "Targaryen", "Valyrian", true, "daenerys_targaryen"));
            characterList.add(new Character("Joffrey Baratheon", "man", "Baratheon", "Andal", false, "joffrey_baratheon"));
            characterList.add(new Character("Margaery Tyrell", "woman", "Tyrell", "Andal", false, "margaery_tyrell"));
            characterList.add(new Character("Tyrion Lannister", "man", "Lannister", "Andal", true, "tyrion_lannister"));
            characterList.add(new Character("Theon Greyjoy", "man", "Greyjoy", "Ironborn", true, "theon_greyjoy"));
            characterList.add(new Character("Arya Stark", "woman", "Stark", "Northmen", true, "arya_stark"));
            SugarRecord.saveInTx(characterList);
        }
    }
}
