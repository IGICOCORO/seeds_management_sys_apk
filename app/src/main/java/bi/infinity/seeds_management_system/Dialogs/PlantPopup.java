package bi.infinity.seeds_management_system.Dialogs;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;

import bi.infinity.seeds_management_system.R;

import static bi.infinity.seeds_management_system.R.style.Theme_AppCompat_DayNight_Dialog;

public class PlantPopup extends Dialog{

    public PlantPopup(@NonNull Context context) {
            super(context, Theme_AppCompat_DayNight_Dialog);
            setContentView(R.layout.popup_plants_details);
    };

}
