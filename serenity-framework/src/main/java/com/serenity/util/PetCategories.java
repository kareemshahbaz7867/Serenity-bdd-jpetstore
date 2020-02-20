package com.serenity.util;

public enum PetCategories {
	
	FISH("Fish"),
	CATS("Cats"),
	DOGS("Dogs"),
	REPTILES("Reptiles"),
	BIRDS("Birds");
	
	String value;
	
	PetCategories(String value)
	{
		this.value=value;
	}
	
	public String getValue()
	{
		return value;
	}

}
