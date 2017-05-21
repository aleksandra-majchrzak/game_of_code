package com.example.gameofcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView charactersListView;
    ArrayAdapter adapter;

    List<Character> charactersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents() {
        charactersList = Character.listAll();

        charactersListView = (ListView) findViewById(R.id.characters_listView);
        adapter = new ArrayAdapter<Character>(this, R.layout.character_row, charactersList) {
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Character currentCharacter = this.getItem(position);

                if (convertView == null)
                    convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.character_row, parent, false);

                TextView nameTextView = (TextView) convertView.findViewById(R.id.character_name_textView);
                nameTextView.setText(currentCharacter.getName());

                ImageView photoImageView = (ImageView) convertView.findViewById(R.id.character_imageView);
                photoImageView.setImageBitmap(PhotoLoader.loadBitmapFromAssets(MainActivity.this, currentCharacter.getPhotoPath()));

                return convertView;
            }
        };

        charactersListView.setAdapter(adapter);

        charactersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
                intent.putExtra("character_id", charactersList.get(position).getId());

                startActivity(intent);
            }
        });
    }
}
