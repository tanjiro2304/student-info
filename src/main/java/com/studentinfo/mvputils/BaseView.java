package com.studentinfo.mvputils;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveObserver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class BaseView<P extends Presenter> extends VerticalLayout implements View<P>,
        BeforeEnterObserver, BeforeLeaveObserver {

    @Autowired
    private P presenter;

    @PostConstruct
    private void postConstruct() {
        if (presenter != null) {
            presenter.setView(this);
            presenter.beforeViewInit();
            init();
            presenter.afterViewInit();
        }
    }

    protected abstract void init();

    @Override
    public P getPresenter() {
        return presenter;
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        getPresenter().beforeEnter(event);
    }

    @Override
    public void beforeLeave(BeforeLeaveEvent event) {
        getPresenter().beforeLeave(event);
    }
}
