package com.example.allexercises;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TD1ExA2Activity extends AppCompatActivity {

    private EditText etEditorInput;
    private TextView tvPreview;
    private CheckBox cbBold, cbItalic, cbUnderline;
    private RadioGroup rgCase, rgTextColor, rgBgColor;
    private Spinner spinnerSize;

    private final String[] sizes = {"14", "18", "22", "26", "30"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1_exa2);

        etEditorInput = findViewById(R.id.etEditorInput);
        tvPreview = findViewById(R.id.tvPreview);
        cbBold = findViewById(R.id.cbBold);
        cbItalic = findViewById(R.id.cbItalic);
        cbUnderline = findViewById(R.id.cbUnderline);
        rgCase = findViewById(R.id.rgCase);
        rgTextColor = findViewById(R.id.rgTextColor);
        rgBgColor = findViewById(R.id.rgBgColor);
        spinnerSize = findViewById(R.id.spinnerSize);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sizes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSize.setAdapter(adapter);

        etEditorInput.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) { updatePreview(); }
            @Override public void afterTextChanged(Editable s) {}
        });

        View.OnClickListener checkboxListener = v -> updatePreview();
        cbBold.setOnClickListener(checkboxListener);
        cbItalic.setOnClickListener(checkboxListener);
        cbUnderline.setOnClickListener(checkboxListener);

        rgCase.setOnCheckedChangeListener((group, checkedId) -> updatePreview());
        rgTextColor.setOnCheckedChangeListener((group, checkedId) -> updatePreview());
        rgBgColor.setOnCheckedChangeListener((group, checkedId) -> updatePreview());

        spinnerSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { updatePreview(); }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void updatePreview() {
        String baseText = etEditorInput.getText().toString();

        if (baseText.isEmpty()) {
            tvPreview.setText("Votre texte formatté apparaîtra ici.");
            return;
        }
        int checkedCase = rgCase.getCheckedRadioButtonId();
        if (checkedCase == R.id.rbMajuscule) {
            baseText = baseText.toUpperCase();
        } else if (checkedCase == R.id.rbMinuscule) {
            baseText = baseText.toLowerCase();
        }
        tvPreview.setText(baseText);

        int textStyle = Typeface.NORMAL;
        if (cbBold.isChecked() && cbItalic.isChecked()) {
            textStyle = Typeface.BOLD_ITALIC;
        } else if (cbBold.isChecked()) {
            textStyle = Typeface.BOLD;
        } else if (cbItalic.isChecked()) {
            textStyle = Typeface.ITALIC;
        }
        tvPreview.setTypeface(null, textStyle);

        if (cbUnderline.isChecked()) {
            tvPreview.setPaintFlags(tvPreview.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        } else {
            tvPreview.setPaintFlags(tvPreview.getPaintFlags() & (~Paint.UNDERLINE_TEXT_FLAG));
        }

        String selectedSize = spinnerSize.getSelectedItem().toString();
        tvPreview.setTextSize(TypedValue.COMPLEX_UNIT_SP, Float.parseFloat(selectedSize));

        int checkedTextColor = rgTextColor.getCheckedRadioButtonId();
        if (checkedTextColor == R.id.rbTextRed) {
            tvPreview.setTextColor(Color.RED);
        } else if (checkedTextColor == R.id.rbTextBlue) {
            tvPreview.setTextColor(Color.BLUE);
        } else {
            tvPreview.setTextColor(Color.BLACK);
        }

        int checkedBgColor = rgBgColor.getCheckedRadioButtonId();
        if (checkedBgColor == R.id.rbBgYellow) {
            tvPreview.setBackgroundColor(Color.parseColor("#FFF59D"));
        } else if (checkedBgColor == R.id.rbBgGray) {
            tvPreview.setBackgroundColor(Color.LTGRAY);
        } else {
            tvPreview.setBackgroundColor(Color.WHITE);
        }
    }
}