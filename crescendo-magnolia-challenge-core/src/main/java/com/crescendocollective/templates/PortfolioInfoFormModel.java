package com.crescendocollective.templates;

import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

import javax.jcr.Node;
import javax.servlet.http.HttpServletRequest;

import com.crescendocollective.config.ApplicationContextBean;

public class PortfolioInfoFormModel<RD extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition> {

    public PortfolioInfoFormModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent,
                                  ApplicationContextBean applicationContextBean) {
        super(content, definition, parent);
    }

    @Override
    public String execute(){
        HttpServletRequest request = MgnlContext.getWebContext().getRequest();
        if ("POST".equals(request.getMethod())) {
            //TODO: Process form data anPortfolioInfoFormModeld save to sweepstakes workspace
        }
        return super.execute();
    }
}
