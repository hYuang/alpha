package com.huang.rxjava;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;

public class SingleRx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createSingleSuccess().subscribe(new SingleObserver<Integer>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Integer t) {
				// TODO Auto-generated method stub
				System.out.println("onSuccess "+t);
				
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("Throwable "+e.getMessage());
				
			}
			
		});
		
		createSingleError().subscribe(new SingleObserver<Integer>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Integer t) {
				// TODO Auto-generated method stub
				System.out.println("onSuccess "+t);
				
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("Throwable "+e.getMessage());
				
			}
			
		});

	}
	
	private static Single<Integer> createSingleSuccess(){
		return Single.create(new SingleOnSubscribe<Integer>(){
			@Override
			public void subscribe(SingleEmitter<Integer> emitter) throws Exception {
				// TODO Auto-generated method stub
				emitter.onSuccess(1);
			}
		});
	}
	
	private static Single<Integer> createSingleError(){
		return Single.create(new SingleOnSubscribe<Integer>(){
			@Override
			public void subscribe(SingleEmitter<Integer> emitter) throws Exception {
				// TODO Auto-generated method stub
				emitter.onError(new Throwable("single error"));
			}
		});
	}

}
