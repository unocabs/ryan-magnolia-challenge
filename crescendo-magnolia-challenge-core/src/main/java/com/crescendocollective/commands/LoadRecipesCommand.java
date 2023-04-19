package com.crescendocollective.commands;

import info.magnolia.commands.impl.BaseRepositoryCommand;
import info.magnolia.context.Context;

import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crescendocollective.config.ApplicationContextBean;

public class LoadRecipesCommand extends BaseRepositoryCommand {

    private final Logger logger = LoggerFactory.getLogger(LoadRecipesCommand.class);

    public LoadRecipesCommand(ApplicationContextBean applicationContextBean) {

    }

    @Override
    public boolean execute(Context context) throws RepositoryException {
        // TODO: Retreive recipe JSON data and save to recipes workspace
        return true;
    }


}
