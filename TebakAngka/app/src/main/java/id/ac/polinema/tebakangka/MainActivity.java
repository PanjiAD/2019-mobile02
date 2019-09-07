package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini

	private int number, random;
	private  String inputField;
	private EditText inputNumber;
	private Button guessButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO: bind layout di sini
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inputNumber = findViewById(R.id.number_input);
		guessButton = findViewById(R.id.guess_button);
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		random = new Random().nextInt(100) + 1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka

		inputField = inputNumber.getText().toString();

		if (inputField.isEmpty()){
			Toast.makeText(this, "Masukkan kosong", Toast.LENGTH_SHORT).show();
		}
		else {
			number = Integer.parseInt(inputField);

			if (number > 100){
				Toast.makeText(this, "Tebakan anda melampaui batas", Toast.LENGTH_SHORT).show();
			}
			else {
				if (number < random) {
					Toast.makeText(this, "Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
				} else if (number > random) {
					Toast.makeText(this, "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
				} else{
					Toast.makeText(this, "Tebakan anda benar!", Toast.LENGTH_SHORT).show();
					guessButton.setEnabled(false);
				}
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		initRandomNumber();
		guessButton.setEnabled(true);
		inputNumber.setText(null);
	}
}
