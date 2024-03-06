package com.company.plataformalogogenia.security;

import com.company.plataformalogogenia.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.SpecificPolicy;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "Administradora", code = "administradora")
public interface AdministradoraRole {
    @MenuPolicy(menuIds = {"Cuentas", "Logogenista.browse", "PeriodoAcademico", "Tutoria.browse", "PeriodoAcademico.browse", "Alumno.browse"})
    @ScreenPolicy(screenIds = {"LoginScreen", "MainScreen", "Cuenta.browse", "Cuentas", "Cuenta.edit", "Logogenista.browse", "PeriodoAcademico", "Tutoria.browse", "PeriodoAcademico.browse", "Alumno.browse", "sec_RoleAssignmentEntity.edit"})
    void screens();

    @EntityPolicy(entityClass = User.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    @EntityAttributePolicy(entityClass = User.class, attributes = {"username", "password"}, action = EntityAttributePolicyAction.MODIFY)
    void user();

    @SpecificPolicy(resources = "ui.loginToUi")
    void specific();

    @EntityPolicy(entityClass = Alumno.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    @EntityAttributePolicy(entityClass = Alumno.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    void alumno();

    @EntityPolicy(entityClass = Logogenista.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    @EntityAttributePolicy(entityClass = Logogenista.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    void logogenista();

    @EntityAttributePolicy(entityClass = PeriodoAcademico.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = PeriodoAcademico.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void periodoAcademico();

    @EntityAttributePolicy(entityClass = Competencia.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Competencia.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void competencia();

    @EntityAttributePolicy(entityClass = Indicador.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Indicador.class, actions = {EntityPolicyAction.UPDATE, EntityPolicyAction.READ, EntityPolicyAction.CREATE})
    void indicador();

    @EntityAttributePolicy(entityClass = Reporte.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Reporte.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void reporte();

    @EntityAttributePolicy(entityClass = Tutoria.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Tutoria.class, actions = {EntityPolicyAction.UPDATE, EntityPolicyAction.READ, EntityPolicyAction.CREATE})
    void tutoria();

    @EntityAttributePolicy(entityClass = RoleAssignmentEntity.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = RoleAssignmentEntity.class, actions = {EntityPolicyAction.UPDATE, EntityPolicyAction.READ, EntityPolicyAction.CREATE})
    void sec_RoleAssignmentEntity();
}