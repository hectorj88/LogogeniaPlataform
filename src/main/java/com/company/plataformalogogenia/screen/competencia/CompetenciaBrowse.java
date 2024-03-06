package com.company.plataformalogogenia.screen.competencia;

import io.jmix.ui.screen.*;
import com.company.plataformalogogenia.entity.Competencia;

@UiController("Competencia.browse")
@UiDescriptor("competencia-browse.xml")
@LookupComponent("table")
public class CompetenciaBrowse extends MasterDetailScreen<Competencia> {
}