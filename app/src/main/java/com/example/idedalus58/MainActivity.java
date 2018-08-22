package com.example.idedalus58;



import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import static android.support.v4.view.MenuItemCompat.getActionView;


public class  MainActivity extends AppCompatActivity {


    //++++++++++++++++++++++++++++++ Login avec la base de doneé +++++++++++++++++++++++++++++++++//
      /*  try
    {
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:..\\Loginbibliotheque\\bibliothequeMB_DB.db";
        Connection con = DriverManager.getConnection(url);
        System.out.println("URL: " +url);
        System.out.println("Connection: " +con);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }*/

   /* public static class Connect {

        //private static String url = "jdbc:mysql://localhost:3306/bibliothequeMB_DB?useSSL=false";
        private static String url = "jdbc:sqlite:..\\Loginbibliotheque\\bibliothequeMB_DB.db";

        private static String user = "root";
        private static String passwd = "Dedal";
        private static Connection connection;

        public static Connection connecter(){
            if (connection == null){
                try {
                    connection = DriverManager.getConnection(url, user, passwd);
                } catch (Exception e) {
                    throw new IllegalStateException("Impossible connecter", e);
                }
            }
            return connection;
        }
    }*/

    //*************************** Pour passer de l'Activity Main vers l'Activity Login ***********//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//


    //***************************  *********************************//

           @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);

                //Pour la bare de recherche
                SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
                SearchView searchView = (SearchView) getActionView(menu.findItem(R.id.search));
                searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
                return true;

            }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.fragment_apropos) {*/

        //===================== pour le items connection et interaction ==========================//

        /*int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout;
            return true;
        }*/


        switch (item.getItemId()) {
            case R.id.action_apropos:
                Intent apropos = new Intent(this, AproposActivity.class);
                startActivity(apropos);
                break;

            case R.id.action_settings:
                Intent settings = new Intent(this, SettingsActivity.class);
                startActivity(settings);
                break;

            case R.id.action_rendezVous:
                Intent rendezVous = new Intent(this, RendezVousActivity.class);
                startActivity(rendezVous);
                break;

            case R.id.action_historique:
                Intent historique = new Intent(this, HistoriqueActivity.class);
                startActivity(historique);
                break;

        /*}else if (id == R.id.email_sign_in_button){
            logout();*/

            default:

            Intent intentAproposActivity = new Intent (MainActivity.this, AproposActivity.class);
            startActivity(intentAproposActivity);
            return true;

        }

          return super.onOptionsItemSelected(item);
         }

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

   /* private void logout()
    {
        .getInstance().signOut();
        Intent intent = new Intent(getApplicationContext().MainActivity.class);
        intent addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }*/
    }



