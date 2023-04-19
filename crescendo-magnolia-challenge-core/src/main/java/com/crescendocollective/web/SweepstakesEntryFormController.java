package com.crescendocollective.web;

import info.magnolia.module.blossom.annotation.Template;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Template(id = "crescendo-magnolia-challenge-core:components/sweepstakes/sweepstakesEntryForm", title = "Sweepstakes Entry Form (Spring)")
@RequestMapping("/sweepstakes-entry-form")
public class SweepstakesEntryFormController {

    private static final String VIEW_NAME = "/components/sweepstakes/sweepstakesEntryForm.ftl";
    private static final String VIEW_NAME_THANKS = "/components/sweepstakes/sweepstakesEntryFormThanks.ftl";

    @RequestMapping(method = RequestMethod.GET)
    public String handleGet() {
        return VIEW_NAME;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handlePost() {
        // TODO: Process form data and save to sweepstakes workspace
        return VIEW_NAME_THANKS;
    }

}
