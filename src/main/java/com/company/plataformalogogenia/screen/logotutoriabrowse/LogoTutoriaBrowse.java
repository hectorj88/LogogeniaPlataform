package com.company.plataformalogogenia.screen.logotutoriabrowse;

import com.company.plataformalogogenia.entity.Tutoria;
import com.company.plataformalogogenia.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import com.company.plataformalogogenia.screen.tutoria.TutoriaBrowse;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("LogoTutoria.browse")
@UiDescriptor("Logo-tutoria-browse.xml")
public class LogoTutoriaBrowse extends TutoriaBrowse {

    @Autowired
    CurrentAuthentication cab;
    @Autowired
    private CollectionLoader<Tutoria> tutoriasDl;

    @Subscribe
    public void onInit(InitEvent event)
    {
        User IdUsuario = ((User) cab.getUser());
        String query="select t from Tutoria t"+
                " where t.logogenistaId.idCuenta = :IdUsuario";
        tutoriasDl.setQuery(query);
        tutoriasDl.setParameter("IdUsuario",IdUsuario);
        tutoriasDl.load();
    }
}