package com.kodelabs.boilerplate;

import com.kodelabs.boilerplate.domain.executor.Executor;
import com.kodelabs.boilerplate.domain.executor.MainThread;
import com.kodelabs.boilerplate.domain.interactors.WelcomingInteractor;
import com.kodelabs.boilerplate.domain.interactors.impl.WelcomingInteractorImpl;
import com.kodelabs.boilerplate.domain.repository.MessageRepository;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WelcomingInteractorImplTest {

    private WelcomingInteractor.Callback mMockedCallback;
    private MessageRepository mMessageRepository;
    private Executor mExecutor;
    private MainThread mMainThread;


    @Test
    public void testWelcomeMessageFound() throws Exception {

        String msg = "Welcome, friend!";

        mMessageRepository = mock(MessageRepository.class);
        mExecutor = mock(Executor.class);
        mMainThread = mock(MainThread.class);
        mMockedCallback = mock(WelcomingInteractor.Callback.class);

        when(mMessageRepository.getWelcomeMessage()).thenReturn(msg);

        WelcomingInteractorImpl interactor = new WelcomingInteractorImpl(
                mExecutor,
                mMainThread,
                mMockedCallback,
                mMessageRepository
        );

        interactor.run();

        Mockito.verify(mMessageRepository).getWelcomeMessage();
        //Mockito.verifyNoMoreInteractions(mMessageRepository);
        //Mockito.verify(mMockedCallback).onMessageRetrieved(msg);
    }
}
