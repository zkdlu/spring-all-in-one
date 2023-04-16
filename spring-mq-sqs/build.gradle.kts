apply {
    plugin("kotlin-jpa")
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.1.RELEASE")
    implementation("org.springframework.cloud:spring-cloud-aws-messaging:2.2.1.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("mysql:mysql-connector-java")
}