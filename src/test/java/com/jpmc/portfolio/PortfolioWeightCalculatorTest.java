package com.jpmc.portfolio;

import com.jpmc.exception.PortfolioException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class PortfolioWeightCalculatorTest {

    @Mock
    private PortfolioWeightCalculator portfolioWeightCalculator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreatePortfolio() throws Exception {
        List<String> fundList = new ArrayList<>();
        fundList.add("A,B,1000");
        fundList.add("A,C,2000");
        fundList.add("B,D,500");
        fundList.add("B,E,250");
        fundList.add("B,F,250");
        fundList.add("C,G,1000");
        fundList.add("C,H,1000");
        Mockito.doNothing().when(portfolioWeightCalculator).createPortfolio(fundList);
        portfolioWeightCalculator.createPortfolio(fundList);
        Mockito.verify(portfolioWeightCalculator,Mockito.times(1)).createPortfolio(Mockito.anyList());

    }

    @Test(expected = PortfolioException.class)
    public void testCreatePortfolio_ThrowException() throws  Exception{
        Mockito.doThrow(PortfolioException.class).when(portfolioWeightCalculator).createPortfolio(null);
        portfolioWeightCalculator.createPortfolio(null);
    }
}