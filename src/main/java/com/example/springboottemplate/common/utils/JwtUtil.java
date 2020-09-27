package com.example.springboottemplate.common.utils;

import com.example.springboottemplate.common.enums.ResponseCodeAndMsg;
import com.example.springboottemplate.common.exception.ApiException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    // 加密秘钥，每次重启服务器都会重新生成，这就意味着，每次重启服务器，所有已登录的用户都会强制退出，感觉不能忍啊！
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // token 过期时间 24 小时
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    /**
     * 解析 jwt
     */
    public static Object parse(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
        } catch (JwtException e) {
            throw new ApiException(ResponseCodeAndMsg.JWT_PARSE_ERROR);
        }
    }

    /**
     * 生成 jwt
     */
    public static String sign(Map map) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        return Jwts.builder().setClaims(map).signWith(SECRET_KEY).setExpiration(date).compact();
    }
}
