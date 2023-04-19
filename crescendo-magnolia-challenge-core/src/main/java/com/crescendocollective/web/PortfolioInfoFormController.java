package com.crescendocollective.web;

import info.magnolia.jcr.util.PropertyUtil;
import info.magnolia.module.blossom.annotation.Template;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crescendocollective.dto.Fund;
import com.crescendocollective.service.FundService;

@Controller
@Template(
    id = "crescendo-magnolia-challenge-core:components/portfolio-info/portfolioInfoForm",
    title = "Portfolio Entry Form (Spring)",
    dialog = "crescendo-magnolia-challenge:pages/fund-detail")
@RequestMapping("/portfolio-info-entry-form")
public class PortfolioInfoFormController {

    private final Logger logger = LoggerFactory.getLogger(PortfolioInfoFormController.class);
    private static final String VIEW_NAME = "/components/portfolio-info/portfolioInfoForm.ftl";

    @Autowired
    private FundService fundService;

    @RequestMapping(method = RequestMethod.GET)
    public String handleGet(Node pageNode, Node componentNode, ModelMap model) throws RepositoryException {
        String portfolioCode = PropertyUtil.getString(componentNode, "portfolioCode");

        Node portfolioNode = fundService.findPortfolioByPortfolioCode(portfolioCode);
        if (portfolioNode != null) {
            String code = portfolioNode.getProperty("portfolioCode").getString();
            logger.info("Portfolio Code From Repo: {}", code);
            model.addAttribute("portfolioCode", code);

            List<Fund>/*DTO*/ funds = fundService.findFundsByPortfolioCode(code);
            model.addAttribute("funds", funds);
        }

        return VIEW_NAME;
    }
}
