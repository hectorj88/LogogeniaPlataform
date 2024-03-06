package com.company.plataformalogogenia.security;

import com.company.plataformalogogenia.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.SpecificPolicy;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "AsesoraPedagogica", code = "asesora-pedagogica")
public interface AsesoraPedagogicaRole {
    @EntityAttributePolicy(entityClass = Reporte.class, attributes = "retroalimentacion", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Reporte.class, attributes = {"tutoriaId", "periodoAcademicoId", "fechaHoraEnvio", "videoSesion1", "videoSesion2", "escaneoSesion1", "escaneoSesion2", "indicadores"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Reporte.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void reporte();

    @MenuPolicy(menuIds = "ReportebrowseAsesoria")
    @ScreenPolicy(screenIds = {"ReportebrowseAsesoria", "Reporte.browse.Asesoria", "ReporteAse.retro", "LoginScreen", "MainScreen", "Logogenista.browse", "PeriodoAcademico.browse", "Alumno.browse"})
    void screens();

    @SpecificPolicy(resources = "ui.loginToUi")
    void specific();

    @EntityAttributePolicy(entityClass = Alumno.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Alumno.class, actions = EntityPolicyAction.READ)
    void alumno();

    @EntityAttributePolicy(entityClass = Competencia.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Competencia.class, actions = EntityPolicyAction.READ)
    void competencia();

    @EntityAttributePolicy(entityClass = Indicador.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Indicador.class, actions = EntityPolicyAction.READ)
    void indicador();

    @EntityAttributePolicy(entityClass = PeriodoAcademico.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = PeriodoAcademico.class, actions = EntityPolicyAction.READ)
    void periodoAcademico();

    @EntityAttributePolicy(entityClass = Tutoria.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Tutoria.class, actions = EntityPolicyAction.READ)
    void tutoria();

    @EntityAttributePolicy(entityClass = Logogenista.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Logogenista.class, actions = EntityPolicyAction.READ)
    void logogenista();
}