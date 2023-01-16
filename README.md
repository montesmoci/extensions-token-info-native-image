## Environment
Version info: 'GraalVM 22.2.0 Java 17 CE'
Java version info: '17.0.4+8-jvmci-22.2-b06'
C compiler: cc (apple, arm64, 14.0.0)
Garbage collector: Serial GC
Micronaut: 3.8.1

## Steps to Recreate

1. Build native image `./gradlew nativeCompile`
2. Execute native image `./extensions-token-info`
3. Authenticate with Basic Authentication at `http://localhost:8080/login`
with credential Username = admin and Password = password
4. Request should respond with JWT cookie.
5. Perform GET `http://localhost:8080/token_info` request.
6. Observe the 'extensions' json object encompassing the `roles` array.
```json
{
  "extensions": {
    "roles": [
      "ADMIN"
    ]
  },
  "active": true,
  "username": "admin@example.com",
  "exp": 1673910387,
  "iat": 1673906787,
  "nbf": 1673906787,
  "sub": "admin@example.com",
  "iss": "extensions-token-info"
}
```


--------

## Micronaut 3.8.1 Documentation

- [User Guide](https://docs.micronaut.io/3.8.1/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.8.1/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.8.1/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


