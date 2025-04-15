# onecx-remote-component-example-bff

An example for a OneCX compatible BFF.

Start with (for local env)

```
export KC_REALM=onecx && export QUARKUS_OIDC_AUTH_SERVER_URL=http://keycloak-app:8080/realms/onecx && export QUARKUS_OIDC_TOKEN_ISSUER=http://keycloak-app/realms/onecx && export TKIT_SECURITY_AUTH_ENABLED=false && export TKIT_RS_CONTEXT_TENANT_ID_MOCK_ENABLED=false && export TKIT_LOG_JSON_ENABLED=false && export TKIT_OIDC_HEALTH_ENABLED=false && mvn quarkus:dev
```
