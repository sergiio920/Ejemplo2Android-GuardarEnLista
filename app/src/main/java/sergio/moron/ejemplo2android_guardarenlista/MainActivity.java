package sergio.moron.ejemplo2android_guardarenlista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import sergio.moron.ejemplo2android_guardarenlista.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
    //Variables de la vista a la interfaz
    private Button btnRegistrar;
    private EditText txtEmail;
    private EditText txtPassword;

    //Variables para la lógica
    ArrayList<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INICIALIZO TODITO
        listaUsuarios = new ArrayList<>();

        inicializaVista();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Coger los textos de las cajas
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                //Comprobar que están rellenados y sino advertirlos
                if (email.isEmpty() || password.isEmpty()){
                    //No se puede guardar
                    Toast.makeText(MainActivity.this, "FALTAN DATOS BOBOLON", Toast.LENGTH_SHORT).show();

                } else {
                    //Guardamos en la lista
                    Usuario miUsuario = new Usuario(email, password);
                    listaUsuarios.add(miUsuario);
                    Toast.makeText(MainActivity.this, "USUARIO ALMACENADO: "+miUsuario.toString(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void inicializaVista() {
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnRegistrar = findViewById(R.id.btnRegisterName);
    }
}