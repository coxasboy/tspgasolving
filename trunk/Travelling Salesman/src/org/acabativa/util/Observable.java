package org.acabativa.util;

public interface Observable {

	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	
}
