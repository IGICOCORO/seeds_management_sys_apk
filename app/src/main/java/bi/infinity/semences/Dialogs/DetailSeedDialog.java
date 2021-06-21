package bi.infinity.semences.Dialogs;


import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;

import bi.infinity.semences.R;

import static bi.infinity.semences.R.style.Theme_AppCompat_DayNight_Dialog;

public class DetailSeedDialog extends Dialog{

    public DetailSeedDialog(@NonNull Context context) {
        super(context, Theme_AppCompat_DayNight_Dialog);
        setContentView(R.layout.dialog_seed_details);
    };

}