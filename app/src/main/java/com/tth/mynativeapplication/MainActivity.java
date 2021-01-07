package com.tth.mynativeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String simpleFileName = "note.txt";
    private Button button1, button2, button3, button4, button5;
    private TextView tv, tv1, tv2, tv3, tv4, tv5;
    private long startTime, endTime;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native int jniDelay();

    public native int sortNative();

    public native int fibonaciNative(int x);

    public native float dtht(float n);

    public native String testStringNative();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        tv = findViewById(R.id.sample_text);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        tv5 = findViewById(R.id.textView5);

        button1.setText("JNI Delay");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv4.setText(stringFromJNI());
                startTime = System.nanoTime();
                jniDelay();
                endTime = System.nanoTime() - startTime;
                tv5.setText(String.valueOf(endTime));
            }
        });

        button2.setText("INT");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime = System.nanoTime();
                for (int i = 0; i < 1000; i++) {
                    fibonaci(80);
                }
                endTime = System.nanoTime() - startTime;
                tv2.setText(String.valueOf(endTime));

                startTime = System.nanoTime();
                fibonaciNative(80);
                endTime = System.nanoTime() - startTime;
                tv3.setText(String.valueOf(endTime));
            }
        });

        button3.setText("FLOAT");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime = System.nanoTime();
                for (int i = 0; i < 100000; i++) {
                    dtht1(3.14f);
                }
                endTime = System.nanoTime() - startTime;
                tv2.setText(String.valueOf(endTime));

                startTime = System.nanoTime();
                dtht(3.14f);
                endTime = System.nanoTime() - startTime;
                tv3.setText(String.valueOf(endTime));
            }
        });

        button4.setText("TIME MEMORY");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime = System.nanoTime();
                sort();
                endTime = System.nanoTime() - startTime;
                tv2.setText(String.valueOf(endTime));

                startTime = System.nanoTime();
                sortNative();
                endTime = System.nanoTime() - startTime;
                tv3.setText(String.valueOf(endTime));
            }
        });

        button5.setText("STRING");
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime = System.nanoTime();
                for (int i = 0; i < 1000; i++) {
                    testString();
                }
                endTime = System.nanoTime() - startTime;
                tv2.setText(String.valueOf(endTime));

                startTime = System.nanoTime();
                for (int i = 0; i < 1000; i++) {
                    testStringNative();
                }
                endTime = System.nanoTime() - startTime;
                tv3.setText(String.valueOf(endTime));

            }
        });
    }

    public int sort() {
        int a[], dem = 10000, temp;
        a = new int[10000];
        for (int i = 0; i < 10000; ++i) {
            a[i] = dem--;
        }
        for (int i = 0; i < 10000; ++i) {
            for (int j = i + 1; j < 10000; ++j) {
                if (a[j] < a[i]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        return 0;
    }

    public long fibonaci(int n) {
        int a, b, c;
        a = b = 1;
        c = 0;
        if (n < 3) return 1;
        else {
            while (n-- > 2) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    public float dtht1(float n) {
        float kq = n;
        kq *= kq;
        kq *= 3.14159265358979f;
        return kq;
    }

    public String testString() {
        String a = "hello";
        String b = "its me";
        String c = " ";
        a = a + c;
        a = a + b;
        return a;
    }
}


