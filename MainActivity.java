package com.example.qosmio.calc1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView disp;

    //12345

    Button arrow,ce,c,plmin,sqroot,seven7,eight8,nine9,div,mul,per,recip,min,pl,six6,five5,four4,
    three3,two2,dot,one1,zero0,eq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrow = findViewById(R.id.arrow);
        ce = findViewById(R.id.ce);
        c = findViewById(R.id.c);
        plmin = findViewById(R.id.plmin);
        sqroot = findViewById(R.id.sqroot);
        seven7 = findViewById(R.id.seven);
        eight8 = findViewById(R.id.eight);
        nine9 = findViewById(R.id.nine);
        div = findViewById(R.id.div);
        per = findViewById(R.id.per);
        four4 = findViewById(R.id.four);
        five5 = findViewById(R.id.five);
        six6 = findViewById(R.id.six);
        mul = findViewById(R.id.mul);
        recip = findViewById(R.id.recip);
        one1 = findViewById(R.id.one);
        two2 = findViewById(R.id.two);
        three3 = findViewById(R.id.three);
        min = findViewById(R.id.min);
        pl = findViewById(R.id.pl);
        zero0 = findViewById(R.id.zero);
        dot = findViewById(R.id.dot);
        eq = findViewById(R.id.eq);

        disp = findViewById(R.id.disp);
        arrow.setOnClickListener(this);
        ce.setOnClickListener(this);
        c.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        plmin.setOnClickListener(this);
        pl.setOnClickListener(this);
        min.setOnClickListener(this);
        per.setOnClickListener(this);
        recip.setOnClickListener(this);
        eq.setOnClickListener(this);
        dot.setOnClickListener(this);
        one1.setOnClickListener(this);
        two2.setOnClickListener(this);
        three3.setOnClickListener(this);
        four4.setOnClickListener(this);
        five5.setOnClickListener(this);
        six6.setOnClickListener(this);
        seven7.setOnClickListener(this);
        eight8.setOnClickListener(this);
        nine9.setOnClickListener(this);
        zero0.setOnClickListener(this);
        sqroot.setOnClickListener(this);
    }
    enum Op {plus, minus, div, mul, nil}
    Op op = Op.nil;
    double cash1 = Double.NEGATIVE_INFINITY;
    double cash2 = Double.NEGATIVE_INFINITY;
    String s;
    public void onClick(View v){
        switch(v.getId()){
            case R.id.arrow:
                if(disp.length()>1) {
                    disp.setText((disp.getText().toString()).substring(0, disp.length() - 1));
                }else {
                    disp.setText("");
                }
                break;
            case R.id.c:
                disp.setText("");
                op = Op.nil;
                break;
            case R.id.ce:
                disp.setText("");
                break;
            case R.id.div:
                switch(op){
                    case nil:
                        if(disp.getText().toString().equals("")){

                        }else{
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash2=Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.div;
                        }
                        break;
                    case plus:
                        if(disp.getText().toString().equals("")){
                            op = Op.div;
                            cash1=cash2;
                        }else{
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash2=Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.div;
                        }
                        break;
                    case minus:
                        if(disp.getText().toString().equals("")){
                            op = Op.div;
                            cash1=cash2;
                        }else{
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash2=Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.div;
                        }
                        break;
                    case mul:
                        if(disp.getText().toString().equals("")){
                            op = Op.div;
                        }else{
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash2*=Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.div;
                        }
                        break;
                    case div:
                        if(disp.getText().toString().equals("")){
                        }else{
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash2/=Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.div;
                        }
                        break;
                }
                break;
            case R.id.dot:if(!((disp.getText()).toString()).contains(".") && !((disp.getText()).toString()).equals("")){
                     disp.append(".");
                }
                break;
            case R.id.eight:
                if(disp.length() < 10) {
                    disp.append("8");
                }
                break;
            case R.id.eq:
                switch (op){
                    case nil:
                        break;
                    case plus:
                        op = Op.nil;
                        s = disp.getText().toString();
                        if(s.endsWith(".")){
                            s = s.substring(0,s.length() - 1);
                        }
                        disp.setText(s);
                        s = String.valueOf(Double.parseDouble((disp.getText()).toString())+cash1);
                        if(s.endsWith(".0")) {
                            s = s.substring(0, s.length()-2);
                        }
                        if(s.length()>10){
                            s = s.substring(0, 10);
                        }
                        disp.setText(s);
                        cash1=Double.NEGATIVE_INFINITY;
                        cash2=Double.NEGATIVE_INFINITY;
                        break;
                    case minus:
                        op = Op.nil;
                        s = disp.getText().toString();
                        if(s.endsWith(".")){
                            s = s.substring(0,s.length() - 1);
                        }
                        disp.setText(s);
                        s = String.valueOf(cash1-Double.parseDouble((disp.getText()).toString()));
                        if(s.endsWith(".0")) {
                            s = s.substring(0, s.length()-2);
                        }
                        if(s.length()>10){
                            s = s.substring(0, 10);
                        }
                        disp.setText(s);
                        cash1=Double.NEGATIVE_INFINITY;
                        cash2=Double.NEGATIVE_INFINITY;
                        break;
                    case mul:
                        op = Op.nil;
                        s = disp.getText().toString();
                        if(s.endsWith(".")){
                            s = s.substring(0,s.length() - 1);
                        }
                        disp.setText(s);
                        s = String.valueOf(Double.parseDouble((disp.getText()).toString())*cash2);
                        if(s.endsWith(".0")) {
                            s = s.substring(0, s.length()-2);
                        }
                        if(s.length()>10){
                            s = s.substring(0, 10);
                        }
                        disp.setText(s);
                        cash1=Double.NEGATIVE_INFINITY;
                        cash2=Double.NEGATIVE_INFINITY;
                        break;
                    case div:
                        op = Op.nil;
                        s = disp.getText().toString();
                        if(s.endsWith(".")){
                            s = s.substring(0,s.length() - 1);
                        }
                        disp.setText(s);
                        s = String.valueOf(cash2/Double.parseDouble((disp.getText()).toString()));
                        if(s.endsWith(".0")) {
                            s = s.substring(0, s.length()-2);
                        }
                        if(s.length()>10){
                            s = s.substring(0, 10);
                        }
                        disp.setText(s);
                        cash1=Double.NEGATIVE_INFINITY;
                        cash2=Double.NEGATIVE_INFINITY;
                        break;
                }
                break;
            case R.id.five:
                if(disp.length() < 10) {
                    disp.append("5");
                }
                break;
            case R.id.four:
                if(disp.length() < 10) {
                    disp.append("4");
                }
                break;
            case R.id.min:
                switch(op) {
                    case nil:
                        if (disp.getText().toString().equals("")) {
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash1 = Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.minus;
                        }
                        break;
                    case plus:
                        if (disp.getText().toString().equals("")) {
                            op = Op.minus;
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash1 += Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.minus;
                        }
                        break;
                    case minus:
                        if (disp.getText().toString().equals("")) {
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash1 -= Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.minus;
                        }
                        break;
                    case mul:
                        if (disp.getText().toString().equals("")) {
                            op = Op.minus;
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash1 = cash2*Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.minus;
                        }
                        break;
                    case div:
                        if (disp.getText().toString().equals("")) {
                            op = Op.minus;
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash1 = cash2/Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.div;
                        }
                        break;
                }
                break;
            case R.id.mul:
                switch(op) {
                    case nil:
                        if (disp.getText().toString().equals("")) {

                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash2 = Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.mul;
                        }
                        break;
                    case plus:
                        if (disp.getText().toString().equals("")) {
                            op = Op.mul;
                            cash1 = cash2;
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash2 = Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.mul;
                        }
                        break;
                    case minus:
                        if (disp.getText().toString().equals("")) {
                            op = Op.mul;
                            cash1 = cash2;
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash2 = Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.mul;
                        }
                        break;
                    case mul:
                        if (disp.getText().toString().equals("")) {
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash2 *= Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.mul;
                        }
                        break;
                    case div:
                        if (disp.getText().toString().equals("")) {
                            op = Op.mul;
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash2 /= Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.mul;
                        }
                        break;
                }
                break;
            case R.id.nine:
                if(disp.length() < 10) {
                    disp.append("9");
                }
                break;
            case R.id.one:
                if(disp.length() < 10) {
                    disp.append("1");
                }
                break;
            case R.id.per:
                if(disp.length()!=0) {
                    s = disp.getText().toString();
                    s = String.valueOf((cash1/100)*Double.parseDouble(s));
                    if(s.length()>10){
                        s = s.substring(0, 10);
                    }
                    disp.setText(s);
                }
                break;
            case R.id.pl:
                switch(op) {
                    case nil:
                        if (disp.getText().toString().equals("")) {
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash1 = Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.plus;
                        }
                        break;
                    case plus:
                        if (disp.getText().toString().equals("")) {
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash1 += Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.plus;
                        }
                        break;
                    case minus:
                        if (disp.getText().toString().equals("")) {
                            op = Op.plus;
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash1 -= Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.plus;
                        }
                        break;
                    case mul:
                        if (disp.getText().toString().equals("")) {
                            op = Op.plus;
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash1 = cash2*Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.plus;
                        }
                        break;
                    case div:
                        if (disp.getText().toString().equals("")) {
                            op = Op.plus;
                        } else {
                            s = disp.getText().toString();
                            if(s.endsWith(".")){
                                s = s.substring(0,s.length() - 1);
                            }
                            disp.setText(s);
                            cash1 = cash2/Double.parseDouble(disp.getText().toString());
                            disp.setText("");
                            op = Op.plus;
                        }
                        break;
                }
                break;
            case R.id.plmin:
                if(disp.length()!=0) {
                    if((disp.getText().toString()).startsWith("-")){
                        disp.setText(((disp.getText()).toString()).substring(1, disp.length()));
                    }else{
                        disp.setText("-".concat(disp.getText().toString()));
                    }
                }

                break;
            case R.id.recip:
                if(disp.length()!=0) {
                    s = disp.getText().toString();
                    if(s.endsWith(".")){
                        s = s.substring(0,s.length() - 1);
                    }
                    disp.setText(s);
                    s = disp.getText().toString();
                    s = String.valueOf(1 / Double.parseDouble(s));
                    if(s.endsWith(".0")) {
                        s = s.substring(0, s.length()-2);
                    }
                    if(s.length()>10){
                        s = s.substring(0, 10);
                    }
                    disp.setText(s);
                }
                break;
            case R.id.seven:
                if(disp.length() < 10) {
                    disp.append("7");
                }
                break;
            case R.id.six:
                if(disp.length() < 10) {
                    disp.append("6");
                }
                break;
            case R.id.sqroot:
                if(disp.length()!=0) {
                    s = disp.getText().toString();
                    if(s.endsWith(".")){
                        s = s.substring(0,s.length() - 1);
                    }
                    disp.setText(s);
                    s = disp.getText().toString();
                    s = String.valueOf(Math.sqrt(Double.parseDouble(s)));
                    if(s.endsWith(".0")) {
                        s = s.substring(0, s.length()-2);
                    }
                    if(s.length()>10){
                        s = s.substring(0, 10);
                    }
                    disp.setText(s);
                }
                break;
            case R.id.three:
                if(disp.length() < 10) {
                    disp.append("3");
                }
                break;
            case R.id.two:
                if(disp.length() < 10) {
                    disp.append("2");
                }
                break;
            case R.id.zero:
                if(disp.length() < 10) {
                    disp.append("0");
                }
                break;
        }
    }
}
