package com.huang.rxjava;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class CompleteRx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createCompleteOnComplete().subscribe(new CompletableObserver() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				System.out.println("disposable");
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("onComplete");
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("Throwable "+e.getMessage());
			}
			
		});
		createCompleteOnError().subscribe(new CompletableObserver() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				System.out.println("disposable");
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("onComplete");
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("Throwable "+e.getMessage());
			}
			
		});

	}
	
	public static Completable createCompleteOnComplete(){
		return Completable.create(new CompletableOnSubscribe() {

			@Override
			public void subscribe(CompletableEmitter emitter) throws Exception {
				// TODO Auto-generated method stub
				emitter.onComplete();
				
			}
			
		});
		
	}
	
	public static Completable createCompleteOnError(){
		return Completable.create(new CompletableOnSubscribe() {

			@Override
			public void subscribe(CompletableEmitter emitter) throws Exception {
				// TODO Auto-generated method stub
				emitter.onError(new Throwable("Complete error"));
				
			}
			
		});
		
	}

}
