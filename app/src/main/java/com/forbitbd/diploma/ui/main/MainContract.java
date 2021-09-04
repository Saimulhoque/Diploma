package com.forbitbd.diploma.ui.main;

import com.forbitbd.diploma.model.Result;

public interface MainContract {
    
    interface View{
        void showProgressbar();
        void hideProgressbar();
        void openDialog(Result result);
    }
    
    interface Presenter{

        void getResults(Result result);
    }
}
