package com.zjn.util.message;

import java.util.Map;

public class ErrorMessageException extends RuntimeException {

    private Map<String, Object> resultData;
    private Message errorMessage;

    public Message getErrorMessage() {
        return errorMessage;
    }

    public ErrorMessageException(Message errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorMessageException(Message errorMessage, Object data) {
        this.errorMessage = errorMessage;
        this.resultData = this.errorMessage.createWithData(data);
    }

    public ErrorMessageException(Map<String, Object> resultData) {
        resultData = resultData;
    }

    public Map<String, Object> getResultData() {
        if (resultData != null) {
            return resultData;
        } else {
            return this.errorMessage.create();
        }
    }
}
