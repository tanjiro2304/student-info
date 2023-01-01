package com.studentinfo.mvputils;

public interface View<P extends Presenter> {
    P getPresenter();

}
