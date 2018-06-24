
### Spring boot actuator and security sample

```
$ http :8080/actuator

{
    "error": "Unauthorized",
    "message": "Unauthorized",
    "path": "/actuator",
    "status": 401,
    "timestamp": "2018-06-24T13:37:16.502+0000"
}
```
```
$ http :8080/actuator --auth=user:PassworD

{
    "_links": {
        "auditevents": {
            "href": "http://localhost:8080/actuator/auditevents",
            "templated": false
        },
        "beans": {
            "href": "http://localhost:8080/actuator/beans",
            "templated": false
        },
        "conditions": {
            "href": "http://localhost:8080/actuator/conditions",
            "templated": false
        },
        ...
    }
}
```
```
$ http :8080/actuator/hellth

{
    "status": "UP"
}
```
```
$ http :8080/actuator/hellth --auth=user:PassworD

{
    "details": {
        "diskSpace": {
            "details": {
                "free": 41727836160,
                "threshold": 10485760,
                "total": 120137318400
            },
            "status": "UP"
        }
    },
    "status": "UP"
}
```