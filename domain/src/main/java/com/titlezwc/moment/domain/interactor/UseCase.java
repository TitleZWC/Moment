package com.titlezwc.moment.domain.interactor;

import com.titlezwc.moment.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by TitleZWC on 2016/12/24.
 */

public abstract class UseCase{
    protected final PostExecutionThread postExecutionThread;
    protected Subscription subscription = Subscriptions.empty();
    protected final ThreadExecutor threadExecutor;

    protected UseCase(ThreadExecutor paramThreadExecutor, PostExecutionThread paramPostExecutionThread)
    {
        this.threadExecutor = paramThreadExecutor;
        this.postExecutionThread = paramPostExecutionThread;
    }

    protected abstract Observable buildUseCaseObservable(UseCaseParams paramUseCaseParams);

    public void execute(Subscriber paramSubscriber)
    {
        execute(paramSubscriber, null);
    }

    public void execute(Subscriber paramSubscriber, UseCaseParams paramUseCaseParams)
    {
        this.subscription = buildUseCaseObservable(paramUseCaseParams).subscribeOn(Schedulers.from(this.threadExecutor)).observeOn(this.postExecutionThread.getScheduler()).subscribe(paramSubscriber);
    }

    public void unsubscribe()
    {
        if (!this.subscription.isUnsubscribed())
            this.subscription.unsubscribe();
    }
}