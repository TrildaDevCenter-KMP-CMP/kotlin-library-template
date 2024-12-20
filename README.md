# kotlin-library-template [![CI](https://github.com/christian-draeger/kotlin-library-template/actions/workflows/build.yml/badge.svg)](https://github.com/christian-draeger/kotlin-library-template/actions/workflows/build.yml)
A template project to jumpstart the creation and publishing of new Kotlin libraries.

## Publishing
The Project contains a github action to publish the library to maven central.
This github action requires the following secrets to be set:
- `MAVEN_CENTRAL_USERNAME`
- `MAVEN_CENTRAL_PASSWORD`
- `SIGNING_IN_MEMORY_KEY`
- `SIGNING_IN_MEMORY_KEY_ID`
- `SIGNING_IN_MEMORY_KEY_PASSWORD`

### How to get the signing key
Please change the `<key id>` placeholder in the following command to your signing key id.
```bash
gpg --export-secret-keys --armor <key id> | grep -v '\-\-' | grep -v '^=.' | tr -d '\n'
```
