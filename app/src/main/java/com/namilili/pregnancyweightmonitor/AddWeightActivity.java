package com.namilili.pregnancyweightmonitor;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddWeightActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private PregnancyWeightDBHelper dbHelper;
    private EditText etDate;
    private EditText etWeight;
    private Button btnSubmit;
    private TextView tvBMI;
    private String BMI;
    private DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_weight);
        dbHelper = new PregnancyWeightDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);

        etDate =(EditText) this.findViewById(R.id.date);
        etWeight =(EditText) this.findViewById(R.id.weight);
        btnSubmit = (Button) this.findViewById(R.id.add_weight);
        tvBMI = (TextView) this.findViewById(R.id.bmi);
      //  etDate.setEnabled(false);

        BMI = SharedPreferencesEdit.querySharedPreferencesString(getApplicationContext(),SharedPreferencesEdit.SP_BMI);
        tvBMI.setText(BMI);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dbHelper.insert(etDate.getText().toString(),etWeight.getText().toString());
                    etDate.setText("");
                    etWeight.setText("");
                }
                catch (SQLiteException e)
                {
                    e.printStackTrace();
                }
            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
