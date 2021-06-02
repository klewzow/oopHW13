package com.gmail.klewzow;

public class IncorrectInputString extends Exception {

	public IncorrectInputString() {

		System.err.println(this.getMessage());
	}

	@Override
	public String getMessage() {

		return "TIncorrectInputString";
	}

}
