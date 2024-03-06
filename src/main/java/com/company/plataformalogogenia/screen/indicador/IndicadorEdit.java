package com.company.plataformalogogenia.screen.indicador;

import io.jmix.ui.screen.*;
import com.company.plataformalogogenia.entity.Indicador;

@UiController("Indicador.edit")
@UiDescriptor("indicador-edit.xml")
@EditedEntityContainer("indicadorDc")
public class IndicadorEdit extends StandardEditor<Indicador> {
}