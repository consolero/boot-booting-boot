# Boot Booting Boot

Yo dawg, I herd you like Spring Boot, so I put `@SpringBootTest` on `class Boot`
so it boots `OpenAPI2SpringBoot` while you build.

----

Minimal exemplary multi-module Gradle project (Kotlin DSL) that generates
a Spring Boot REST API and a client, launches the server during
integration testing and uses the generated client to check whether both work.

We generate client and server at build time via the OpenAPI Generator Gradle
plugin and use OpenAPI's legendary [`petstore.yaml`][petstore] for this purpose.

Usage:

- Build and run tests: `./gradlew build`
- Run server: `./gradlew bootRun`
- Run server w/o Gradle (after build):
  `java -jar server/build/libs/server-0.0.1-SNAPSHOT-boot.jar`

----

Licensed under the terms of the
[CC0 1.0 Universal (CC0 1.0) Public Domain Dedication][CC0] license
and thus effectively part of the public domain.

[petstore]: https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator/src/test/resources/3_0/petstore.yaml
[CC0]: https://creativecommons.org/publicdomain/zero/1.0/deed
