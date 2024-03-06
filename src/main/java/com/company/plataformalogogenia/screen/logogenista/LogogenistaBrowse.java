package com.company.plataformalogogenia.screen.logogenista;

import com.company.plataformalogogenia.entity.User;
import com.company.plataformalogogenia.screen.roleassignmententity.RoleAssignmentEntityEdit;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import io.jmix.ui.RemoveOperation;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.DataGrid;
import io.jmix.ui.component.EntityPicker;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.*;
import com.company.plataformalogogenia.entity.Logogenista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@UiController("Logogenista.browse")
@UiDescriptor("logogenista-browse.xml")
@LookupComponent("table")
public class LogogenistaBrowse extends MasterDetailScreen<Logogenista> {

    @Autowired
    private EntityPicker<User> idCuentaField;

    @Autowired
    private ScreenBuilders screenBuilders;

    //private MetadataImpl metadata;

    //@Autowired
    //public RoleAssignmentEntity perfilLogo;

    /*@Autowired
    UiControllerDependencyManager dependencyManager;*/



    //Autowired
    //private EditorScreen<ResourceRoleModel> editorScreen_1;

    //Autowired
    //private CollectionContainer<RoleAssignmentEntity> roleAssignmentEntitiesDc;

    //private ResourceRoleModel roleModel;

    //DataGrid.EditorOpenEvent editorOpenEvent
    //After//ActionPerformedEvent

    @Subscribe
    public void onInit(InitEvent event)
    {
        idCuentaField.getAction("CrearCuenta").setVisible(false);
    }
    @Subscribe("table.edit")
    public void onTableEdit(Action.ActionPerformedEvent event) {
        //idCuentaField.getAction("entityClear").setVisible(false);
    }

    @Subscribe("table.create")
    public void onTableCreate(Action.ActionPerformedEvent event) {
        idCuentaField.getAction("CrearCuenta").setVisible(true);
    }
    @Subscribe("cancel")
    public void onCancel(Action.ActionPerformedEvent event) {
        idCuentaField.getAction("CrearCuenta").setVisible(false);
    }

    @Subscribe
    protected void onBeforeCommit(BeforeCommitChangesEvent event)
    {
        String nombUsuario=idCuentaField.getValue().getUsername();

        ApplicationContext apc=getApplicationContext();
        RoleAssignmentEntityEdit raee=
        screenBuilders.editor(RoleAssignmentEntity.class,this)
                .newEntity()
                .withInitializer(hacer -> {
                    setApplicationContext(apc);
                })
                .withScreenClass(RoleAssignmentEntityEdit.class)
                .build();

        RoleAssignmentEntity nuevo_rol=raee.getEditedEntity();

        nuevo_rol.setRoleType("resource");
        nuevo_rol.setRoleCode("logogenista");
        nuevo_rol.setUsername(nombUsuario);

        raee.setEntityToEdit(nuevo_rol);

        ((io.jmix.ui.component.impl.TextFieldImpl) raee.getWindow().getComponent("roleTypeField")).setValue("resource");
        ((io.jmix.ui.component.impl.TextFieldImpl) raee.getWindow().getComponent("roleCodeField")).setValue("logogenista");
        ((io.jmix.ui.component.impl.TextFieldImpl) raee.getWindow().getComponent("usernameField")).setValue(nombUsuario);

                /*screenBuilders.editor(RoleAssignmentEntity.class,this)
                .newEntity()
                .withInitializer(perfil -> {
                    perfil.setRoleType("resource");
                    perfil.setRoleCode("logogenista");
                    perfil.setUsername(nombUsuario);
                })
                .withScreenClass(RoleAssignmentEntityEdit.class)
                .build()
                .show();*/

        //JmixTextField nuevo = (JmixTextField) raee.getWindow().getComponent("usernameField");
        //nuevo.setValue(nombUsuario);
        raee.show();

        raee.closeWithCommit();

        String hola="hola";

        //RoleAssignmentEntity nuevo_rol=new RoleAssignmentEntity();

        //RoleAssignmentEntityEdit raee=

        //nuevo_rol.setRoleType("resource");
        //nuevo_rol.setRoleCode("logogenista");
        //nuevo_rol.setUsername(idCuentaField.getValue().getUsername());

        //raee.setEntityToEdit(nuevo_rol);
        //raee.closeWithCommit();

        /*metadata= (MetadataImpl) getApplicationContext().getBean("core_Metadata");
        RoleAssignmentEntity rolAAsignar = metadata.create(RoleAssignmentEntity.class);
        rolAAsignar.setUsername(idCuentaField.getValue().getUsername());
        rolAAsignar.setRoleCode("logogenista");
        rolAAsignar.setRoleType("resource");*/



        /*if (editing)
        {

        }*/
        //asignarRol();
        idCuentaField.getAction("CrearCuenta").setVisible(false);
    }

    private void asignarRol()
    {


        /*AsignadorPerfil asignador=new AsignadorPerfil();

        UiControllerUtils.setScreenData(asignador, getApplicationContext().getBean(ScreenData.class));
        dependencyManager.inject(asignador, FrameOwner.NO_OPTIONS);
        asignador.setUser(idCuentaField.getValue());
        asignador.getRoleAssignmentFragment().getFragment();

        asignador.guardar();

        metadata= (MetadataImpl) getApplicationContext().getBean("core_Metadata");
        RoleAssignmentEntity rolAAsignar = metadata.create(RoleAssignmentEntity.class);
        rolAAsignar.setUsername(idCuentaField.getValue().getUsername());
        rolAAsignar.setRoleCode("logogenista");
        rolAAsignar.setRoleType("resource");

        RoleAssignmentScreen ras= new RoleAssignmentScreen();
        ras.setUser(idCuentaField.getValue());


        //ResourceRoleModel rd=new ResourceRoleModel();

        RoleAssignmentFragment rf= new RoleAssignmentFragment();

        rf.setUser(idCuentaField.getValue());

        //rf.getFragment().getContext().

        //editorScreen_1.setEntityToEdit(rd);

        //roleAssignmentEntitiesDc.replaceItem(rolAAsignar);
        //StandardEditor<RoleAssignmentEntity> editor;*/


    }
}