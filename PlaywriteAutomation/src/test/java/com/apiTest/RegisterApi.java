package com.apiTest;

import com.base.BaseTest;

public class RegisterApi extends BaseTest{
	
	private static String registeredUserEmail;
    private static String registeredUserPassword;
    private static String userToken;

    
    
    
    @Test
    @Order(1)
    public void testRegisterUser_success() {
        String name = "Sathishkumar";
        String email = " sathish16148@mail.com";
        String password = "password123";

        registeredUserEmail = email;
        registeredUserPassword = password;

        UserRegisterRequest req = new UserRegisterRequest(name, email, password);

        Response resp = ApiUtils.getRequestSpec()
            .body(req)
            .when()
            .post("/users/register")
            .then()
            .statusCode(201)
            .body("message", notNullValue())
            .body("data.email", equalTo(email))
            .extract().response();

        RegisterResponse rr = resp.as(RegisterResponse.class);
        assertEquals(email, rr.getData().getEmail());
        assertEquals(name, rr.getData().getName());
        assertNotNull(rr.getData().getId());
    }

}
