package com.yimning.service.auth;

import com.yimning.entity.auth.AccessTokenDTO;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.apache.http.Header;

import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Authentication {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        System.out.println(getToken());
    }

    public static String getToken() throws NoSuchAlgorithmException, KeyManagementException, IOException {
        File file = new File("token.text");
        String token = "";
        String str = "";
        if (file.exists()) {
            BufferedReader bufferedReader = null;
            InputStreamReader inputStreamReader = null;
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(file));
                bufferedReader = new BufferedReader(inputStreamReader);
                while ((str = bufferedReader.readLine()) != null) {
                    token = token + str;
                }
            } catch (IOException e) {
                System.out.println("token exist.");
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("close stream faild");
                }
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    System.out.println("close stream faild");
                }
            }
        }

        if (token.trim().length() > 0) {
            return token;
        }

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();

        AccessTokenDTO.AuthDTO authDTO = new AccessTokenDTO.AuthDTO();
        AccessTokenDTO.AuthDTO.IdentityDTO.PasswordDTO.UserDTO.DomainDTO domainDTO = new AccessTokenDTO.AuthDTO.IdentityDTO.PasswordDTO.UserDTO.DomainDTO();
        AccessTokenDTO.AuthDTO.IdentityDTO identityDTO = new AccessTokenDTO.AuthDTO.IdentityDTO();
        AccessTokenDTO.AuthDTO.IdentityDTO.PasswordDTO passwordDTO = new AccessTokenDTO.AuthDTO.IdentityDTO.PasswordDTO();
        AccessTokenDTO.AuthDTO.IdentityDTO.PasswordDTO.UserDTO userDTO = new AccessTokenDTO.AuthDTO.IdentityDTO.PasswordDTO.UserDTO();
        AccessTokenDTO.AuthDTO.ScopeDTO.ProjectDTO projectDTO = new AccessTokenDTO.AuthDTO.ScopeDTO.ProjectDTO();
        AccessTokenDTO.AuthDTO.ScopeDTO scopeDTO = new AccessTokenDTO.AuthDTO.ScopeDTO();
        projectDTO.setName("cn-north-4");
        scopeDTO.setProject(projectDTO);
        domainDTO.setName("hw112288");

        userDTO.setName("hw112288");
        userDTO.setPassword("asd2015..");
        userDTO.setDomain(domainDTO);

        passwordDTO.setUser(userDTO);
        List<String> method = new ArrayList<String>();
        method.add("password");
        identityDTO.setMethods(method);
        identityDTO.setPassword(passwordDTO);

        authDTO.setIdentity(identityDTO);
        authDTO.setScope(scopeDTO);

        accessTokenDTO.setAuth(authDTO);

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json;charset=utf8");
        StreamClosedHttpResponse httpResponse = null;
        try {
            httpResponse = httpUtils.doPost(Constant.TOKEN_ACCESS_URL, header, JsonUtils.jsonObj2Sting(accessTokenDTO));
        } catch (Exception exception) {
            System.err.println("please check your network.");
            return null;
        }


        Header[] headers = httpResponse.getHeaders("X-Subject-Token");
        token =headers[0].getValue();
        if (file.exists()) {
            file.delete();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(token.getBytes());
        fileOutputStream.close();
        return token;
    }
}
