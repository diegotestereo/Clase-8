package com.example.clase_8;

import Variables.Vars;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	//declaracion de variables
	private Button Btn_guardar;
	private CheckBox CkBox_Perfumes,CkBox_Danza,CkBox_Futbol,
		CkBox_Rugby,CkBox_Ropa,CkBox_flores;
	private RadioButton RdBtn_Primaria,RdBtn_Secundaria,
		RdBtn_Universidad,RdBtn_Hombre,RdBtn_Mujer;
	private RadioGroup RdGroup_Sex,RdGroup_Est;
	private RatingBar RtgBar_Animo;
	private Spinner Spin_Equipos;
	private String[] equipos;//cadena de strings
	private SharedPreferences preferencias;
	private String PREFS=Vars.PREFS;
	private String sex,est,gustos,animo,equips;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		equipos=new String[]{"River","Boca","Racing","Independiente"};

		levantarXML();
		seteoBotones();
		boton();
		checkBoxes();
		
		radioGrupo();
		animoRatingBar();
		SpinerLista();
		}


	private void seteoBotones() {

		RdBtn_Hombre.setChecked(false);
		RdBtn_Mujer.setChecked(false);
		RdBtn_Primaria.setChecked(false);
		RdBtn_Universidad.setChecked(false);
		RdBtn_Secundaria.setChecked(false);
	}


	private void SpinerLista() {
		equipos= new String[]{"rojo","racing","boca","river","platense"};
		//equipos= getResources().getStringArray(R.array.equipos);
		
		ArrayAdapter<String> adaptador_elementos = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,equipos);
		Spin_Equipos.setAdapter(adaptador_elementos);
		Spin_Equipos.setSelection(0);
		
		Spin_Equipos.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
			switch (position) {
			case 0:Toast.makeText(getApplicationContext(), equipos[position], Toast.LENGTH_SHORT).show();
					break;
			case 1:Toast.makeText(getApplicationContext(), equipos[position], Toast.LENGTH_SHORT).show();
			break;
			case 2:Toast.makeText(getApplicationContext(), equipos[position], Toast.LENGTH_SHORT).show();
			break;
			case 3:Toast.makeText(getApplicationContext(), equipos[position], Toast.LENGTH_SHORT).show();
			break;

			default:Toast.makeText(getApplicationContext(), equipos[position], Toast.LENGTH_SHORT).show();
			
				break;
			}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			Toast.makeText(getApplicationContext(), "no eligio ninguno", Toast.LENGTH_SHORT).show();
			

				
			}
		});
		
		
		
		
	}

	private void animoRatingBar() {
		RtgBar_Animo.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				Toast.makeText(getApplicationContext(), "Estado de ánimo: "+rating+"/5", Toast.LENGTH_SHORT).show();
				animo=String.valueOf(rating);
				
			}
		});
	}
	
	
	private void chequeboxes(String sexo){
		 boolean bol;
		
		if (sexo.contentEquals("hombre")){ 
		bol=true;
		}else{
			bol=false;
			}
		CkBox_Danza.setEnabled(!bol);
		CkBox_Danza.setChecked(false);
		CkBox_flores.setEnabled(!bol);
		CkBox_flores.setChecked(false);
		CkBox_Futbol.setEnabled(bol);
		CkBox_Futbol.setChecked(false);
		CkBox_Perfumes.setEnabled(!bol);
		CkBox_Perfumes.setChecked(false);
		CkBox_Ropa.setEnabled(true);
		CkBox_Ropa.setChecked(false);
		CkBox_Rugby.setEnabled(bol);
		CkBox_Rugby.setChecked(false);
		
	}
	
	private void radioGrupo() {
			
		RdGroup_Sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId){
				case  R.id.RdBtn_Hombre:
					Toast.makeText(getApplicationContext(), "Hombre", Toast.LENGTH_SHORT).show();
					chequeboxes("hombre");
					sex="hombre";
					
					
					break;
				case  R.id.RdBtn_Mujer:
					Toast.makeText(getApplicationContext(), "Mujer", Toast.LENGTH_SHORT).show();
					chequeboxes("mujer");
					sex="mujer";
					break;
				
				
				}
			}
		});
		
				
		
		RdGroup_Est.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId){
				
				case R.id.RdBtn_Primaria:Toast.makeText(getApplicationContext(), "primaria", Toast.LENGTH_SHORT).show();
				                        est="primaria";
											break;
				case R.id.RdBtn_Secundaria:Toast.makeText(getApplicationContext(), "secundaria", Toast.LENGTH_SHORT).show();
				  est="secundaria";
											break;
				case R.id.RdBtn_Universidad:Toast.makeText(getApplicationContext(), "universidad", Toast.LENGTH_SHORT).show();
				  est="universidad";
											break;
							
				
				}
				
			}
		});
				
	}
		
	private void checkBoxes() {
	
		CkBox_Danza.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				
				if (isChecked){
					Toast.makeText(getApplicationContext(), "Danza On "+buttonView.getId(), Toast.LENGTH_SHORT).show();
											}
				else{Toast.makeText(getApplicationContext(), "Danza Off", Toast.LENGTH_SHORT).show();
				}		
			}
		});
		
		CkBox_flores.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked){
					Toast.makeText(getApplicationContext(), "flores On", Toast.LENGTH_SHORT).show();		
						}
				else{Toast.makeText(getApplicationContext(), "flores Off", Toast.LENGTH_SHORT).show();
				}	
				
			}
		});
		
	}
	
	private void boton() {
		Btn_guardar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			AlmacenarPreferencias();
			Intent intento =new Intent(MainActivity.this,Actividad2.class);
			startActivity(intento);
			}
		});
		
	}

	private void AlmacenarPreferencias(){
		
		preferencias= getSharedPreferences(PREFS,Context.MODE_PRIVATE);
		SharedPreferences.Editor editor =preferencias.edit();
		editor.putString("estudios", est);
		editor.putString("sexo", sex);
		/*editor.putString("gustos", gustos);
		editor.putString("animo", animo);
		editor.putString("equipo", equips);*/
		//editor.putString("animo", animo);
		//editor.putInt(getResources().getString(R.id.RtgBar_Animo), RtgBar_Animo.getProgress());
		editor.putInt(animo, RtgBar_Animo.getProgress());
		editor.putString("sexo", sex);
		editor.commit();
		
		
	}
	
	private void levantarXML() {
		Btn_guardar=(Button) findViewById(R.id.Btn_Guardar);
		CkBox_Perfumes= (CheckBox) findViewById(R.id.CkBox_Perfumes);
		CkBox_Danza= (CheckBox) findViewById(R.id.CkBox_Danza);
		CkBox_Futbol= (CheckBox) findViewById(R.id.CkBox_Futbol);
		CkBox_Rugby= (CheckBox) findViewById(R.id.CkBox_Rugby);
		CkBox_Ropa= (CheckBox) findViewById(R.id.CkBox_Ropa);
		CkBox_flores= (CheckBox) findViewById(R.id.CkBox_Flores);
		RdBtn_Primaria= (RadioButton) findViewById(R.id.RdBtn_Primaria);
		RdBtn_Secundaria= (RadioButton) findViewById(R.id.RdBtn_Secundaria);
		RdBtn_Universidad= (RadioButton) findViewById(R.id.RdBtn_Universidad);
		RdBtn_Hombre= (RadioButton) findViewById(R.id.RdBtn_Hombre);
		RdBtn_Mujer= (RadioButton) findViewById(R.id.RdBtn_Mujer);
		RtgBar_Animo= (RatingBar) findViewById(R.id.RtgBar_Animo);
		Spin_Equipos=(Spinner) findViewById(R.id.Spin_Equipos);
		RdGroup_Sex=(RadioGroup) findViewById(R.id.RdGroup_Sexo);
		RdGroup_Est=(RadioGroup) findViewById(R.id.RdGroup_Estudios);
		
	}

}
