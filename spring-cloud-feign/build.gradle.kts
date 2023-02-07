dependencies {
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2021.0.5"))
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
    implementation("org.springframework.boot:spring-boot-starter-web")
}