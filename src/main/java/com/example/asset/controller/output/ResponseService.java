package com.example.asset.controller.output;


public class ResponseService<T> {
    private T data;
    private String message;
    private String status;
    private int totalPages;
    private int currentPage;
    private int limit;

    public ResponseService(T data, String message, String status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public ResponseService(T data, String message, String status, int totalPages, int currentPage, int limit) {
        this.data = data;
        this.message = message;
        this.status = status;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.limit = limit;
    }

    public ResponseService(T data) {
        this.data = data;
    }

    public ResponseService(T data, String status) {
        this.data = data;
        this.status = status;
    }

    public ResponseService(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
