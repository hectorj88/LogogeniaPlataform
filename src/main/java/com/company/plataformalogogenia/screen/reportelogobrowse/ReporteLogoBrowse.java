package com.company.plataformalogogenia.screen.reportelogobrowse;

import com.company.plataformalogogenia.entity.Reporte;
import com.company.plataformalogogenia.entity.User;
import io.jmix.core.FetchPlan;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.impl.ScreenDataXmlLoader;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import com.company.plataformalogogenia.screen.reporte.ReporteBrowse;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("ReporteLogo.browse")
@UiDescriptor("reporte-logo-browse.xml")
public class ReporteLogoBrowse extends ReporteBrowse {

    @Autowired
    CurrentAuthentication cab;
    @Autowired
    private CollectionLoader<Reporte> reportesDl;

    @Subscribe
    public void onInit(InitEvent event)
    {
       //String IdUsuario = ((User) cab.getUser()).getId().toString().replace("-","");
        User IdUsuario = ((User) cab.getUser());
        String query="select e from Reporte e"+
                " where e.tutoriaId.logogenistaId.idCuenta = :IdUsuario";
        reportesDl.setQuery(query);
        reportesDl.setParameter("IdUsuario",IdUsuario);
        reportesDl.load();
    }
}