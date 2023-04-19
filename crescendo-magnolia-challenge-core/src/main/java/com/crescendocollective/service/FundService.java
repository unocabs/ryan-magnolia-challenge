package com.crescendocollective.service;

import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.jcr.util.PropertyUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.springframework.stereotype.Service;

import com.crescendocollective.dto.Fund;
import com.crescendocollective.magnolia.essentials.util.JcrQueryUtil;

@Service
public class FundService {

    public Node findPortfolioByPortfolioCode(String portfolioCode) throws RepositoryException {
        String query = "select * from [mgnl:portfolio] as p where p.portfolioCode = $portfolioCode";
        Map<String, String> params = new HashMap<>();
        params.put("portfolioCode", portfolioCode);
        String workspace = "funds";
        return JcrQueryUtil.getNode(query, workspace, params);
    }

    public Node findFundByIsinNumber(String isinNumber) throws RepositoryException {
        String query = "select * from [mgnl:fund] as f where f.isinNumber = $isinNumber";
        Map<String, String> params = new HashMap<>();
        params.put("isinNumber", isinNumber);
        String workspace = "funds";
        return JcrQueryUtil.getNode(query, workspace, params);
    }

    public List<Fund> findFundsByPortfolioCode(String portfolioCode) throws RepositoryException {
        Node portfolio = findPortfolioByPortfolioCode(portfolioCode);
        Iterable<Node> funds = NodeUtil.getNodes(portfolio, "mgnl:fund");

        return StreamSupport.stream(funds.spliterator(), false).map( f -> {
            Fund fund = new Fund();

            try{
                fund.setName(f.getName());
                fund.setIsinNumber(PropertyUtil.getString(f, "isinNumber"));
            }catch (RepositoryException re){
                re.printStackTrace();
            }

            return fund;
        }).collect(Collectors.toList());
    }
}
