package akitasoft.bydbuzz.com.bydbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VenueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue);

        final Button button = (Button) findViewById(R.id.btn_upgrade);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SeatActivity.class);
//                intent.putExtra("sampleText", "thereisnocowlevel");
                startActivity(intent);
            }
        });
    }
}
