package com.domoft.domoftware.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String lastName;
    private String username;
    private String password;
    private String imageUrl;
    private String title;
    private String bio;
    private String phone;
    private String address;
    private String preferredLanguage;
    private String notificationPreferences;
}
