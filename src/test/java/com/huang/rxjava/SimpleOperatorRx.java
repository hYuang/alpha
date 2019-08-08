package com.huang.rxjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

public class SimpleOperatorRx {
	public final static Logger log = LoggerFactory.getLogger(SimpleOperatorRx.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getRange();
		getJust().subscribe(new Consumer<Long>() {
			@Override
			public void accept(Long t) throws Exception {
				// TODO Auto-generated method stub
				log.info("just " +t);
			}
		});
		getDefer().subscribe(new Consumer<Long>() {
			@Override
			public void accept(Long t) throws Exception {
				// TODO Auto-generated method stub
				log.info("defer " +t);
			}
		});
		Integer []  arrays = {0,1,2,3,4,5};
		List<Integer> list = new ArrayList<Integer>();
		int length  =arrays.length;
		for( int i = 0 ; i < length ; i++) {
			list.add(arrays[i]);
		}
		fromArray(arrays).subscribe(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) throws Exception {
				// TODO Auto-generated method stub
				log.info("arrays " + t);
			}
		});
		fromInterator(list).subscribe(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) throws Exception {
				// TODO Auto-generated method stub
				log.info("list "+t);
			}
		});
		
		flatMapObserver().subscribe(new Consumer<String>() {
			@Override
			public void accept(String t) throws Exception {
				// TODO Auto-generated method stub
				log.info("flatMap " +t);
			}
		});
		
		flatMapIterableObserver().subscribe(new Consumer<String>() {

			@Override
			public void accept(String t) throws Exception {
				// TODO Auto-generated method stub
				log.info("flatMapIterable " +t);
			}
		});
		
		groupByObserver().subscribe(new Consumer<GroupedObservable<Integer,Integer>>(){
			@Override
			public void accept(GroupedObservable<Integer, Integer> t) throws Exception {
				log.info("groupByObserver: " + t.getKey()  );
			}
		});
		
		groupByStringObserver().subscribe(new Consumer<GroupedObservable<Integer,String>>(){
			@Override
			public void accept(GroupedObservable<Integer, String> t) throws Exception {
				log.info("groupByStringObserver: " + t.getKey()  );
			}
		});
	}
	
	public static void getRange() {
		Observable.range(10, 5).subscribe(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) throws Exception {
				// TODO Auto-generated method stub
				log.info("range " + t);
			}
		});
	}
	
	public static Observable<Long> getJust() {
		return Observable.just(System.currentTimeMillis());
	}
	
	public static Observable<Long> getDefer(){
		return Observable.defer(new Callable<Observable<Long>>() {

			@Override
			public Observable<Long> call() throws Exception {
				// TODO Auto-generated method stub
				return getJust();
			}
		});
	}
	
	public static Observable<Integer> fromArray(Integer[] items){
		return Observable.fromArray(items);
	}
	
	public static Observable<Integer> fromInterator(List<Integer> items){
		return Observable.fromIterable(items);
	}
	
	public static Observable<String> flatMapObserver(){
		return Observable.just(1,2,3).flatMap(new Function<Integer,Observable<String>>(){
			@Override
			public Observable<String> apply(Integer t) throws Exception {
				return Observable.just("flat Map :" + t);
			}
		});
	}
	
	public static Observable<String> flatMapIterableObserver(){
		return Observable.just(1, 2, 3).flatMapIterable(new Function<Integer,Iterable<String>>(){

			@Override
			public Iterable<String> apply(Integer t) throws Exception {
				// TODO Auto-generated method stub
				List<String> s = new ArrayList<String>();
				s.add("flatMapIterable: " + t);
				return s;
			}
		});
	}
	
	public static Observable<GroupedObservable<Integer,Integer>> groupByObserver(){
		return Observable.just(1,2,3,4,5,6,7,8,9).groupBy(new Function<Integer,Integer>(){
			@Override
			public Integer apply(Integer t) throws Exception {
				// TODO Auto-generated method stub
				return t %2;
			}
		});
	}
	
	public static Observable<GroupedObservable<Integer,String>> groupByStringObserver(){
		return Observable.just(1,2,3,4,5,6,7,8,9).groupBy(new Function<Integer,Integer>(){

			@Override
			public Integer apply(Integer t) throws Exception {
				// TODO Auto-generated method stub
				return t % 2;
			}
		},new Function<Integer,String>(){
			@Override
			public String apply(Integer t) throws Exception {
				// TODO Auto-generated method stub
				return "groupByKeyValue:" + t;
			}
		});
	}

}
