package com.company.plataformalogogenia.screen.alumno;

import io.jmix.ui.component.ComboBox;
import io.jmix.ui.screen.*;
import com.company.plataformalogogenia.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@UiController("Alumno.browse")
@UiDescriptor("alumno-browse.xml")
@LookupComponent("table")
public class AlumnoBrowse extends MasterDetailScreen<Alumno> {
    @Autowired
    private ComboBox<String> diagnosticoField;

    @Subscribe
    public void onInit(InitEvent event) {
        List<String> list = new ArrayList<>();
        list.add("Sordo");
        list.add("Hipoacúsico");
        list.add("Oyente");
        diagnosticoField.setOptionsList(list);
    }
}