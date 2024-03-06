package com.company.plataformalogogenia.screen.reporte;

import io.jmix.ui.screen.*;
import com.company.plataformalogogenia.entity.Reporte;

@UiController("Reporte.edit")
@UiDescriptor("reporte-edit.xml")
@EditedEntityContainer("reporteDc")
public class ReporteEdit extends StandardEditor<Reporte> {
}