package vuki.com.exercise;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import vuki.com.exercise.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView( this, R.layout.activity_main );

        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        final View pv = inflater.inflate( R.layout.dialog, null );

        final PopupWindow popupWindow = new PopupWindow(
                pv,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );

        Button btn = (Button) pv.findViewById( R.id.btnRegister );
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                TextView error = (TextView) pv.findViewById( R.id.lblInitError );
                error.setText( "Ovo je teksst koji nem moze stati jer nema sdovoljno mejsta ali negdej cemo ga zagurati hehe" );
                error.setVisibility( View.VISIBLE );
            }
        } );

        new Handler().postDelayed( new Runnable() {
            public void run() {
                popupWindow.showAtLocation( pv.findViewById( R.id.root ), Gravity.CENTER, 0, 0 );
            }
        }, 100 );

    }
}
