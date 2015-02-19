package com.capgemini.StarterKit.SwingClient;

public final class RestServiceAdresses {

    public static final String ZIP_CODE_FIND_ALL = "http://localhost:8080/ElectionRestServiceDAO/ElectionRest/zipCode/findAll";
    public static final String CANDIDATE_FIND_FOR_ZIPCODE = "http://localhost:8080/ElectionRestServiceDAO/ElectionRest/candidate/findCorrectCandidate/";
	public static final String CHECK_ZIP_CODE_PESEL_CORELATION = "http://localhost:8080/ElectionRestServiceDAO/ElectionRest/voters/check/";
	public static final String SAVE_RESULTS_TO_DATABASE = "http://localhost:8080/ElectionRestServiceDAO/ElectionRest/result/createStr/";
}
