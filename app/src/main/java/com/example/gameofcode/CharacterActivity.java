package com.example.gameofcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CharacterActivity extends AppCompatActivity {

    Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        initComponents();
    }

    private void initComponents() {

        final long characterId = getIntent().getLongExtra("character_id", 0);
        character = Character.findById(Character.class, characterId);

        TextView nameTextView = (TextView) findViewById(R.id.name_textView);
        TextView genderTextView = (TextView) findViewById(R.id.gender_textView);
        TextView houseTextView = (TextView) findViewById(R.id.house_textView);
        TextView cultureTextView = (TextView) findViewById(R.id.culture_textView);
        final SwitchCompat isAliveSwitch = (SwitchCompat) findViewById(R.id.is_alive_switch);
        Button saveButton = (Button) findViewById(R.id.save_button);

        nameTextView.setText(character.getName());
        genderTextView.setText(character.getGender());
        houseTextView.setText(character.getHouse());
        cultureTextView.setText(character.getCulture());
        isAliveSwitch.setChecked(character.isAlive());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character.setAlive(isAliveSwitch.isChecked());
                character.save();
                CharacterActivity.this.finish();
            }
        });
    }
}
