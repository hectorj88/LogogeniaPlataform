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

@ResourceRole(name = "Logogenista", code = "logogenista")
public interface LogogenistaRole {
    @MenuPolicy(menuIds = "ReporteLogo.browse")
    @ScreenPolicy(screenIds = {"ReporteLogo.browse", "Competencia.browse", "Indicador.edit", "Alumno.browse", "MainScreen", "LoginScreen", "PeriodoAcademico.browse", "ReporteLogo.crear", "ReporteLogo.abrir", "Tutoria.browse", "LogoTutoria.browse"})
    void screens();

    @EntityAttributePolicy(entityClass = Reporte.class, attributes = {"tutoriaId", "periodoAcademicoId", "videoSesion1", "videoSesion2", "escaneoSesion1", "escaneoSesion2", "indicadores"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Reporte.class, attributes = {"id", "retroalimentacion", "fechaHoraEnvio"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Reporte.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ})
    void reporte();

    @EntityAttributePolicy(entityClass = Alumno.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Alumno.class, actions = EntityPolicyAction.READ)
    void alumno();

    @EntityAttributePolicy(entityClass = Competencia.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Competencia.class, actions = EntityPolicyAction.READ)
    void competencia();

    @EntityAttributePolicy(entityClass = Indicador.class, attributes = "porcentajeCompletado", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Indicador.class, attributes = {"idCompetencia", "reporte"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Indicador.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.CREATE})
    void indicador();

    @EntityAttributePolicy(entityClass = PeriodoAcademico.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = PeriodoAcademico.class, actions = EntityPolicyAction.READ)
    void periodoAcademico();

    @EntityAttributePolicy(entityClass = Tutoria.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Tutoria.class, actions = EntityPolicyAction.READ)
    void tutoria();

    @SpecificPolicy(resources = "ui.loginToUi")
    void specific();
}