package com.company.plataformalogogenia.screen.periodoacademico;

import io.jmix.ui.screen.*;
import com.company.plataformalogogenia.entity.PeriodoAcademico;

@UiController("PeriodoAcademico.browse")
@UiDescriptor("periodo-academico-browse.xml")
@LookupComponent("table")
public class PeriodoAcademicoBrowse extends MasterDetailScreen<PeriodoAcademico> {
}