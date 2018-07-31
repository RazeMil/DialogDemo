package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    TextView tvDemo2;
    Button btnDemo2;
    TextView tvDemo3;
    Button btnDemo3;
    TextView tvEx3;
    Button btnEx3;
    Button btnDemo4;
    TextView tvDemo4;
    Button btnDemo5;
    TextView tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvEx3 = findViewById(R.id.textViewEx3);
        btnEx3 = findViewById(R.id.buttonEx3);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo5 = findViewById(R.id.textViewDemo5);
        btnDemo5 = findViewById(R.id.buttonDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                /*myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close",null);
*/
                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnDemo2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                                            myBuilder.setTitle("Demo 2 Buttons Dialog");
                                            myBuilder.setMessage("Select one of the Buttons below");
                                            myBuilder.setCancelable(false);

                                            //Configure Positive Button
                                            myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    tvDemo2.setText("You have selected Positive.");
                                                }
                                            });
                                            myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    tvDemo2.setText("You have selected Negative.");
                                                }
                                            });
                                            myBuilder.setNeutralButton("Cancel", null);
                                            AlertDialog myDialog = myBuilder.create();
                                            myDialog.show();
                                        }


                                    }

        );
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                //obtain the UI component in the input.xml layout
                //It needs to be defined as "Final", so that it can be used in the onClick () method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = etInput.getText().toString();
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnEx3.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                          View viewDialog = inflater.inflate(R.layout.exercise3, null);

                                          //obtain the UI component in the input.xml layout
                                          //It needs to be defined as "Final", so that it can be used in the onClick () method later
                                          final EditText etInput1 = viewDialog.findViewById(R.id.editTextNum1);
                                          final EditText etInput2 = viewDialog.findViewById(R.id.editTextNum2);

                                          AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                                          myBuilder.setView(viewDialog);
                                          myBuilder.setTitle("Exercise 3");
                                          myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                              @Override
                                              public void onClick(DialogInterface dialog, int which) {
                                                  int num1 = Integer.parseInt(etInput1.getText().toString());
                                                  int num2 = Integer.parseInt(etInput2.getText().toString());
                                                  int sum = num1 + num2;
                                                  tvEx3.setText("The Sum is " + Integer.toString(sum));
                                              }
                                          });
                                          myBuilder.setNegativeButton("Cancel", null);
                                          AlertDialog myDialog = myBuilder.create();
                                          myDialog.show();
                                      }
                                  });
                btnDemo4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                tvDemo4.setText("Date: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        };
                        Calendar c = Calendar.getInstance();
                        int year = c.get(Calendar.YEAR);
                       int month = c.get(Calendar.MONTH);
                         int day = c.get(Calendar.DAY_OF_MONTH);
                        DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, year, month, day);
                        myDateDialog.show();
                    }
                });
                btnDemo5.setOnClickListener(new View.OnClickListener() {
                    @Override
                      public void onClick(View v) {
                    TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            tvDemo5.setText("Time: "+hourOfDay+":"+minute);
                    }
                };
                    Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener,hour,minute,true);
                myTimeDialog.show();
            }
        });
    }}