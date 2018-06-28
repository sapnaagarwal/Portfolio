package com.jpmc.portfolio;

import com.jpmc.exception.PortfolioException;

import java.text.DecimalFormat;
import java.util.List;

public class PortfolioWeightCalculatorImpl implements PortfolioWeightCalculator {

    public void createPortfolio(List<String> fundList) throws PortfolioException{
        String[] fundInfo = null;
        Fund rootFund = new Fund();
        Fund targetFund = null;

        if(fundList == null || fundList.size()<1){
            throw new PortfolioException(PortfolioException.ErrorCode.NO_FUND_ERROR);
        }

        for(String fund: fundList){
            fundInfo = fund.split(",");
            if(fundInfo.length != 3){
                throw new PortfolioException(PortfolioException.ErrorCode.INSUFFICIENT_FUND_INFORMATION_ERROR);
            }
            targetFund = rootFund;
            if(rootFund.name !=null){
                if(! fundInfo[0].equals(rootFund.name)){
                    for(Fund n: rootFund.getChildren()){
                        if(n.name.equals(fundInfo[0])){
                            targetFund = n;
                            break;
                        }
                    }
                }else{
                    rootFund.val = rootFund.val + Integer.parseInt(fundInfo[2]);
                }
            }else{
                rootFund.name=fundInfo[0];
                rootFund.val = Integer.parseInt(fundInfo[2]);
            }
            Fund childFund = new Fund();
            childFund.name = fundInfo[1];
            childFund.val = Integer.parseInt(fundInfo[2]);
            targetFund.addChild(childFund);
        }
        this.calculateFundWeight(rootFund, rootFund.getVal(), rootFund.getName());
    }

    public void calculateFundWeight(Fund n, long parentSum, String parentFundName ){
        if(n.getChildren().size()<1){

            double fundWeight = (double) n.getVal()/parentSum;
            DecimalFormat decFormat = new DecimalFormat("#0.000");
            StringBuilder sb = new StringBuilder();
            sb.append(parentFundName);
            sb.append(",");
            sb.append(n.getName());
            sb.append(",");
            sb.append(decFormat.format(fundWeight));
            System.out.println(sb);
        }
        for(Fund n1: n.getChildren()){
            calculateFundWeight(n1,parentSum,parentFundName);
        }
    }
}
