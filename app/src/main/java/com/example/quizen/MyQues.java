package com.example.quizen;

public class MyQues {
        int mQuestion;
        boolean mAns;

        public MyQues(int question, boolean ans) {
            mQuestion = question;
            this.mAns = ans;
        }

        public int getQuestion() {
            return mQuestion;
        }

        public void setQuestion(int question) {
            mQuestion = question;
        }

        public boolean isAns() {
            return mAns;
        }

        public void setAns(boolean ans) {
            mAns = ans;
        }
    }


