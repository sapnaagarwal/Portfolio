package com.jpmc.portfolio;

import com.jpmc.exception.PortfolioException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PortfolioMain {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = null;
        List<String> fundList = new ArrayList<String>();
        String currentLine;
        try
        {
            if(args == null || args.length< 1){
                throw new PortfolioException(PortfolioException.ErrorCode.FILENAME_NOT_PROVIDED_ERROR);
            }
            br = new BufferedReader(new FileReader(args[0]));
            while (( currentLine = br.readLine()) != null){
                fundList.add(currentLine);
            }
            if(fundList.size()<1){
                System.out.println("No fund to create portfolio");
            }
            PortfolioWeightCalculatorImpl weightCalculator = new PortfolioWeightCalculatorImpl();
            weightCalculator.createPortfolio(fundList);

        }catch(PortfolioException e) {
            System.out.println(e.getErrorCode()+ ", " + e.getErrorMessage());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
            if (br != null)
                br.close();
        }

    }
}
