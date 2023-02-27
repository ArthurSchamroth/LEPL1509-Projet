package be.lepl1509group13.workoutwarrior;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button open_program_suggestion_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        open_program_suggestion_btn = findViewById(R.id.daily_program);
        open_program_suggestion_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_program_suggestion();
            }
        });
    }

    public void open_program_suggestion() {
        Intent intent = new Intent(this, Activity_program_suggestion.class);
        startActivity(intent);
    }


}