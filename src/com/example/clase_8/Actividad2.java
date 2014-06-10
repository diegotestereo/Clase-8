package com.example.clase_8;

import Variables.Vars;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Actividad2 extends Activity{
	
	private String PREFS=Vars.PREFS;
	private Button boton;
	private RatingBar RtgBar_Animo2 ;
	private SharedPreferences preferencias2;
	
	private TextView TxtV_Gustos1 ;
	private TextView TxtV_Gustos2 ;
	private TextView TxtV_Gustos3 ;
	private TextView TxtV_Gustos4 ;
	private TextView TxtV_Gustos5 ;
	private TextView TxtV_Gustos6 ;
	private TextView TxtV_Sexo ;
	private TextView TxtV_Extudios;
	
	
	
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity2);
	levantarXML();
	boton();
	
	cargarDatos();
}

private void cargarDatos() {
	preferencias2 = getSharedPreferences(PREFS,Context.MODE_PRIVATE);
    RtgBar_Animo2.setRating(preferencias2.getInt("animo",0));
    TxtV_Sexo.setText(preferencias2.getString("sexo", "nada"));
    TxtV_Extudios.setText(preferencias2.getString("estudios", "nada"));
}

private void boton() {
	boton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			SharedPreferences.Editor editor =preferencias2.edit();
			editor.clear();
			editor.commit();
			
		}
	});
	
}

private void levantarXML() {
	boton =(Button)findViewById(R.id.button1);
	TxtV_Gustos1 =(TextView) findViewById(R.id.TxtV_Gustos1);
	TxtV_Gustos2 =(TextView) findViewById(R.id.TxtV_Gustos2);
	TxtV_Gustos3 =(TextView) findViewById(R.id.TxtV_Gustos3);
	TxtV_Gustos4 =(TextView) findViewById(R.id.TxtV_Gustos4);
	TxtV_Gustos5 =(TextView) findViewById(R.id.TxtV_Gustos5);
	TxtV_Gustos6 =(TextView) findViewById(R.id.TxtV_Gustos6);
	TxtV_Sexo =(TextView) findViewById(R.id.TxtV_Sexo);
	TxtV_Extudios =(TextView) findViewById(R.id.TxtV_Estudios);
 RtgBar_Animo2 =(RatingBar) findViewById(R.id.RtgBar_Animo2);
	
	
	
}
}
