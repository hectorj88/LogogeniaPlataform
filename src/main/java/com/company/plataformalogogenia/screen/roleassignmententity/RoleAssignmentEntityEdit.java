package com.company.plataformalogogenia.screen.roleassignmententity;

import io.jmix.ui.screen.*;
import io.jmix.securitydata.entity.RoleAssignmentEntity;

import java.util.ArrayList;
import java.util.List;

@UiController("sec_RoleAssignmentEntity.edit")
@UiDescriptor("role-assignment-entity-edit.xml")
@EditedEntityContainer("roleAssignmentEntityDc")
public class RoleAssignmentEntityEdit extends StandardEditor<RoleAssignmentEntity> {
}