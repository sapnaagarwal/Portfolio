package com.jpmc.exception;

public class PortfolioException extends Exception {

    private int errorCode;
    private String errorMessage;

    public PortfolioException( ErrorCode errorCode) {
        this( errorCode, null);
    }

    public PortfolioException(ErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode=errorCode.errorCode;
        this.errorMessage=errorCode.errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public enum ErrorCode {

        INSUFFICIENT_FUND_INFORMATION_ERROR(1001, "Insufficient fund information. For each record in data file 3 paramter should be passed in."),
        FILENAME_NOT_PROVIDED_ERROR(1002, "Please provide datafile name"),
        NO_FUND_ERROR(1002, "No fund to create portfolio."),
        UNKNOWN(10001,"Unknown");

        private String errorMessage;
        private int errorCode;

        ErrorCode(int errorCode, String errorMessage){
            this.errorCode=errorCode;
            this.errorMessage=errorMessage;
        }
    }
}
