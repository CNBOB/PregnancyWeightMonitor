package com.namilili.pregnancyweightmonitor;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddWeightActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private PregnancyWeightDBHelper dbHelper;
    private EditText etDate;
    private EditText etWeight;
    private Button btnSubmit;
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
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dbHelper.insert(etDate.getText().toString(),etWeight.getText().toString());
                }
                catch (SQLiteException e)
                {
                    e.printStackTrace();
                }
            }
        });

    }
}
