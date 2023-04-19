package com.crescendocollective.templates;

import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

import javax.jcr.Node;
import javax.servlet.http.HttpServletRequest;

public class SweepstakesEntryFormModel<RD extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition> {

    public SweepstakesEntryFormModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) {
        super(content, definition, parent);
    }

    public String execute() {

        HttpServletRequest request = MgnlContext.getWebContext().getRequest();
        if ("POST".equals(request.getMethod())) {
            //TODO: Process form data and save to sweepstakes workspace
        }

        return super.execute();
    }

}
