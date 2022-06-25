package com.example.vuelovmovil.notifications;

public class UserTokenRequest {
    private String token;
    private Long usuarioId;

    public UserTokenRequest(String token, Long usuarioId) {
        this.token = token;
        this.usuarioId = usuarioId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getusuarioId() {
        return usuarioId;
    }

    public void setusuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
