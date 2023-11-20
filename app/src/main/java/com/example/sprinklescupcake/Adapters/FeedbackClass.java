package com.example.sprinklescupcake.Adapters;

public class FeedbackClass {

    private int FeedbackId;
    private String UserId;
    private String FeedbackTitle;


    public FeedbackClass(int feedbackId, String userId, String feedbackTitle) {
        FeedbackId = feedbackId;
        UserId = userId;
        FeedbackTitle = feedbackTitle;
    }

    public FeedbackClass(String feedbackTitle) {
        FeedbackTitle = feedbackTitle;
    }

    public int getFeedbackId() {
        return FeedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        FeedbackId = feedbackId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getFeedbackTitle() {
        return FeedbackTitle;
    }

    public void setFeedbackTitle(String feedbackTitle) {
        FeedbackTitle = feedbackTitle;
    }
}
