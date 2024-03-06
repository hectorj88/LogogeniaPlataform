package com.company.plataformalogogenia.screen.reportelogocrear;

import com.company.plataformalogogenia.entity.Competencia;
import com.company.plataformalogogenia.entity.Indicador;
import io.jmix.core.Metadata;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.DateField;
import io.jmix.ui.component.Table;
import io.jmix.ui.component.TextField;
import io.jmix.ui.component.data.TableItems;
import io.jmix.ui.component.data.table.ContainerTableItems;
import io.jmix.ui.component.data.table.EmptyTableItems;
import io.jmix.ui.component.table.TableDataContainer;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.impl.CollectionLoaderImpl;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import com.company.plataformalogogenia.screen.reporte.ReporteEdit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@UiController("ReporteLogo.crear")
@UiDescriptor("reporte-logo-crear.xml")
public class ReporteLogoCrear extends ReporteEdit {

    @Autowired
    private TextField<String> ultimoCambioPorField;

    @Autowired
    private DateField<Date> fechaHoraEnvioField;

    @Autowired
    private Table<Indicador> indicadoresTable;

    @Autowired
    private CollectionContainer<Indicador> indicadoresDc;

    @Autowired
    private Metadata metadata;

    @Autowired
    private CollectionLoader<Competencia> competenciasDl;


    @Subscribe//("indicadoresTable.testeo")
    public void afterInit(/*AfterInitEvent event*//*Action.ActionPerformedEvent event*/AfterShowEvent event)
    {
        Collection<Indicador> nuevosIndicadores = new ArrayList<Indicador>();

        competenciasDl.load();

        for (Competencia indice:competenciasDl.getContainer().getItems()) {
            Indicador nuevoIndicador=(Indicador) metadata.create("Indicador");
            nuevoIndicador.setReporte(this.getEditedEntity());
            nuevoIndicador.setIdCompetencia(indice);
            nuevoIndicador.setPorcentajeCompletado(0);
            //indicadoresDc.setItem(nuevoIndicador);
            nuevosIndicadores.add(nuevoIndicador);
        }
        indicadoresDc.setItems(nuevosIndicadores);
        //this.getEditedEntity().getId();
        indicadoresTable.setItems(new ContainerTableItems<>(indicadoresDc));
    }

    @Subscribe
    protected void onBeforeCommit(BeforeCommitChangesEvent event) {
        ultimoCambioPorField.setValue("Logogenista");
        fechaHoraEnvioField.setValue(new Date());
        limitarValorPorcentajes();
        //String hola="hola";
        //indicadoresDc.getItems();
        //indicadoresTable.getItems();
    }

    protected void limitarValorPorcentajes()
    {
        indicadoresTable.getItems().getItems().forEach(indicador -> {
            if(indicador.getPorcentajeCompletado()>100)
            {
                indicador.setPorcentajeCompletado(100);
            } else if (indicador.getPorcentajeCompletado()<0) {
                indicador.setPorcentajeCompletado(0);
            }
        });
    }

}