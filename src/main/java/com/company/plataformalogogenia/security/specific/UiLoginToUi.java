package com.company.plataformalogogenia.security.specific;

import io.jmix.core.accesscontext.SpecificOperationAccessContext;

public class UiLoginToUi extends SpecificOperationAccessContext {

    public static final String NAME = "ui.loginToUi";

    public UiLoginToUi() {
        super(NAME);
    }
}
