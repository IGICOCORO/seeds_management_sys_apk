package bi.infinity.seeds_management_system.Dialogs;

import android.app.Dialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bi.infinity.seeds_management_system.Model.Seed;
import bi.infinity.seeds_management_system.R;

import static bi.infinity.seeds_management_system.R.style.Theme_AppCompat_DayNight_Dialog;


public class AddSeedDialog extends Dialog {
    Seed seed;
    Context context;
    EditText field_seed_nom, field_seed_date, field_seed_company_from, field_seed_prix,field_seed_qtt;
    Button btn_add_seed;

    public AddSeedDialog(Context context) {
        super(context, Theme_AppCompat_DayNight_Dialog);
        setContentView(R.layout.popup_plants_details);
        this.context = context;


       /* field_seed_nom = findViewById(R.id.field_seed_nom);
        field_seed_prix = findViewById(R.id.field_seed_prix);
        field_seed_qtt = findViewById(R.id.field_seed_qtt);
        field_seed_company_from = findViewById(R.id.field_seed_company_from);
        field_seed_date = findViewById(R.id.field_seed_date);
        btn_add_seed = findViewById(R.id.btn_seed_cancel);
        btn_add_seed = findViewById(R.id.btn_seed_submit);*/
    }

}
