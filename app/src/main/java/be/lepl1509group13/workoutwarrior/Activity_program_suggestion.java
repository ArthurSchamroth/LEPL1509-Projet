package be.lepl1509group13.workoutwarrior;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_program_suggestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_suggestion);
        getSupportActionBar().hide();
    }

    public void open_popup(View v) {
        /**
         * Ouvre le pop-up souhaité
         */
        Button button = findViewById(R.id.button_ex1);
        button.setOnClickListener(v1 -> display_popup_content(1));
        Button button2 = findViewById(R.id.button_ex2);
        button2.setOnClickListener(v12 -> display_popup_content(2));
        Button button3 = findViewById(R.id.button_ex3);
        button3.setOnClickListener(v12 -> display_popup_content(3));
    }

    public void display_popup_content(int exercice) {
        /**
         * Affiche le contenu du pop-up (les détails) relatif à l'exercice
         */
        // Créer le pop-up
        AlertDialog.Builder builder = new AlertDialog.Builder(Activity_program_suggestion.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.exercice_details_pop_up, null);
        builder.setView(dialogView);

        // Récupérer le nom et l'image pour les changer en fonction du bouton appuyé
        TextView exercice_name = dialogView.findViewById(R.id.dvp_couche_barre_TextView);
        ImageView imageView = dialogView.findViewById(R.id.dvp_couche_barre);

        String[] details;

        // En fonction du bouton appuyé, modifier le contenu
        if (exercice == 1) {
            imageView.setImageResource(R.drawable.developpe_couche_barre);
            details = new String[]{"Muscles ciblés : pectoraux, triceps", "Répétitions : 4x10", "Repos : 1 min"};
        } else if (exercice == 2) {
            exercice_name.setText("Soulevé de terre");
            imageView.setImageResource(R.drawable.souleve_de_terre);
            details = new String[]{"Muscles ciblés : fessiers, ischio-jambiers, abdominaux, dorsaux, trapèzes", "Répétitions : 4x8", "Repos : 1 min 30"};
        } else {
            exercice_name.setText("Squat");
            imageView.setImageResource(R.drawable.squat);
            details = new String[]{"Muscles ciblés : quadriceps, ischio-jambiers, fessiers", "Répétitions : 3x10", "Repos : 1 min 30"};
        }

        // Définir le contenu de la ListView (pour les détails de l'exercice)
        ListView listView = dialogView.findViewById(R.id.details_exo);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, details);
        listView.setAdapter(adapter);

        AlertDialog dialog = builder.create();
        dialog.show();

        ImageView closeButton = dialogView.findViewById(R.id.close_btn);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fermer la pop-up
                dialog.dismiss();
            }
        });
    }
}
