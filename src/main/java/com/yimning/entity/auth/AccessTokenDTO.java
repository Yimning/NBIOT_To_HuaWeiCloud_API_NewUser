package com.yimning.entity.auth;

import lombok.Data;

import java.util.List;

@Data
public class AccessTokenDTO {
    private AuthDTO auth;

    @Data
    public static class AuthDTO {
        private IdentityDTO identity;

        private ScopeDTO scope;

        @Data
        public static class IdentityDTO {

            private List<String> methods;

            private PasswordDTO password;

            @Data
            public static class PasswordDTO {

                private UserDTO user;


                @Data
                public static class UserDTO {

                    private String name;

                    private String password;

                    private DomainDTO domain;


                    @Data
                    public static class DomainDTO {

                        private String name;

                    }

                }

            }
        }


        @Data
        public static class ScopeDTO {

            private ProjectDTO project;

            @Data
            public static class ProjectDTO {
                private String name;

            }
        }
    }

}
