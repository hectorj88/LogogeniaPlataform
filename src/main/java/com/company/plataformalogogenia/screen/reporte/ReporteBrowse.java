package com.company.plataformalogogenia.screen.reporte;

import io.jmix.ui.screen.*;
import com.company.plataformalogogenia.entity.Reporte;

@UiController("Reporte.browse")
@UiDescriptor("reporte-browse.xml")
@LookupComponent("reportesTable")
public class ReporteBrowse extends StandardLookup<Reporte> {
}