package com.ryxen.oauth;

import java.util.Map;

import org.springframework.security.oauth2.core.user.OAuth2User;

public abstract  class OAuth2UserInfo  implements OAuth2User{
	protected Map<String, Object> attributes;

    public OAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public abstract String getId();

    public abstract String getName();

    public abstract String getEmail();

    public abstract String getImageUrl();
}
