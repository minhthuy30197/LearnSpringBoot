package com.example.demo.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Please provide a valid email")
    @ApiModelProperty(
            example="sam.smith@gmail.com",
            notes="Email cannot be empty",
            required=true
    )
    private String email;

    @Pattern(regexp="(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Please provide a valid phone number")
    @ApiModelProperty(
            example="0916016972",
            notes="Phone cannot be empty",
            required=true
    )
    private String phone;

    @NotNull(message = "Full name is required")
    @NotEmpty(message = "Full name is required")
    @ApiModelProperty(
            example="Sam Smith",
            notes="Full name cannot be empty",
            required=true
    )
    @JsonProperty("full_name")
    private String fullName;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    @Size(min = 4, max = 20, message = "Pasword must be between 4 and 20 characters")
    @ApiModelProperty(
            example="verysecretpassword",
            notes="Password can't be empty",
            required=true
    )
    private String password;

    @Valid
    @URL(regexp="(https?:\\/\\/.*\\.(?:png|jpg))", message="Avatar must be an url image")
    @ApiModelProperty(
            example="https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png",
            notes="Avatar must be an url image",
            required=false
    )
    private String avatar;

    @JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(
            example = "2019/12/20",
            notes="Birthday can't be empty",
            required=true
    )
    private Date birthday;
}
