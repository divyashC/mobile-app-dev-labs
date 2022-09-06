package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button b_equal;
    private Button b_multiply;
    private Button b_divide;
    private Button b_add;
    private Button b_subtract;
    private Button b_clear;
    private Button b_dot;
    private Button b_percentage;
    private Button b_plus_minus;
    private TextView t_input;
    private TextView t_output;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '=';
    private final char EXTRA = '@';
    private final char MODULUS = '%';
    private char ACTION;
    private double val1 = Double.NaN;
    private double val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                t_input.setText(t_input.getText().toString() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                t_input.setText(t_input.getText().toString() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                t_input.setText(t_input.getText().toString() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                t_input.setText(t_input.getText().toString() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                t_input.setText(t_input.getText().toString() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                t_input.setText(t_input.getText().toString() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                t_input.setText(t_input.getText().toString() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                t_input.setText(t_input.getText().toString() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                t_input.setText(t_input.getText().toString() + "9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                t_input.setText(t_input.getText().toString() + "0");
            }
        });

        b_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                t_input.setText(t_input.getText().toString() + ".");
            }
        });

        b_percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t_input.getText().length() > 0) {
                    ACTION = MODULUS;
                    operation();
                    if (!ifReallyDecimal()) {
                        t_output.setText(val1 + "%");
                    } else {
                        t_output.setText((int) val1 + "%");
                    }
                    t_input.setText(null);
                } else {
                    t_output.setText("Error");
                }
            }
        });

        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t_input.getText().length() > 0) {
                    ACTION = ADDITION;
                    operation();
                    if (!ifReallyDecimal()) {
                        t_output.setText(val1 + "+");
                    } else {
                        t_output.setText((int) val1 + "+");
                    }
                    t_input.setText(null);
                } else {
                    t_output.setText("Error");
                }
            }
        });

        b_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t_input.getText().length() > 0) {
                    ACTION = SUBTRACTION;
                    operation();
                    if (t_input.getText().length() > 0)
                        if (!ifReallyDecimal()) {
                            t_output.setText(val1 + "-");
                        } else {
                            t_output.setText((int) val1 + "-");
                        }
                    t_input.setText(null);
                } else {
                    t_output.setText("Error");
                }
            }
        });

        b_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t_input.getText().length() > 0) {
                    ACTION = MULTIPLICATION;
                    operation();
                    if (!ifReallyDecimal()) {
                        t_output.setText(val1 + "×");
                    } else {
                        t_output.setText((int) val1 + "×");
                    }
                    t_input.setText(null);
                } else {
                    t_output.setText("Error");
                }
            }
        });

        b_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t_input.getText().length() > 0) {
                    ACTION = DIVISION;
                    operation();
                    if (ifReallyDecimal()) {
                        t_output.setText((int) val1 + "/");
                    } else {
                        t_output.setText(val1 + "/");
                    }
                    t_input.setText(null);
                } else {
                    t_output.setText("Error");
                }
            }
        });

        b_plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!t_output.getText().toString().isEmpty() || !t_input.getText().toString().isEmpty()) {
                    val1 = Double.parseDouble(t_input.getText().toString());
                    ACTION = EXTRA;
                    t_output.setText("-" + t_input.getText().toString());
                    t_input.setText("");
                } else {
                    t_output.setText("Error");
                }
            }
        });

        b_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t_input.getText().length() > 0) {
                    operation();
                    ACTION = EQU;
                    if (!ifReallyDecimal()) {
                        t_output.setText(/*t_output.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf(val1));
                    } else {
                        t_output.setText(/*t_output.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf((int) val1));
                    }
                    t_input.setText(null);
                } else {
                    t_output.setText("Error");
                }
            }
        });

        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t_input.getText().length() > 0) {
                    CharSequence name = t_input.getText().toString();
                    t_input.setText(name.subSequence(0, name.length() - 1));
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    t_input.setText("");
                    t_output.setText("");
                }
            }
        });

        // Empty text views on long click.
        b_clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                t_input.setText("");
                t_output.setText("");
                return true;
            }
        });
    }

    private void viewSetup() {
        b1 = findViewById(R.id.button_1);
        b2 = findViewById(R.id.button_2);
        b3 = findViewById(R.id.button_3);
        b4 = findViewById(R.id.button_4);
        b5 = findViewById(R.id.button_5);
        b6 = findViewById(R.id.button_6);
        b7 = findViewById(R.id.button_7);
        b8 = findViewById(R.id.button_8);
        b9 = findViewById(R.id.button_9);
        b0 = findViewById(R.id.button_0);
        b_equal = findViewById(R.id.button_equal);
        b_multiply = findViewById(R.id.button_multiply);
        b_divide = findViewById(R.id.button_divide);
        b_add = findViewById(R.id.button_add);
        b_subtract = findViewById(R.id.button_subtract);
        b_clear = findViewById(R.id.button_clear_ac);
        b_dot = findViewById(R.id.button_decimal);
        b_percentage = findViewById(R.id.button_percentage);
        b_plus_minus = findViewById(R.id.button_plus_minus);
        t_input = findViewById(R.id.input);
        t_output = findViewById(R.id.output);
    }

    private void operation() {
        if (!Double.isNaN(val1)) {
            if (t_output.getText().toString().charAt(0) == '-') {
                val1 = (-1) * val1;
            }
            val2 = Double.parseDouble(t_input.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EXTRA:
                    val1 = (-1) * val1;
                    break;
                case MODULUS:
                    val1 = val1 % val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(t_input.getText().toString());
        }
    }

    // Remove error message that is already written there.
    private void ifErrorOnOutput() {
        if (t_output.getText().toString().equals("Error")) {
            t_output.setText("");
        }
    }

    // Whether value if a double or not
    private boolean ifReallyDecimal() {
        return val1 == (int) val1;
    }

    private void noOperation() {
        String inputExpression = t_output.getText().toString();
        if (!inputExpression.isEmpty() && !inputExpression.equals("Error")) {
            if (inputExpression.contains("-")) {
                inputExpression = inputExpression.replace("-", "");
                t_output.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("+")) {
                inputExpression = inputExpression.replace("+", "");
                t_output.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("/")) {
                inputExpression = inputExpression.replace("/", "");
                t_output.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("%")) {
                inputExpression = inputExpression.replace("%", "");
                t_output.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("×")) {
                inputExpression = inputExpression.replace("×", "");
                t_output.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
        }
    }

    // Make text small if too many digits.
    private void exceedLength() {
        if (t_input.getText().toString().length() > 10) {
            t_input.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
    }
}