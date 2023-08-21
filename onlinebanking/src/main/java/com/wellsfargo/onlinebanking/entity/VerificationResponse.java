package com.wellsfargo.onlinebanking.entity;

public class VerificationResponse {
	
private boolean valid;

public VerificationResponse(boolean valid) {
	this.valid = valid;
}

public boolean isValid() {
	return valid;
}

public void setValid(boolean valid) {
	this.valid = valid;
}


}
