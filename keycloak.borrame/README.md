

## Keycloak

https://www.keycloak.org/documentation.html

### Getting Started Guide

https://www.keycloak.org/docs/latest/getting_started/index.html

### Server Administration Guide

https://www.keycloak.org/docs/latest/server_admin/

Authorization Code Flow

https://www.keycloak.org/docs/latest/server_admin/index.html#authorization-code-flow



### Authorization Services Guide

https://www.keycloak.org/docs/latest/authorization_services/

Role-based access control (RBAC)

### Keycloak Admin REST API

https://www.keycloak.org/docs-api/5.0/rest-api/index.html

Google: keycloak admin user for realm



https://github.com/keycloak/keycloak-containers

https://github.com/ncarlier/kong-integration-samples/blob/master/docker-compose.keycloak.yml

```
% docker-compose -f "keycloak/docker-compose.keycloak-postgres.yml" -p keycloak_registry_tuto up -d 
% docker-compose -f "keycloak/docker-compose.keycloak-postgres.yml" ps
% docker-compose -p keycloak_registry_tuto ps
% docker-compose -p keycloak_registry_tuto logs -f keycloak
% curl -s http://localhost:8080/auth/realms/master/health/check

%# Removing volume 
docker-compose down -v
```


