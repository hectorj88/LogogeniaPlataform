package com.company.plataformalogogenia.screen.cuentaedit;

import io.jmix.ui.component.PasswordField;
import io.jmix.ui.component.TextField;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import com.company.plataformalogogenia.screen.user.UserEdit;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Cuenta.edit")
@UiDescriptor("cuenta-edit.xml")
public class CuentaEdit extends UserEdit {
    @Autowired
    private TextField<String> tipoField;

    @Autowired
    private PasswordField passwordField;

    @Subscribe
    protected void onBeforeCommit(BeforeCommitChangesEvent event) {
        passwordField.setValue("{noop}"+passwordField.getValue());
        tipoField.setValue("L");
    }
}