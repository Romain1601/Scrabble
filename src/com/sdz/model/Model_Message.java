package com.sdz.model;

import java.util.ArrayList;

import com.sdz.observer.Observable;
import com.sdz.observer.Observer;

public class Model_Message implements Observable {
	
	public ArrayList<String> success;
	public ArrayList<String> error;
	public ArrayList<Observer> MessageObserver = new ArrayList<Observer>();
	
	
	public Model_Message() {
		success = new ArrayList<String>();
		error = new ArrayList<String>();
	}
	
	public void addError(String message) {
		error.add(message);
		notifyObserver(message);
	}
	
	public void addSuccess(String message) {
		success.add(message);
		notifyObserver(message);
	}
	
	
	public ArrayList<String> getListError() {
		return error;
	}
	
	public ArrayList<String> getListSuccess() {
		return success;
	}
	
	public void resetListError() {
		error = new ArrayList<String>();
		notifyObserver("reset_error");
	}
	
	public void resetSuccess() {
		success = new ArrayList<String>();
		notifyObserver("reset_success");
	}
	
	
	
	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.MessageObserver.add(obs);
		
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		MessageObserver = new ArrayList<Observer>();
	}

	@Override
	public void notifyObserver(String str) {
		// TODO Auto-generated method stub
		MessageObserver.get(0).update(str);
	}
	
	
	
	

}
