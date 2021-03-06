package com.se.hackathon.helper.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "Login Request", description = "The login request payload")
public class LoginRequest {

   // @NullOrNotBlank(message = "Login Username can be null but not blank")
    @ApiModelProperty(value = "Registered username", allowableValues = "NonEmpty String")
    private String username;

  //  @NullOrNotBlank(message = "Login Email can be null but not blank")
    @ApiModelProperty(value = "User registered email", required = true, allowableValues = "NonEmpty String")
    private String email;

    @NotNull(message = "Login password cannot be blank")
    @ApiModelProperty(value = "Valid user password", required = true, allowableValues = "NonEmpty String")
    private String password;
}
