package course.coursera.actioneventtranslate;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lv = (ListView)findViewById(R.id.listView);

        final List<String> list = new ArrayList<String>();

        list.add("Dog");
        list.add("Cat");
        list.add("Mouse");
        list.add("Elephant");

        final ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               final String value = (String)lv.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setLocale(Locale.getDefault().getDisplayLanguage(),configuration);
    }

    public void setLocale(final String lang, final Configuration configuration) {
        final Locale myLocale = new Locale(lang);
        configuration.setLocale(myLocale);
        final Resources res = getResources();
        final DisplayMetrics dm = res.getDisplayMetrics();
 /*       final Configuration conf = res.getConfiguration();
        conf.locale = myLocale;*/
        res.updateConfiguration(configuration, dm);
        final Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();
    }

}
