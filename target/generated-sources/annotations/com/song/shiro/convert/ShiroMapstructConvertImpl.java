package com.song.shiro.convert;

import com.song.shiro.jwt.JwtToken;
import com.song.shiro.vo.JwtTokenRedisVo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-24T15:18:34+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class ShiroMapstructConvertImpl implements ShiroMapstructConvert {

    @Override
    public JwtTokenRedisVo jwtTokenToJwtTokenRedisVo(JwtToken jwtToken) {
        if ( jwtToken == null ) {
            return null;
        }

        JwtTokenRedisVo jwtTokenRedisVo = new JwtTokenRedisVo();

        jwtTokenRedisVo.setHost( jwtToken.getHost() );
        jwtTokenRedisVo.setUsername( jwtToken.getUsername() );
        jwtTokenRedisVo.setSalt( jwtToken.getSalt() );
        jwtTokenRedisVo.setToken( jwtToken.getToken() );
        jwtTokenRedisVo.setCreateDate( jwtToken.getCreateDate() );
        jwtTokenRedisVo.setExpireSecond( jwtToken.getExpireSecond() );
        jwtTokenRedisVo.setExpireDate( jwtToken.getExpireDate() );

        return jwtTokenRedisVo;
    }
}
