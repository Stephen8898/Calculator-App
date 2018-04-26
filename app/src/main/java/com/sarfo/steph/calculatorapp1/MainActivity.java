package com.sarfo.steph.calculatorapp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Fields to connect to our display
    private EditText result;
    private EditText newNumber;
    private TextView displayOperation;

    // operand variables
    private Double operand1 = null;
    private String pendingOperand ="=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (EditText) findViewById(R.id.result);
        newNumber = (EditText) findViewById(R.id.newNumber);
        displayOperation = (TextView) findViewById(R.id.operation);

        Button button0 =(Button) findViewById(R.id.button0);
        Button button1 =(Button) findViewById(R.id.button1);
        Button button2 =(Button) findViewById(R.id.button2);
        Button button3 =(Button) findViewById(R.id.button3);
        Button button4 =(Button) findViewById(R.id.button4);
        Button button5 =(Button) findViewById(R.id.button5);
        Button button6 =(Button) findViewById(R.id.button6);
        Button button7 =(Button) findViewById(R.id.button7);
        Button button8 =(Button) findViewById(R.id.button8);
        Button button9 =(Button) findViewById(R.id.button9);
        Button buttonDot =(Button) findViewById(R.id.buttonDot);


        Button buttonEquals =(Button) findViewById(R.id.buttonEquals);
        Button buttonAdd =(Button) findViewById(R.id.buttonAdd);
        Button buttonMult =(Button) findViewById(R.id.buttonMultiply);
        Button buttonMinus =(Button) findViewById(R.id.buttonMinus);
        Button buttonDivide =(Button) findViewById(R.id.buttonDivide);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                newNumber.append(b.getText().toString());
            }
        };


        Button[] b = {button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonDot};

        for(Button button: b){
            button.setOnClickListener(listener);
        }
        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Button b =(Button) v;
                String op = b.getText().toString();
                String value = newNumber.getText().toString();

              try{
                  Double doubleValue = Double.valueOf(value);
                  performOperation(doubleValue, op);
              }catch(NumberFormatException e){
                    newNumber.setText("");
              }
                pendingOperand = op;
                displayOperation.setText(pendingOperand);


            }
        };

           Button [] bOp = {buttonEquals,buttonMinus,buttonMult,buttonDivide,buttonAdd};
             for(Button button : bOp){
                button.setOnClickListener(opListener);
            }



        }

                private void performOperation(Double v, String o){
                    if(operand1== null){
                        operand1 = v;

                    }else{


                        if(pendingOperand.equals("=")){
                            pendingOperand = o;
                        }
                        switch(pendingOperand){
                            case "=" :
                                operand1 = v;
                                break;

                            case "/" :
                                if(v == 0){
                                    operand1 = 8008.0;
                                }else{
                                    operand1 /= v;
                                }
                                break;

                            case "*":
                                operand1 *= v;
                                break;

                            case "+":
                                operand1 += v;
                                break;

                            case "-":
                                operand1 -= v;
                                break;

                        }
                    }


                    result.setText(operand1.toString());
                    newNumber.setText("");

                }
    }


