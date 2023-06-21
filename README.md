#### Spring E-Commerce microservice

[![Java CI with Maven](https://github.com/JunChen22/E-commerce/actions/workflows/maven.yml/badge.svg)](https://github.com/JunChen22/E-commerce/actions/workflows/maven.yml) <a href="https://github.com/JunChen22/E-commerce-React"><img src="https://img.shields.io/badge/Frontend-React-green"></a> <a href="https://github.com/JunChen22/E-commerce"><img src="https://img.shields.io/badge/Mononith-version-green"></a> <a href="TBD"><img src="https://img.shields.io/badge/Demo-running-green"></a>

E-commerce for medium to large business. The microservice version is multi-vendor platforms.

``` lua
E-commerece 
├── Authuthorization server  -- could replace it with OAuth2 but not implement here
├── config-repo  -- centralized config
├── gateway  -- gateway for connection / not needed in kubernetes
├── eureka   -- service registration and discovery capabilities / not needed in kubernetes
├── E-commerece-mbg  --  Shared MyBatis generator geneated boiler plate
├── E-commerece-util  -- Shared util like exception 
├── kubernetes
│   ├── Helm     -- package manager for Kubernetes that simplifies the deployment and management of microservices.
│   │    ├── common  -- base/boiler plates
│   │    ├── components  -- each services
│   │    └── environment  -- different environment, devolopment vs production 
│   │            └── istio  -- service mesh 
│   └── monitor    -- grafana prometheus - performance metric monitor/visualizer
├── E-commerece-admin  -- role based 
│   ├── User mangament system/service
│   ├── Product management system/service
│   ├── Content management system/service
│   ├── Sales mangement system/service
│   └── Order management system/service
├── E-commerece-app   
│   ├── User mangament system/service
│   ├── Product management system/service
│   ├── Content management system/service
│   ├── Sales mangement system/service
│   └── Order management system/service
└── E-commerece-search   -- searching related module, in-memory imported in data for fast search

Two way of deploying. One with Docker and one with Kubernetes.
Docker by default will be smaller than deploying in Kubernetes. And Kuberentes will have features same as Spring Cloud
like service discovery and load balance (Eureka), central config, Distributed Tracing and circuit breaker.
The .env file stores login infos for easier change. Gets read in during run time by docker.

```
First split ECom-app into 5 parts with rabbit mq, gateway and eureka in docker.

![alt text](./document/Untitled%20Diagram.drawio.png)

Then to kuberente.


Hibernate is an ORM framework that provides a high-level, declarative way to define your data model in Java and have
Hibernate generate the database schema for you, while MyBatis is a SQL mapper framework that provides a low-level,
programmatic way to interact with a database using SQL statements. MyBatis Generator is a tool that generates Java
code based on an existing database schema to help with building a custom data access layer.

Tried separating mbg to another module but kept having problem with it. Either maven or IntelliJ error. Right now it's 
kept together and will separate it later.

API calls and documentations
- get the whole landscape running then
- go to http://localhost:8080/swagger-ui.html
- in API_calls.txt, there's a examples for simples apis.

Set up/installation:

```
Database and mybatis generator

  Generate mybatis files
 $ docker-compose up postgres
 $ cd ECom-app
 $ mvn mybatis-generator:generate -Dmybatis.generator.overwrite=true // generate DAO, mapper and java clasees
 $ docker-compose down

  Start whole landscape
 $ mvn package
 
 To deploy 
 $ docker-compose build
 $ docker-compose up

* can not deploy locally(IDE) only Docker or Kubernetes
 

 
  Import data into elastic search
 $  curl -X POST http://localhost:8080/esProduct/importAll   // should return number of items imported
 
```

### Tech stack
| Tech                                                            | role                                  | version | How is it being used here                       |
|-----------------------------------------------------------------|---------------------------------------|---------|-------------------------------------------------|
| [SpringBoot](https://spring.io/projects/spring-boot)            | MVC framework                         |         |                                                 |
| [SpringSecurity](https://spring.io/projects/spring-security)    | Security                              |         |                                                 |
| [PostgreSQL](https://www.postgresql.org/)                       | SQL database                          |         | store all product and user related data         |
| [MyBatis](http://www.mybatis.org/mybatis-3/zh/index.html)       | ORM framework                         |         |                                                 |
| [MyBatisGenerator](http://www.mybatis.org/generator/index.html) | Sourcecode generator                  |         | Generate basic functionality(CRUD) to database  |
| [RabbitMQ](https://www.rabbitmq.com/)                           | Message queue                         |         |                                                 |
| [Redis](https://redis.io/)                                      | Cache mechanism                       |         | used like a scheduler here, emails verification |
| [MongoDB](https://www.mongodb.com)                              | NoSql database(search & read history) |         | store user search & view history                |
| [Elasticsearch](https://github.com/elastic/elasticsearch)       | Search engine                         |         | imported data from PostgreSQL for fast search   |
| [LogStash](https://github.com/elastic/logstash)                 | Logging Service                       |         |                                                 |
| [Kibana](https://github.com/elastic/kibana)                     | Elasticsearch LogStash visualization  |         |                                                 |
| [Docker](https://www.docker.com)                                | Containerization                      |         | Easier deployment                               |
| [Kubernetes](https://kubernetes.io/)                            | Container Orchestration               |         |                                                 |
| [JWT](https://github.com/jwtk/jjwt)                             | Encryption tool                       |         |                                                 |
| [Lombok](https://github.com/rzwitserloot/lombok)                | minimize boilerplate                  |         |                                                 |
| [PageHelper](http://git.oschina.net/free/Mybatis_PageHelper)    | MyBatis pagination helper             |         |                                                 |
| [Swagger-UI](https://github.com/swagger-api/swagger-ui)         | Documentation tool                    |         |                                                 |
| [Hibernate-Validator](http://hibernate.org/validator)           | Validation                            |         |                                                 |
| [PayPal](https://developer.paypal.com/home)                     | Payment Gateway                       | 1.4.1   |                                                 |
| [Google Pay](https://developers.google.com/pay/api)             | Payment Gateway                       |         |                                                 |
| [Ubuntu](https://ubuntu.com/)                                   | OS                                    |         |                                                 |
| AWS S3                                                          | File storage                          |         |                                                 |
kubectl
minikube


IntelliJ plugin
- MyBatisCodeHelperPro 3.1.8 (highly needed when writing dao.xml)


Mongo and Redis wasn't being used yet.


Product management system(PMS) - manage their product catalog, including product data, pricing, and inventory.
- product
- brand

Order management system(OMS) -  manage their order processing, inventory, shipping, and other fulfillment-related tasks.
- order management
- return/refund
- shipping

Sales management system(SMS) - manage their sales processes, including lead generation, customer relationship management, and sales analytics.
- sales
 - promotion sales (time frame)
 - flash sales (by short time or by number of sales)
- coupon
- view used coupon history

Content management system(CMS) - create, manage, and publish digital content, such as text, images, and multimedia, on websites or other digital platforms.
- misc things like
 - Contact US
 - Buyer's guide("article")
  - product comparison
  - guide on what to buy
 - about us
 - shipping and return
 - warranty
 - home page(words and pictures)
 - product comparison
 - FAQ

User management system(UMS) - manage user accounts and permissions, including authentication, authorization, and access control.
- User
- admin





Docker:
- https://docs.docker.com/engine/install/ubuntu/

Elastic search:
- https://www.elastic.co/guide/en/elasticsearch/reference/current/deb.html#install-deb

### Material used:
- https://github.com/macrozheng/mall
- https://www.youtube.com/watch?v=EpYBP7EZ8Y4
- https://www.youtube.com/watch?v=-PcU6uf-p3g&list=PLA7e3zmT6XQUNzbNoTb-8c-VTa_i_w5-y

JWT:
- https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
- https://dzone.com/articles/spring-boot-security-json-web-tokenjwt-hello-world

MyBatis
- https://mybatis.org/mybatis-3/sqlmap-xml.html