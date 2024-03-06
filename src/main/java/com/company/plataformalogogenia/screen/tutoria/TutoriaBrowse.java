package com.company.plataformalogogenia.screen.tutoria;

import io.jmix.ui.component.ComboBox;
import io.jmix.ui.screen.*;
import com.company.plataformalogogenia.entity.Tutoria;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@UiController("Tutoria.browse")
@UiDescriptor("tutoria-browse.xml")
@LookupComponent("table")
public class TutoriaBrowse extends MasterDetailScreen<Tutoria> {
    @Autowired
    private ComboBox<String> estadoField;

    @Subscribe
    public void onInit(InitEvent event) {
        List<String> list = new ArrayList<>();
        list.add("Suspendida");
        list.add("Activa");
        list.add("Terminada");
        estadoField.setOptionsList(list);
    }
}