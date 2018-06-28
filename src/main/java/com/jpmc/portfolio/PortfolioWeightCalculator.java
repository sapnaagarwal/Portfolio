package com.jpmc.portfolio;

import com.jpmc.exception.PortfolioException;

import java.util.List;

public interface PortfolioWeightCalculator {

    public void createPortfolio(List<String> fundList) throws PortfolioException;

    public void calculateFundWeight(Fund n, long parentSum, String parentFundName);
}
