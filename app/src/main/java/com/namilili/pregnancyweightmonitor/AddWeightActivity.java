package com.namilili.pregnancyweightmonitor;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddWeightActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private PregnancyWeightDBHelper dbHelper;
    private EditText etDate;
    private EditText etWeight;
    private Button btnSubmit;
    private TextView tvBMI;
    private String BMI;
    private DatePicker datePicker;
    private WeightListAdapter weightListAdapter;
    private ListView weightList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_weight);
        dbHelper = new PregnancyWeightDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);

        weightList = (ListView) this.findViewById(R.id.listWeight);
        etDate =(EditText) this.findViewById(R.id.date);
        etWeight =(EditText) this.findViewById(R.id.weight);
        btnSubmit = (Button) this.findViewById(R.id.add_weight);
        tvBMI = (TextView) this.findViewById(R.id.bmi);

        BMI = SharedPreferencesEdit.querySharedPreferencesString(getApplicationContext(),SharedPreferencesEdit.SP_BMI);
        tvBMI.setText(BMI);
        tvBMI.setClickable(true);

        initListView();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dbHelper.insert(etDate.getText().toString(),etWeight.getText().toString());
                    etDate.setText("");
                    etWeight.setText("");
                    etDate.hasFocus();
                    initListView();
                }
                catch (SQLiteException e)
                {
                    e.printStackTrace();
                }
            }
        });

        tvBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder normalDialog = new AlertDialog.Builder(AddWeightActivity.this);
                normalDialog.setTitle("计算BMI值");
                normalDialog.setMessage("是否重新计算BMI值?");
                normalDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(AddWeightActivity.this,BMIActivity.class));
                        finish();
                    }
                });
                normalDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                normalDialog.show();
            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    public  void initListView() {
        Cursor cursor;
        ArrayList<WeightItem> arrayList = new ArrayList<>();
        WeightItem weightItem;
        cursor = dbHelper.getAll("", "");

        for (int i=0;i<cursor.getCount();i++) {
            if (cursor.moveToNext()) {
                weightItem = new WeightItem();
                weightItem.setDate(cursor.getString(1));
                weightItem.setWeight(cursor.getString(2));
                arrayList.add(weightItem);
            }
        }

//        if (weightListAdapter == null) {
            weightListAdapter = new WeightListAdapter(this,arrayList);
            weightList.setAdapter(weightListAdapter);
            weightListAdapter.notifyDataSetChanged();
//        }
//        else
//        {
//
//        }
    }

}
