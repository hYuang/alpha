package com.huang.rxjava;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SimpleRx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createObserver().subscribe(new Observer<Integer>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				System.out.println("onSubscribe ");
				
			}

			@Override
			public void onNext(Integer t) {
				// TODO Auto-generated method stub
				System.out.println("onNext "+ t);
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("onError "+ e);
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("onComplete ");
			}

			
			
		});
	}
	
	private static Observable<Integer> createObserver(){
		return Observable.create(new ObservableOnSubscribe<Integer>() {

			@Override
			public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
				// TODO Auto-generated method stub
				for( int i = 0; i < 5 ; i++) {
					int temp = new Random().nextInt(10);
					System.out.println("temp " +temp);
					if(temp > 8) {
						emitter.onError(new Throwable("value > 8"));
						break;
					}else {
						emitter.onNext(temp);
					}
					if (i == 4) {
						emitter.onComplete();
					}
				}
				
			}
			
		});
	}

}
