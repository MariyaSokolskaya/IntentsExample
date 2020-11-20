package com.example.lifecircle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText numbers;
    Button plus, minus, multy, divide, result;
    double a, b, c;
    char znak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Я родился!",Toast.LENGTH_SHORT).show();

        numbers = findViewById(R.id.numbers);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multy = findViewById(R.id.multy);
        divide = findViewById(R.id.divide);
        result = findViewById(R.id.result);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numA = numbers.getText().toString();
                if (numA.equals("") || numA == null)
                    b = 0;
                else
                    b = Double.parseDouble(numA);
                numbers.setText("");
                switch (znak){
                    case '+': c = a + b; break;
                    case '-': c = a - b; break;
                    case '*': c = a * b; break;
                    case '/':
                        if (b != 0)
                            c = a / b;
                        break;
                    default: c = 0;
                }
                numbers.setText(Double.valueOf(c).toString());
            }
        });
    }

    public void firstNum(View button){
        String numA = numbers.getText().toString();
        if (numA.equals("") || numA == null)
            a = 0;
        else
            a = Double.parseDouble(numA);
        numbers.setText("");
        switch (button.getId()){
            case R.id.plus:
                znak = '+'; break;
            case R.id.minus:
                znak = '-'; break;
            case R.id.multy:
                znak = '*'; break;
            case R.id.divide:
                znak = '/';
        }
        //String s = button.getTag().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.about_item:
                //TODO переход на AboutActivity
                break;
            case R.id.close_item:
                //TODO закрыть приложение
                break;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Я стартовала", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Я остановлена", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Убивают!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Я на паузе", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Я восстанавливаюсь (после паузы)", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Я восстанавливаюсь (после остановки)", Toast.LENGTH_SHORT).show();
    }
}
